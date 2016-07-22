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
		//1,获取要删除的客户id
		String id = request.getParameter("id");
		//2，调用service中根据id删除客户的方法
		service.delCustById(id);
		//3.请求转发到客户列表面
		request.getRequestDispatcher("/servlet/PageCustServlet").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);

	}

}
