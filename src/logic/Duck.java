package logic;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;

import input.InputUtility;
import render.IRenderable;
import render.RenderableHolder;
import utility.DrawingUtility;

public class Duck implements IRenderable{
	protected int defaultX = 50, defaultY = 125;
	protected int x,y,z;
	protected int hp;
	protected float hpMax = 50;
	protected int price;
	protected int eggDelay , eggDelayCounter;
	protected boolean canBuy;
	protected boolean dead;
	protected boolean bought;
	protected AlphaComposite tran;
	protected int i=0, aniCount = 0;;
	
	public Duck(int x, int y) {
		// TODO Auto-generated constructor stub
		this.x = x;
		this.y = y;
		this.hp = (int) hpMax;
		this.eggDelay = 40;
		this.dead = false;
		this.bought = false;
	}
	
	public void update(){
		if(!dead){
			
			if(!canBuy) getDuck();
			if(canBuy && !bought){
				if(InputUtility.isMouseLeftDown()){
					this.x = InputUtility.getMouseX()-75/2;
					this.y = InputUtility.getMouseY()-75/2;
					this.z = Integer.MAX_VALUE;
					
				}
				if(!InputUtility.isMouseLeftDown() && InputUtility.isMouseLeftDownUp()){
					if(GameLogic.playingArea.canBePlaced(InputUtility.getMouseX(), InputUtility.getMouseY())){
						this.x = GameLogic.playingArea.placedX(InputUtility.getMouseX());
						this.y = GameLogic.playingArea.placedY(InputUtility.getMouseY());
						GameLogic.playingArea.placed((y-125)/75, (x-175)/75);
						this.bought = true;
						this.z = 0;
						GameLogic.newDuck = true;
					}else{
						this.x = defaultX;
						this.y = defaultY;
						this.canBuy = false;
						this.z = 0;
					}
				}
			}
			
			
			if(bought){
				if(eggDelay == eggDelayCounter){
					eggDelayCounter = 0;
					RenderableHolder.getInstance().add(new Egg(this));
				hp-=5;
				}else eggDelayCounter++;
			}
			
			if(hp == 0){
				dead = true;
				GameLogic.playingArea.dead((y-125)/75, (x-175)/75);
			}
		}
		
		
		
	}

	public void getDuck(){

		if(InputUtility.isMouseLeftDownTrigger()){
			GameLogic.newDuck = false;
			if(defaultX <= InputUtility.getMouseX() && defaultX+75 >= InputUtility.getMouseX()){
			
				if(defaultY <= InputUtility.getMouseY() && defaultY+75 >= InputUtility.getMouseY()){
					canBuy = true;
					InputUtility.setMouseLeftDownTrigger(false);
				}
			}
		}
		else canBuy = false;
	}
	
	@Override
	public void draw(Graphics2D g) {
		// TODO Auto-generated method stub
		
		tran = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float) hp/hpMax);
		g.setComposite(tran);
		if(bought){
			if(aniCount == eggDelay/2){
				if(i == 0) i = 1;
				else i = 0;
				aniCount = 0;
			}
			aniCount++;
		}
		DrawingUtility.drawDuck(g, x, y, i);
		
				
	}

	@Override
	public boolean isVisible() {
		// TODO Auto-generated method stub
		return !dead;
	}

	@Override
	public int getZ() {
		// TODO Auto-generated method stub
		return z;
	}

	public void decreaseHP(int power) {
		// TODO Auto-generated method stub
		if(this.hp > power){
			this.hp -= power;
		}
		else this.hp = 0;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	
	
	
}