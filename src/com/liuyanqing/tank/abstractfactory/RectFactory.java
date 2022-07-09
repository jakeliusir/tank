package com.liuyanqing.tank.abstractfactory;

import com.liuyanqing.tank.Dir;
import com.liuyanqing.tank.Group;
import com.liuyanqing.tank.TankFrame;

public class RectFactory extends GameFactory{
//	单例来生成对象 饿汉式单例模式  不存在线程安全问题
	private  RectFactory() {}
	private static final RectFactory INSTANCE =new RectFactory();
    public static RectFactory getInstance() {
		return INSTANCE;
	}

	@Override
	public BaseTank createTank(int x, int y, Dir dir, Group group, TankFrame tf) {
		// TODO Auto-generated method stub
		return new RectTank(x,y,dir,group,tf);
	}

	@Override
	public BaseBullet createBullet(int x, int y, Dir dir, Group group, TankFrame tf) {
	   
		return new RectBullet(x,y,dir,group,tf);
	}

	@Override
	public BaseExplode createExplode(int x, int y, TankFrame tf) {
		// TODO Auto-generated method stub
		return new RectExplode(x,y,tf);
	}

}
