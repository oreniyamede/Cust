package com.killua.service;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;

import com.killua.dao.CustDao;
import com.killua.domain.Cust;
import com.killua.domain.Page;
import com.killua.factory.BasicFactory;
import com.killua.util.DaoUtils;

public class CustServiceImpl implements CustService {
	CustDao dao = BasicFactory.getFactory().getInstance(CustDao.class);
	public void addCust(Cust cust) {
		//1.检查用户名是否已经存在
		if(dao.findUserByName(cust.getName())!=null){
			throw new RuntimeException("用户名已经存在！");
		}
		//2.调用dao中的方法增加客户
		dao.addCust(cust);
	}
	@Override
	public List<Cust> getAllCust() {
		return dao.getAllCust();
	}
	@Override
	public Cust findCustById(String id) {
		return dao.findUserById(id);
	}
	@Override
	public void updateCust(Cust cust) {
		dao.updateCust(cust);
	}

	public void delCustById(String id) {
		dao.delCustByID(id);
		
	}
	@Override
	public void batchDel(String[] ids) {
		Connection conn = DaoUtils.getConn();
		try {
			conn.setAutoCommit(false);  //用conn设置事务
			for(String id : ids){
				dao.delCustByIDWithTrans(conn,id);//通过id删除客户
			}
			DbUtils.commitAndCloseQuietly(conn); //使用这个提交事物是因为还要对conn连接进行处理
		} catch (SQLException e) {
			DbUtils.rollbackAndCloseQuietly(conn);//使用这个回滚是因为还要对conn进行处理
			e.printStackTrace();
			throw new RuntimeException(e);
		}

	}
	@Override
	public List<Cust> findCustByCond(Cust cust) {
		
		return dao.findCustByCond(cust);
	}
	@Override
	public Page pageCust(int thispage, int rowperpage,Cust cust) {
		Page page = new Page();
		//--当前页
		page.setThispage(thispage);
		//--每页记录数
		page.setRowperpage(rowperpage);
		//--共有多少行
	//	int countrow = dao.getCountRow();	
	//	page.setCountrow(countrow);   已经废弃的方法
		//查出来有多少行
		int selectcountpage = dao.getSelcetCountRow((thispage-1)*rowperpage,rowperpage,cust);
		page.setSelectcountpage(selectcountpage);
	
		//--共有多少页
		int countpage = selectcountpage/rowperpage+(selectcountpage%rowperpage==0?0:1);
		page.setCountpage(countpage);
		//--首页
		page.setFirstpage(1);
		//--尾页
		page.setLastpage(countpage);
		//--上一页
		page.setPrepage(thispage==1?1:thispage-1);
		//--下一页
		page.setNextpage(thispage == countpage ? countpage :thispage+1);
		//--当前页数据
		List<Cust> list= dao.getCustByPage((thispage-1)*rowperpage,rowperpage,cust);
		page.setList(list);
		return page;
		
	}


}
