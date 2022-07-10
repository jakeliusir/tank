package com.liuyanqing.tank;


public class Main {

	public static void main(String[] args) throws InterruptedException {
     TankFrame t =new TankFrame();
     
     
     int initTankCount = Integer.parseInt((String)PropertyMgr.get("initTankCount"));
     //初始化地方坦克
     
     for(int i =0 ;i<initTankCount;i++) {
    	 t.tanks.add(new Tank(50+i*100,100, Dir.DOWN, Group.BAD,t));
     }
     while(true) {
    	 Thread.sleep(20);
    	 t.repaint();
     }
   }
}
