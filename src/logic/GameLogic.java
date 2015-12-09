package logic;

import java.util.List;

import input.InputUtility;
import render.GameScreen;
import render.IRenderable;
import render.PlayingArea;
import render.RenderableHolder;

public class GameLogic {
	private static GameLogic instance = new GameLogic();
	
	public static GameLogic getInstance() {
		return instance;
	}

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
	

	public GameLogic() {
		// TODO Auto-generated constructor stub
		playerStatus = new PlayerStatus();
		createDuck();
		duckSuper = new DuckSuper(50, 200);
		shell = new Shell(50, 275);
		playingArea = new PlayingArea();
		releaseDragonDelay = RandomUtility.random(50, 70);
		starfallDelay = RandomUtility.random(30, 50);
		
		
		RenderableHolder.getInstance().add(playingArea);
		RenderableHolder.getInstance().add(duck);
		RenderableHolder.getInstance().add(shell);
		RenderableHolder.getInstance().add(duckSuper);
		
	}
	
	public void logicUpdate(){
		for(IRenderable a : RenderableHolder.getRenderableList()){
			a.update();
		}
		if(starfallDelay == starfallDelayCounter){
			starfallDelayCounter = 0;
			starfallDelay = RandomUtility.random(80, 120);
			star = new Star(RandomUtility.random(0, GameScreen.WIDTH), 0);
			RenderableHolder.getInstance().add(star);
		}else starfallDelayCounter++;
		
		if(releaseDragonDelay == releaseDragonDelayCounter){
			releaseDragonDelayCounter = 0;
			
			
		}else releaseDragonDelayCounter++;
	}
	
	public void createDuck(){
		duck = new Duck(50,125);
	}
	
}
