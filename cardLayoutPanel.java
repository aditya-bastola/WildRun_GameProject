// Aditya Bastola
// 5 / 2 / 22
// PlatformGame.java

//import java.awt.CardLayout;
import java.awt.CardLayout;

import javax.swing.JPanel;

// add panel to cardLayoutPanel, add backbuttons and background
public class cardLayoutPanel extends JPanel
{

	private CardLayout cardLayout = new CardLayout();
	
	
	// add each panel to cardLayoutPanel that uses cardLayout()
	public cardLayoutPanel() {
		
		setLayout(cardLayout);
		
		MenuPage mPage = new MenuPage(cardLayout, this);
		add(mPage, "MENU_PAGE");

		TutorialPage tPage = new TutorialPage(cardLayout,this);
		add(tPage, "TUTORIAL_PAGE");
		
		
		LevelOne lOne =  new LevelOne(cardLayout,this);
		add(lOne, "LEVEL_ONE");

		//lOne.isMale = csPage.isMale;
		
		LevelTwo lTwo =  new LevelTwo(cardLayout,this);
		add(lTwo, "LEVEL_TWO");

		LevelThree lThree = new LevelThree(cardLayout, this);
		add(lThree, "LEVEL_THREE");
		
		CharacterSelect csPage = new CharacterSelect(cardLayout, this, lOne, lTwo, lThree);
		add(csPage, "CHARACTER_SELECT");

		
		//lOne.setFocusable(true);
		
		//cardLayout.setRequestFocusOnCard(true);
		
	}

}
