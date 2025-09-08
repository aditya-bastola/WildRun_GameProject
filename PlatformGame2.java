// Aditya Bastola
// PlatformGame.java

import javax.swing.*;

// creates frame and has main
public class PlatformGame2 {

	// creates frame
	public PlatformGame2()
	{
		JFrame frame = new JFrame();
		frame.setTitle("PlatformGame2");
		frame.setLocation(0,0);
		cardLayoutPanel cLayoutPanel = new cardLayoutPanel();
		frame.setContentPane(cLayoutPanel);
		frame.setSize(1200,675);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setResizable(true);
	}
	
	// main
	public static void main (String [] args)
	{
		PlatformGame2 pGame2 =  new PlatformGame2();
	}

}
