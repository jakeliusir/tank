package com.liuyanqing.tank;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

import com.liuyanqing.tank.cor.Collider;
import com.liuyanqing.tank.cor.TankTankCollider;
import com.liuyanqing.tank.strategy.FireStrategy;
import com.sun.prism.paint.Stop;

public class Tank extends GameObject {
	public static int WIDTH = ResourceMgr.goodTankU.getWidth(), HEIGHT = ResourceMgr.goodTankU.getHeight();
	private static final int SPEED = 5;
	private boolean living = true;
	public int x;
	public int y;
	public Dir dir = Dir.DOWN;
	private boolean moving = true;


	private Random random = new Random();
	FireStrategy fs = null;
	public Group group = Group.BAD;
	public Rectangle rect = new Rectangle();
	int oldx,oldy;

	public Tank(int x, int y, Dir dir, Group group) {
		super();
		this.x = x;
		this.y = y;
		this.dir = dir;
		this.group = group;
		

		rect.x = this.x;
		rect.y = this.y;
		rect.width = WIDTH;
		rect.height = HEIGHT;
		if (group == Group.GOOD) {
			String goodFs = (String) PropertyMgr.get("goodFs");
			try {
				fs = (FireStrategy) Class.forName(goodFs).newInstance();

			} catch (Exception e) {
			}
		} else {
			String badFs = (String) PropertyMgr.get("badFs");
			try {
				fs = (FireStrategy) Class.forName(badFs).newInstance();
			} catch (Exception e) {

			}
		}
		GameModel.getInstance().add(this);

	}

	private void boundsCheck() {
		if (this.x < 2) {
			x = 2;
		}
		if (this.y < 28) {
			y = 28;
		}
		if (this.x > TankFrame.GAME_WIDTH - Tank.WIDTH - 2) {
			x = TankFrame.GAME_WIDTH - Tank.WIDTH - 2;
		}
		if (this.y > TankFrame.GAME_HEIGHT - Tank.HEIGHT - 2) {
			y = TankFrame.GAME_HEIGHT - Tank.HEIGHT - 2;
		}
		
//		if (moving =false) {
//			x=oldx;
//			y=oldy;
//		}

	}

	public void die() {
		this.living = false;

	}

	public void fire() {
		fs.fire(this);
	}

	public Dir getDir() {
		return dir;
	}

	public Group getGroup() {
		return group;
	}



	public Rectangle getRect() {
		return rect;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public boolean isMoving() {
		return moving;
	}

	private void move() {
		  oldx = x;
     	  oldy = y;
   
		if (!moving) {
		
			return;
		}
		switch (dir) {
		case LEFT:
			x -= SPEED;
			break;
		case RIGHT:
			x += SPEED;
			break;
		case UP:
			y -= SPEED;
			break;
		case DOWN:
			y += SPEED;
			break;
		}
//	    randomDir();
		if (this.group == Group.BAD && random.nextInt(100) > 95) {
			this.fire();
		}
		if (group == Group.BAD && random.nextInt(100) > 95) {
			randomDir();
		}
		boundsCheck();

		// update rect
		rect.x = this.x;
		rect.y = this.y;
		
	}

	public int getOldx() {
		return oldx;
	}

	public void setOldx(int oldx) {
		this.oldx = oldx;
	}

	public int getOldy() {
		return oldy;
	}

	public void setOldy(int oldy) {
		this.oldy = oldy;
	}

	public void paint(Graphics g) {
		// TODO Auto-generated method stub
//		Color c = g.getColor();
//		g.setColor(Color.blue);
//		g.fillRect(x,y,50,50);//绘制了一个小黑块
//	    x+=10;
//	    y+=10;	
		if (!living) {
			GameModel.getInstance().remove(this);
		}
		switch (dir) {
		case LEFT:
			g.drawImage(this.group == Group.GOOD ? ResourceMgr.goodTankL : ResourceMgr.badTankL, x, y, null);
			break;
		case RIGHT:
			g.drawImage(this.group == Group.GOOD ? ResourceMgr.goodTankR : ResourceMgr.badTankR, x, y, null);
			break;
		case UP:
			g.drawImage(this.group == Group.GOOD ? ResourceMgr.goodTankU : ResourceMgr.badTankU, x, y, null);
			break;
		case DOWN:
			g.drawImage(this.group == Group.GOOD ? ResourceMgr.goodTankD : ResourceMgr.badTankD, x, y, null);
			break;

		default:
			break;
		}
		move();
	}

	private void randomDir() {

		this.dir = Dir.values()[random.nextInt(4)];

	}

	public void setDir(Dir dir) {
		this.dir = dir;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public void setMoving(boolean moving) {
		this.moving = moving;
	}

	public void setRect(Rectangle rect) {
		this.rect = rect;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}
	public void stop() {
		this.x =oldx;
		this.y =oldy;
//		moving = false;
	
		
	}

}