package com.killua.factory;

import java.io.FileReader;
import java.util.Properties;

import com.killua.dao.CustDao;

public class BasicFactory {
	private BasicFactory() {

	}
	
	private static BasicFactory factory = new BasicFactory();
	private static Properties prop = null;
	
	static{
		try {
			prop = new Properties();
			prop.load(new FileReader(BasicFactory.class.getClassLoader().getResource("config.properties").getPath()));
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	
	}
	
	public static BasicFactory getFactory(){
		return factory;
	}
	
	public <T> T getInstance(Class<T> clazz){
		try {
			String cName = clazz.getSimpleName();
			String cImplName = prop.getProperty(cName);
			return  (T)Class.forName(cImplName).newInstance();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
