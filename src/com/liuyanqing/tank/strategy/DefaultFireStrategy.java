package com.liuyanqing.tank.strategy;

import com.liuyanqing.tank.Audio;
import com.liuyanqing.tank.Bullet;
import com.liuyanqing.tank.Group;
import com.liuyanqing.tank.Tank;

public class DefaultFireStrategy implements FireStrategy {

	@Override
	public void fire(Tank t) {
		int bx = t.x+Tank.WIDTH/2-Bullet.WIDTH/2;
		int by = t.y+Tank.HEIGHT/2-Bullet.HEIGHT/2;
		
	    new Bullet(bx,by,t.dir,t.getGroup());	
		if (t.group==Group.GOOD) {
			new Thread(()->{
				new Audio("audio/tank_fire.wav").play();
			}).start();
		}
	}




}
