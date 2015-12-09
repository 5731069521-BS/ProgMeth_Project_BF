package render;

import input.InputUtility;
import utility.DrawingUtility;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JComponent;

public class GameScreen extends JComponent {
	public static final int WIDTH = 600;
	public static final int HEIGHT = 700;
	
	public GameScreen() {
		// TODO Auto-generated constructor stub

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
					InputUtility.setMouseLeftDown(false);
					InputUtility.setMouseLeftDownTrigger(false);
					
				}
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
//				System.out.println("mouse press");
				if(e.getButton() == 1){
					if(!InputUtility.isMouseLeftDown()){
						InputUtility.setMouseLeftDownTrigger(true);
						System.out.println("					trigger True");
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
				if(e.getButton() == 1){
					InputUtility.setMouseLeftDown(true);
					InputUtility.setMouseLeftDownUp(false);
					
				}
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
				if(e.getButton() == 1){
					if(InputUtility.isMouseOnScreen()){
						InputUtility.setMouseX(e.getX());
						InputUtility.setMouseY(e.getY());
					}					
				}
			}
		});
		
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(DrawingUtility.bg, 0, 0, null);
		
		synchronized (RenderableHolder.getInstance()) {
			for(IRenderable renderable : RenderableHolder.getRenderableList()){
				if(renderable.isVisible())
				renderable.draw(g2);
			}
		}
		
	}
	
	
}
