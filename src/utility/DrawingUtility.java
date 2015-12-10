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

	public static BufferedImage duckPic = getImage("res/img/duck-all.png");
	public static BufferedImage superDuckPic = getImage("res/img/superDuck-all.png");
	public static BufferedImage star = getImage("res/img/star-all.png");
	public static BufferedImage dragon = getImage("res/img/toothless-all.png");
	public static BufferedImage superDragon = getImage("res/img/toothlessSuper-all.png");
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
		BufferedImage dragonUse = dragon.getSubimage(i*500, 0, 500, 700);
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
	
}
