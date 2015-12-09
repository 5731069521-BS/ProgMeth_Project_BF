package logic;

import java.awt.Graphics2D;

public class DragonSuper extends Dragon{

	private int x,y;
	private int hp;
	private int hpMax = 100;
	private int speed;
	private int power;
	
	public DragonSuper(int x) {
		// TODO Auto-generated constructor stub
		super(x);
	}
	
	@Override
	public void draw(Graphics2D g) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isVisible() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getZ() {
		// TODO Auto-generated method stub
		return 0;
	}

}
