// Aditya Bastola
// 5 / 2 / 22
// PlatformGame.java
import java.awt.CardLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.Timer;

// add to cardLayoutPanel, set background and backbuttons
public class TutorialPage extends JPanel implements ActionListener
{
	Image TUTORIAL_PAGE_BACKGROUND = new ImageIcon("tutorial_background.png").getImage();

	JButton BACK_TO_MENU =  new JButton();
	
	int jumpCounter = 0;
	int forwardCounter = 0;
	int backwardCounter = 1000;
	
	ImageIcon jump = new ImageIcon("jumpText.png");
	Image jump1 = jump.getImage();
	
	boolean jumpUp = true;
	
	ImageIcon forward = new ImageIcon("forwardText.png");
	Image forward1 = forward.getImage();
	
	ImageIcon backward = new ImageIcon("backwardsText.png");
	Image backward1 = backward.getImage();
	
	Timer timer;
	
	private final int DELAY = 25;


	// adds panel to cardlayout
	public TutorialPage(CardLayout cardLayout, cardLayoutPanel cards)
	{

		this.setLayout(null);

		runIt( cardLayout,  cards);

		cards.add(this);
		
		timer = new Timer(DELAY,this);
		timer.start();








	}

	// makes backbuttons
	public void runIt(CardLayout cardLayout, cardLayoutPanel cards)
	{
		this.add(BACK_TO_MENU);

		BACK_TO_MENU.setBounds(380,545,370,100);

		BACK_TO_MENU.addActionListener(e -> cardLayout.show(cards, "MENU_PAGE"));

		BACK_TO_MENU.setOpaque(false);
		BACK_TO_MENU.setContentAreaFilled(false);
		BACK_TO_MENU.setBorderPainted(false);
	}
	// sets background
	public void paintComponent (Graphics g)
	{
		g.drawImage(TUTORIAL_PAGE_BACKGROUND, 0,0, 1200, 700, null);
		
		g.drawImage(jump1, 665, 150 + jumpCounter, 270, 85, null);
		
		g.drawImage(forward1, forwardCounter,270, 350, 85, null);
		
		g.drawImage(backward1, backwardCounter,400, 380, 85, null);
		
		updateText();
		
		
		
		
	}
	
	public void actionPerformed (ActionEvent e)
	{
		repaint();
	}
	
	public void updateText() {
		
		if (jumpCounter == 0)
			jumpUp = true;
		if (jumpCounter == -50)
			jumpUp = false;
			
	
		if (jumpUp)
			jumpCounter-=2;
		else 
			jumpCounter+=2;
			
		forwardCounter+= 10;
		
		if (forwardCounter == 1000)
			forwardCounter = 0;
		
		backwardCounter-= 10;
		
		if (backwardCounter == 0)
			backwardCounter = 1000;
		

		
	}

}
