package logic;

import java.awt.Graphics2D;

import render.IRenderable;

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
	}

	public void buy(int price) {
		this.money -= price;
	}

	@Override
	public void draw(Graphics2D g) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isVisible() {
		// TODO Auto-generated method stub
		return false;
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
