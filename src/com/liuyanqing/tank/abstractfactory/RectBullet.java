package com.liuyanqing.tank.abstractfactory;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.liuyanqing.tank.Dir;
import com.liuyanqing.tank.Explode;
import com.liuyanqing.tank.Group;
import com.liuyanqing.tank.ResourceMgr;
import com.liuyanqing.tank.Tank;
import com.liuyanqing.tank.TankFrame;

public class RectBullet extends BaseBullet {
    private static final int SPEED =20;
    public static int WIDTH = ResourceMgr.bulletD.getWidth(),HEIGHT = ResourceMgr.bulletD.getHeight();

     Rectangle rect1  = new Rectangle();
    

    private int x , y;
    private Dir dir;
    private boolean living = true; 
    TankFrame tf  = null;
    
    private Group group = Group.BAD;

	public static int getWIDTH() {
		return WIDTH;
	}

	public static void setWIDTH(int wIDTH) {
		WIDTH = wIDTH;
	}

	public static int getHEIGHT() {
		return HEIGHT;
	}

	public static void setHEIGHT(int hEIGHT) {
		HEIGHT = hEIGHT;
	}

	public Rectangle getRect1() {
		return rect1;
	}

	public void setRect1(Rectangle rect1) {
		this.rect1 = rect1;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Dir getDir() {
		return dir;
	}

	public void setDir(Dir dir) {
		this.dir = dir;
	}

	public boolean isLiving() {
		return living;
	}

	public void setLiving(boolean living) {
		this.living = living;
	}

	public TankFrame getTf() {
		return tf;
	}

	public void setTf(TankFrame tf) {
		this.tf = tf;
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public static int getSpeed() {
		return SPEED;
	}

	public RectBullet(int x, int y, Dir dir, Group group, TankFrame tf) {
		super();
		this.x = x;
		this.y = y;
		this.group =group;
		this.dir = dir;
		this.tf =tf;
		rect1.x = this.x;
		rect1.y = this.y;
		rect1.width = WIDTH;
		rect1.height = HEIGHT;
		
		tf.bullets.add(this);
	}

	@Override
	public void paint(Graphics g) {
		if(!living) {
			tf.bullets.remove(this);
		}
//		Color color = g.getColor();
//		g.setColor(Color.RED);
//		g.fillOval(x, y, WIDTH, HEIGHT);//绘制了一个黑块
//	    x+=10;
//	    y+=10;	
		switch (dir) {
		case LEFT:
			g.drawImage(ResourceMgr.bulletL,x,y,null);
			break;
		case RIGHT:
			g.drawImage(ResourceMgr.bulletR,x,y,null);
			break;
		case UP:
			g.drawImage(ResourceMgr.bulletU,x,y,null);
			break;
		case DOWN:
			g.drawImage(ResourceMgr.bulletD,x,y,null);
			break;

		default:
			break;
		}	
		move();

	}

	private void move() {
		  switch (dir) {
			case LEFT:
				x-=SPEED;
				break;
			case RIGHT:
				x+=SPEED;
				break;
			case UP:
				y-=SPEED;
				break;
			case DOWN:
				y+=SPEED;
				break;
			}
			//更新rect
			rect1.x = this.x;
			rect1.y = this.y;
		    
			if(x<0 || y<0 || x> TankFrame.GAME_WIDTH || y> TankFrame.GAME_HEIGHT) living = false;
			
		
	}

	@Override
	public void collidewith(BaseTank tank) {
		if(this.group == tank.group) {
			
			return;
		}
		Rectangle rect1 = new Rectangle(this.x,this.y,WIDTH,HEIGHT);
		Rectangle rect2 = new Rectangle(tank.getX(),tank.getY(),Tank.WIDTH,Tank.HEIGHT);
		if (this.rect1.intersects(tank.rect)) {
	
			tank.die();
			this.die();
			int ex = tank.getX()+Tank.WIDTH/2 - Explode.WIDTH/2;
			int ey = tank.getY()+Tank.HEIGHT/2 -Explode.HEIGHT/2;
			tf.explodes.add(tf.gf.createExplode(ex,ey,tf));
		}

	}

	private void die() {
		
		this.living =false;
	}

}
