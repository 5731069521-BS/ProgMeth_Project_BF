package utility;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

import logic.StateParsingException;

public class GameSaveUtility {

	public static class GameSaveRecord implements Comparable<GameSaveRecord>{
	
		private String name = "";
		private int state = 0;
		private int star = 0;
		
		public GameSaveRecord(String name, int state, int star) {
			// TODO Auto-generated constructor stub
			this.name = name;
			this.state = state;
			this.star = star;
		}
		
		/*
		 * format name:state;star 
		 */
		
		public GameSaveRecord(String record) throws StateParsingException{
			// TODO Auto-generated constructor stub
			int index1 = record.indexOf(":");
			int index2 = record.indexOf(";");
			if(index1<0) throw new StateParsingException(1);
			try{
				this.name = record.substring(0, index1);
				this.state = Integer.parseInt(record.substring(index1+1, index2));
				this.star = Integer.parseInt(record.substring(index2+1, record.length()));
			}catch(NumberFormatException e){
				throw new StateParsingException(0);
			}
			
		}
		
		private String getRecord(){
			return name.trim() + ":" + state + ";" + star;
		}
		
		private static String[] defaultRecord(){
			return new String[]{"BEE:10;100","FAAI:10;100"};
		}
		
		
		@Override
		public int compareTo(GameSaveRecord o) {
			// TODO Auto-generated method stub
			if(this.state < o.state) return 1;
			else if (this.state > o.state) return -1;
			else return this.name.compareTo(o.name);
		}
	}
	
	private static GameSaveRecord[] gameSaveRecord = null;
	private static String readFileName = "statesave";
	
	public static boolean recordPlayer(){
		return false;
	}
	
	public static void displayPlayer(){
		
	}
	
	public static boolean loadPlayerData(){
		File f = new File(readFileName);
		if(!f.exists()){
			if(!createDefaultDataFile()) return false;
		}
		if(!readAndParsePlayerFile(f)){
			f.delete();
			if(!createDefaultDataFile()) return false;
			return readAndParsePlayerFile(f);
		}
		return true;
	}
	
	private static boolean readAndParsePlayerFile(File f){
		try{
			BufferedReader in = new BufferedReader(new FileReader(f));
			String line;
			gameSaveRecord = new GameSaveRecord[5];
			String str = "";
			int c;
			while((c = in.read()) != -1){
				str += (char)c;
			}
			in.close();
			String[] records = str.split("\n");
			for(int i = 0; i<gameSaveRecord.length; i++){
				try{
					gameSaveRecord[i] = new GameSaveRecord(records[i]);
				}catch(StateParsingException e){
					System.err.println("Error parsing line " + (i+1) + ", " + e.getMessage());
					gameSaveRecord[i] = new GameSaveRecord("ERROR_RECORD", 0, 0);
				}
			}
			Arrays.sort(gameSaveRecord);
			return true;
		}catch(Exception e){
			gameSaveRecord = null;
		}
		return false;
	}
	
	private static boolean createDefaultDataFile(){
		try{
			BufferedWriter out = new BufferedWriter(new FileWriter("statesave"));
			String str = "";
			for(String s : GameSaveRecord.defaultRecord()){
				str += s+"\n";
			}
			str = str.trim();
			out.write(str);
			out.close();
			return true;
		}catch (IOException e){
			gameSaveRecord = null;
			return false;
		}
	}
	
	public static void setReadFileName(String name){
		readFileName = name;
	}
	
}
