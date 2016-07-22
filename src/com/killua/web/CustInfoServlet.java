package com.killua.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.killua.domain.Cust;
import com.killua.factory.BasicFactory;
import com.killua.service.CustService;

public class CustInfoServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CustService service = BasicFactory.getFactory().getInstance(CustService.class);
		//1.��ȡҪ��ѯ�Ŀͻ�id
		String id = request.getParameter("id");
		//2.����Service�и���id���ҿͻ��ķ���
		Cust cust = service.findCustById(id);
		if(cust ==null ){
			throw new RuntimeException("�Ҳ����ͻ���");
		}
		//3.�����ҵĿͻ���Ϣ����request���У�����ת����updateCust.jspҳ��չʾ
		request.setAttribute("cust", cust);
		request.setAttribute("thispage", request.getParameter("thispage"));
		request.getRequestDispatcher("/updateCust.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);

	}

}
