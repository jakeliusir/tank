package com.liuyanqing.tank.strategy;

import com.liuyanqing.tank.Audio;
import com.liuyanqing.tank.Bullet;
import com.liuyanqing.tank.Dir;
import com.liuyanqing.tank.GameModel;
import com.liuyanqing.tank.Group;
import com.liuyanqing.tank.Tank;
import com.liuyanqing.tank.decorator.RectDecorator;
import com.liuyanqing.tank.decorator.TailDecorator;

public class DefaultFireStrategy implements FireStrategy {

	@Override
	public void fire(Tank t) { 
		int bx = t.x+Tank.WIDTH/2-Bullet.WIDTH/2;int by = t.y+Tank.HEIGHT/2-Bullet.HEIGHT/2;
//		bug decorator ,模式之后 new Bullet把自己加了一遍

			   new Bullet(bx,by,t.dir,t.getGroup());	
			 
	    
		if (t.group==Group.GOOD) {
			new Thread(()->{
				new Audio("audio/tank_fire.wav").play();
			}).start();
		}
	}




}
