package com.killua.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.killua.domain.Cust;

public interface CustDao {
	/**
	 * �����û��������û�
	 * @param name �û���
	 * @return �ҵ����û�������Ҳ�������NULL
	 */
	Cust findUserByName(String name);
	/**
	 * ��ӿͻ�
	 * @param cust
	 */

	void addCust(Cust cust);
	/**
	 * ��ȡ�����û���Ϣ��ɵļ���
	 * @return ��װ�������û���Ϣ�ļ��ϣ����û�пͻ�������null
	 */
	List<Cust> getAllCust();
	/**
	 * ����id���ҿͻ�
	 * @param id = �ͻ�id
	 * @return �ͻ�bean
	 */
	Cust findUserById(String id);
	/**
	 * �޸Ŀͻ���Ϣ
	 * @param cust ������Ϣbean
	 */
	void updateCust(Cust cust);
	/**
	 * ͨ��idɾ���ͻ���Ϣ
	 * @param id
	 */
	void delCustByID(String id);
	/**
	 * ͨ���ͻ�idʹ���¼�����ɾ��
	 * @param id
	 * @throws SQLException 
	 */
	void delCustByIDWithTrans(Connection conn,String id) throws SQLException;
	/**
	 * �����û���/�Ա�/�ͻ����Ͳ��ҿͻ�
	 * @param cust ����bean
	 * @return ���ط��������Ŀͻ�bean
	 */
	List<Cust> findCustByCond(Cust cust);
	/**
	 * ��ѯ���ݿ���һ���ж�������¼
	 * @return
	 */
	int getCountRow();
	/**
	 * ��ѯָ��¼���������¼
	 * @param from ��������¼��ȡ������
	 * @param count 
	 * @param cust 
	 * @return
	 */

	List<Cust> getCustByPage(int from, int count, Cust cust);
	/**
	 * �������������
	 * @param from
	 * @param count
	 * @param cust
	 * @return
	 */
	int getSelcetCountRow(int from, int count, Cust cust);
	
	
}
