package com.liuyanqing.tank;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import sun.security.jca.GetInstance;

public class ResourceMgr {
	
	
	private static  ResourceMgr INSTANCE = new ResourceMgr();
	private ResourceMgr() {
		
	}
	
	public static ResourceMgr getInstance() {
		return INSTANCE;
	}
	
	
	public static BufferedImage goodTankL , goodTankU , goodTankR , goodTankD;
	public static BufferedImage badTankL , badTankU , badTankR , badTankD;
	public static BufferedImage bulletL , bulletU , bulletR , bulletD;
	public static BufferedImage [] exploses = new BufferedImage[16];
	
	
	static {
		try {
			badTankU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/BadTank1.png"));
			badTankL = ImageUtil.rotateImage(badTankU, -90);
			badTankR = ImageUtil.rotateImage(badTankU, 90);
			badTankD = ImageUtil.rotateImage(badTankU, 180);
			
			goodTankU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/GoodTank1.png"));
			goodTankL = ImageUtil.rotateImage(goodTankU, -90);
			goodTankR = ImageUtil.rotateImage(goodTankU, 90);
			goodTankD = ImageUtil.rotateImage(goodTankU, 180);
			
			bulletU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/bulletU.png"));
			bulletL = ImageUtil.rotateImage(bulletU, -90);
			bulletR = ImageUtil.rotateImage(bulletU, 90);
			bulletD = ImageUtil.rotateImage(bulletU, 180);
			
			
			for (int i = 1; i < 16; i++) {
				exploses[i] =ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/e"+(i+1)+".gif"));
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
