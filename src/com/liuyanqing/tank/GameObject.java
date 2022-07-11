package com.liuyanqing.tank;

import java.awt.Graphics;

public abstract class GameObject {
//形容词用接口 名词用抽象方法继承
	
    public int x;
	public int y;
	public abstract void paint(Graphics g);
	public abstract int getWidth();
	public abstract int getHight();
	
	
}
