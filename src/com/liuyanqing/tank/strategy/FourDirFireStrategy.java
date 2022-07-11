package com.liuyanqing.tank.strategy;

import com.liuyanqing.tank.Audio;
import com.liuyanqing.tank.Bullet;
import com.liuyanqing.tank.Dir;
import com.liuyanqing.tank.GameModel;
import com.liuyanqing.tank.GameObject;
import com.liuyanqing.tank.Group;
import com.liuyanqing.tank.Tank;
import com.liuyanqing.tank.decorator.GODecorator;
import com.liuyanqing.tank.decorator.RectDecorator;
import com.liuyanqing.tank.decorator.TailDecorator;

import javafx.scene.control.TabPane.TabClosingPolicy;

public class FourDirFireStrategy implements FireStrategy {

	@Override
	public void fire(Tank t) {
		int bx = t.x+Tank.WIDTH/2-Bullet.WIDTH/2;
		int by = t.y+Tank.HEIGHT/2-Bullet.HEIGHT/2;
		
		 Dir[] dirs = Dir.values();
		for(Dir dir : dirs) {
			
						  new Bullet(bx,by,dir,t.group);		
//						   GameModel.getInstance().add(new RectDecorator(new Bullet(bx, by, dir, t.group)));
		}
	    
		if (t.group==Group.GOOD) {
			new Thread(()->{
				new Audio("audio/tank_fire.wav").play();
			}).start();
		}
		
	}



}
