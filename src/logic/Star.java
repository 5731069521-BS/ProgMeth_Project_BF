package logic;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;

import input.InputUtility;
import render.GameScreen;
import render.IRenderable;
import utility.DrawingUtility;

public class Star implements IRenderable{
	private int gone = 250;
	
	private int x, y, goneCount;
	private int speedX, speedY;
	private boolean dead;
	private int i,count;
	private boolean onFloor;
	private boolean flashing, draw;
	private int flashCounter, flashDurationCounter;
	
	public Star(int x, int y) {
		// TODO Auto-generated constructor stub
		this.x = x;
		this.y = y;
		this.speedY = RandomUtility.random(3, 7);
		this.speedX = RandomUtility.random(-2, 2);
		this.dead = false;
		this.i = 0;
		this.draw = true;
	}

	@Override
	public void draw(Graphics2D g) {
		// TODO Auto-generated method stub
		
		AlphaComposite tran = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1);
		g.setComposite(tran);
		if(draw)
		DrawingUtility.drawStar(g, x, y, i);
//		g.fillRect(x-5, y-5, 40, 40);
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
			
		}
		if(onFloor){
			if(gone == goneCount){
				this.dead = true;
				onFloor = false;
				flashing = false;
			}else goneCount++;
		}
		
	}
	
	
	public boolean isClick(int x, int y){
		if(InputUtility.isMouseLeftDownTrigger()){
			if(this.x-5<=x && this.x+35>=x){
				if(this.y-5<=y && this.y+35>=y) {
					InputUtility.setMouseLeftDownTrigger(false);
					return true;
				}
			}			
		}
		return false;
	}
	
}
