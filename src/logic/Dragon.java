package logic;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;

import render.GameScreen;
import render.IRenderable;
import utility.DrawingUtility;

public class Dragon implements IRenderable{
	protected float hpMax = 50;
	protected int power = 10;
	protected int speed = 1;

	protected int x,y;
	protected int hp;
	protected int i , count;
	protected boolean dead;
	protected AlphaComposite tran;
	public int column = 0;
	
	public Dragon(int x) {
		// TODO Auto-generated constructor stub
		this.x = GameLogic.playingArea.placedX(x);
		this.column = (x-175)/75 - 1;
		if(column == -1) column = 0;
		this.y = GameScreen.HEIGHT-50;
		this.hp = (int) hpMax;
		
	}
	
	public void attackDuck(Duck duck){
		duck.decreaseHP(this.power);
		y += speed;
		
	}
	
	public void attackShell(Shell shell){
		shell.decreaseHP(this.power);
		y+=speed;
	}
	
	public void decreaseHP(int s){
		
		if(hp >= s) hp -= s;
		else hp = 0;
	}
	 
	public void update(){
		if(i%4 == 0){
			this.y += speed; 			
		}else this.y -= speed;
		
		if(hp == 0 ){
			dead = true;
			System.out.println("dragon deadddd");
		}
		if(y<= 120){
//			GameLogic.playerStatus.isEnd = true;
			GameLogic.playerStatus.isWin = false;
			dead = true;
		}

	}

	@Override
	public void draw(Graphics2D g) {
		// TODO Auto-generated method stub
//		(float) hp/hpMax
		tran = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float) hp/hpMax);
		g.setComposite(tran);
		
		DrawingUtility.drawDragon(g, x, y, i);
		
		g.drawString(Integer.toString(column), x, y);
		g.drawString(Integer.toString(hp), x, y+10);
		
		if(GameLogic.playerStatus.isPause() || GameLogic.playerStatus.isEnd) return;
		if(count==0){
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
		return -1;
	}

}
