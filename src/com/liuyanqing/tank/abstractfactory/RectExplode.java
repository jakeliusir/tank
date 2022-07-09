package com.liuyanqing.tank.abstractfactory;

import java.awt.Graphics;

import com.liuyanqing.tank.Audio;
import com.liuyanqing.tank.ResourceMgr;
import com.liuyanqing.tank.TankFrame;

public class RectExplode extends BaseExplode {

    private static final int SPEED =10;
    public static int WIDTH = ResourceMgr.exploses[1].getWidth();
    public static int HEIGHT = ResourceMgr.exploses[1].getHeight();
   
    private int x , y;
    private int step = 0;
    boolean living = true; 
    TankFrame tf  = null;
	public static int getWIDTH() {
		return WIDTH;
	}

	public static void setWIDTH(int wIDTH) {
		WIDTH = wIDTH;
	}

	public static int getHEIGHT() {
		return HEIGHT;
	}

	public static void setHEIGHT(int hEIGHT) {
		HEIGHT = hEIGHT;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getStep() {
		return step;
	}

	public void setStep(int step) {
		this.step = step;
	}

	public boolean isLiving() {
		return living;
	}

	public void setLiving(boolean living) {
		this.living = living;
	}

	public TankFrame getTf() {
		return tf;
	}

	public void setTf(TankFrame tf) {
		this.tf = tf;
	}

	public static int getSpeed() {
		return SPEED;
	}

	public RectExplode(int x, int y, TankFrame tf) {
		super();
		this.x = x;
		this.y = y;
		this.tf =tf;
		
		new Thread(()->{
			new Audio("audio/explode.wav").play();
		}).start();
		
	}

	@Override
	public void paint(Graphics g) {
		  g.drawImage(ResourceMgr.exploses[step++], x, y,null);
	      if (step>=ResourceMgr.exploses.length) {
			tf.explodes.remove(this);

	}

}
}
