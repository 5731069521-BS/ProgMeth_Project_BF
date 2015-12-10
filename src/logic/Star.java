package logic;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;

import input.InputUtility;
import render.GameScreen;
import render.IRenderable;
import utility.DrawingUtility;

public class Star implements IRenderable{
	private int x, y;
	private int speedX, speedY;
	private boolean dead;
	private int i,count;
	private boolean onFloor;
	private int gone = 100 , goneCount;
	
	
	public Star(int x, int y) {
		// TODO Auto-generated constructor stub
		this.x = x;
		this.y = y;
		this.speedY = RandomUtility.random(3, 7);
		this.speedX = RandomUtility.random(-2, 2);
		this.dead = false;
		this.i = 0;
	}

	@Override
	public void draw(Graphics2D g) {
		// TODO Auto-generated method stub
		
		AlphaComposite tran = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1);
		g.setComposite(tran);
		DrawingUtility.drawStar(g, x, y, i);
//		if(count==0){
			i++;
//			count = 0;
//		}else count++;
		if(i == 7) i = 0;
		
	}

	@Override
	public boolean isVisible() {
		// TODO Auto-generated method stub
		return !dead;
	}

	@Override
	public int getZ() {
		// TODO Auto-generated method stub
		return Integer.MAX_VALUE;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		if(isClick(InputUtility.getMouseX(), InputUtility.getMouseY())){
			dead = true;
			GameLogic.playerStatus.collectStar();
		}
		if(!dead){
			y += speedY;
			x += speedX;
			if(x<0){
				x = Math.abs(x);
				speedX = -speedX;
			}
			else if(x>GameScreen.WIDTH-30){
				x = GameScreen.WIDTH - 30;
				speedX = -speedX;
			}
			if(y> GameScreen.HEIGHT-30){
				y = GameScreen.HEIGHT - 30;
				onFloor = true;
			}			
			
			if(onFloor){
				if(gone == goneCount){
					this.dead = true;
				}goneCount++;
			}
		}
	}
	
	public boolean isClick(int x, int y){
		if(InputUtility.isMouseLeftDownTrigger()){
			if(this.x-2<=x && this.x+32>=x){
				if(this.y-2<=y && this.y+32>=y) {
					InputUtility.setMouseLeftDownTrigger(false);
					return true;
				}
			}			
		}
		return false;
	}
	
}
