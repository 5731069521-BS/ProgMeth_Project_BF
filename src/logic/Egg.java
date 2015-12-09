package logic;

import java.awt.Color;
import java.awt.Graphics2D;

import render.IRenderable;

public class Egg implements IRenderable{
	private int power, x, y, speed;
	private boolean destroyed;
	private Duck shooter;
	
	public Egg(Duck shooter) {
		// TODO Auto-generated constructor stub
		this.shooter = shooter;
		this.x = shooter.getX()+75/2;
		this.y = shooter.getY()+75/2;
		this.speed = 5;
		this.destroyed = false;
		this.power = 1;
	}
	
	public void attackDragon(Dragon d){
		destroyed = true;
		d.decreaseHP(this.power);
	}
	
	public void update(){
		System.out.println("egg update!");
		y += speed;
	}

	@Override
	public void draw(Graphics2D g) {
		// TODO Auto-generated method stub
		g.setColor(Color.white);
		g.fillOval(x, y, 15, 20);
	}

	@Override
	public boolean isVisible() {
		// TODO Auto-generated method stub
		return !destroyed;
	}

	@Override
	public int getZ() {
		// TODO Auto-generated method stub
		return 0;
	}

}
