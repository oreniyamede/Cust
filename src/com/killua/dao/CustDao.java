package com.killua.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.killua.domain.Cust;

public interface CustDao {
	/**
	 * 根据用户名查找用户
	 * @param name 用户名
	 * @return 找到的用户，如果找不到返回NULL
	 */
	Cust findUserByName(String name);
	/**
	 * 添加客户
	 * @param cust
	 */

	void addCust(Cust cust);
	/**
	 * 获取所有用户信息组成的集合
	 * @return 封装了所有用户信息的集合，如果没有客户，返回null
	 */
	List<Cust> getAllCust();
	/**
	 * 根据id查找客户
	 * @param id = 客户id
	 * @return 客户bean
	 */
	Cust findUserById(String id);
	/**
	 * 修改客户信息
	 * @param cust 最新信息bean
	 */
	void updateCust(Cust cust);
	/**
	 * 通过id删除客户信息
	 * @param id
	 */
	void delCustByID(String id);
	/**
	 * 通过客户id使用事件批量删除
	 * @param id
	 * @throws SQLException 
	 */
	void delCustByIDWithTrans(Connection conn,String id) throws SQLException;
	/**
	 * 根据用户名/性别/客户类型查找客户
	 * @param cust 条件bean
	 * @return 返回符合条件的客户bean
	 */
	List<Cust> findCustByCond(Cust cust);
	/**
	 * 查询数据库中一共有多少条记录
	 * @return
	 */
	int getCountRow();
	/**
	 * 查询指记录后多少条记录
	 * @param from 从哪条记录后取多少条
	 * @param count 
	 * @param cust 
	 * @return
	 */

	List<Cust> getCustByPage(int from, int count, Cust cust);
	/**
	 * 查出来的总行数
	 * @param from
	 * @param count
	 * @param cust
	 * @return
	 */
	int getSelcetCountRow(int from, int count, Cust cust);
	
	
}
