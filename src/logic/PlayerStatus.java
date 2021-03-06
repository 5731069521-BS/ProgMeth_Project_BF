package logic;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;

import render.IRenderable;
import render.RenderableHolder;
import utility.AudioUtility;
import utility.DrawingUtility;

public class PlayerStatus implements IRenderable{
	public static int timeMax = 300*10;
	private int time;
	private int stopTime = 50*10;
	private int money;

	private int state;
	private String name;
	private boolean isPause;
	public boolean isEnd;
	public boolean isWin;
	
//	public PlayerStatus(String name, int state, int money) {
//		// TODO Auto-generated constructor stub
//		this.name = name;
//		this.money = money;
//		this.state = state;
//		this.time = this.timeMax;
//	}
	public PlayerStatus() {
		// TODO Auto-generated constructor stub
		this.time = this.timeMax;
		this.money = 100;
		this.state = 10;
	}
	
	public boolean isPause(){
		return isPause;
	}

	public void collectStar() {
		this.money += 1;
		if(!DrawingUtility.isMute)
			AudioUtility.starSound.play();
	}

	public void buy(int price) {
		this.money -= price;
	}

	@Override
	public void draw(Graphics2D g) {
		// TODO Auto-generated method stub
		DrawingUtility.drawWinLine(g, this.time);
		AlphaComposite tran = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1);
		g.setComposite(tran);
		
		DrawingUtility.drawStar(g, 50, 126, 0);
		g.setFont(DrawingUtility.standardFont);
		g.drawString(Integer.toString(money), 85, 155);
		g.setFont(DrawingUtility.smallFont);
	}
	
	public boolean canReleaseDragon(){
		if(time >= stopTime){
			return true;
		}
		return false;
	}
	

	@Override
	public boolean isVisible() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public int getZ() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void update() {
		// TODO Auto-generated method stub
		if(time == 0){
			this.isEnd = true;
			for(IRenderable a : RenderableHolder.getRenderableList()){
				if(a instanceof Dragon){
					this.isWin = false;
					return;
				}
			}
			this.isWin = true;
		}
		
		time -= 1;
		System.out.println(time);
		
		
	}
	
	public int getTime() {
		return time;
	}
	
	public void setTime(int time) {
		this.time = time;
	}
	
	public int getMoney() {
		return money;
	}
	
	public void setMoney(int money) {
		this.money = money;
	}
	
	public int getState() {
		return state;
	}
	
	public void setState(int state) {
		this.state = state;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setPause(boolean isPause) {
		this.isPause = isPause;
	}

}
