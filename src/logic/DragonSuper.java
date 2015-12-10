package logic;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;

import utility.DrawingUtility;

public class DragonSuper extends Dragon{

	
	public DragonSuper(int x) {
		// TODO Auto-generated constructor stub
		super(x);
		this.hpMax = 100;
		this.hp = (int) this.hpMax;
		this.speed = 1;
	}
	
	@Override
	public void draw(Graphics2D g) {
		// TODO Auto-generated method stub
		tran = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float) hp/hpMax);
		g.setComposite(tran);
		
		DrawingUtility.drawSuperDragon(g, x, y, i);
		g.drawString(Integer.toString(column), x, y);
		g.drawString(Integer.toString(hp), x, y+10);
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
		return 0;
	}

}
