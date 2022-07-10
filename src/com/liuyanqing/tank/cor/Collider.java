package com.liuyanqing.tank.cor;

import com.liuyanqing.tank.GameObject;

public interface Collider {
  boolean collide(GameObject o1,GameObject o2);
}
