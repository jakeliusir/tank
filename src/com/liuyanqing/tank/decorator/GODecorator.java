package com.liuyanqing.tank.decorator;

import java.awt.Graphics;

import com.liuyanqing.tank.GameObject;
//装饰器模式
public abstract class GODecorator extends GameObject{
   GameObject go;
   public GODecorator(GameObject go) {
	   this.x = go.x;
	   this.y = go.y;
	   this.go =go;
}
  
	@Override
	public void paint(Graphics g) {
		go.paint(g);
	}

}
