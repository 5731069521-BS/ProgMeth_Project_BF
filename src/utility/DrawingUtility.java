package utility;

import java.awt.Font;
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
	public static BufferedImage bg = getImage("res/bg_night.jpg");
	protected static BufferedImage waveAnim;
	
	public static BufferedImage getWaveAnim(){
		return waveAnim;
	}
	
	public static void drawDuck(){
		/* fill code */
		
	}
	
	public static void drawDragon(){
		/* fill code */
		
	}
	
	public static void drawEgg(){
		/* fill code */
		
	}
	
}
