package com.liuyanqing.tank;

import java.awt.Graphics;




public class Explode extends GameObject  {
    private static final int SPEED =10;
    public static int WIDTH = ResourceMgr.exploses[1].getWidth();
    public static int HEIGHT = ResourceMgr.exploses[1].getHeight();  
    private int x , y;
    private int step = 0;
    boolean living = true; 
   	public Explode(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	
		
		new Thread(()->{
			new Audio("audio/explode.wav").play();
		}).start();
		
		GameModel.getInstance().add(this);
		
	}
	public void paint(Graphics g) {
      g.drawImage(ResourceMgr.exploses[step++], x, y,null);
      if (step>=ResourceMgr.exploses.length) {
    	  GameModel.getInstance().remove(this);
		
		
		
	}



	}








}
