/**
 * ������ ����. ��� ����. 
 * ��2 ���. ����ڰ� ���� ġ�� ���� �� ������ ����. 
 * ���� ��޺ζ�� ������ ��. RequestDispatcher 
 */

package org.han.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServlet
 */
@WebServlet("/hello/result")
public class ResultHelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
	
    public ResultHelloServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
		System.out.println("destroy........");
	}

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		System.out.println("init.........");
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		System.out.println("init config.....");

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doGet.........");
		System.out.println("Result Hello Servlet " + this + " : " + Thread.currentThread().getName());
		
		// ��2 ���. ����ڰ� ���� ġ�� ���� �� ������ ����. 
		String page = "/WEB-INF/jsp/inputResult.jsp";
		// ���� ��޺ζ�� ������ ��. 
		RequestDispatcher dispatcher = request.getRequestDispatcher(page);
		dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		String page = "/WEB-INF/jsp/inputAction.jsp";
//		RequestDispatcher dispatcher = request.getRequestDispatcher(page);
//		dispatcher.forward(request, response);
		System.out.println("input Result doPost");

	}

}