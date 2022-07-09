package com.liuyanqing.tank;

import java.io.IOException;
import java.util.Properties;
public class PropertyMgr {

    private static Properties properties = new Properties();
    private PropertyMgr() {
		// TODO Auto-generated constructor stub
	}
    public  static  Properties getInstance() {
		return properties;
	}
    
    static {
    	try {
			properties.load(PropertyMgr.class.getClassLoader().getResourceAsStream("config"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    public static Object get(String key) {
    	if (properties ==null) {
			return null;	
		}
    	return properties.get(key);
    }
    
//    int getInt(key)
//    getString(key)
    
        public static void main(String[] args) {
		System.out.println(PropertyMgr.get("initTankCount"));
	}

}
