import java.awt.Dimension;

import javax.swing.JFrame;

import logic.GameLogic;
import render.GameScreen;



public class Main {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame("DDragon");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.setPreferredSize(new Dimension(600, 700));
		
		GameScreen gameScreen = new GameScreen();
		GameLogic gameLogic = new GameLogic();
		
		frame.setResizable(false);
		frame.getContentPane().add(gameScreen);
		frame.setVisible(true);
		frame.pack();
		gameScreen.requestFocus();
		
		while(true){
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {}
			gameLogic.logicUpdate();
			gameScreen.repaint();
		}
	}

}