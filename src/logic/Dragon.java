package logic;

import java.awt.Graphics2D;

import render.GameScreen;
import render.IRenderable;

public class Dragon implements IRenderable{

	private int x,y;
	private int hp;
	private  int hpMax = 50;
	private int speed;
	private int power;
	
	public Dragon(int x) {
		// TODO Auto-generated constructor stub
		this.x = x;
		this.y = GameScreen.HEIGHT;
		this.hp = hpMax;
		this.speed = 0;
		this.power = 0;
	}
	
	public void attackDuck(Duck duck){
		duck.decreaseHP(this.power);
	}
	
	public void decreaseHP(int s){
		hp -= s;
	}
	
	public void update(){
		this. y -= speed;
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

}
