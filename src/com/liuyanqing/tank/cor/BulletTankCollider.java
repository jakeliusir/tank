package com.liuyanqing.tank.cor;

import com.liuyanqing.tank.Bullet;
import com.liuyanqing.tank.GameObject;
import com.liuyanqing.tank.Tank;

public class BulletTankCollider implements Collider{

	@Override
	public boolean collide(GameObject o1, GameObject o2) {
		  if (o1  instanceof Bullet && o2 instanceof Tank) {
			   Bullet b =(Bullet)o1;
			   Tank t = (Tank)o2;
//			   TODO copy code form method collidewith
			   if (b.collidewith(t)) {
				return false;
			}
		}else if(o1 instanceof Tank && o2 instanceof Bullet){
			collide(o2, o1);
		}
			return true;
		
		
	}

}
