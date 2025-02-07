
// Aditya Bastola
// 5 / 2 / 22
// PlatformGame.java
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

// reads image from file
public class BufferedImageLoader {
	
	private BufferedImage image;
	// reads image from file
	public BufferedImage loadImage (String fileName) throws IOException {
		image = ImageIO.read(new File (fileName));
		return image;
	}

}
