package com.liuyanqing.tank.abstractfactory;

import com.liuyanqing.tank.Dir;
import com.liuyanqing.tank.Group;
import com.liuyanqing.tank.TankFrame;

public abstract class GameFactory {
public abstract BaseTank createTank(int x,int y,Dir dir,Group group,TankFrame tf);
public abstract BaseBullet createBullet(int x,int y,Dir dir,Group group,TankFrame tf);
public abstract BaseExplode createExplode(int x, int y,TankFrame tf);
	
	
}
