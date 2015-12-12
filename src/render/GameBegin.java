package render;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComponent;

public class GameBegin extends JComponent{
	public GameBegin() {
		// TODO Auto-generated constructor stub
		this.setPreferredSize(new Dimension(GameScreen.WIDTH, GameScreen.HEIGHT));
	}
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		AlphaComposite noTran = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1);
		g2.setComposite(noTran);
		g2.setColor(new Color(255/2, 0, 255/2));
		g2.fillRect(0, 0, GameScreen.WIDTH, GameScreen.HEIGHT);
		
		g2.setColor(Color.CYAN);
		g2.fillRoundRect(200, 400, 200, 50, 40, 40);
		
		
	}
}
