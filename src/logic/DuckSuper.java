package logic;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;

import input.InputUtility;
import render.RenderableHolder;
import utility.DrawingUtility;

public class DuckSuper extends Duck{
	

	public DuckSuper(int x, int y) {
		// TODO Auto-generated constructor stub
		super(x,y);
		this.defaultX = 50;
		this.defaultY = 200+75/2;
	}
	
	public void update(){
		if(!canBuy) getDuck();
		if(canBuy && !bought){
			if(InputUtility.isMouseLeftDown()){
				this.x = InputUtility.getMouseX()-75/2;
				this.y = InputUtility.getMouseY()-75/2;
				
			}
			if(!InputUtility.isMouseLeftDown() && InputUtility.isMouseLeftDownUp()){
				if(GameLogic.playingArea.canBePlaced(InputUtility.getMouseX(), InputUtility.getMouseY())){
					this.x = GameLogic.playingArea.placedX(InputUtility.getMouseX());
					this.y = GameLogic.playingArea.placedY(InputUtility.getMouseY());
					this.column = (x-175)/75;
					GameLogic.playingArea.placed((y-125)/75, column);
					this.bought = true;
					GameLogic.newSuperDuck = true;
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
				RenderableHolder.getInstance().add(new EggSuper(this));
			}else eggDelayCounter++;
			if(hp == 0 ){
				GameLogic.playingArea.dead((y-125)/75, (x-175)/75);
				dead = true;
			}
		}
		
		
		
	}
	
	@Override
	public void draw(Graphics2D g) {
		// TODO Auto-generated method stub
		tran = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float) (hp/hpMax));
		g.setComposite(tran);
		
		if(bought){
			if(aniCount == eggDelay/2){
				if(i == 0) i = 1;
				else i = 0;
				aniCount = 0;
			}
			aniCount++;
		}
		DrawingUtility.drawSuperDuck(g, x, y, i);
		g.drawString(Integer.toString(column), x, y);
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


}
