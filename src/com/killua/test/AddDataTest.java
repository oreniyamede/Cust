package com.killua.test;

import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;

import com.killua.util.DaoUtils;

public class AddDataTest {
	
	@Test
	public void test(){
		String sql = "insert into customer values (null,?,?,?,?,?,?,?,?)";
		try {
			QueryRunner runner = new QueryRunner(DaoUtils.getSource());//仍连接池进去
			//执行sql语句，并且把参数传进去
			for(int i = 0; i!=100; i++){
				runner.update(sql,"name"+i,"男","1999-09-09","10000","aaa@qq.com","小正太","白银客户","变态");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
}
