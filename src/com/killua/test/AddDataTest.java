package com.killua.test;

import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;

import com.killua.util.DaoUtils;

public class AddDataTest {
	
	@Test
	public void test(){
		String sql = "insert into customer values (null,?,?,?,?,?,?,?,?)";
		try {
			QueryRunner runner = new QueryRunner(DaoUtils.getSource());//�����ӳؽ�ȥ
			//ִ��sql��䣬���ҰѲ�������ȥ
			for(int i = 0; i!=100; i++){
				runner.update(sql,"name"+i,"��","1999-09-09","10000","aaa@qq.com","С��̫","�����ͻ�","��̬");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
}
