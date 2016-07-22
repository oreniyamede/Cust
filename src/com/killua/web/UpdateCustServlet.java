package com.killua.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.killua.domain.Cust;
import com.killua.factory.BasicFactory;
import com.killua.service.CustService;

public class UpdateCustServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");  //解决POST请求乱码
		response.setContentType("text/html;charset=utf-8"); //解决响应乱码
		CustService service = BasicFactory.getFactory().getInstance(CustService.class);

		try {
			//1.封装数据校验数据
			Cust cust = new Cust();
			BeanUtils.populate(cust, request.getParameterMap());//复制map属性到cust对象
			
			//单独处理preference里只能保存一个的问题
			String[] prefs = request.getParameterValues("preference");
			StringBuffer buffer = new StringBuffer();
			for(String pref : prefs){
				buffer.append(pref+",");
			}
				String pref = buffer.substring(0,buffer.length()-1);
				cust.setPreference(pref);
			//2.调用Service中修改客户信息的方法
				service.updateCust(cust);
			//3.重定向到到向到客户列表页面
				String i = request.getParameter("thispage");
				response.sendRedirect(request.getContextPath()+"/servlet/PageCustServlet?thispage="+i+"");
				
			}catch(Exception e){
				e.printStackTrace();
			}
		

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);

	}

}
