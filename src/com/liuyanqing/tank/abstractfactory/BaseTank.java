package com.liuyanqing.tank.abstractfactory;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.liuyanqing.tank.Group;

public abstract class BaseTank {
     
	public Rectangle rect = new Rectangle();
	public Group group  = Group.BAD;
	public abstract void paint(Graphics g);

	public abstract void die();
	public abstract int getX();
	public abstract int getY();

	public Group getGroup() {
		return group;
	}
	
	
}
