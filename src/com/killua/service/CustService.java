package com.killua.service;

import java.util.List;

import com.killua.domain.Cust;
import com.killua.domain.Page;

public interface CustService {
	/**
	 * 添加客户
	 * @param cust
	 */
	void addCust(Cust cust);
	/**
	 * 查询客户所有信息
	 * @return
	 */
	List<Cust> getAllCust();
	/**
	 * 根据id查找客户信息
	 * @param id 客户id
	 * @return 查找到的客户信息，if cannot found return null
	 */
	Cust findCustById(String id);
	/**
	 * 修改客户信息的方法
	 * @param cust 封装了最新客户信息的bean
	 */
	void updateCust(Cust cust);
	/**
	 * 通过id删除客户
	 * @param id
	 */
	void delCustById(String id);
	/**
	 * 批量删除客户	其中会进行事务管理
	 * @param ids 所有要删除的id组成的数组
	 */
	void batchDel(String[] ids);
	/**
	 * 根据条件查询客户信息
	 * @param cust 封装了查询条件的bean，其中可以有用户名/性别/客户类型
	 * @return 符合条件的客户
	 */
	List<Cust> findCustByCond(Cust cust);
	/**
	 * 分页查询客户的方法
	 * @param thispage 当前页码
	 * @param rowperpage 每页记录数
	 * @param cust 根据javabean增加sql判断语句
	 * @return 当前页的所有信息
	 */
	Page pageCust(int thispage, int rowperpage, Cust cust);

}
