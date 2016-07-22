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
		//1.����û����Ƿ��Ѿ�����
		if(dao.findUserByName(cust.getName())!=null){
			throw new RuntimeException("�û����Ѿ����ڣ�");
		}
		//2.����dao�еķ������ӿͻ�
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
			conn.setAutoCommit(false);  //��conn��������
			for(String id : ids){
				dao.delCustByIDWithTrans(conn,id);//ͨ��idɾ���ͻ�
			}
			DbUtils.commitAndCloseQuietly(conn); //ʹ������ύ��������Ϊ��Ҫ��conn���ӽ��д���
		} catch (SQLException e) {
			DbUtils.rollbackAndCloseQuietly(conn);//ʹ������ع�����Ϊ��Ҫ��conn���д���
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
		//--��ǰҳ
		page.setThispage(thispage);
		//--ÿҳ��¼��
		page.setRowperpage(rowperpage);
		//--���ж�����
	//	int countrow = dao.getCountRow();	
	//	page.setCountrow(countrow);   �Ѿ������ķ���
		//������ж�����
		int selectcountpage = dao.getSelcetCountRow((thispage-1)*rowperpage,rowperpage,cust);
		page.setSelectcountpage(selectcountpage);
	
		//--���ж���ҳ
		int countpage = selectcountpage/rowperpage+(selectcountpage%rowperpage==0?0:1);
		page.setCountpage(countpage);
		//--��ҳ
		page.setFirstpage(1);
		//--βҳ
		page.setLastpage(countpage);
		//--��һҳ
		page.setPrepage(thispage==1?1:thispage-1);
		//--��һҳ
		page.setNextpage(thispage == countpage ? countpage :thispage+1);
		//--��ǰҳ����
		List<Cust> list= dao.getCustByPage((thispage-1)*rowperpage,rowperpage,cust);
		page.setList(list);
		return page;
		
	}


}
