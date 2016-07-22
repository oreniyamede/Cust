package com.killua.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.killua.factory.BasicFactory;
import com.killua.service.CustService;

public class DelCustServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CustService service = BasicFactory.getFactory().getInstance(CustService.class);
		//1,��ȡҪɾ���Ŀͻ�id
		String id = request.getParameter("id");
		//2������service�и���idɾ���ͻ��ķ���
		service.delCustById(id);
		//3.����ת�����ͻ��б���
		request.getRequestDispatcher("/servlet/PageCustServlet").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);

	}

}
