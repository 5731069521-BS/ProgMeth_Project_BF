package logic;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;

import render.GameScreen;
import render.IRenderable;
import utility.DrawingUtility;

public class Dragon implements IRenderable{

	protected int x,y;
	protected int hp;
	protected float hpMax = 50;
	protected int speed;
	protected int power;
	protected int i , count;
	protected boolean dead;
	protected AlphaComposite tran;
	
	public Dragon(int x) {
		// TODO Auto-generated constructor stub
		this.x = GameLogic.playingArea.placedX(x);
		
		this.y = GameScreen.HEIGHT+75;
		this.hp = (int) hpMax;
		this.speed = 1;
		this.power = 0;
	}
	
	public void attackDuck(Duck duck){
		duck.decreaseHP(this.power);
	}
	
	public void decreaseHP(int s){
		if(hp > s) hp -= s;
		else hp = 0;
	}
	 
	public void update(){
		this. y -= speed;
		
		if(hp == 0){
			dead = true;
		}
		
	}

	@Override
	public void draw(Graphics2D g) {
		// TODO Auto-generated method stub
		tran = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float) hp/hpMax);
		g.setComposite(tran);
		
		DrawingUtility.drawDragon(g, x, y, i);
		if(count==7){
			i++;
			count = 0;
		}else count++;
		if(i == 8) i = 0;
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

}
