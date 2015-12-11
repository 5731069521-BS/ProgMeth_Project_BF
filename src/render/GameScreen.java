package render;

import input.InputUtility;
import logic.GameLogic;
import logic.RandomUtility;
import utility.DrawingUtility;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JComponent;

public class GameScreen extends JComponent {
	public static final int WIDTH = 600;
	public static final int HEIGHT = 700;
	public int ranBg;
	
	public GameScreen() {
		// TODO Auto-generated constructor stub
		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		DrawingUtility.createBg();
		ranBg = RandomUtility.random(0, 6);
		addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
					if(e.getButton() == 1){
						if(InputUtility.isMouseLeftDown()){
							InputUtility.setMouseLeftDownUp(true);
							if(InputUtility.isMouseOnScreen()){
								InputUtility.setMouseX(e.getX());
								InputUtility.setMouseY(e.getY());
							}
						}else{
							InputUtility.setMouseLeftDownUp(false);
						}
						InputUtility.setMouseLeftDownTrigger(false);
						InputUtility.setMouseLeftDown(false);
					}
					else InputUtility.setMouseRightClickUp(true);
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
//				System.out.println("mouse press");
				if(e.getButton() == 1){
					if(InputUtility.isMouseRightClickUp()){
						InputUtility.setMouseRightClickUp(false);
						GameLogic.playerStatus.setPause(!GameLogic.playerStatus.isPause());
						InputUtility.setMouseLeftDown(false);
						InputUtility.setMouseLeftDownTrigger(false);
						InputUtility.setMouseLeftDownUp(false);
						
						return;
					}
					
					if(!InputUtility.isMouseLeftDown()){
						InputUtility.setMouseLeftDownTrigger(true);
					}else{
						InputUtility.setMouseLeftDownTrigger(false);
					}
					InputUtility.setMouseLeftDown(true);
					
					if(InputUtility.isMouseOnScreen()){
						InputUtility.setMouseX(e.getX());
						InputUtility.setMouseY(e.getY());
					}
					InputUtility.setMouseLeftDownUp(false);
					
				}
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
					InputUtility.setMouseOnScreen(false);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
					InputUtility.setMouseOnScreen(true);
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
//				if(e.getButton() == 1){
//					if(!InputUtility.isMouseLeftDown()){
//						InputUtility.setMouseLeftDownTrigger(true);
//					}else{
//						InputUtility.setMouseLeftDownTrigger(false);
//					}
//					InputUtility.setMouseLeftDown(true);
//					InputUtility.setMouseLeftDownUp(false);
//					
//				}
			}
		});
		addMouseMotionListener(new MouseMotionListener() {
			
			@Override
			public void mouseMoved(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseDragged(MouseEvent e) {
				// TODO Auto-generated method stub
					if(InputUtility.isMouseOnScreen()){
						InputUtility.setMouseX(e.getX());
						InputUtility.setMouseY(e.getY());
					}					

			}
		});
		
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		DrawingUtility.drawBg(g2, ranBg);
		
		RenderableHolder.sort();
		synchronized (RenderableHolder.getInstance()) {
			for(IRenderable renderable : RenderableHolder.getRenderableList()){
				if(renderable.isVisible()){
					renderable.draw(g2);
				}
				else RenderableHolder.getRenderableList().remove(renderable);
			}
		}
		if(GameLogic.playerStatus.isEnd){
			if(GameLogic.playerStatus.isWin){
				
			}else DrawingUtility.drawLoseScreen(g2);
		}else if(GameLogic.playerStatus.isPause() ){
				DrawingUtility.drawPauseScreen(g2);
			}
		
	}
	
	
}
