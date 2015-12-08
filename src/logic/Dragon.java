package logic;

import render.IRenderable;

public class Dragon implements IRenderable{

	private int x,y;
	private int hp;
	private int hpMax = 50;
	private int speed;
	private int power;
	
	public Dragon(int x) {
		// TODO Auto-generated constructor stub
		this.x = x;
		this.y = 0;
		this.hp = hpMax;
		this.speed = 0;
		this.power = 0;
	}
	
	public void attackDuck(Duck duck){
		
	}
	
	public void update(){
		
	}

	@Override
	public void draw() {
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

}
