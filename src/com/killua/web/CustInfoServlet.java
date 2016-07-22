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
		//1.获取要查询的客户id
		String id = request.getParameter("id");
		//2.调用Service中根据id查找客户的方法
		Cust cust = service.findCustById(id);
		if(cust ==null ){
			throw new RuntimeException("找不到客户！");
		}
		//3.将查找的客户信息存入request域中，请求转发到updateCust.jsp页面展示
		request.setAttribute("cust", cust);
		request.setAttribute("thispage", request.getParameter("thispage"));
		request.getRequestDispatcher("/updateCust.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);

	}

}
