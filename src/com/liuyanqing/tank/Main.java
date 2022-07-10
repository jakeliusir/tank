package com.liuyanqing.tank;


public class Main {

	public static void main(String[] args) throws InterruptedException {
     TankFrame t =new TankFrame();
    
     while(true) {
    	 Thread.sleep(20);
    	 t.repaint();
     }
   }
}
