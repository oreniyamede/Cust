package com.killua.service;

import java.util.List;

import com.killua.domain.Cust;
import com.killua.domain.Page;

public interface CustService {
	/**
	 * ��ӿͻ�
	 * @param cust
	 */
	void addCust(Cust cust);
	/**
	 * ��ѯ�ͻ�������Ϣ
	 * @return
	 */
	List<Cust> getAllCust();
	/**
	 * ����id���ҿͻ���Ϣ
	 * @param id �ͻ�id
	 * @return ���ҵ��Ŀͻ���Ϣ��if cannot found return null
	 */
	Cust findCustById(String id);
	/**
	 * �޸Ŀͻ���Ϣ�ķ���
	 * @param cust ��װ�����¿ͻ���Ϣ��bean
	 */
	void updateCust(Cust cust);
	/**
	 * ͨ��idɾ���ͻ�
	 * @param id
	 */
	void delCustById(String id);
	/**
	 * ����ɾ���ͻ�	���л�����������
	 * @param ids ����Ҫɾ����id��ɵ�����
	 */
	void batchDel(String[] ids);
	/**
	 * ����������ѯ�ͻ���Ϣ
	 * @param cust ��װ�˲�ѯ������bean�����п������û���/�Ա�/�ͻ�����
	 * @return ���������Ŀͻ�
	 */
	List<Cust> findCustByCond(Cust cust);
	/**
	 * ��ҳ��ѯ�ͻ��ķ���
	 * @param thispage ��ǰҳ��
	 * @param rowperpage ÿҳ��¼��
	 * @param cust ����javabean����sql�ж����
	 * @return ��ǰҳ��������Ϣ
	 */
	Page pageCust(int thispage, int rowperpage, Cust cust);

}
