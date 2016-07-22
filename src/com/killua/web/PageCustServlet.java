package com.killua.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import com.killua.domain.Cust;
import com.killua.domain.Page;
import com.killua.factory.BasicFactory;
import com.killua.service.CustService;

public class PageCustServlet extends HttpServlet {

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
			HttpSession session = request.getSession();
			if(cust.getName()!=null || cust.getType()!=null || cust.getGender()!=null){ //��ֹ�´�����ʱ���˸��ղ���������֮ǰ��cust
				session.setAttribute("cust", cust);
			}
			//1.��ȡ��ǰҪ��ʾ��ҳ��ÿҳ��¼��
			int thispage = Integer.parseInt(request.getParameter("thispage"));
			int rowperpage = 10;  //ÿҳ��¼��
			//2.����Service�з�ҳ��ѯ�ͻ��ķ������ҿͻ���Ϣ
			cust = (Cust) session.getAttribute("cust");
			Page page = service.pageCust(thispage,rowperpage,cust);
			//3.����request���У�����pageList.jspҳ���н�����ʾ
			request.setAttribute("page", page);//�൱��EL���ʽ�ġ�${requestScope.page}
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
