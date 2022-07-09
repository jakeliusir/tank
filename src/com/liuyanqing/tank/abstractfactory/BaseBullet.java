package com.liuyanqing.tank.abstractfactory;

import java.awt.Graphics;


public abstract class BaseBullet {


	public abstract void paint(Graphics g);

	public abstract void collidewith(BaseTank tank);
}
