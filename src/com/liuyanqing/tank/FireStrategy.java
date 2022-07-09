package com.liuyanqing.tank;

import com.liuyanqing.tank.abstractfactory.RectTank;

public interface FireStrategy {
     
	void fire(Tank t);

	void fire(RectTank rectTank);
}
