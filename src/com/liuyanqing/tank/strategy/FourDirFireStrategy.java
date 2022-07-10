package com.liuyanqing.tank.strategy;

import com.liuyanqing.tank.Audio;
import com.liuyanqing.tank.Bullet;
import com.liuyanqing.tank.Dir;
import com.liuyanqing.tank.Group;
import com.liuyanqing.tank.Tank;

public class FourDirFireStrategy implements FireStrategy {

	@Override
	public void fire(Tank t) {
		int bx = t.x+Tank.WIDTH/2-Bullet.WIDTH/2;
		int by = t.y+Tank.HEIGHT/2-Bullet.HEIGHT/2;
		
		 Dir[] dirs = Dir.values();
		for(Dir dir : dirs) {
			new Bullet(bx,by,dir,t.group,t.gm);		
		}
	    
		if (t.group==Group.GOOD) {
			new Thread(()->{
				new Audio("audio/tank_fire.wav").play();
			}).start();
		}
		
	}



}
