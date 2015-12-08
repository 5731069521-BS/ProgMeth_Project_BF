package logic;

public class DuckSuper extends Duck{
	
	private int x,y;
	private int hp;
	private int hpMax = 50;
	private int price;
	private int layingDelay;
	private int layingDelayCounter;

	public DuckSuper(int x, int y) {
		// TODO Auto-generated constructor stub
		super(x,y);
		this.x = x;
		this.y = y;
		this.hp = hpMax;
		this.price = 6;
		this.layingDelay = 10;
	}
	
	@Override
	public void draw() {
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
