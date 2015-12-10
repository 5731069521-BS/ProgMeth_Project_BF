package utility;

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class DrawingUtility {
	protected static final Font standardFont = new Font("Tahoma", Font.BOLD, 30);
	
	protected static BufferedImage getImage(String directory){
		ClassLoader loader = DrawingUtility.class.getClassLoader();
		try{
			return ImageIO.read(loader.getResource(directory));
		}catch(IOException e){
			return null;
		}
	}

	public static BufferedImage duckPic = getImage("res/duck-all.png");
	public static BufferedImage superDuckPic = getImage("res/superDuck-all.png");
	public static BufferedImage star = getImage("res/star-all.png");
	public static BufferedImage dragon = getImage("res/toothless-all.png");
	public static BufferedImage superDragon = getImage("res/toothlessSuper-all.png");
	public static BufferedImage egg = getImage("res/egg.png");
	public static BufferedImage superEgg = getImage("res/superEgg.png");
	public static BufferedImage shell = getImage("res/shell.png");
	public static BufferedImage[] bg = new BufferedImage[7];
	
	public static void createBg(){
		bg[0] = getImage("res/background-1.png");
		bg[1] = getImage("res/background-2.png");
		bg[2] = getImage("res/background-3.png");
		bg[3] = getImage("res/background-4.png");
		bg[4] = getImage("res/background-5.png");
		bg[5] = getImage("res/background-6.png");
		bg[6] = getImage("res/background-7.png");
		
	}
	
//	public static int duckCount = 0;
	public static final AffineTransformOp resizeDuck = new AffineTransformOp(AffineTransform.getScaleInstance(0.75/2, 0.75/2), AffineTransformOp.TYPE_BICUBIC);
	public static final AffineTransformOp resizeDragon = new AffineTransformOp(AffineTransform.getScaleInstance(0.75/5, 0.75/5), AffineTransformOp.TYPE_BICUBIC);
	public static final AffineTransformOp resizeStar = new AffineTransformOp(AffineTransform.getScaleInstance(0.3, 0.3), AffineTransformOp.TYPE_BICUBIC);
	public static final AffineTransformOp resizeEgg = new AffineTransformOp(AffineTransform.getScaleInstance(0.25, 0.25), AffineTransformOp.TYPE_BICUBIC);
	public static final AffineTransformOp resizeShell = new AffineTransformOp(AffineTransform.getScaleInstance(0.75/2, 0.75/2), AffineTransformOp.TYPE_BICUBIC);
	
	protected static BufferedImage waveAnim;
	
	public static BufferedImage getWaveAnim(){
		return waveAnim;
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
		BufferedImage dragonUse = dragon.getSubimage(i*500, 0, 500, 500);
		g.drawImage(dragonUse, resizeDragon, x, y);
	}
	
	public static void drawSuperDragon(Graphics2D g, int x, int y, int i){
		BufferedImage dragonUse = superDragon.getSubimage(i*500, 0, 500, 500);
		g.drawImage(dragonUse, resizeDragon, x, y);
		
	}
	
	public static void drawEgg(Graphics2D g,int x, int y){
		/* fill code */
		g.drawImage(egg, resizeEgg, x-25/2, y-5 );
	}
	
	public static void drawStar(Graphics2D g, int x, int y, int i){
		BufferedImage starUse = star.getSubimage(i*100, 0, 100, 100);
		g.drawImage(starUse, resizeStar, x, y);
	}
	
	public static void drawShell(Graphics2D g, int x, int y){
		g.drawImage(shell, resizeShell, x, y);
	}
	
	public static void drawSuperEgg(Graphics2D g, int x, int y){
		g.drawImage(superEgg, resizeEgg, x-25/2, y-5);
	}
	
}
