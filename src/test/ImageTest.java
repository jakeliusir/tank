package test;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.junit.jupiter.api.Test;

import com.sun.org.apache.bcel.internal.generic.NEW;

class ImageTest {

	@Test
	void test() {
		BufferedImage image;
		try {
//			image = ImageIO.read(new File("D:/liu.jpg"));
//			assertNotNull(image);
			//ImageTest.class=>this.getClass
			BufferedImage image2 = ImageIO.read(this.getClass().getClassLoader().getResourceAsStream("images/tankL.gif"));
			assertNotNull(image2);
			System.out.println(image2);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
}
		
	
	

}
