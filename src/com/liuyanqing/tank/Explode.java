package com.liuyanqing.tank;

import java.awt.Graphics;
import java.awt.Rectangle;

import javax.sound.sampled.AudioFileFormat;

import com.liuyanqing.tank.abstractfactory.BaseExplode;


public class Explode extends BaseExplode  {
    private static final int SPEED =10;
    public static int WIDTH = ResourceMgr.exploses[1].getWidth();
    public static int HEIGHT = ResourceMgr.exploses[1].getHeight();
   
    private int x , y;
    private int step = 0;
    boolean living = true; 
    TankFrame tf  = null;
    
	public Explode(int x, int y,TankFrame tf) {
		super();
		this.x = x;
		this.y = y;
		this.tf =tf;
		
		new Thread(()->{
			new Audio("audio/explode.wav").play();
		}).start();
		
	}

	public void paint(Graphics g) {
      g.drawImage(ResourceMgr.exploses[step++], x, y,null);
      if (step>=ResourceMgr.exploses.length) {
		tf.explodes.remove(this);
		
		
		
	}



	}





}
