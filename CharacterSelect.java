// Aditya Bastola
// 5 / 2 / 22
// PlatformGame.java
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

// add to cardLayoutPanel, set background and backbuttons
public class CharacterSelect extends JPanel
{
	JButton BACK_TO_MENU = new JButton ("");
	
	Image CHARACTER_SELECT_BACKGROUND = new ImageIcon("CharacterSelectScreen.png").getImage();
	
	JButton chooseBoy = new JButton(".");
	JButton chooseGirl = new JButton("..");
	
	boolean isMale = false;
	
	

	// adds characterSelect panel to cardlayout
	public CharacterSelect(CardLayout cardLayout, cardLayoutPanel cards, LevelOne lOne, LevelTwo lTwo, LevelThree lThree)
	{
		
		
		this.add(BACK_TO_MENU);
		this.add(chooseBoy);
		this.add(chooseGirl);
		

		//BACK_TO_MENU.addActionListener(e -> cardLayout.show(cards, "MENU_PAGE"));
		
		runIt( cardLayout,  cards, lOne, lTwo, lThree);

		cards.add(this);
		
		this.setLayout(null);
		
		
	}

	// draws characterSelect on characterSelect panel for refrence
	public void paintComponent (Graphics g)
	{
		super.paintComponent(g);
		g.drawImage(CHARACTER_SELECT_BACKGROUND, 0,0, 1200, 700, null);
		
		
		//System.out.println(isMale);
		
		if (isMale)
		{
			g.setColor(Color.GREEN);
			g.drawRect(360,470,130,160);
		}
		if (isMale == false)
		{
			g.setColor(Color.GREEN);
			g.drawRect(650,470,130,160);
		}
		
		
		
	}
	
	// has buttons and action listeners for character selection
	public void runIt(CardLayout cardLayout, cardLayoutPanel cards, LevelOne lOne, LevelTwo lTwo, LevelThree lThree)
	{
		BACK_TO_MENU.setBounds(395,30,400,80);
		BACK_TO_MENU.addActionListener(e -> cardLayout.show(cards, "MENU_PAGE"));
		BACK_TO_MENU.setOpaque(false);
		BACK_TO_MENU.setContentAreaFilled(false);
		BACK_TO_MENU.setBorderPainted(false);
			
		chooseBoy.setBounds(360,470,180,160);
		chooseBoy.setOpaque(false);
		chooseBoy.setContentAreaFilled(false);
		chooseBoy.setBorderPainted(false);
		
		chooseBoy.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	        	 isMale = true;
	        	 lOne.isMale = isMale;
	        	 lTwo.isMale = isMale;
	        	// lThree.isMale = isMale;
	        	 //System.out.println("Male");
	        	 repaint();
	        	 
	         }
	      });
		
		chooseGirl.setBounds(570,470,180,160);
		chooseGirl.setOpaque(false);
		chooseGirl.setContentAreaFilled(false);
		chooseGirl.setBorderPainted(false);
		
		chooseGirl.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	        	 isMale = false;
	        	 lOne.isMale = isMale;
	        	 lTwo.isMale = isMale;
	        	 //lThree.isMale = isMale;
	        	// System.out.println("Female");
	        	 repaint();
	        	
	         }
	      });
		
		
		
	
	}
	
	

	

}


