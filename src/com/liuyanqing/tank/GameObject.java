package com.liuyanqing.tank;

import java.awt.Graphics;

public abstract class GameObject {
//形容词用接口 名词用抽象方法继承
	
	int x,y;
	public abstract void paint(Graphics g);
	
	
}
