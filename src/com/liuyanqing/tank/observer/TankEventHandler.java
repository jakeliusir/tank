package com.liuyanqing.tank.observer;

import com.liuyanqing.tank.Tank;

public class TankEventHandler implements TankFireObserver {

	/**
	 * 观察者 观察是哪个Tank发出的Fire;
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void actionOnFire(TankFireEvent event) {
		Tank tank =event.getTank();
		tank.fire();
		
	}

}
