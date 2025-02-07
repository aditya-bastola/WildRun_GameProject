// Aditya Bastola
// 5 / 2 / 22
// PlatformGame.java
import java.awt.image.BufferedImage;

// get specific image from sprite sheet
public class SpriteSheet {
	
	private BufferedImage image;
	
	// localize image 
	public SpriteSheet(BufferedImage image)
	{
		this.image = image;
	}
	// grabs wanted image from sprite sheet
	public BufferedImage grabImage (int col, int row, int width, int height) {
		
		BufferedImage img = image.getSubimage((col * 32) - 32, (row * 32) - 32, width, height);
		return img;
		
		}
	
	

}
