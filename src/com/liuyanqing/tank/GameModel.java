package com.liuyanqing.tank;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import com.liuyanqing.tank.cor.BulletTankCollider;
import com.liuyanqing.tank.cor.Collider;
import com.liuyanqing.tank.cor.ColliderChain;
import com.liuyanqing.tank.cor.TankTankCollider;


public class GameModel {
	private static final GameModel INSTANCE = new GameModel();
    Tank myTank =null;
//	   public  List<Bullet> bullets = new ArrayList<>();
//	   public  List<Tank>  tanks  = new ArrayList<>(); 
//	   public  List<Explode> explodes  = new ArrayList<>();
	ColliderChain colliderChain = new ColliderChain();
	Collider collider = new BulletTankCollider();
	Collider collider2 = new TankTankCollider();
	private List<GameObject> objects = new ArrayList<GameObject>();

	static {
		INSTANCE.init();
	}
	private GameModel() {}
	private void init() {
	    myTank = new Tank(200, 900, Dir.UP, Group.GOOD);
		int initTankCount = Integer.parseInt((String) PropertyMgr.get("initTankCount"));
		// 初始化地方坦克
		for (int i = 0; i < initTankCount; i++) {
			new Tank(50 + i * 180, 80, Dir.DOWN, Group.BAD);
		}
        //初始化墙
		add(new Wall(150, 150, 200, 50));
		add(new Wall(550, 150, 200, 50));
		add(new Wall(300, 300, 50, 200));
		add(new Wall(550, 300, 50, 200));
		add(new Wall(750, 650, 200, 50));
		add(new Wall(1250, 150, 50, 150));
		add(new Wall(1050, 450, 200, 50));
	}
     public  static GameModel getInstance() {
    	 return INSTANCE;
     }

	public void add(GameObject tank) {
		this.objects.add(tank);
	}

	public Tank getMainTank() {

		return myTank;
	}

	public void paint(Graphics g) {
		System.out.print("Paint");
		myTank.paint(g);
//		bullet.paint(g);//绘制了一个子弹
//		for(Bullet bullet : bullets) {
//			bullet.paint(g);
//		}
//		
		for (int i = 0; i < objects.size(); i++) {
			objects.get(i).paint(g);
			
		}

//       互相碰撞
		for (int i = 0; i < objects.size(); i++) {
			for (int j = i + 1; j < objects.size(); j++) {// Comparator.compare(o1,o2)
				GameObject o1 = objects.get(i);
				GameObject o2 = objects.get(j);
//			collider.collide(o1, o2);
//			collider2.collide(o1, o2);
				colliderChain.collide(o1, o2);
			}
		}

//   	for(Iterator<Bullet> it  =bullets.iterator();it.hasNext();) {
//		Bullet bullet  = it.next();
//		if(!bullet.live)it.remove();
//	}
//	    g.setColor(Color.white);
//		g.drawString("子弹的数量："+bullets.size(), 10, 60);

//		计算敌方坦克的数量
//	    g.setColor(Color.RED);
//	    g.drawString("敌方坦克的数量："+tanks.size(), 10, 80);
//		计算爆炸的数量
//	    g.setColor(Color.RED);
//	    g.drawString("爆炸的数量："+explodes.size(), 10, 100);
//	       
		// 画出敌方坦克
//		for (int i = 0; i < tanks.size(); i++) {
//			tanks.get(i).paint(g);
//		}

		// 判断炮弹是否打到坦克上面
//		for (int i = 0; i < bullets.size(); i++) {
//		
//			for (int j = 0; j < tanks.size(); j++) {
//				bullets.get(i).collidewith(tanks.get(j));
//			}
//		}
//		爆炸效果
//		for (int i = 0; i < explodes.size(); i++) {
//			explodes.get(i).paint(g);
//		}
//		
	}

	public void remove(GameObject go) {
		this.objects.remove(go);

	}


}
