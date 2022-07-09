package com.liuyanqing.tank;

import com.liuyanqing.tank.abstractfactory.RectTank;

public class FourDirFireStrategy implements FireStrategy {

	@Override
	public void fire(Tank t) {
		int bx = t.x+Tank.WIDTH/2-Bullet.WIDTH/2;
		int by = t.y+Tank.HEIGHT/2-Bullet.HEIGHT/2;
		
		 Dir[] dirs = Dir.values();
		for(Dir dir : dirs) {
			new Bullet(bx,by,dir,t.group,t.tf);		
		}
	    
		if (t.group==Group.GOOD) {
			new Thread(()->{
				new Audio("audio/tank_fire.wav").play();
			}).start();
		}
		
	}

	@Override
	public void fire(RectTank rectTank) {
		
		
	}

}
