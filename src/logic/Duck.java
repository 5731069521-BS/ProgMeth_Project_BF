package logic;

import render.IBuyable;
import render.IRenderable;

public class Duck implements IRenderable, IBuyable{

	private int x,y;
	private int hp;
	private int hpMax = 50;
	private int price;
	private int layingDelay;
	private int layingDelayCounter;
	private boolean canBuy;
	private boolean dead;
	
	public Duck(int x, int y) {
		// TODO Auto-generated constructor stub
		this.x = x;
		this.y = y;
		this.hp = hpMax;
		this.price = 4;
		this.layingDelay = 10;
	}
	
	public int getX(){
		return x;
	}

	public int getY() {
		return y;
	}

	public int getHp() {
		return hp;
	}

	public int getPrice() {
		return price;
	}

	public int getLayingDelay() {
		return layingDelay;
	}
	
	
	@Override
	public void draw() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isVisible() {
		// TODO Auto-generated method stub
		
		return !dead;
	}

	@Override
	public int getZ() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isBuyable() {
		// TODO Auto-generated method stub
		return canBuy;
	}	

}
