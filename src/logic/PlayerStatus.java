package logic;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;

import render.IRenderable;
import utility.AudioUtility;
import utility.DrawingUtility;

public class PlayerStatus implements IRenderable{
	private int time;
	private int money;
	private int state;
	private String name;
	private boolean isPause;
	
	public PlayerStatus() {
		// TODO Auto-generated constructor stub
		
	}
	
	public void releaseDragon(){
		
	}
	
	public boolean isPause(){
		return isPause;
	}

	public void collectStar() {
		this.money += 1;
		AudioUtility.starSound.play();
	}

	public void buy(int price) {
		this.money -= price;
	}

	@Override
	public void draw(Graphics2D g) {
		// TODO Auto-generated method stub
		AlphaComposite tran = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1);
		g.setComposite(tran);
		
		DrawingUtility.drawStar(g, 55, 130, 0);
		g.setFont(DrawingUtility.standardFont);
		g.drawString(Integer.toString(money), 95, 160);
		g.setFont(DrawingUtility.smallFont);
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
		
	}
}
