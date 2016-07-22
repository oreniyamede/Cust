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
		request.setCharacterEncoding("utf-8");  //解决POST请求乱码
		response.setContentType("text/html;charset=utf-8"); //解决响应乱码
		CustService service = BasicFactory.getFactory().getInstance(CustService.class);
		
		
		try {
			//1.获取查询条件封装到bean中
			Cust cust = new Cust();
			BeanUtils.populate(cust, request.getParameterMap());
			//2.调用Service中条件查询客户的方法，查出符合条件的客户
			HttpSession session = request.getSession();
			if(cust.getName()!=null || cust.getType()!=null || cust.getGender()!=null){ //防止下次请求时拿了个空参数覆盖了之前的cust
				session.setAttribute("cust", cust);
			}
			//1.获取当前要显示的页和每页记录数
			int thispage = Integer.parseInt(request.getParameter("thispage"));
			int rowperpage = 10;  //每页记录数
			//2.调用Service中分页查询客户的方法查找客户信息
			cust = (Cust) session.getAttribute("cust");
			Page page = service.pageCust(thispage,rowperpage,cust);
			//3.存入request域中，带到pageList.jsp页面中进行显示
			request.setAttribute("page", page);//相当于EL表达式的　${requestScope.page}
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
