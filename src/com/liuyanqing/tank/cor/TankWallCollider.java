package com.liuyanqing.tank.cor;

import com.liuyanqing.tank.Bullet;
import com.liuyanqing.tank.GameObject;
import com.liuyanqing.tank.Tank;
import com.liuyanqing.tank.Wall;

public class TankWallCollider implements Collider{

	@Override
	public boolean collide(GameObject o1, GameObject o2) {
		  if (o1  instanceof Bullet && o2 instanceof Wall) {
			   Bullet b =(Bullet)o1;
			   Wall w = (Wall)o2;
//			   TODO copy code form method collidewith
			   if (b.rect1.intersects(w.rect)) {
				   b.die();
				return false;
			}
//			   
		}else if(o1 instanceof Wall && o2 instanceof Bullet){
			collide(o2, o1);
		}
			return true;
		
		
	}

}
