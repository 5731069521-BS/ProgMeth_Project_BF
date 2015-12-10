package logic;

import java.awt.Graphics2D;

import utility.DrawingUtility;

public class EggSuper extends Egg {
	
	public EggSuper(Duck shooter) {
		// TODO Auto-generated constructor stub
		super(shooter);
	}
	public void draw(Graphics2D g) {
		// TODO Auto-generated method stub
		if(!destroyed){
			DrawingUtility.drawSuperEgg(g, x, y+70/2);
		}
	}
}
