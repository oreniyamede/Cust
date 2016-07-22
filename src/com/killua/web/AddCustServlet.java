package com.killua.web;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.killua.domain.Cust;
import com.killua.factory.BasicFactory;
import com.killua.service.CustService;

public class AddCustServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");  //���POST��������
		response.setContentType("text/html;charset=utf-8"); //�����Ӧ����
		CustService service = BasicFactory.getFactory().getInstance(CustService.class);

		try {
			//1.��װ����У������
			Cust cust = new Cust();
			BeanUtils.populate(cust, request.getParameterMap());//����map���Ե�cust����
			
			//��������preference��ֻ�ܱ���һ��������
			String[] prefs = request.getParameterValues("preference");
			StringBuffer buffer = new StringBuffer();
			for(String pref : prefs){
				buffer.append(pref+",");
			}
			String pref = buffer.substring(0,buffer.length()-1);
			cust.setPreference(pref);
			
			
			//2.����Service�еķ�����ӿͻ�
			service.addCust(cust);
			//3.�ض���ص���ҳ
			response.sendRedirect(request.getContextPath()+"/index.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);

	}

}
