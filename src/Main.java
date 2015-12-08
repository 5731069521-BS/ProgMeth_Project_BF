import javax.swing.JFrame;

import render.GameScreen;
import logic.GameLogic;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame("Catch a fruit");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		GameScreen gameScreen = new GameScreen();
		GameLogic gameLogic = new GameLogic();
		
		frame.getContentPane().add(gameScreen);
		frame.setVisible(true);
		frame.pack();
		gameScreen.requestFocus();
		
		while(true){
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {}
			gameScreen.repaint();
			gameLogic.logicUpdate();
		}
	}

}
