package logic;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;

import input.InputUtility;
import render.IRenderable;

public class Duck implements IRenderable{
	protected int defaultX = 50, defaultY = 125;
	protected int x,y;
	protected int hp;
	protected float hpMax = 50;
	protected int price;
	protected boolean canBuy;
	protected boolean dead;
	protected AlphaComposite tran;
	protected boolean bought;
	
	public Duck(int x, int y) {
		// TODO Auto-generated constructor stub
		this.x = x;
		this.y = y;
		this.hp = (int) hpMax;
		this.dead = false;
		this.bought = false;
	}
	
	public void update(){
		if(!canBuy) getDuck();
		System.out.println(canBuy +" "+ bought);
		if(canBuy && !bought){
			if(InputUtility.isMouseLeftDown()){
				System.out.println("asdlkjfa;sldjfa;lsdjkfal;sdkjf");
				this.x = InputUtility.getMouseX()-75/2;
				this.y = InputUtility.getMouseY()-75/2;
				
			}
			if(!InputUtility.isMouseLeftDown() && InputUtility.isMouseLeftDownUp()){
				if(GameLogic.playingArea.canBePlaced(InputUtility.getMouseX(), InputUtility.getMouseY())){
					System.out.println("                              downnnn");
					this.x = GameLogic.playingArea.placedX(InputUtility.getMouseX());
					this.y = GameLogic.playingArea.placedY(InputUtility.getMouseY());
					this.bought = true;
				}else{
					this.x = defaultX;
					this.y = defaultY;
				}
			}
		}
		
		
		
	}

	public void getDuck(){

		if(InputUtility.isMouseLeftDownTrigger()){
			if(defaultX <= InputUtility.getMouseX() && defaultX+75 >= InputUtility.getMouseX()){
				System.out.println("in");				
				if(defaultY <= InputUtility.getMouseY() && defaultY+75 >= InputUtility.getMouseY()){
					canBuy = true;
					InputUtility.setMouseLeftDownTrigger(false);
				}
			}
			InputUtility.setMouseLeftDownTrigger(false);
		}
		else canBuy = false;
	}
	
	@Override
	public void draw(Graphics2D g) {
		// TODO Auto-generated method stub
		tran = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float) hp/hpMax);
g.setComposite(tran);
		
		g.setColor(Color.pink);
//		g.fillRoundRect(x, y, 75, 75, 10, 10);
		g.fillArc(x, y, 75, 75, 0, 360);
		g.setColor(Color.white);
//		g.fillRoundRect(x+4, y+4, (75-8), (75-8), 10, 10);
		g.fillArc(x+4, y+4, 67, 67, 0, 360);
		
		
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

	public void decreaseHP(int power) {
		// TODO Auto-generated method stub
		this.hp -= power;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	
	
	
}