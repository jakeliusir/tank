package com.liuyanqing.tank.cor;

import com.liuyanqing.tank.Bullet;
import com.liuyanqing.tank.Explode;
import com.liuyanqing.tank.GameModel;
import com.liuyanqing.tank.GameObject;
import com.liuyanqing.tank.Tank;

public class BulletTankCollider implements Collider {

	@Override
	public boolean collide(GameObject o1, GameObject o2) {
		if (o1 instanceof Bullet && o2 instanceof Tank) {
			Bullet b = (Bullet) o1;
			Tank t = (Tank) o2;
//			   TODO copy code form method collidewith  yes
			if (b.group == t.group) {
				return false;
			} else if (b.rect1.intersects(t.rect)) {
				t.die();
				b.die();
				int ex = t.getX() + Tank.WIDTH / 2 - Explode.WIDTH / 2;
				int ey = t.getY() + Tank.HEIGHT / 2 - Explode.HEIGHT / 2;
				new Explode(ex, ey);
				return true;
			} else {
				return false;
			}
		} else if (o1 instanceof Tank && o2 instanceof Bullet) {
			collide(o2, o1);
		}
		return true;

	}

}
