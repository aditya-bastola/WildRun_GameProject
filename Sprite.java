// Aditya Bastola
// 5 / 2 / 22
// PlatformGame.java

import java.awt.*;
import java.util.ArrayList;

// stores details about sprites including their location 
public class Sprite {

	static int SPRITE_SIZE = 50;

	private int x_center = 0;
	private int y_center = 0;

	private int x_velocity = 0;
	private int y_velocity = 0;

	private int W = 50;
	private int H = 50;

	private int frameCounter = 0;
	
	boolean invisible = false;
	
	Image enemyImage = null;

	boolean isCoin = false;
	boolean isCoinObject = false;

	boolean isEnemy = false;
	boolean isPlayer;
	boolean isPortal = false;
	boolean isMovingPlatform = false;
	boolean isPlayerOnMovingPlatform = false;

	boolean isJetpack = false;
	
	boolean animatedEnemy = false;

	int goldBarFrame = 4;
	int waterOrbFrame = 3;
	int framePartition = 0;

	boolean isWaterOrb = false;

	boolean sprintLeft = false;
	boolean sprintRight = false;


	Sprite ridingBlock = null;

	int leftBound = 0;
	int rightBound = 0;
	int topBound = 0;
	int bottomBound = 0;

	int leftOrRight = 1; // 0 is left, 1 is right 
	boolean goUp = true;

	boolean isOnPlatform = true;
	boolean playerStill = true;

	private Image image = null;
	private ArrayList <Image> images = null;
	ArrayList <Image> currentImages = new ArrayList<Image>();
	ArrayList <Image> playerStandRight = new ArrayList<Image>();
	ArrayList <Image> playerStandLeft = new ArrayList<Image>();
	ArrayList <Image> playerJumpRight = new ArrayList<Image>();
	ArrayList <Image> playerJumpLeft = new ArrayList<Image>();
	ArrayList <Image> playerGoRight = new ArrayList<Image>();
	ArrayList <Image> playerGoLeft = new ArrayList<Image>();
	
	ArrayList <Image> enemyRight = new ArrayList<Image>();
	ArrayList <Image> enemyLeft = new ArrayList<Image>();

	int DIRECTION = 0;
	int NEUTRAL_FACING = 1;
	int RIGHT_FACING = 2;
	int LEFT_FACING = 3;

	int index = 0;

	int playerFrameCounter = 0;

	int playerIndex = 0;

	Image playerImage;

	boolean lastStatus = false;

	boolean airMovement = false;

	boolean entryPortal = false;


	int PortalX = 0; // where player comes out
	int PortalY = 0;

	int playerPortalX_velocity = 100; // if !=100 then set it 
	int playerPortalY_velocity = 100;
	
	int enemyFrameCounter = 0;
	
	int enemyIndex = 0;

	// empty constructor
	public Sprite() {
		super();
	}

	// constructor for still player
	public Sprite(int x_center, int y_center, int x_velocity, int y_velocity, int w, int h, Image image) {
		super();
		this.x_center = x_center;
		this.y_center = y_center;
		this.x_velocity = x_velocity;
		this.y_velocity = y_velocity;
		this.W = w;
		this.H = h;
		this.image = image;
	}


	// constructor for animated sprite (coins, characters)
	public Sprite(int x_center, int y_center, int x_velocity, int y_velocity, int w, int h, ArrayList <Image> images) {
		super();
		this.x_center = x_center;
		this.y_center = y_center;
		this.x_velocity = x_velocity;
		this.y_velocity = y_velocity;
		this.W = w;
		this.H = h;
		this.images = images;
	}

	// constructor for moving enemies and moving platforms
	public Sprite(int x_center, int y_center, int x_velocity, int y_velocity, int w, int h, ArrayList <Image> enemyImages, int leftBound, int rightBound) {
		super();
		this.x_center = x_center;
		this.y_center = y_center;
		this.x_velocity = x_velocity;
		this.y_velocity = y_velocity;
		this.W = w;
		this.H = h;
		this.images = enemyImages;
		this.leftBound = leftBound;
		this.rightBound = rightBound;
		this.setX_velocity(x_velocity);
		this.setY_velocity(y_velocity);
	}
	// animtedEnemies
		public Sprite(int x_center, int y_center, int x_velocity, int y_velocity, int w, int h, ArrayList <Image> enemyRight, ArrayList <Image> enemyLeft, int leftBound, int rightBound) {
			super();
			this.x_center = x_center;
			this.y_center = y_center;
			this.x_velocity = x_velocity;
			this.y_velocity = y_velocity;
			this.W = w;
			this.H = h;
			this.enemyRight = enemyRight;
			this.enemyLeft = enemyLeft;
			this.leftBound = leftBound;
			this.rightBound = rightBound;
			this.setX_velocity(x_velocity);
			this.setY_velocity(y_velocity);
		}

	// moving platform
	public Sprite(int x_center, int y_center, int x_velocity, int y_velocity, int w, int h, Image img, int leftBound, int rightBound) {
		super();
		this.x_center = x_center;
		this.y_center = y_center;
		this.x_velocity = x_velocity;
		this.y_velocity = y_velocity;
		this.W = w;
		this.H = h;
		this.image = img;
		this.leftBound = leftBound;
		this.rightBound = rightBound;
		this.setX_velocity(x_velocity);
		this.setY_velocity(y_velocity);


	} // moving platform go up or down - use y velocity to choose inital direction 
	public Sprite(int x_center, int y_center, int x_velocity, int y_velocity, int w, int h, Image img, int topBound, int bottomBound, int rightBound, int leftBound, boolean goUp) {
		super();
		this.x_center = x_center;
		this.y_center = y_center;
		this.x_velocity = x_velocity;
		this.y_velocity = y_velocity;
		this.W = w;
		this.H = h;
		this.image = img;
		this.topBound = topBound;
		this.bottomBound = bottomBound;
		this.goUp = goUp;
		this.rightBound = rightBound;
		this.leftBound = leftBound;

		this.setX_velocity(x_velocity);
		this.setY_velocity(y_velocity);


	}

	// constructor for player animation 
	public Sprite(int x_center, int y_center, int x_velocity, int y_velocity, int w, int h, ArrayList <Image> playerStandRight, ArrayList <Image> playerStandLeft, ArrayList <Image> playerJumpRight, ArrayList <Image> playerJumpLeft, ArrayList <Image> playerGoRight, ArrayList <Image> playerGoLeft, boolean isPlayer) {
		super();
		this.x_center = x_center;
		this.y_center = y_center;
		this.x_velocity = x_velocity;
		this.y_velocity = y_velocity;
		this.W = w;
		this.H = h;
		this.playerStandRight = playerStandRight;
		this.playerStandLeft = playerStandLeft;
		this.playerJumpRight = playerJumpRight;
		this.playerJumpLeft = playerJumpLeft;
		this.playerGoRight = playerGoRight;
		this.playerGoLeft = playerGoLeft;
		this.isPlayer = isPlayer;
		currentImages = playerStandLeft;
		this.setX_velocity(0);


	}

	

	public boolean isInvisible() {
		return invisible;
	}

	public void setInvisible(boolean invisible) {
		this.invisible = invisible;
	}

	public boolean isAnimatedEnemy() {
		return animatedEnemy;
	}

	public void setAnimatedEnemy(boolean animatedEnemy) {
		this.animatedEnemy = animatedEnemy;
	}

	public boolean isWaterOrb() {
		return isWaterOrb;
	}

	public void setWaterOrb(boolean isWaterOrb) {
		this.isWaterOrb = isWaterOrb;
	}

	public boolean isJetpack() {
		return isJetpack;
	}

	public void setJetpack(boolean isJetpack) {
		this.isJetpack = isJetpack;
	}

	public int getPlayerPortalX_velocity() {
		return playerPortalX_velocity;
	}

	public void setPlayerPortalX_velocity(int playerPortalX_velocity) {
		this.playerPortalX_velocity = playerPortalX_velocity;
	}

	public int getPlayerPortalY_velocity() {
		return playerPortalY_velocity;
	}

	public void setPlayerPortalY_velocity(int playerPortalY_velocity) {
		this.playerPortalY_velocity = playerPortalY_velocity;
	}

	public boolean isEntryPortal() {
		return entryPortal;
	}

	public void setEntryPortal(boolean entryPortal) {
		this.entryPortal = entryPortal;
	}

	public int getPortalX() {
		return PortalX;
	}

	public void setPortalX(int portalX) {
		this.PortalX = portalX;
	}

	public int getPortalY() {
		return PortalY;
	}

	public void setPortalY(int portalY) {
		this.PortalY = portalY;
	}

	// sets var
	public boolean isGoUp() {
		return goUp;
	}
	// sets var
	public void setGoUp(boolean goUp) {
		this.goUp = goUp;
	}
	// sets var
	public boolean isPlayerOnMovingPlatform() {
		return isPlayerOnMovingPlatform;
	}
	// sets var
	public void setPlayerOnMovingPlatform(boolean isPlayerOnMovingPlatform) {
		this.isPlayerOnMovingPlatform = isPlayerOnMovingPlatform;
	}
	// sets var
	public Sprite getRidingBlock() {
		return ridingBlock;
	}
	// sets var
	public void setRidingBlock(Sprite ridingBlock) {
		this.ridingBlock = ridingBlock;
	}
	// sets var
	public boolean isMovingPlatform() {
		return isMovingPlatform;
	}
	// sets var
	public void setMovingPlatform(boolean isMovingPlatform) {
		this.isMovingPlatform = isMovingPlatform;
	}

	// sets var
	public boolean isAirMovement() {
		return airMovement;
	}
	// sets var
	public void setAirMovement(boolean airMovement) {
		this.airMovement = airMovement;
	}

	// cycles through image array
	public void nextImage () {
		index++;
		if (index >= images.size()) {
			index = 0;
		}
		image = images.get(index);
	}
	// cycles through image array
	public void playerNextImage() {
		playerIndex++;
		if (playerIndex >= currentImages.size()) {
			playerIndex = 0;
		}
		playerImage = currentImages.get(playerIndex);
	}
	public void enemyNextImage() {
		enemyIndex++;
		if (enemyIndex >= currentImages.size()) {
			enemyIndex = 0;
		}
		if (currentImages.size() != 0)
		enemyImage = currentImages.get(enemyIndex);
	}

	// gets var
	public int getDIRECTION() {
		return DIRECTION;
	}
	// sets var
	public void setDIRECTION(int dIRECTION) {
		DIRECTION = dIRECTION;
	}
	// gets var
	public boolean isPortal() {
		return isPortal;
	}
	// sets var
	public void setPortal(boolean isPortal) {
		this.isPortal = isPortal;
	}
	// gets var
	public ArrayList<Image> getCurrentImages() {
		return currentImages;
	}
	// sets var
	public void setCurrentImages(ArrayList<Image> currentImages) {
		this.currentImages = currentImages;
	}

	// where all methods to animate player are run, frame counter used to make animation look smooth 
	public void spritePlayerUpdateAnimation()
	{

		playerFrameCounter++;

		if (playerFrameCounter % 3 == 0)
		{
			playerChooseDirection();
			playerChooseImages();
			playerNextImage();
		}
	}
	
	public void spriteEnemyUpdateAnimation()
	{

		enemyFrameCounter++;

		if (enemyFrameCounter % 6 == 0)
		{
			enemyDirection();
			enemyNextImage();
		}
	}

	// decides player direction based on velocity
	public void playerChooseDirection()
	{
		if (getX_velocity() > 0)
		{
			DIRECTION = RIGHT_FACING;
		}
		else if (getX_velocity() < 0)
		{
			DIRECTION = LEFT_FACING;
		}

	}

	// used to choose images needed for player animation 
	public void playerChooseImages()
	{

		if (DIRECTION == RIGHT_FACING)
		{
			if (getisPlayerStill())
			{
				currentImages = playerStandRight;
			}
			else if (getisOnPlatform() == false)
			{
				currentImages = playerJumpRight;
			}
			else {
				currentImages =  playerGoRight;
			}

		}
		else if (DIRECTION == LEFT_FACING)
		{
			if (getisPlayerStill())
			{
				currentImages = playerStandLeft;
			}
			else if (getisOnPlatform() == false)
			{
				currentImages = playerJumpLeft;
			}
			else {
				currentImages =  playerGoLeft;
			}

		}

	}

	// updates sprite location by adding the velocity to the x center
	public void update()
	{
		if (this.getRidingBlock() != null)
		{
			this.x_center +=  this.x_velocity + ridingBlock.getX_velocity();
			this.y_center +=  this.y_velocity + ridingBlock.getY_velocity();	
		}
		else {
			this.x_center +=  this.x_velocity;
			this.y_center +=  this.y_velocity;	
		}
		if (this.getY_velocity() > 0 && this.isOnPlatform)
		{
			this.setX_velocity(0);
		}


		// players stops moving after jump 


			if (this.getisOnPlatform() && lastStatus == false && this.isAirMovement() == true)
			{
				x_velocity = 0;
			}
			lastStatus = this.getisOnPlatform();
		

		/*
			if (this.isPlayer) {

				if (sprintRight == true && this.getX_velocity() < 0)
				{
					this.setX_velocity(this.getX_velocity() + 10);
				}
				if (sprintLeft == true && this.getX_velocity() > 0)
				{
					this.setX_velocity(this.getX_velocity() - 10);
				}

				if (this.getX_velocity() > 0)
				sprintRight =  true;
				else 
				sprintRight = false;


				if (this.getX_velocity() < 0)
				sprintLeft =  true;
				else 
				sprintLeft = false;

			}
		 */
	}


	// draws character, animated sprite and enemies
	public void display(Graphics g)
	{
		update();

		if (isEnemy)
		{
			enemyDirection();

			g.drawImage(this.images.get(leftOrRight), this.getx_center() - SPRITE_SIZE/2, this.gety_center()  - SPRITE_SIZE/2, this.getW(), this.getH(), null);	
		}
		
		if (isAnimatedEnemy())
		{
			
			frameCounter++;
			
			if (frameCounter/4 == currentImages.size())
			{
				frameCounter = 0; 
			}
			
			spriteEnemyUpdateAnimation();
			
			g.drawImage(enemyImage, this.getx_center() - SPRITE_SIZE/2, this.gety_center()  - SPRITE_SIZE/2, this.getW(), this.getH(), null);

		}

		if (isMovingPlatform)
		{
			enemyDirection();


			g.drawImage(this.image, this.getx_center() - SPRITE_SIZE/2, this.gety_center()  - SPRITE_SIZE/2, this.getW(), this.getH(), null);	
		}

		if (goUp && isMovingPlatform())
		{
			verticalPlatforms();

			g.drawImage(this.image, this.getx_center() - SPRITE_SIZE/2, this.gety_center()  - SPRITE_SIZE/2, this.getW(), this.getH(), null);	
		}

		else if (isCoin)
		{
			frameCounter++;

			if (isWaterOrb())
				framePartition = waterOrbFrame;
			else
				framePartition = goldBarFrame;

			if (frameCounter/framePartition == images.size())
			{
				frameCounter = 0; 
			}

			g.drawImage(images.get(frameCounter/framePartition), this.getx_center() - SPRITE_SIZE/2, this.gety_center()  - SPRITE_SIZE/2, this.getW(), this.getH(), null);

		}

		else if (isPlayer && invisible == false){

			spritePlayerUpdateAnimation();
			g.drawImage(playerImage, this.getx_center() - SPRITE_SIZE/2, this.gety_center()  - SPRITE_SIZE/2, this.getW(), this.getH(), null);
		}
		else {
			g.drawImage(this.getImage(), this.getx_center() - SPRITE_SIZE/2, this.gety_center()  - SPRITE_SIZE/2, this.getW(), this.getH(), null);
		}

	}

	// checks if enemy has gone past a certain point, if yes then it changes the direction 
	public void enemyDirection()
	{
		if (getLeft() <= leftBound)
		{
			setLeft(leftBound);
			setX_velocity(getX_velocity() * -1);
			leftOrRight = 1;
			currentImages = enemyRight;
			
			
		}
		if (getRight() >= rightBound)
		{
			setRight(rightBound);
			setX_velocity(getX_velocity() * -1);
			leftOrRight = 0;
			currentImages = enemyLeft;
		}
	}
	
	// sets vertical platform direction
	public void verticalPlatforms()
	{
		if (getTop() <= topBound)
		{
			setTop(topBound);
			setY_velocity(getY_velocity() * -1);
		}
		if (getBottom() >= bottomBound)
		{
			setBottom(bottomBound + 1);
			setY_velocity(getY_velocity() * -1);
		}
	}


	// returns variable
	public int getTop()
	{
		return this.y_center - SPRITE_SIZE/2;
		//return this.y_center - H/2;
	}

	// returns variable
	public int getBottom()
	{
		return this.y_center + SPRITE_SIZE/2;
		//return this.x_center + H/2;
	}

	// returns variable
	public int getLeft()
	{
		return this.x_center - SPRITE_SIZE/2;
		//return this.x_center - W/2;
	}
	
	// returns variable
	public int getRight()
	{
		return this.x_center + SPRITE_SIZE/2;
		//return this.x_center + W/2;
	}
	
	// sets variable
	public void setTop(int newTop)
	{
		this.y_center = newTop + SPRITE_SIZE/2;
		//this.y_center = newTop + H/2;
	}
	
	// sets variable
	public void setBottom(int newBottom)
	{
		this.y_center = newBottom - SPRITE_SIZE/2;
		//this.y_center = newBottom - H/2;

	}

	// sets variable
	public void setLeft(int newLeft)
	{
		this.x_center = newLeft + SPRITE_SIZE/2;
		//this.x_center = newLeft + W/2;
	}
	
	// sets variable
	public void setRight(int newRight)
	{
		this.x_center = newRight - SPRITE_SIZE/2;
		//this.x_center = newRight - W/2;
	}

	// returns variable
	public ArrayList<Image> getImages() {
		return images;
	}
	// sets variable
	public void setImages(ArrayList<Image> images) {
		this.images = images;
	}

	// returns variable
	public boolean isCoinObject() {
		return isCoinObject;
	}
	public void setCoinObject(boolean isCoinObject) {
		this.isCoinObject = isCoinObject;
	}

	// sets variable
	public void setAnimate(boolean isCoin) {
		this.isCoin = isCoin;
	}

	// returns variable
	public boolean isEnemy() {
		return isEnemy;
	}
	// sets variable
	public void setEnemy(boolean isEnemy) {
		this.isEnemy = isEnemy;
	}

	// returns variable
	public boolean getisOnPlatform() {
		return isOnPlatform;
	}

	// sets variable
	public void setOnPlatform(boolean isOnPlatform) {
		this.isOnPlatform = isOnPlatform;
	}

	// returns variable
	public boolean getisPlayerStill() {
		return playerStill;
	}

	// sets variable
	public void setPlayerStill(boolean playerStill) {
		this.playerStill = playerStill;
	}

	// returns variable
	public int getx_center() {
		return x_center;
	}

	// sets variable
	public void setx_center(int x_center) {
		this.x_center = x_center;
	}

	// returns variable
	public int gety_center() {
		return y_center;
	}
	// sets variable
	public void sety_center(int y_center) {
		this.y_center = y_center;
	}

	// returns variable
	public int getX_velocity() {
		return x_velocity;
	}
	// sets variable
	public void setX_velocity(int x_velocity) {
		this.x_velocity = x_velocity;
	}

	// returns variable
	public int getY_velocity() {
		return y_velocity;
	}
	// sets variable
	public void setY_velocity(int y_velocity) {
		this.y_velocity = y_velocity;
	}

	// returns variable
	public int getW() {
		return W;
	}
	// sets variable
	public void setW(int w) {
		W = w;
	}

	// returns variable
	public int getH() {
		return H;
	}
	// sets variable
	public void setH(int h) {
		H = h;
	}

	// returns variable
	public Image getImage() {
		return image;
	}
	// sets variable
	public void setImage(Image image) {
		this.image = image;
	}

}
