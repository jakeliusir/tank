package com.liuyanqing.tank.decorator;

import java.awt.Color;
import java.awt.Graphics;

import com.liuyanqing.tank.GameObject;

public   class RectDecorator extends GODecorator {

	public RectDecorator(GameObject go) {
		super(go);
		
	}

	@Override
	public void paint(Graphics g) {
		this.x = go.x;
		this.y = go.y;
		go.paint(g);
		Color c = g.getColor();
		g.setColor(Color.RED);
		g.drawRect(go.x,go.y,go.getWidth(),go.getHight());
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
