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
		releaseDragonDelay = RandomUtility.random(100, 120);
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
			starfallDelay = RandomUtility.random(150, 200);
			star = new Star(RandomUtility.random(0, GameScreen.WIDTH), 0);
			RenderableHolder.getInstance().add(star);
		}else starfallDelayCounter++;
		
//		DRAGON OUT
		if(releaseDragonDelay == releaseDragonDelayCounter){
			releaseDragonDelayCounter = 0;
			releaseDragonDelay = RandomUtility.random(100, 120);
			int ran = RandomUtility.random(0, 5);
			if(ran == 3){
				RenderableHolder.getInstance().add(new DragonSuper(175+ran*75));
				
			}else
			RenderableHolder.getInstance().add(new Dragon(175+ran*75));
			
		}else releaseDragonDelayCounter++;
		
//		SU KAN
		for(int i = 0; i<RenderableHolder.getRenderableList().size(); i++){

			for(int j = 0; j<RenderableHolder.getRenderableList().size(); j++){

				if(RenderableHolder.getRenderableList().get(i) instanceof Dragon){
					Dragon dragon = (Dragon) RenderableHolder.getRenderableList().get(i);
					if(RenderableHolder.getRenderableList().get(j) instanceof Egg){
						Egg egg = (Egg) RenderableHolder.getRenderableList().get(j);
						
						if(!egg.destroyed &&egg.column == dragon.column ){
							if(egg.y-15 <= dragon.y && egg.y+15 >= dragon.y){
								
								egg.attackDragon(dragon);
								break;
							}
						}
					}
					if(RenderableHolder.getRenderableList().get(j) instanceof Duck){
						Duck duck = (Duck) RenderableHolder.getRenderableList().get(j);
						
						if(!duck.dead && duck.column == dragon.column){
							if(duck.y<=dragon.y && duck.y+75>= dragon.y){
								dragon.attackDuck(duck);
								break;
							}
						}
					}
					if(RenderableHolder.getRenderableList().get(j) instanceof Shell){
						Shell shell = (Shell) RenderableHolder.getRenderableList().get(j);
						
						if(!shell.dead && shell.column == dragon.column){
							if(shell.y<=dragon.y && shell.y+75>=dragon.y){
								
							}
						}
					}
				}
			}
		}
		
		
	}
	
	public void createDuck(){
//		duck = new Duck(50,125);
//		RenderableHolder.getInstance().add(duck);
		RenderableHolder.getInstance().add(new Duck(50, 125+75/2));
		newDuck = false;
	}
	public void createSuperDuck(){
		RenderableHolder.getInstance().add(new DuckSuper(50, 200+75/2));
		newSuperDuck = false;
	}
	public void createShell(){
		RenderableHolder.getInstance().add(new Shell(50, 275+75/2));
		newShell = false;
	}
	
}
