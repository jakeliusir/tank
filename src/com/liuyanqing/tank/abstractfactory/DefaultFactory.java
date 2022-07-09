package com.liuyanqing.tank.abstractfactory;

import com.liuyanqing.tank.Bullet;
import com.liuyanqing.tank.Dir;
import com.liuyanqing.tank.Explode;
import com.liuyanqing.tank.Group;
import com.liuyanqing.tank.Tank;
import com.liuyanqing.tank.TankFrame;

public class DefaultFactory extends GameFactory{
private DefaultFactory() {
} 
private static  DefaultFactory INSTANCE = new DefaultFactory();
public static  DefaultFactory getInstance() {
	return INSTANCE;
}
//private DefaultFactory() {}
//private static DefaultFactory INSTANCE = new DefaultFactory();
//public static DefaultFactory getInstance() {
//	return INSTANCE;
//} 

	@Override
	public BaseTank createTank(int x, int y, Dir dir, Group group, TankFrame tf) {
		// TODO Auto-generated method stub
		return new Tank(x,y,dir,group,tf);
	}
	@Override
	public BaseBullet createBullet(int x, int y, Dir dir, Group group, TankFrame tf) {
		// TODO Auto-generated method stub
		return new Bullet(x,y,dir,group,tf);
	}
	@Override
	public BaseExplode createExplode(int x, int y, TankFrame tf) {
		// TODO Auto-generated method stub
		return new Explode(x, y, tf);
	}


}
