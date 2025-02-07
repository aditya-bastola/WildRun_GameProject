
// Aditya Bastola
// 5 / 2 / 22
// PlatformGame.java
import java.awt.CardLayout;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

// add to cardLayoutPanel, set background and backbuttons
public class MenuPage extends JPanel

{
	
	//Image MAIN_PAGE_BACKGROUND = new ImageIcon("MAIN_PAGE_BACKGROUND.png").getImage();
	Image MENU_PAGE_BACKGROUND = new ImageIcon("MENU_PAGE.png").getImage();
	JButton LEVEL_1_BUTTON = new JButton();
	JButton LEVEL_2_BUTTON = new JButton();
	JButton LEVEL_3_BUTTON = new JButton();
	JButton TUTORIAL_BUTTON =  new JButton();
	JButton CHARACTER_BUTTON =  new JButton();
	
	CardLayout cardLayout; 
	cardLayoutPanel cards;
	
	// adds menu page to cardLayoutPanel
	public MenuPage (CardLayout cardLayout, cardLayoutPanel cards)
	{
		this.setLayout(null);
		runIt( cardLayout,  cards);
		cards.add(this);
		this.cardLayout  = cardLayout;
		this.cards  = cards;
	}
	// draws background
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.drawImage(MENU_PAGE_BACKGROUND, 0,0, 1200, 700, null);
	}
	
	// makes backbuttons to direct user to different panels
	public void runIt(CardLayout cardLayout, cardLayoutPanel cards) {

		//cardLayout.setRequestFocusOnCard(true);
		this.add(LEVEL_1_BUTTON);
		this.add(LEVEL_2_BUTTON);
		this.add(LEVEL_3_BUTTON);
		this.add(TUTORIAL_BUTTON);
		this.add(CHARACTER_BUTTON);

		LEVEL_1_BUTTON.setBounds(180,210,265,75);
		LEVEL_1_BUTTON.addActionListener(e -> cardLayout.show(cards, "LEVEL_ONE"));
		LEVEL_1_BUTTON.setOpaque(false);
		LEVEL_1_BUTTON.setContentAreaFilled(false);
		LEVEL_1_BUTTON.setBorderPainted(false);


		LEVEL_2_BUTTON.setBounds(455,320,265,75);
		LEVEL_2_BUTTON.addActionListener(e -> cardLayout.show(cards, "LEVEL_TWO"));
		LEVEL_2_BUTTON.setOpaque(false);
		LEVEL_2_BUTTON.setContentAreaFilled(false);
		LEVEL_2_BUTTON.setBorderPainted(false);

		LEVEL_3_BUTTON.setBounds(730,210,265,75);
		LEVEL_3_BUTTON.addActionListener(e -> cardLayout.show(cards, "LEVEL_THREE"));
		LEVEL_3_BUTTON.setOpaque(false);
		LEVEL_3_BUTTON.setContentAreaFilled(false);
		LEVEL_3_BUTTON.setBorderPainted(false);

		TUTORIAL_BUTTON.setBounds(240,450,280,80);
		TUTORIAL_BUTTON.addActionListener(e -> cardLayout.show(cards, "TUTORIAL_PAGE"));
		TUTORIAL_BUTTON.setOpaque(false);
		TUTORIAL_BUTTON.setContentAreaFilled(false);
		TUTORIAL_BUTTON.setBorderPainted(false);
		
		CHARACTER_BUTTON.setBounds(600,450,280,80);
		CHARACTER_BUTTON.addActionListener(e -> cardLayout.show(cards, "CHARACTER_SELECT"));
		CHARACTER_BUTTON.setOpaque(false);
		CHARACTER_BUTTON.setContentAreaFilled(false);
		CHARACTER_BUTTON.setBorderPainted(false);
		
		
	}

}
