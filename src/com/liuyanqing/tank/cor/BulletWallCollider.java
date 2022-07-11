package com.liuyanqing.tank.cor;


import com.liuyanqing.tank.GameObject;
import com.liuyanqing.tank.Tank;
import com.liuyanqing.tank.Wall;

public class BulletWallCollider implements Collider{

	@Override
	public boolean collide(GameObject o1, GameObject o2) {
		  if (o1  instanceof Tank && o2 instanceof Wall) {
			   Tank t =(Tank)o1;
			   Wall w = (Wall)o2;
//			   TODO copy code form method collidewith
			   if (t.rect.intersects(w.rect)) {
//				   t.die();
				   t.stop();
				  
				return false;
			}
		}else if(o1 instanceof Wall && o2 instanceof Tank){
			collide(o2, o1);
		    
			
		}
			return true;
		
		
	}

}
