package logic;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;

public class DuckSuper extends Duck{
	

	public DuckSuper(int x, int y) {
		// TODO Auto-generated constructor stub
		super(x,y);
		this.defaultX = 50;
		this.defaultY = 200;
	}
	
	@Override
	public void draw(Graphics2D g) {
		// TODO Auto-generated method stub
		tran = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float) (hp/hpMax));
		g.setComposite(tran);
		
		g.setColor(Color.blue);
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


}
