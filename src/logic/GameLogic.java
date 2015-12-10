package logic;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import input.InputUtility;
import render.GameScreen;
import render.IRenderable;
import render.PlayingArea;
import render.RenderableHolder;

public class GameLogic {

	private int releaseDragonDelay;
	private int releaseDragonDelayCounter;
	private int starfallDelay;
	private int starfallDelayCounter;
	public static PlayerStatus playerStatus;
	protected  Duck duck;
	protected DuckSuper duckSuper;
	public static PlayingArea playingArea;
	protected Shell shell;
	protected Star star;
	protected Dragon dragon;
	protected DragonSuper superDragon;
	public static boolean newDuck;
	public static boolean newSuperDuck;
	public static boolean newShell;
	 

	public GameLogic() {
		// TODO Auto-generated constructor stub
		playerStatus = new PlayerStatus();
		playingArea = new PlayingArea();
		RenderableHolder.getInstance().add(playingArea);
		createDuck();
		createSuperDuck();
		createShell();
		releaseDragonDelay = RandomUtility.random(50, 70);
		starfallDelay = RandomUtility.random(30, 50);
		
		

		
	}
	
	public void logicUpdate(){
		RenderableHolder.sort();
		for(IRenderable a : RenderableHolder.getRenderableList()){
			
			a.update();
			
		}
		if(newDuck){
			newDuck = false;
			this.createDuck();
		}
		if(newSuperDuck){
			this.createSuperDuck();
		}
		if(newShell){
			this.createShell();
		}
//		STAR FALL
		if(starfallDelay == starfallDelayCounter){
			starfallDelayCounter = 0;
			starfallDelay = RandomUtility.random(80, 120);
			star = new Star(RandomUtility.random(0, GameScreen.WIDTH), 0);
			RenderableHolder.getInstance().add(star);
		}else starfallDelayCounter++;
		
//		DRAGON OUT
		if(releaseDragonDelay == releaseDragonDelayCounter){
			releaseDragonDelayCounter = 0;
			int ran = RandomUtility.random(0, 5);
			System.out.println(ran);
			if(ran == 3){
				RenderableHolder.getInstance().add(new DragonSuper(175+ran*75));
				System.out.println("superDragon");
			}else
			RenderableHolder.getInstance().add(new Dragon(175+ran*75));
			
		}else releaseDragonDelayCounter++;
	}
	
	public void createDuck(){
//		duck = new Duck(50,125);
//		RenderableHolder.getInstance().add(duck);
		RenderableHolder.getInstance().add(new Duck(50, 125));
		newDuck = false;
	}
	public void createSuperDuck(){
		RenderableHolder.getInstance().add(new DuckSuper(50, 200));
		newSuperDuck = false;
	}
	public void createShell(){
		RenderableHolder.getInstance().add(new Shell(50, 275));
		newShell = false;
	}
	
}
