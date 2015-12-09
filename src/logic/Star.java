package logic;

import java.awt.Color;
import java.awt.Graphics2D;

import render.GameScreen;
import render.IRenderable;

public class Star implements IRenderable{
	private int x, y;
	private int speedX, speedY;
	private boolean dead;
	
	
	
	public Star(int x, int y) {
		// TODO Auto-generated constructor stub
		this.x = x;
		this.y = y;
		this.speedY = RandomUtility.random(3, 7);
		this.speedX = RandomUtility.random(-2, 2);
		this.dead = false;
	}

	@Override
	public void draw(Graphics2D g) {
		// TODO Auto-generated method stub
		g.setColor(Color.yellow);
		g.fillArc(x, y, 20, 20, 0, 360);
		
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
	public void update() {
		// TODO Auto-generated method stub
		y += speedY;
		x += speedX;
		if(x<0){
			x = Math.abs(x);
			speedX = -speedX;
		}
		else if(x>GameScreen.WIDTH){
			x -= GameScreen.WIDTH;
			x = GameScreen.WIDTH - x;
			speedX = -speedX;
		}
		if(y>= GameScreen.HEIGHT){
			y = GameScreen.HEIGHT - 20;
		}
	}
}
