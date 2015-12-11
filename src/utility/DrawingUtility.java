package utility;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import render.GameScreen;

public class DrawingUtility {
	public static final Font standardFont = new Font("Comic Sans MS", Font.BOLD, 30);
	public static final Font smallFont = new Font("Tahoma", Font.PLAIN, 10);
	
	protected static BufferedImage getImage(String directory){
		ClassLoader loader = DrawingUtility.class.getClassLoader();
		try{
			return ImageIO.read(loader.getResource(directory));
		}catch(IOException e){
			return null;
		}
	}

	public static BufferedImage duckPic = getImage("res/img/duck-all-new1.png");
	public static BufferedImage superDuckPic = getImage("res/img/superDuck-all-new1.png");
	public static BufferedImage star = getImage("res/img/star-all.png");
	public static BufferedImage dragon = getImage("res/img/toothless-all-new.png");
	public static BufferedImage superDragon = getImage("res/img/toothlessSuper-all-new.png");
	public static BufferedImage egg = getImage("res/img/egg.png");
	public static BufferedImage superEgg = getImage("res/img/superEgg.png");
	public static BufferedImage shell = getImage("res/img/shell-all.png");
	public static BufferedImage[] bg = new BufferedImage[7];
	
	public static void createBg(){
		bg[0] = getImage("res/img/background-1.png");
		bg[1] = getImage("res/img/background-2.png");
		bg[2] = getImage("res/img/background-3.png");
		bg[3] = getImage("res/img/background-4.png");
		bg[4] = getImage("res/img/background-5.png");
		bg[5] = getImage("res/img/background-6.png");
		bg[6] = getImage("res/img/background-7.png");
		
	}
	
	
//	public static int duckCount = 0;
	public static final AffineTransformOp resizeDuck = new AffineTransformOp(AffineTransform.getScaleInstance(0.75/2, 0.75/2), AffineTransformOp.TYPE_BICUBIC);
	public static final AffineTransformOp resizeDragon = new AffineTransformOp(AffineTransform.getScaleInstance(0.75/5, 0.75/5), AffineTransformOp.TYPE_BICUBIC);
	public static final AffineTransformOp resizeStar = new AffineTransformOp(AffineTransform.getScaleInstance(0.3, 0.3), AffineTransformOp.TYPE_BICUBIC);
	public static final AffineTransformOp resizeEgg = new AffineTransformOp(AffineTransform.getScaleInstance(0.25, 0.25), AffineTransformOp.TYPE_BICUBIC);
	public static final AffineTransformOp resizeShell = new AffineTransformOp(AffineTransform.getScaleInstance(0.75/2, 0.75/2), AffineTransformOp.TYPE_BICUBIC);
	public static final AffineTransformOp resizeBg = new AffineTransformOp(AffineTransform.getScaleInstance(1/1.2, 1/1.2), AffineTransformOp.TYPE_BICUBIC);
	
	protected static BufferedImage waveAnim;
	
	public static BufferedImage getWaveAnim(){
		return waveAnim;
	}
	
	public static void drawBg(Graphics2D g, int i){
		g.drawImage(bg[i], resizeBg, 0, 0);
	}
	
	public static void drawDuck(Graphics2D g, int x, int y, int duckCount){
		/* fill code */
		BufferedImage duckUse = duckPic.getSubimage(duckCount*200, 0, 200, 200);
		g.drawImage(duckUse, resizeDuck, x, y);
		
	}
	
	public static void drawSuperDuck(Graphics2D g, int x, int y, int duckCount){
		BufferedImage duckUse = superDuckPic.getSubimage(duckCount*200, 0, 200, 200);
		g.drawImage(duckUse, resizeDuck, x, y);
	}
	
	public static void drawDragon(Graphics2D g, int x, int y, int i){
		/* fill code */
		int xx = i*500;
		BufferedImage dragonUse = dragon.getSubimage(xx, 0, 500, 700);
		g.drawImage(dragonUse, resizeDragon, x-2, y);
	}
	
	public static void drawSuperDragon(Graphics2D g, int x, int y, int i){
		BufferedImage dragonUse = superDragon.getSubimage(i*500, 0, 500, 700);
		g.drawImage(dragonUse, resizeDragon, x-2, y);
		
	}
	
	public static void drawEgg(Graphics2D g,int x, int y){
		/* fill code */
		g.drawImage(egg, resizeEgg, x-25/2, y-5 );
	}
	
	public static void drawStar(Graphics2D g, int x, int y, int i){
		BufferedImage starUse = star.getSubimage(i*100, 0, 100, 100);
		g.drawImage(starUse, resizeStar, x, y);
	}
	
	public static void drawShell(Graphics2D g, int x, int y, int i){
		BufferedImage shellUse = shell.getSubimage(i*200, 0, 200, 200);
		g.drawImage(shellUse, resizeShell, x, y);
	}
	
	public static void drawSuperEgg(Graphics2D g, int x, int y){
		g.drawImage(superEgg, resizeEgg, x-25/2, y-5);
	}
	
	public static void drawPauseScreen(Graphics2D g){
		AlphaComposite tran = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f);
		g.setComposite(tran);
		
		g.setColor(Color.DARK_GRAY);
		g.fillRect(0, 0, GameScreen.WIDTH, GameScreen.HEIGHT);
		
	}
	
	public static void drawLoseScreen(Graphics2D g){
		AlphaComposite tran = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.7f);
		g.setComposite(tran);
		
		g.setColor(Color.DARK_GRAY);
		g.fillRect(0, 0, GameScreen.WIDTH, GameScreen.HEIGHT);
		g.setColor(Color.white);
		g.setFont(standardFont);
		Rectangle2D rec = g.getFontMetrics().getStringBounds("YOU LOSE!", g);
		g.drawString("YOU LOSE!", (int) (GameScreen.WIDTH/2 - rec.getWidth()/2),(int) (GameScreen.HEIGHT/2 - rec.getHeight()/2));
	}
	
}
