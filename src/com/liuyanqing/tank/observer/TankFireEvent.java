package com.liuyanqing.tank.observer;

import com.liuyanqing.tank.Tank;

public class TankFireEvent {

	Tank tank;
	public TankFireEvent(Tank tank) {
		super();
		this.tank = tank;
	}
	public Tank getTank() {
		return tank;
	}
	public void setTank(Tank tank) {
		this.tank = tank;
	}

}
