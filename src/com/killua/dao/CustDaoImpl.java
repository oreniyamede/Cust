package com.killua.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.killua.domain.Cust;
import com.killua.util.DaoUtils;
import com.mchange.v2.c3p0.ComboPooledDataSource;


public class CustDaoImpl implements CustDao {
	
	public CustDaoImpl() {
	}

	@Override
	public Cust findUserByName(String name) {
		try {
			String sql = "select * from customer where name = ?";
			QueryRunner runner = new QueryRunner(DaoUtils.getSource());//扔连接池进去
			return runner.query(sql, new BeanHandler<Cust>(Cust.class),name);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	@Override
	public void addCust(Cust cust) {
		String sql = "insert into customer values (null,?,?,?,?,?,?,?,?)";
		try {
			QueryRunner runner = new QueryRunner(DaoUtils.getSource());//仍连接池进去
			//执行sql语句，并且把参数传进去
			runner.update(sql,cust.getName(),cust.getGender(),cust.getBirthday(),cust.getCellphone(),cust.getEmail(),cust.getPreference(),cust.getType(),cust.getDescription());
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	@Override
	public List<Cust> getAllCust() {
		String sql = "select * from customer";
		try {
			QueryRunner runner = new QueryRunner(DaoUtils.getSource());
			
			return runner.query(sql,new BeanListHandler<Cust>(Cust.class));
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	@Override
	public Cust findUserById(String id) {
		String sql = "select * from customer where id = ?";
		try {
			QueryRunner runner = new QueryRunner(DaoUtils.getSource());	
			return (Cust) runner.query(sql,new BeanHandler<Cust>(Cust.class),id); //返回一枚客户
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	@Override
	public void updateCust(Cust cust) {
		String sql = "update customer set name=?,gender=?,birthday=?,cellphone=?,email=?,preference=?,type=?,description=? where id=?";
		try {
			QueryRunner runner = new QueryRunner(DaoUtils.getSource());//仍连接池进去
			//执行sql语句，并且把参数传进去
			runner.update(sql,cust.getName(),cust.getGender(),cust.getBirthday(),cust.getCellphone(),cust.getEmail(),cust.getPreference(),cust.getType(),cust.getDescription(),cust.getId());
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		
	}

	@Override
	public void delCustByID(String id) {
		String sql = "delete from customer where id = ?";
		try {
			QueryRunner runner = new QueryRunner(DaoUtils.getSource());//仍连接池进去
			//执行sql语句，并且把参数传进去
			runner.update(sql,id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}

	@Override
	public void delCustByIDWithTrans(Connection conn, String id) throws SQLException {
		String sql = "delete from customer where id = ?";
		QueryRunner runner = new QueryRunner();
		//执行sql语句，并且把参数传进去
		runner.update(conn,sql,id);
		
	}

	@Override
	public List<Cust> findCustByCond(Cust cust) {
		String sql = "select * from customer where 1=1 ";
		List<Object> list = new ArrayList<Object>();
		if(cust.getName()!=null && !"".equals(cust.getName())){
			sql += " and name like ? ";
			list.add("%"+cust.getName()+"%");
		}
		
		if(cust.getGender()!=null && !"".equals(cust.getGender())){
			sql += " and gender = ? ";
			list.add(cust.getGender());
		}
		
		if(cust.getType()!=null && !"".equals(cust.getType())){
			sql += " and type = ? ";
			list.add(cust.getType());
		}
		try {
			QueryRunner runner = new QueryRunner(DaoUtils.getSource());	
			if(list.size()<=0){
				return runner.query(sql,new BeanListHandler<Cust>(Cust.class));
			}else{
				return runner.query(sql,new BeanListHandler<Cust>(Cust.class),list.toArray()); //返回客户集
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	@Override
	public int getCountRow() {
		String sql = "select count(*) from customer";
		
		try {
			QueryRunner runner = new QueryRunner(DaoUtils.getSource());	
			return ((Long)runner.query(sql,new ScalarHandler())).intValue();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}


	public List<Cust> getCustByPage(int from, int count,Cust cust) {
		String sql = "select * from customer where 1=1 ";
		List<Object> list = new ArrayList<Object>();
		if(cust!=null){
			if(cust.getName()!=null && !"".equals(cust.getName())){
				sql += " and name like ? ";
				list.add("%"+cust.getName()+"%");
			}
			
			if(cust.getGender()!=null && !"".equals(cust.getGender())){
				sql += " and gender = ? ";
				list.add(cust.getGender());
			}
			
			if(cust.getType()!=null && !"".equals(cust.getType())){
				sql += " and type = ? ";
				list.add(cust.getType());
			}
		}
	
		sql += " limit ?,?";
		list.add(from);
		list.add(count);
		
		try {
			QueryRunner runner = new QueryRunner(DaoUtils.getSource());	
			if(list.size()<=0){
				return runner.query(sql,new BeanListHandler<Cust>(Cust.class),from,count);
			}else{
				return runner.query(sql,new BeanListHandler<Cust>(Cust.class),list.toArray()); //返回客户集
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		
	}

	@Override
	public int getSelcetCountRow(int from, int count, Cust cust) {
		String sql = "select count(*) from customer where 1=1 ";
		List<Object> list = new ArrayList<Object>();
		if(cust!=null){
			if(cust.getName()!=null && !"".equals(cust.getName())){
				sql += " and name like ? ";
				list.add("%"+cust.getName()+"%");
			}
			
			if(cust.getGender()!=null && !"".equals(cust.getGender())){
				sql += " and gender = ? ";
				list.add(cust.getGender());
			}
			
			if(cust.getType()!=null && !"".equals(cust.getType())){
				sql += " and type = ? ";
				list.add(cust.getType());
			}
		}
	

		try {
			QueryRunner runner = new QueryRunner(DaoUtils.getSource());	
			int i = ((Long)runner.query(sql,new ScalarHandler(),list.toArray())).intValue();
			return i;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}






}
