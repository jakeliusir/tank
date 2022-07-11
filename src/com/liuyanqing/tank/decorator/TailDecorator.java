package com.liuyanqing.tank.decorator;

import java.awt.Color;
import java.awt.Graphics;

import com.liuyanqing.tank.GameObject;

public   class TailDecorator extends GODecorator {

	public TailDecorator(GameObject go) {
		super(go);
		
	}

	@Override
	public void paint(Graphics g) {
		this.x = go.x;
		this.y = go.y;
		go.paint(g);
		Color c = g.getColor();
		g.setColor(Color.RED);
		g.drawLine(go.x, go.y, go.x+getWidth(),go.y+getHight());
		g.setColor(c);
	}

	@Override
	public int getWidth() {
		// TODO Auto-generated method stub
		return super.go.getWidth();
	}

	@Override
	public int getHight() {
		// TODO Auto-generated method stub
		return super.go.getHight();
	}

	

}
