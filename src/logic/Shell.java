package logic;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;

import render.IRenderable;

public class Shell implements IRenderable {
	private int x,y;
	private int hp;
	private int hpMax = 50;
	private int price;
	private boolean canBuy;
	private boolean dead;
	private boolean bought;
	private AlphaComposite tran;
	
	public Shell(int x, int y) {
		// TODO Auto-generated constructor stub
		this.x = x;
		this.y = y;
		this.hp = hpMax;
		
	}

	@Override
	public void draw(Graphics2D g) {
		// TODO Auto-generated method stub
		tran = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float) (hp/hpMax));
		g.setComposite(tran);
		
		g.setColor(Color.yellow);
		g.fillRoundRect(x, y, 75, 75, 10, 10);
		g.setColor(Color.white);
		g.fillRoundRect(x+4, y+4, (75-8), (75-8), 10, 10);
		
	}

	@Override
	public boolean isVisible() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public int getZ() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
		
		
	}

}
