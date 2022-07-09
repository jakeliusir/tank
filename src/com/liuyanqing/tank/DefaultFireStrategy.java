package com.liuyanqing.tank;

import com.liuyanqing.tank.abstractfactory.RectBullet;
import com.liuyanqing.tank.abstractfactory.RectTank;

public class DefaultFireStrategy implements FireStrategy {

	@Override
	public void fire(Tank t) {
		int bx = t.x+Tank.WIDTH/2-Bullet.WIDTH/2;
		int by = t.y+Tank.HEIGHT/2-Bullet.HEIGHT/2;
		
	    new Bullet(bx,by,t.dir,t.group,t.tf);	
		if (t.group==Group.GOOD) {
			new Thread(()->{
				new Audio("audio/tank_fire.wav").play();
			}).start();
		}
	}

	@Override
	public void fire(RectTank rectTank) {
		int bx = rectTank.getX()+RectTank.WIDTH/2-RectBullet.WIDTH/2;
		int by = rectTank.getY()+RectTank.HEIGHT/2-RectBullet.HEIGHT/2;
		
	    new Bullet(bx,by,rectTank.getDir(),rectTank.group,rectTank.getTf());	
		if (rectTank.group==Group.GOOD) {
			new Thread(()->{
				new Audio("audio/tank_fire.wav").play();
			}).start();
		}
		
	}

}
