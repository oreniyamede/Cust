package com.killua.web;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.killua.domain.Cust;
import com.killua.factory.BasicFactory;
import com.killua.service.CustService;

public class FindCustByCondServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");  //���POST��������
		response.setContentType("text/html;charset=utf-8"); //�����Ӧ����
		CustService service = BasicFactory.getFactory().getInstance(CustService.class);
		
		try {
			//1.��ȡ��ѯ������װ��bean��
			Cust cust = new Cust();
			BeanUtils.populate(cust, request.getParameterMap());
		
			//2.����Service��������ѯ�ͻ��ķ�����������������Ŀͻ�
			List<Cust> list = service.findCustByCond(cust);
			//3.���鵽�Ŀͻ�����request��������ת����listCust.jspҳ�����չʾ
			request.setAttribute("list", list);
			request.getRequestDispatcher("/pageList.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

	
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);

	}

}
