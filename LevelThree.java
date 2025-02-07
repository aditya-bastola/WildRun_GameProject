
		
		// Aditya Bastola
		// 5 / 2 / 22
		// PlatformGame.java
		import java.awt.CardLayout;
		import java.awt.Color;
		import java.awt.Font;
		import java.awt.Graphics;
		import java.awt.Image;
		import java.awt.Rectangle;
		import java.awt.event.ActionEvent;
		import java.awt.event.ActionListener;
		import java.awt.event.ComponentAdapter;
		import java.awt.event.ComponentEvent;
		import java.awt.event.KeyEvent;
		import java.awt.event.KeyListener;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
		import java.io.IOException;
		import java.util.ArrayList;
		import java.util.concurrent.TimeUnit;

		import javax.swing.ImageIcon;
		import javax.swing.JButton;
		import javax.swing.JPanel;
		import javax.swing.Timer;









		// add to cardLayoutPanel, set background and backbuttons
		public class LevelThree extends JPanel implements KeyListener, ActionListener
		{

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			JButton TO_HOME_PAGE = new JButton ("");



			int bloodCounter = 0;

			private  JButton RESET = new JButton (".");

			boolean restartBool = false;

			int bloodX = 0;
			int bloodY = 0;

			int deadX = 0;
			int deadY = 0;

			int deadCounter = 0;

			boolean bloodAnimation = false;

			boolean deadAnimation = false;

			boolean fourFrames = false;

			ImageIcon brick = new ImageIcon("brick_1.png");
			Image brick1 = brick.getImage();
			ImageIcon backwardsSpace = new ImageIcon("space_background.png");
			Image backwardsSpace1 = backwardsSpace.getImage();
			ImageIcon waterBlock = new ImageIcon("water_block.png");
			Image waterBlock1 = waterBlock.getImage();

			ImageIcon background = new ImageIcon("background0.png");
			Image background1 = background.getImage();

			ImageIcon level2ButtonIcon = new ImageIcon("level_2_button.png");
			Image level2Button = level2ButtonIcon.getImage();
			ImageIcon grassBlock = new ImageIcon("minecraft_block.png");
			Image grassBlock1 = grassBlock.getImage();

			ImageIcon fullHeart = new ImageIcon("full_heart.png");
			Image fullHeart1 = fullHeart.getImage();
			ImageIcon halfHeart = new ImageIcon("half_heart.png");
			Image halfHeart1 = halfHeart.getImage();
			ImageIcon emptyHeart = new ImageIcon("empty_heart.png");
			Image emptyHeart1 = emptyHeart.getImage();
			ImageIcon longBlock = new ImageIcon("long_grass_block.png");
			Image longGrassBlock1 = longBlock.getImage();
			ImageIcon transparentBlock = new ImageIcon("transparent_block.png");
			Image transparentBlock1 = transparentBlock.getImage();
			ImageIcon jetPackRight = new ImageIcon("jetPackRight.png");
			Image jetPackRight1 = jetPackRight.getImage();
			ImageIcon jetPackLeft = new ImageIcon("jetPackLeft.png");
			Image jetPackLeft1 = jetPackLeft.getImage();
			ImageIcon underWater = new ImageIcon("backwards_space.png");
			Image underWater1 = underWater.getImage();
			ImageIcon gameOverScreen = new ImageIcon("gameOverScreen.png");
			Image gameOverScreen1 = gameOverScreen.getImage();


			ImageIcon grassBlock2 = new ImageIcon("grass_block2.png");
			Image grassBlock12 = grassBlock2.getImage();

			ImageIcon RESET_IMAGE = new ImageIcon("restart_button.png");
			Image RESET_IMAGE1 = RESET_IMAGE.getImage();

			ArrayList <Sprite> spriteArrayList =  new ArrayList<Sprite>();
			ArrayList <Sprite> enemyArrayList =  new ArrayList<Sprite>();
			ArrayList <Sprite> coinArrayList =  new ArrayList<Sprite>();
			ArrayList <Sprite> defaultCoinArrayList =  new ArrayList<Sprite>();
			ArrayList <Sprite> entryPortalArrayList =  new ArrayList<Sprite>();

			Font myFont1 = new Font("Sans Serif", Font.BOLD, 30);



			int [] [] csvArray;

			Image [] imageArray = new Image [10];
			Sprite p1;

			Sprite sprite1;
			private final int DELAY = 25;
			private Timer timer;
			static final int SPRITE_SIZE = 50;
			static int GRAVITY = 1;
			static final int JUMP_VELOCITY = 12;
			static final int RIGHT_MARGIN = 300;
			static final int LEFT_MARGIN = 130;
			static final int VERTICAL_MARGIN = -600;
			int spriteTimer = 180;
			int sprite = 1;
			static int viewX = 0;
			static int viewY = 0;
			static final int WIDTH = 675;
			static final int LENGTH = 1200;

			boolean gameOver = false;

			Rectangle r;


			ArrayList <Image> coinAnimationImages = new ArrayList <Image>();
			ArrayList <Image> enemyImages = new ArrayList<Image>();
			ArrayList <Image> charOneCurrent = new ArrayList<Image>();
			ArrayList <Image> charOneStandLeft = new ArrayList<Image>();
			ArrayList <Image> charOneStandRight = new ArrayList<Image>();
			ArrayList <Image> charOneGoLeft = new ArrayList<Image>();
			ArrayList <Image> charOneGoRight = new ArrayList<Image>();
			ArrayList <Image> charOneJumpLeft = new ArrayList<Image>();
			ArrayList <Image> charOneJumpRight = new ArrayList<Image>();


			ArrayList <Image> charTwoCurrent = new ArrayList<Image>();
			ArrayList <Image> charTwoStandLeft = new ArrayList<Image>();
			ArrayList <Image> charTwoStandRight = new ArrayList<Image>();
			ArrayList <Image> charTwoGoLeft = new ArrayList<Image>();
			ArrayList <Image> charTwoGoRight = new ArrayList<Image>();
			ArrayList <Image> charTwoJumpLeft = new ArrayList<Image>();
			ArrayList <Image> charTwoJumpRight = new ArrayList<Image>();

			ArrayList <Image> swampManRight = new ArrayList<Image>();
			ArrayList <Image> swampManLeft = new ArrayList<Image>();

			ArrayList <Image> bloodSplatter = new ArrayList<Image>();

			ArrayList <Image> bodies = new ArrayList<Image>(); // 0 is male, 1 is female

			Image [] bluePortalArray = new Image [4];
			Image [] redPortalArray = new Image [4];


			String playerDirection = "RIGHT"; // type "RIGHT" or "LEFT



			int lives = 3;
			int coinsNum = 0;

			boolean sideToSideMovement = false;

			public boolean isMale = false;

			int jetPackShots = 5;

			boolean noXOverlap = true;
			boolean noYOverlap = true;

			boolean enemyContact = false;

			int deadDelayCounter = 0;


			// empty constructor
			public LevelThree() {

			}


			// Uses CSV arrays to put the sprites/platforms in an arraylist later used to display sprite objects on screen
			public LevelThree(CardLayout cardLayout, cardLayoutPanel cards)
			{
				super();


				this.addComponentListener( new ComponentAdapter() {
					@Override
					public void componentShown( ComponentEvent e ) {
						LevelThree.this.requestFocusInWindow();

					}
				});



				r = new Rectangle (100,100,200,100);

				this.setLayout(null);

				addKeyListener(this);

				imageLoadArray(bluePortalArray,"blue_portal.png",0);
				imageLoadArray(bluePortalArray,"blue_portal2.png",1);
				imageLoadArray(bluePortalArray,"blue_portal3.png",2);
				imageLoadArray(bluePortalArray,"blue_portal4.png",3);

				imageLoadArray(redPortalArray,"red_portal.png",0);
				imageLoadArray(redPortalArray,"red_portal2.png",1);
				imageLoadArray(redPortalArray,"red_portal3.png",2);
				imageLoadArray(redPortalArray,"red_portal4.png",3);

				imageLoad(bodies,"charOneDead.png",0);
				imageLoad(bodies,"charTwoDead.png",1);





				//imageArray[0] = grassBlock1;
				//imageArray[0] = grassBlock12;
				//imageArray[0] = brick12;
				//imageArray[0] = fullHeart1;

				imageArray[1] = waterBlock1;
				imageArray[0] = transparentBlock1;

				TO_HOME_PAGE.setSize(200,75);

				TO_HOME_PAGE.setOpaque(false);
				TO_HOME_PAGE.setContentAreaFilled(false);
				TO_HOME_PAGE.setBorderPainted(false);

				this.add(TO_HOME_PAGE);

				TO_HOME_PAGE.addActionListener(e -> cardLayout.show(cards, "MENU_PAGE"));

				cards.add(this);

				RESET.setSize(200,75);

				RESET.setOpaque(false);
				RESET.setContentAreaFilled(false);
				RESET.setBorderPainted(false);

				ButtonListener bListener = new ButtonListener();
				RESET.addActionListener(bListener);

				RESET.setFocusable(false);


				// ball XY location

				restartBool = false;



				this.add(RESET);


				//csvArray = CSVReader.readCSV("Configuration.csv");
				csvArray = CSVReader.readCSV("LevelTwoMap.csv");

				createCSVObject();

				BufferedImageLoader loader = new BufferedImageLoader();

				BufferedImage spriteSheet2 = null;

				SpriteSheet spriteSheet = null;

				try {

					spriteSheet2 =  loader.loadImage("marioSpriteSheet.png");
				}
				catch (IOException e)
				{
					e.printStackTrace();
				}

				/*
				for (int i = 1; i < 7; i++)
				{
					ImageIcon coin = new ImageIcon("star coin rotate " + i + ".png");
					Image coin1 = coin.getImage();
					coinAnimationImages.add(coin1);
				}
				 */

				for (int i = 1; i < 5; i++)
				{
					ImageIcon coin = new ImageIcon("waterOrb" + i + ".png");
					Image coin1 = coin.getImage();
					coinAnimationImages.add(coin1);
				}

				for (int i = 1; i < 5; i++)
				{
					ImageIcon coin = new ImageIcon("bloodSplatter" + i + ".png");
					Image coin1 = coin.getImage();
					bloodSplatter.add(coin1);
				}


				ImageIcon snakeLeft = new ImageIcon("left_snake.png");
				Image snakeLeft1 = snakeLeft.getImage();
				enemyImages.add(snakeLeft1);

				ImageIcon snakeRight = new ImageIcon("right_snake.png");
				Image snakeRight1 = snakeRight.getImage();
				enemyImages.add(snakeRight1);


				imageLoad(charOneStandRight,"charOneRightNeutral.png",0);
				imageLoad(charOneStandLeft,"charOneLeftNeutral.png",0);
				imageLoad(charOneJumpLeft,"charOneJumpLeft.png", 0);
				imageLoad(charOneJumpRight,"charOneJumpRight.png", 0);

				imageLoad(charOneGoRight,"charOneRightRun1.png", 0);
				imageLoad(charOneGoRight,"charOneRightRun2.png", 1);
				imageLoad(charOneGoRight,"charOneRightRun3.png", 2);
				imageLoad(charOneGoRight,"charOneRightRun4.png", 3);
				imageLoad(charOneGoRight,"charOneRightRun5.png", 4);
				imageLoad(charOneGoRight,"charOneRightRun6.png", 5);

				imageLoad(charOneGoLeft,"charOneLeftRun1.png", 0);
				imageLoad(charOneGoLeft,"charOneLeftRun2.png", 1);
				imageLoad(charOneGoLeft,"charOneLeftRun3.png", 2);
				imageLoad(charOneGoLeft,"charOneLeftRun4.png", 3);
				imageLoad(charOneGoLeft,"charOneLeftRun5.png", 4);
				imageLoad(charOneGoLeft,"charOneLeftRun6.png", 4);

				// CHAR TWO

				imageLoad(charTwoStandRight,"charTwoStandRight.png",0);
				imageLoad(charTwoStandLeft,"charTwoStandLeft.png",0);


				imageLoad(charTwoJumpLeft,"charTwoJumpLeft.png", 0);
				imageLoad(charTwoJumpRight,"charTwoJumpRight.png", 0);

				imageLoad(charTwoGoRight,"charTwoRightRun1.png", 0);
				imageLoad(charTwoGoRight,"charTwoRightRun2.png", 1);
				imageLoad(charTwoGoRight,"charTwoRightRun3.png", 2);
				imageLoad(charTwoGoRight,"charTwoRightRun4.png", 3);
				imageLoad(charTwoGoRight,"charTwoRightRun5.png", 4);
				imageLoad(charTwoGoRight,"charTwoRightRun6.png", 5);

				imageLoad(charTwoGoLeft,"charTwoLeftRun1.png", 0);
				imageLoad(charTwoGoLeft,"charTwoLeftRun2.png", 1);
				imageLoad(charTwoGoLeft,"charTwoLeftRun3.png", 2);
				imageLoad(charTwoGoLeft,"charTwoLeftRun4.png", 3);
				imageLoad(charTwoGoLeft,"charTwoLeftRun5.png", 4);
				imageLoad(charTwoGoLeft,"charTwoLeftRun6.png", 4);



				// enemyImages

				imageLoad(swampManRight, "swampRunRight1.png", 0);
				imageLoad(swampManRight, "swampRunRight2.png", 1);
				imageLoad(swampManRight, "swampRunRight3.png", 2);
				imageLoad(swampManRight, "swampRunRight4.png", 3);
				imageLoad(swampManRight, "swampRunRight5.png", 4);

				imageLoad(swampManLeft, "swampRunLeft1.png", 0);
				imageLoad(swampManLeft, "swampRunLeft2.png", 1);
				imageLoad(swampManLeft, "swampRunLeft3.png", 2);
				imageLoad(swampManLeft, "swampRunLeft4.png", 3);
				imageLoad(swampManLeft, "swampRunLeft5.png", 4);









				if (isMale) {
					p1 = new Sprite(220,100,0,0, 50,50, charOneStandRight, charOneStandLeft, charOneJumpRight, charOneJumpLeft, charOneGoRight, charOneGoLeft, true);
				}
				else {
					p1 = new Sprite(150,100,0,0, 50,50, charTwoStandRight, charTwoStandLeft, charTwoJumpRight, charTwoJumpLeft, charTwoGoRight, charTwoGoLeft, true);
				}



				if (isMale)
				{
					p1.playerStandRight = charOneStandRight;
					p1.playerStandLeft = charOneStandLeft;
					p1.playerJumpRight = charOneJumpRight;
					p1.playerJumpLeft = charOneJumpLeft;
					p1.playerGoRight = charOneGoRight;
					p1.playerGoLeft = charOneGoLeft;
				}
				else {
					p1.playerStandRight = charTwoStandRight;
					p1.playerStandLeft = charTwoStandLeft;
					p1.playerJumpRight = charTwoJumpRight;
					p1.playerJumpLeft = charTwoJumpLeft;
					p1.playerGoRight = charTwoGoRight;
					p1.playerGoLeft = charTwoGoLeft;
				}


				//repaint();
				timer = new Timer(DELAY, this);
				timer.start();

			}

			// button's action listener, resets game
			class ButtonListener implements ActionListener {

				public void actionPerformed(ActionEvent e) {


					p1.setx_center(150);
					p1.setX_velocity(0);
					p1.setDIRECTION(2);
					gameOver = false;
					lives = 3;
					p1.setJetpack(false);

					spriteArrayList.clear();
					createCSVObject();
					coinsNum = 0;


				}
			}

			// creates sprite objects from array
			public void createCSVObject() {


				for (int m = 0; m < csvArray.length; m++)
				{
					for (int n = 0; n < csvArray[0].length; n++)
					{
						if (csvArray [m] [n] != 0)
						{
							if (csvArray [m] [n] == 1) // dirt 
							{
								sprite1 = new Sprite (SPRITE_SIZE/2 + n*SPRITE_SIZE,SPRITE_SIZE/2 + m*SPRITE_SIZE,0,0,SPRITE_SIZE,SPRITE_SIZE,imageArray[0]);
							}

							if (csvArray [m] [n] == 2) { // brick
								sprite1 = new Sprite (SPRITE_SIZE/2 + n*SPRITE_SIZE,SPRITE_SIZE/2 + m*SPRITE_SIZE,0,0,SPRITE_SIZE,SPRITE_SIZE,imageArray[1]);
							}

							if (csvArray [m] [n] == 3 ) // coin
							{
								sprite1 = new Sprite (SPRITE_SIZE/2 + n*SPRITE_SIZE,SPRITE_SIZE/2 + m*SPRITE_SIZE,0,0,SPRITE_SIZE,SPRITE_SIZE,coinAnimationImages);
								sprite1.setAnimate(true);
								sprite1.setCoinObject(true);
								sprite1.setWaterOrb(true);
								

								coinArrayList.add(sprite1);

								defaultCoinArrayList.add(sprite1);
							}

							if (csvArray [m] [n] == 4) // enemy
							{

								int leftBound = n * SPRITE_SIZE;
								int rightBound = leftBound + 4 * SPRITE_SIZE;

								sprite1 = new Sprite (SPRITE_SIZE/2 + n*SPRITE_SIZE,SPRITE_SIZE/2 + m*SPRITE_SIZE,2,0,SPRITE_SIZE,SPRITE_SIZE,enemyImages,leftBound,rightBound);
								sprite1.setx_center(SPRITE_SIZE/2 + n * SPRITE_SIZE);
								sprite1.sety_center(SPRITE_SIZE/2 + m * SPRITE_SIZE);
								sprite1.setEnemy(true);

								enemyArrayList.add(sprite1);
							}
							if (csvArray [m] [n] == 42) // enemy 2 length
							{

								int leftBound = n * SPRITE_SIZE;
								int rightBound = leftBound + 2 * SPRITE_SIZE;

								sprite1 = new Sprite (SPRITE_SIZE/2 + n*SPRITE_SIZE,SPRITE_SIZE/2 + m*SPRITE_SIZE,2,0,SPRITE_SIZE,SPRITE_SIZE,enemyImages,leftBound,rightBound);
								sprite1.setx_center(SPRITE_SIZE/2 + n * SPRITE_SIZE);
								sprite1.sety_center(SPRITE_SIZE/2 + m * SPRITE_SIZE);
								sprite1.setEnemy(true);

								enemyArrayList.add(sprite1);
							}

							if (csvArray [m] [n] == 43) // enemy 4 length moves other way
							{

								int leftBound = n * SPRITE_SIZE - 100;
								int rightBound = n * SPRITE_SIZE;

								sprite1 = new Sprite (SPRITE_SIZE/2 + n*SPRITE_SIZE,SPRITE_SIZE/2 + m*SPRITE_SIZE,-2,0,SPRITE_SIZE,SPRITE_SIZE,enemyImages,leftBound,rightBound);
								sprite1.setx_center(SPRITE_SIZE/2 + n * SPRITE_SIZE);
								sprite1.sety_center(SPRITE_SIZE/2 + m * SPRITE_SIZE);
								sprite1.setEnemy(true);

								enemyArrayList.add(sprite1);
							}
							if (csvArray [m] [n] == 44) // swamp monster length 6 to left
							{

								int leftBound = n * SPRITE_SIZE - 300;
								int rightBound = n * SPRITE_SIZE;

								sprite1 = new Sprite (SPRITE_SIZE/2 + n*SPRITE_SIZE,SPRITE_SIZE/2 + m*SPRITE_SIZE,-2,0,SPRITE_SIZE,SPRITE_SIZE,swampManRight, swampManLeft,leftBound,rightBound);
								sprite1.setx_center(SPRITE_SIZE/2 + n * SPRITE_SIZE);
								sprite1.sety_center(SPRITE_SIZE/2 + m * SPRITE_SIZE);
								//sprite1.setEnemy(true);
								sprite1.setAnimatedEnemy(true);

								enemyArrayList.add(sprite1);
							}
							if (csvArray [m] [n] == 45) // swamp monster length 6 to right
							{

								int leftBound = n * SPRITE_SIZE;
								int rightBound = n * SPRITE_SIZE + SPRITE_SIZE * 6;

								sprite1 = new Sprite (SPRITE_SIZE/2 + n*SPRITE_SIZE,SPRITE_SIZE/2 + m*SPRITE_SIZE,2,0,SPRITE_SIZE,SPRITE_SIZE,swampManRight, swampManLeft,leftBound,rightBound);
								sprite1.setx_center(SPRITE_SIZE/2 + n * SPRITE_SIZE);
								sprite1.sety_center(SPRITE_SIZE/2 + m * SPRITE_SIZE);
								//sprite1.setEnemy(true);
								sprite1.setAnimatedEnemy(true);

								enemyArrayList.add(sprite1);
							}
							if (csvArray [m] [n] == 46) // swamp monster length 3 to left
							{

								int leftBound = n * SPRITE_SIZE - 150;
								int rightBound = n * SPRITE_SIZE;

								sprite1 = new Sprite (SPRITE_SIZE/2 + n*SPRITE_SIZE,SPRITE_SIZE/2 + m*SPRITE_SIZE,-2,0,SPRITE_SIZE,SPRITE_SIZE,swampManRight, swampManLeft,leftBound,rightBound);
								sprite1.setx_center(SPRITE_SIZE/2 + n * SPRITE_SIZE);
								sprite1.sety_center(SPRITE_SIZE/2 + m * SPRITE_SIZE);
								//sprite1.setEnemy(true);
								sprite1.setAnimatedEnemy(true);

								enemyArrayList.add(sprite1);
							}
							if (csvArray [m] [n] == 47) // swamp monster length 3 to right
							{

								int leftBound = n * SPRITE_SIZE;
								int rightBound = n * SPRITE_SIZE + SPRITE_SIZE * 3;

								sprite1 = new Sprite (SPRITE_SIZE/2 + n*SPRITE_SIZE,SPRITE_SIZE/2 + m*SPRITE_SIZE,2,0,SPRITE_SIZE,SPRITE_SIZE,swampManRight, swampManLeft,leftBound,rightBound);
								sprite1.setx_center(SPRITE_SIZE/2 + n * SPRITE_SIZE);
								sprite1.sety_center(SPRITE_SIZE/2 + m * SPRITE_SIZE);
								//sprite1.setEnemy(true);
								sprite1.setAnimatedEnemy(true);

								enemyArrayList.add(sprite1);
							}




							if (csvArray [m] [n] == 5) { // end game portal 
								sprite1 = new Sprite (SPRITE_SIZE/2 + n*SPRITE_SIZE,SPRITE_SIZE/2 + m*SPRITE_SIZE,0,0,SPRITE_SIZE,SPRITE_SIZE,bluePortalArray[2]);
								sprite1.setPortal(true);
							}

							if (csvArray [m] [n] == 51) { // entry portal - vertical - left
								sprite1 = new Sprite (SPRITE_SIZE/2 + n*SPRITE_SIZE,SPRITE_SIZE/2 + m*SPRITE_SIZE,0,0,SPRITE_SIZE,SPRITE_SIZE,bluePortalArray[0]);
								sprite1.setEntryPortal(true);

								System.out.println("51portal n: " + n);
								// portal 1
								
								entryPortalArrayList.add(sprite1);




							}
							if (csvArray [m] [n] == 52) { // entry portal - vertical - right
								sprite1 = new Sprite (SPRITE_SIZE/2 + n*SPRITE_SIZE,SPRITE_SIZE/2 + m*SPRITE_SIZE,0,0,SPRITE_SIZE,SPRITE_SIZE,bluePortalArray[1]);


								System.out.println("52portal n: " + n);

								if (n == 130) {
									sprite1.setEntryPortal(true);
						
									sprite1.setPortalX(51 * 50);
									sprite1.setPortalY(3 * 50);
									sprite1.setPlayerPortalX_velocity(0);
									sprite1.setPlayerPortalY_velocity(1);

								}

								entryPortalArrayList.add(sprite1);

								


							}

							if (csvArray [m] [n] == 53) { // entry portal - horizontal up
								sprite1 = new Sprite (SPRITE_SIZE/2 + n*SPRITE_SIZE,SPRITE_SIZE/2 + m*SPRITE_SIZE,0,0,SPRITE_SIZE,SPRITE_SIZE,bluePortalArray[2]);


								System.out.println("level 253portal n: " + n);

								// portal 2
								if (n == 50) {
									sprite1.setEntryPortal(true);
									System.out.println("2ndportal");
									sprite1.setPortalX(51 * 50);
									sprite1.setPortalY(3 * 50);
									sprite1.setPlayerPortalX_velocity(0);
									sprite1.setPlayerPortalY_velocity(1);

								}
								

								




								entryPortalArrayList.add(sprite1);




							}
							if (csvArray [m] [n] == 54) { // entry portal - horizontal down 
								sprite1 = new Sprite (SPRITE_SIZE/2 + n*SPRITE_SIZE,SPRITE_SIZE/2 + m*SPRITE_SIZE,0,0,SPRITE_SIZE,SPRITE_SIZE,bluePortalArray[3]);
								sprite1.setEntryPortal(true);

								System.out.println("portal n: " + n);
								
								
								if (n == 81 || n == 82) {
									sprite1.setEntryPortal(true);
									sprite1.setPortalX(90 * 50);
									sprite1.setPortalY(3 * 50);
									sprite1.setPlayerPortalX_velocity(0);
									sprite1.setPlayerPortalY_velocity(1);

								}


								entryPortalArrayList.add(sprite1);




							}


							if (csvArray [m] [n] == 55) { // player come out portal - vertical - right
								sprite1 = new Sprite (SPRITE_SIZE/2 + n*SPRITE_SIZE,SPRITE_SIZE/2 + m*SPRITE_SIZE,0,0,SPRITE_SIZE,SPRITE_SIZE,redPortalArray[0]);

							}
							if (csvArray [m] [n] == 56) { // player come out portal - vertical - right
								sprite1 = new Sprite (SPRITE_SIZE/2 + n*SPRITE_SIZE,SPRITE_SIZE/2 + m*SPRITE_SIZE,0,0,SPRITE_SIZE,SPRITE_SIZE,redPortalArray[1]);
								System.out.println("56 n: " + n);
							}
							if (csvArray [m] [n] == 57) { // player come out portal - horizontal - up receiving
								sprite1 = new Sprite (SPRITE_SIZE/2 + n*SPRITE_SIZE,SPRITE_SIZE/2 + m*SPRITE_SIZE,0,0,SPRITE_SIZE,SPRITE_SIZE,redPortalArray[2]);
								System.out.println("57 n: " + n);
							}
							if (csvArray [m] [n] == 58) { // player come out portal - horizontal - down come out
								sprite1 = new Sprite (SPRITE_SIZE/2 + n*SPRITE_SIZE,SPRITE_SIZE/2 + m*SPRITE_SIZE,0,0,SPRITE_SIZE,SPRITE_SIZE,redPortalArray[3]);
								System.out.println("58 n: " + n);
							}



							if (csvArray [m] [n] == 6) { // movingPlatforms - side to side
								int leftBound = n * SPRITE_SIZE;
								int rightBound = leftBound + 5 * SPRITE_SIZE;

								sprite1 = new Sprite (SPRITE_SIZE/2 + n*SPRITE_SIZE,SPRITE_SIZE/2 + m*SPRITE_SIZE,3,0,SPRITE_SIZE,SPRITE_SIZE,imageArray[1],leftBound,rightBound);
								sprite1.setx_center(SPRITE_SIZE/2 + n * SPRITE_SIZE);
								sprite1.sety_center(SPRITE_SIZE/2 + m * SPRITE_SIZE);
								sprite1.setMovingPlatform(true);
								sprite1.setGoUp(false);
							}

							if (csvArray [m] [n] == 7) { // movingPlatforms - side to side
								int leftBound = n * SPRITE_SIZE - 250;
								int rightBound = n * SPRITE_SIZE;

								sprite1 = new Sprite (SPRITE_SIZE/2 + n*SPRITE_SIZE,SPRITE_SIZE/2 + m*SPRITE_SIZE,-3,0,SPRITE_SIZE,SPRITE_SIZE,imageArray[1],leftBound,rightBound);
								sprite1.setx_center(SPRITE_SIZE/2 + n * SPRITE_SIZE);
								sprite1.sety_center(SPRITE_SIZE/2 + m * SPRITE_SIZE);
								sprite1.setMovingPlatform(true);
								sprite1.setGoUp(false);
							}


							if (csvArray [m] [n] == 8) { // movingPlatforms - up and down 
								//int topBound =  4 * SPRITE_SIZE; 
								int topBound =  SPRITE_SIZE * m;
								int bottomBound = topBound + 4 * SPRITE_SIZE;
								int leftBound = n * SPRITE_SIZE;
								int rightBound = leftBound + SPRITE_SIZE;

								sprite1 = new Sprite (SPRITE_SIZE/2 + n*SPRITE_SIZE,SPRITE_SIZE/2 + m*SPRITE_SIZE,0,2,SPRITE_SIZE,SPRITE_SIZE,imageArray[1],topBound,bottomBound, rightBound, leftBound, true);
								sprite1.setx_center(SPRITE_SIZE/2 + n * SPRITE_SIZE);
								sprite1.sety_center(SPRITE_SIZE/2 + m * SPRITE_SIZE);
								sprite1.setMovingPlatform(true);
								sprite1.setGoUp(true);
							}

							if (csvArray [m] [n] == 9) { // movingPlatforms - up and down 
								//int topBound =  4 * SPRITE_SIZE; 
								int topBound =  SPRITE_SIZE * m - 200;
								int bottomBound = SPRITE_SIZE * m;
								int leftBound = n * SPRITE_SIZE;
								int rightBound = leftBound + SPRITE_SIZE;

								sprite1 = new Sprite (SPRITE_SIZE/2 + n*SPRITE_SIZE,SPRITE_SIZE/2 + m*SPRITE_SIZE,0,-2,SPRITE_SIZE,SPRITE_SIZE,imageArray[1],topBound,bottomBound, rightBound, leftBound, true);
								sprite1.setx_center(SPRITE_SIZE/2 + n * SPRITE_SIZE);
								sprite1.sety_center(SPRITE_SIZE/2 + m * SPRITE_SIZE);
								sprite1.setMovingPlatform(true);
								sprite1.setGoUp(true);
							}
							if (csvArray [m] [n] == 10) { // player come out portal - vertical - right
								sprite1 = new Sprite (SPRITE_SIZE/2 + n*SPRITE_SIZE,SPRITE_SIZE/2 + m*SPRITE_SIZE,0,0,SPRITE_SIZE,SPRITE_SIZE,jetPackRight1);
								sprite1.setJetpack(true);
							}



							spriteArrayList.add(sprite1);
						}
					}

				}



			}



			// updates sprite (ground / platforms)locations constantly, doesn't include character
			public void paintComponent (Graphics g) {

				BufferedImage im = new BufferedImage(this.getWidth() * 3, this.getHeight(),BufferedImage.TYPE_3BYTE_BGR);

				// changing all g's to im.getGraphics()
				
				super.paintComponent(im.getGraphics());
				


				for (int i = 0; i < 1500* 31 - viewX; i += 1500)
				{
					im.getGraphics().drawImage(underWater1, i, 0, 1500, 675, null);
				}


				if (bloodAnimation == true)
				{
					bloodCounter++;
					bloodMethod(im.getGraphics(), bloodCounter);
				}

				if (deadAnimation == true)
				{
					deadDelayCounter++;
					deadCounter++;
					drawDead(im.getGraphics(), deadCounter);
				}
				if (p1.getY_velocity() != 0 && p1.getX_velocity() != 0)
					p1.setInvisible(false);




				

				if (gameOver) {
					im.getGraphics().drawImage(level2Button, viewY + 900, viewY + 15, 200,75,null);
					im.getGraphics().drawImage(RESET_IMAGE1, viewY + 600, viewY + 15, 200,75,null);

				}

				scroll(g);

				p1.setOnPlatform(onPlatform(p1, spriteArrayList));
				p1.setPlayerStill(p1.getX_velocity() == 0 && p1.getY_velocity() == 0);

				p1.setRidingBlock(whichPlatform(p1, spriteArrayList));

				//collectCoins();
				deathCheck();

				

				if (gameOver) {
					if (lives == 0) 
					{
						p1.setJetpack(false);
						p1.setx_center(150);
						//p1.sety_center(100);
					}
					p1.setX_velocity(0);
					p1.setDIRECTION(2);

				}

				if (isMale)
				{
					p1.playerStandRight = charOneStandRight;
					p1.playerStandLeft = charOneStandLeft;
					p1.playerJumpRight = charOneJumpRight;
					p1.playerJumpLeft = charOneJumpLeft;
					p1.playerGoRight = charOneGoRight;
					p1.playerGoLeft = charOneGoLeft;
				}
				else {
					p1.playerStandRight = charTwoStandRight;
					p1.playerStandLeft = charTwoStandLeft;
					p1.playerJumpRight = charTwoJumpRight;
					p1.playerJumpLeft = charTwoJumpLeft;
					p1.playerGoRight = charTwoGoRight;
					p1.playerGoLeft = charTwoGoLeft;
				}



				p1.display(im.getGraphics());

				if (p1.getDIRECTION() == 2 && p1.isJetpack()) {
					im.getGraphics().drawImage(jetPackRight1,p1.getx_center() - 27, p1.gety_center() - 15,25,25, null);
				}
				else if (p1.getDIRECTION() == 3 && p1.isJetpack()) {
					im.getGraphics().drawImage(jetPackLeft1,p1.getx_center(), p1.gety_center() - 15,25,25, null);
				}



				for (int i = 0; i < spriteArrayList.size(); i++) {
					Sprite sprite1 = spriteArrayList.get(i); 
					sprite1.display(im.getGraphics());
				}

				for (int i = - 70; i < 234 * 20; i += 234 - 1)
				{
					//g.drawImage(longGrassBlock1, i, 583, 234, 92, null);
				}

				if (gameOver)
				{
					gameOverScreen(im.getGraphics());
				}
				
				AffineTransform tx = AffineTransform.getScaleInstance(1, -1);
		        tx.translate(0, -im.getHeight());
		        AffineTransformOp op = new AffineTransformOp(tx,
		                AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
		        im = op.filter(im, null);

		        // Draw the reversed image on the screen
		        g.drawImage(im, 0, 0, null);
		        
		       // makeHearts(g);
		        
		        TO_HOME_PAGE.setLocation(viewY + 900, 15);

				RESET.setLocation(viewY + 600, 15);

				textMaker("Coins: " + coinsNum, 350 + viewX, 35, g);

				if (p1.isJetpack() == true)
					textMaker("Fuel: " + jetPackShots, 500, 35, g);
				
				//g.drawImage(backwardsSpace1,-1500, 0,1500,675, null);
				
				g.drawImage(backwardsSpace1, -1500, -28, 1500, 675, null);
				
				makeHearts(g);
				
				//scroll(g);

			}


			// adds image to the right image array at the right index
			public void imageLoad (ArrayList<Image> img, String str, int index)
			{
				ImageIcon imgIcon = new ImageIcon(str);
				Image imgIcon1 =  imgIcon.getImage();
				img.add(imgIcon1);
			}
			// adds image to the right image array at the right index
			public void imageLoadArray (Image [] img, String str, int index)
			{
				ImageIcon imgIcon = new ImageIcon(str);
				Image imgIcon1 =  imgIcon.getImage();
				img[index] = imgIcon1;
			}


			// translates the screen to fit the characters view using bounds 
			public void scroll(Graphics g)
			{
				int right_bound = viewX + WIDTH - RIGHT_MARGIN;

				if (p1.getRight() > right_bound) {
					viewX = viewX + p1.getRight() -  right_bound;

				}

				int left_bound = viewX + LEFT_MARGIN;
				if (p1.getLeft() < left_bound)
				{
					viewX = viewX - left_bound + p1.getLeft();
				}

				int bottom_bound = viewY + HEIGHT - VERTICAL_MARGIN;
				{
					if (p1.getBottom() > bottom_bound) {
						viewY = viewY + p1.getBottom() - bottom_bound;
					}
				}

				int top_bound = viewY + VERTICAL_MARGIN;
				if (p1.getTop() < top_bound) {
					viewY = viewY - top_bound - p1.getTop();
				}


				g.translate(-1 * viewX, -1 * viewY);
			}


			// unused keyEvent
			@Override
			public void keyTyped(KeyEvent e) {

			}

			// draws passes in strings
			public void textMaker(String str, int xLocation, int yLocation,Graphics g)
			{
				g.setFont(myFont1);
				g.setColor(Color.RED);
				g.drawString(str,xLocation,yLocation);
			}

			// used to change character velocity / movement
			@Override
			public void keyPressed(KeyEvent e) {


				char ch = e.getKeyChar();

				if (ch == 'a' && gameOver == false) {
					p1.setX_velocity(-5);	
				}
				if (ch == 'd' && gameOver == false) {
					p1.setX_velocity(5);

				}
				if (ch == 'w' && (onPlatform(p1, spriteArrayList)) && gameOver == false) {
					p1.setY_velocity(-1 * JUMP_VELOCITY);
				}
				if (ch == 'f' &&  gameOver == false)
				{
					p1.setX_velocity(0);
				}
				if ( !(onPlatform(p1, spriteArrayList))  && ch == 'd' && gameOver == false)
				{
					p1.setX_velocity(5);
					p1.setAirMovement(true);
				}
				if ( !(onPlatform(p1, spriteArrayList)) && ch == 'a' && gameOver == false)
				{
					p1.setAirMovement(true);
					p1.setX_velocity(-5);
				}

				if (p1.isJetpack()) {
					//System.out.println("isjetpack");
					if ( !(onPlatform(p1,spriteArrayList)) && ch == 'w') {

						jetPackShots--;

						if (jetPackShots == 0)
						{
							p1.setJetpack(false);
						}
						if (p1.getY_velocity() > 0) {

							p1.setY_velocity(-10);

						}
						else {

							p1.setY_velocity(-6);

						}
						GRAVITY = 1;


						System.out.println("yv" + p1.getY_velocity());
					}


				}
			}





			// unused keyEvent
			@Override
			public void keyReleased(KeyEvent e) {


				char ch = e.getKeyChar();

				if (ch == 'a' && (onPlatform(p1, spriteArrayList)) &&  gameOver == false) {
					p1.setX_velocity(0);

				}
				if (ch == 'd' && (onPlatform(p1, spriteArrayList)) &&  gameOver == false) {
					p1.setX_velocity(0);

				}
				if (ch == 'w' && onPlatform(p1, spriteArrayList) &&  gameOver == false) {
					p1.setY_velocity(-1 * JUMP_VELOCITY);
				}
				if (ch == 'f' &&  gameOver == false)
				{
					p1.setX_velocity(0);
				}





			}

			// makes sure characters and other sprites don't go through each other
			@Override
			public void actionPerformed(ActionEvent e) {
				//p1.update();
				fixSpriteLocation2AvoidCollisions(p1, spriteArrayList);
				repaint();
			}

			// check for sprite collision in both axises and returns a boolean that repersents collision
			public boolean detectSprite2SpriteCollision(Sprite s1, Sprite s2)
			{
				noXOverlap = false;
				noYOverlap = false;

				if (s1.getRight() <= s2.getLeft() || s1.getLeft() >= s2.getRight())
				{
					noXOverlap = true;}
				if (s1.getBottom() <= s2.getTop() || s1.getTop() >= s2.getBottom())
				{
					noYOverlap = true;
				}

				if (noXOverlap|| noYOverlap) {
					return false;
				}
				else  {
					return true;
				}

			}

			// checks for one sprite's collision with all other platforms/sprites
			public ArrayList<Sprite> sprite2AllCollisonList (Sprite s, ArrayList <Sprite> list) {

				ArrayList <Sprite> collision_list = new ArrayList<Sprite>();

				for (Sprite p: list)
				{
					if (detectSprite2SpriteCollision(s,p)) {
						collision_list.add(p);

					}
				}
				return collision_list;
			}

			// checks if the character is on a platform with other method calls
			public boolean onPlatform (Sprite s1, ArrayList <Sprite> platforms)
			{
				s1.sety_center(s1.gety_center() + 5);


				ArrayList<Sprite> list_collision = sprite2AllCollisonList(s1, platforms);
				s1.sety_center(s1.gety_center() - 5);


				if (list_collision.size() > 0 && !(list_collision.get(0).isCoinObject))
				{
					return true;
				}
				else {
					return false;	
				}
			}

			// tells me if im on a moving platform or not
			public Sprite whichPlatform (Sprite s1, ArrayList <Sprite> platforms)
			{
				s1.sety_center(s1.gety_center() + 5);

				ArrayList<Sprite> list_collision = sprite2AllCollisonList(s1, platforms);
				s1.sety_center(s1.gety_center() - 5);


				if (list_collision.size() > 0)
				{
					if (list_collision.get(0).isMovingPlatform()) {
						//p1.setPlayerOnMovingPlatform(true);
					}
					return list_collision.get(0);
				}
				else {
					return null;	
				}
			}


			public boolean enemyDie(Sprite s1, Sprite s2)
			{
				if (s1.getx_center() >= s2.getLeft() && s1.getx_center() <= s2.getRight() && s1.gety_center() < s2.gety_center())
				{
					return false;
				}
				else
					return false;
			}



			// if there is platform collision or character collision, this method will fix it
			public void fixSpriteLocation2AvoidCollisions (Sprite s1, ArrayList <Sprite> platforms)
			{

				if (s1.getRidingBlock() != null)
				{
					//s1.setx_center(s1.getx_center() + s1.getX_velocity() + s1.ridingBlock.getX_velocity());
					//s1.sety_center(s1.gety_center() + s1.getY_velocity() + s1.ridingBlock.getY_velocity());
				}
				else {
					//s1.setx_center( s1.getx_center() + s1.getX_velocity());
					//s1.sety_center( s1.gety_center() + s1.getY_velocity());
				}

				s1.setY_velocity(s1.getY_velocity() + GRAVITY);
				s1.sety_center(s1.gety_center() + s1.getY_velocity());

				if (s1.getRidingBlock() != null)
				{
					//s1.setx_center(s1.getx_center() + s1.getX_velocity() + s1.ridingBlock.getX_velocity());
					//s1.sety_center(s1.gety_center() + s1.getY_velocity() + s1.ridingBlock.getY_velocity());
				}
				else {
					//s1.setx_center( s1.getx_center() + s1.getX_velocity());
					//s1.sety_center(s1.gety_center() + s1.getY_velocity());
				}

				ArrayList<Sprite> collisionList = sprite2AllCollisonList(s1,platforms);

				//s1.sety_center(s1.gety_center() - s1.getY_velocity());

				Sprite collided= null;

				if (collisionList.size() > 0) {

					collided = collisionList.get(0);

					if (collided.isCoinObject == true) {
						spriteArrayList.remove(collided);
						//repaint();
						coinsNum++;

					}
					if ((collided.isPortal())) {
						System.out.println("portal");
						spriteArrayList.remove(collided);
						gameOver = true;
					}
					if ((collided.isJetpack())) {
						p1.setJetpack(true);
						spriteArrayList.remove(collided);
						jetPackShots = 5;

					}

					if (collided.isEnemy() || collided.isAnimatedEnemy())
					{
						if (p1.getBottom() < collided.gety_center())
						{
							bloodAnimation = true;
							bloodCounter = 0;
							bloodX = collided.getx_center();
							bloodY = collided.gety_center();
							spriteArrayList.remove(collided);
							enemyArrayList.remove(collided);
							
							System.out.println("bloodX" + bloodX + "bloodY" + bloodY);
						}
						else {

							deadCounter = 0;
							deadAnimation = true;
							System.out.println("deadX: " +  p1.getx_center() + "deadY: " +  p1.gety_center());
							deadX = p1.getLeft();
							deadY = p1.getTop();
							bloodCounter = 0;
							bloodAnimation = true;
							bloodX = p1.getLeft();
							bloodY = p1.getTop();

							enemyContact = true;
							//lives--;
							System.out.println("EnemyContact");
							//p1.setx_center(p1.get);
							p1.setJetpack(false);
						}

					}

					if (collided.isEntryPortal() || onPlatform(s1, entryPortalArrayList))
					{

						s1.setx_center(collided.getPortalX());
						s1.sety_center(collided.getPortalY());

						if (collided.getPlayerPortalX_velocity() != 100)
						{
							p1.setX_velocity(collided.getPlayerPortalX_velocity());
							System.out.println("portal xv: " + collided.getPlayerPortalX_velocity());
						}
						if (collided.getPlayerPortalY_velocity() != 100)
						{
							p1.setY_velocity(collided.getPlayerPortalY_velocity());
							System.out.println("portal yv: " + collided.getPlayerPortalY_velocity());

						}
					}

					if (collided.isCoinObject() == false) { // s1.getTop() <= collided.getBottom()   Math.abs(s1.gety_center() - collided.gety_center()) > 60 &&


						if (s1.getY_velocity() > 0  &&  s1.getBottom() >= collided.getTop() &&  collided.isCoinObject() == false &&  collided.isPortal() == false  && collided.isJetpack() == false && collided.isEnemy() == false && collided.isAnimatedEnemy() == false) 
						{
							//System.out.println("speed1: " + s1.getY_velocity() + " " + s1.gety_center() + " " + collided.gety_center());
							//System.out.println("1 : s1Bottom: " + s1.getBottom() + "collidedTop: " + collided.getTop());
							
							//System.out.println("Here11");
							s1.setBottom(collided.getTop());
							//System.out.println("speed2: " + s1.getY_velocity() + " " + s1.gety_center() + " " + collided.gety_center());
							//System.out.println("2 : s1Bottom: " + s1.getBottom() + "collidedTop: " + collided.getTop());
						}

						else if (s1.getY_velocity() < 0 && s1.getTop() <= collided.getBottom() && collided.isCoinObject() == false &&  collided.isPortal() == false  && collided.isJetpack() == false)
						{
							//s1.getTop() <= collided.getBottom()
							System.out.println("Here2");
							s1.setTop(collided.getBottom());

						}
						//s1.setY_velocity(0);
						
						if (collided.isEnemy()== false && collided.isCoinObject() == false && collided.isPortal() == false && collided.isJetpack() == false)
						{
							s1.setY_velocity(0);
						}
					}
				}


				s1.setx_center(s1.getx_center() + s1.getX_velocity());
				if (s1.getRidingBlock() != null)
				{
					//s1.setx_center(s1.getx_center() + s1.getX_velocity() + s1.ridingBlock.getX_velocity());
					//s1.sety_center(s1.gety_center() + s1.getY_velocity() + s1.ridingBlock.getY_velocity());
				}
				else {
					//s1.setx_center( s1.getx_center() + s1.getX_velocity());
					//s1.sety_center( s1.gety_center() + s1.getY_velocity());
				}

				collisionList = sprite2AllCollisonList(s1,platforms);
				if (collisionList.size() > 0) {
					collided = collisionList.get(0);

					if (collided.isCoinObject() == true) {
						//repaint();
						spriteArrayList.remove(collided);
						coinsNum++;

					}

					if ((collided.isPortal())) {
						spriteArrayList.remove(collided);
						gameOver = true;
					}
					if ((collided.isJetpack())) {
						p1.setJetpack(true);
						spriteArrayList.remove(collided);
						jetPackShots = 5;
					}

					if (collided.isEnemy() || collided.isAnimatedEnemy())
					{

						if (p1.getBottom() < collided.gety_center())
						{

							bloodAnimation = true;
							bloodCounter = 0;
							bloodX = collided.getx_center();
							bloodY = collided.gety_center();
							spriteArrayList.remove(collided);
							enemyArrayList.remove(collided);
							
							System.out.println("bloodX" + bloodX + "bloodY" + bloodY);





						}
						else {

							deadCounter = 0;
							deadAnimation = true;
							System.out.println("deadX: " +  p1.getx_center() + "deadY: " +  p1.gety_center());
							deadX = p1.getLeft();
							deadY = p1.getTop();
							bloodCounter = 0;
							bloodAnimation = true;
							bloodX = p1.getLeft();
							bloodY = p1.getTop();

							enemyContact = true;

							

							System.out.println("EnemyContact");

							//p1.setx_center(100);

							p1.setJetpack(false);

						}

					}



					if (collided.isEntryPortal() || onPlatform(s1, entryPortalArrayList))
					{

						s1.setx_center(collided.getPortalX());
						s1.sety_center(collided.getPortalY());

						if (collided.getPlayerPortalX_velocity() != 100)
						{
							p1.setX_velocity(collided.getPlayerPortalX_velocity());
							System.out.println("portal xv: " + collided.getPlayerPortalX_velocity());
						}
						if (collided.getPlayerPortalY_velocity() != 100)
						{
							p1.setY_velocity(collided.getPlayerPortalY_velocity());
							System.out.println("portal yv: " + collided.getPlayerPortalY_velocity());

						}

					}


					//s1.setx_center(s1.getX_velocity() + collided.getX_velocity());
					//System.out.println("Here2");
					if (collided.isCoinObject() == true) {

						if (s1.getX_velocity() > 0 && collided.isCoinObject() == false && collided.isJetpack() == false)
						{
							System.out.println("Here3");
							s1.setRight(collided.getLeft());


						}
						else if (s1.getX_velocity() < 0 && collided.isCoinObject() == false  && collided.isJetpack() == false)
						{
							System.out.println("Here4");
							s1.setLeft(collided.getRight());


						}
						else if (collided.isEnemy()== false && collided.isCoinObject() == false && collided.isPortal == false  && collided.isJetpack() == false)
						{
							
							System.out.println("Here88");
							s1.setX_velocity(0);

						}

					}
				}
			}

			// checks for death by falling or enemy collision 
			public void deathCheck() {

				boolean fallDown =  p1.getBottom() > 575;

				int top = -100;

				if (p1.getTop() <= top && p1.isJetpack())
				{
					p1.setTop(top);
					p1.setY_velocity(0);
					p1.setX_velocity(0);


				}

				if (fallDown)
				{

					System.out.println("falling");

					deadCounter = 0;
					deadAnimation = true;
					System.out.println("deadX: " +  p1.getx_center() + "deadY: " +  p1.gety_center());
					deadX = p1.getLeft();
					deadY = p1.getTop();
					bloodCounter = 0;
					bloodAnimation = true;
					bloodX = p1.getLeft();
					bloodY = p1.getTop();

				}

				/*
				enemyContact = false;

				ArrayList <Sprite> enemyCollision = sprite2AllCollisonList(p1, enemyArrayList);

				if (enemyCollision.size() != 0)
				{
					//detectSprite2SpriteCollision(p1,enemyCollision.get(0));

					System.out.println("Hello1");

					System.out.println("p1xcenter" + p1.getx_center() + "\nenemyXcenter" + enemyCollision.get(0).getx_center());

					if (p1.getBottom() < enemyCollision.get(0).gety_center())
					{
						System.out.println("here11");
						//enemyContact = true;

							System.out.println("here12");
							spriteArrayList.remove(enemyCollision.get(0));
							enemyArrayList.remove(enemyCollision.get(0));
							repaint();
							//repaint();



					}
					else {

						enemyContact = true;

						lives--;

						System.out.println("EnemyContact");

						p1.setx_center(100);

						p1.setJetpack(false);

					}

				}
				 */

				if (lives == 0) {
					gameOver = true;
				}

			} 

			// detects coins collided with, adds them to count and removes coins 
			public void collectCoins() {

				ArrayList <Sprite> list_coin = sprite2AllCollisonList(p1, spriteArrayList);

				if (list_coin.size() > 0)
				{

					System.out.println("Collision");
					for (Sprite coin : list_coin)
					{
						coinsNum++;
						//coinArrayList.remove(coin);
						//aspriteArrayList.remove(coin);
					}
				}
			}

			// draws the ending screen with text and info on coinsdada
			public void gameOverScreen(Graphics g)
			{
				if (lives <= 0) {
					g.drawImage(gameOverScreen1, viewX + 75,180,993,184,null);

				}

			}

			// draws the hearts depending on amount of lives
			public void makeHearts (Graphics g)
			{
				if (lives == 3)
				{
					g.drawImage(fullHeart1, viewX + 100, 0, 40, 40, null);
					g.drawImage(fullHeart1, viewX + 160, 0, 40, 40, null);
					g.drawImage(fullHeart1, viewX + 220, 0, 40, 40, null);
				}

				if (lives == 2)
				{
					g.drawImage(fullHeart1, viewX + 100, 0, 40, 40, null);
					g.drawImage(fullHeart1, viewX + 160, 0, 40, 40, null);
					g.drawImage(emptyHeart1, viewX + 220, 0, 40, 40, null);
				}
				if (lives == 1)
				{
					g.drawImage(fullHeart1, viewX + 100, 0, 40, 40, null);
					g.drawImage(emptyHeart1, viewX + 160, 0, 40, 40, null);
					g.drawImage(emptyHeart1, viewX + 220, 0, 40, 40, null);
				}
				if (lives == 0)
				{
					g.drawImage(emptyHeart1, viewX + 100, 0, 40, 40, null);
					g.drawImage(emptyHeart1, viewX + 160, 0, 40, 40, null);
					g.drawImage(emptyHeart1, viewX + 220, 0, 40, 40, null);
				}
			}

			public void bloodMethod(Graphics g, int bloodCounter)
			{

				if (bloodCounter/5 == bloodSplatter.size())
				{
					bloodCounter = 0;
					bloodAnimation = false;
				}

				g.drawImage(bloodSplatter.get(bloodCounter/5), bloodX - viewX - 150,bloodY - 50,300,150,null);

				//System.out.println("bloodMethod x: " + bloodX + );


			}

			public void drawDead(Graphics g, int deadCounter)
			{
				if (isMale)
					g.drawImage(bodies.get(0), deadX, deadY, 50,50,null);
				else 
					g.drawImage(bodies.get(1), deadX - viewX, deadY, 50,50,null);


				if (deadDelayCounter < 50 && deadAnimation && deadDelayCounter != 0) // deadDelayCounter < 100 && 
				{	
					p1.setx_center(p1.getx_center());
					p1.sety_center(120);
					p1.setX_velocity(0);
					p1.setY_velocity(-1);
					p1.setInvisible(true);
				}
				if (deadDelayCounter > 50) {

					p1.setInvisible(false);


					lives--;
					deadDelayCounter = 0;
					deadAnimation = false;


					p1.setx_center(100);

					p1.sety_center(120);

					p1.setX_velocity(0);

					p1.setY_velocity(5);

					viewY = 0;

					p1.setJetpack(false);
				}

			}

			/*
			 *bloodCounter++;

				for (int i = 0; i < 4; i++)
				{
					if (bloodCounter/5 == bloodSplatter.size())
					{
						bloodCounter = 0; 
					}

					g.drawImage(bloodSplatter.get(bloodCounter/5), 100,100,300,150,null);


				}
			 */


		}






