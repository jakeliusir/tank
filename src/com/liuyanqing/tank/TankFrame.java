package com.liuyanqing.tank;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Paint;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;





public class TankFrame extends Frame{
	GameModel gm  =new GameModel();
      public  static final int GAME_WIDTH=1480,GAME_HEIGHT=800;     
	    private final int SPEED = 20;	
    	public TankFrame() {
	      setSize(1480,800);
	      setResizable(false);
	      setTitle("̹坦克大战");
	      setVisible(true);	      
	      this.addKeyListener(new MyKeyListener());
	      addWindowListener(new WindowAdapter(){
	    	  @Override
	       public void  windowClosing(WindowEvent event) {
	    		  System.exit(0);	    		  
	    	  }	    	 
	      });			
	}
	//双缓冲解决闪烁问题  首先把画出来的东西（坦克、子弹）
    //先画在内存的图片中,图片大小和游戏画面一直,把内存中的图片一次性的复制显示屏上
	Image offScreenImage  = null;
	@Override
	public void update(Graphics g) {
		if(offScreenImage == null) {
			offScreenImage = this.createImage(GAME_WIDTH, GAME_HEIGHT);
		}
		Graphics goffScreen = offScreenImage.getGraphics();
		Color c =goffScreen.getColor();
		goffScreen.setColor(Color.BLACK);
		goffScreen.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);
		goffScreen.setColor(c);
		paint(goffScreen);
		g.drawImage(offScreenImage, 0, 0, null);
	}
	   @Override
	   public void paint(Graphics g) {
		   gm.paint(g);
		   

	}


   class MyKeyListener extends KeyAdapter{
	       boolean bL = false;  
	       boolean bU = false;
	       boolean bR = false;
	       boolean bD = false;
       
		@Override
		public void keyPressed(KeyEvent e) {	//判断方向
			int key  = e.getKeyCode();
			switch (key) {
			case KeyEvent.VK_LEFT:
				bL=true;
				System.out.println("左键");
				break;
			case KeyEvent.VK_RIGHT:
				bR=true;
				break;
			case KeyEvent.VK_UP:
		
				bU=true;
				break;
			case KeyEvent.VK_DOWN:
		
				bD=true;
				break;
			default:
				break;
			}
			setMainTankDir();
			
			System.out.println("key pressed");
//			x+=30;
//			repaint();
		}

		@Override
		public void keyReleased(KeyEvent e) {
			System.out.println("key Released");
//			paint(getGraphics());
			int key  = e.getKeyCode();
			switch (key) {
			case KeyEvent.VK_LEFT:
				bL=false;
				break;
			case KeyEvent.VK_RIGHT:
				bR=false;
				break;
			case KeyEvent.VK_UP:
				
				bU=false;
				break;
			case KeyEvent.VK_DOWN:
				bD=false;
				break;
			case KeyEvent.VK_CONTROL:
				gm.getMainTank().fire();
				break;
			default:
				break;
			}
			setMainTankDir();	
		}
		private void setMainTankDir() {
			//这里加方向键 
			if(!bL && !bU && !bR && !bD) gm.getMainTank().setMoving(false);
			else {
				gm.getMainTank().setMoving(true);
			if (bL)  gm.getMainTank().setDir(Dir.LEFT);
			if (bR)  gm.getMainTank().setDir(Dir.RIGHT);
			if (bU)  gm.getMainTank().setDir(Dir.UP);
			if (bD)  gm.getMainTank().setDir(Dir.DOWN);
	  }			
	}
  }
}

