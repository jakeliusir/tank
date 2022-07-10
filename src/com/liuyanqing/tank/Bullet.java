package com.liuyanqing.tank;

import java.awt.Graphics;
import java.awt.Rectangle;



public class Bullet extends GameObject {
    private static final int SPEED =20;
    public static int WIDTH = ResourceMgr.bulletD.getWidth(),HEIGHT = ResourceMgr.bulletD.getHeight();

     Rectangle rect1  = new Rectangle();
    

    private int x , y;
    private Dir dir;
    private boolean living = true; 

    GameModel gm =null;
     Group group = Group.BAD;

    
	
	public Bullet(int x, int y, Dir dir,Group group,GameModel gm) {
		super();
		this.x = x;
		this.y = y;
		this.group =group;
		this.dir = dir;
		this.gm =gm;
		rect1.x = this.x;
		rect1.y = this.y;
		rect1.width = WIDTH;
		rect1.height = HEIGHT;
		
		gm.add(this);
	}
	

	public Group getGroup() {
		return group;
	}



	public void setGroup(Group group) {
		this.group = group;
	}



	public void paint(Graphics g) {
		
		if(!living) {
			gm.remove(this);
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
//	public void collidewith(BaseTank tank) {
//		if (this.group == tank.getGroup()) {
//			return;
//		}
//		碰撞时候产生多个rect对象。垃圾收集器回收会积累的特别多才能释放，采用一个初始化Rect
//		CodeReview and refactorning
//		TODO 用一个rect 来记录子弹位置
//		Rectangle rect1 = new Rectangle(this.x,this.y,WIDTH,HEIGHT);
//		Rectangle rect2 = new Rectangle(tank.getX(),tank.getY(),tank.WIDTH,tank.HEIGHT);
		
//	    if (this.rect.intersects(tank.rect)) {
//	    
//			tank.die();
//		    this.die(); 
//			int ex = tank.getX()+Tank.WIDTH/2-Explode.WIDTH/2;
//			int ey = tank.getY()+Tank.HEIGHT/2-Explode.HEIGHT/2;
//		    tf.explodes.add(tf.gf.createExplode(ex, ey, tf));
		
//		   new Thread(()->{
//			   this.explode = true;
//			   System.out.println(rect1);
//			    
//		   }).start(); 
//		}	
//	}
	
	//判断炮弹是否击中坦克
//	public void collidewith(BaseTank tank1) {
//    System.out.println("开始判断");		
//		if(this.group == tank1.group) {
//			 System.out.println("判断结束");	
//			return;
//		}
//		
//		if (this.rect.intersects(tank1.rect)) {
//			System.out.println("开始判断1");		
//			tank1.die();
//			this.die();
//			int ex = tank1.getX()+Tank.WIDTH/2 - Explode.WIDTH/2;
//			int ey = tank1.getY()+Tank.HEIGHT/2 -Explode.HEIGHT/2;
//			tf.explodes.add(tf.gf.createExplode(ex,ey,tf));
//		}
//	}
	private void die() {
	this.living =false;
		
	}



public boolean collidewith(Tank tank) {
	
		if(this.group == tank.group) {
			
			return false;
		}
		Rectangle rect1 = new Rectangle(this.x,this.y,WIDTH,HEIGHT);
		Rectangle rect2 = new Rectangle(tank.getX(),tank.getY(),Tank.WIDTH,Tank.HEIGHT);
		if (this.rect1.intersects(tank.rect)) {
			tank.die();
			this.die();
			int ex = tank.getX()+Tank.WIDTH/2 - Explode.WIDTH/2;
			int ey = tank.getY()+Tank.HEIGHT/2 -Explode.HEIGHT/2;
			gm.add(new Explode(ex,ey,gm));
			return true;
		}
		return false;
	
}




}
