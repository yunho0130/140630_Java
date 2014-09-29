package org.professor.web;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.han.web.Executor;
import org.han.web.MyRequest;

/**
 * Servlet implementation class FrontServlet
 */
@WebServlet("*.bit")
public class FrontServletByProfessor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontServletByProfessor() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("Front Servlet...service");
		
		System.out.println(request.getServletPath());
		
		String controllerName = request.getServletPath();
		controllerName = 
				controllerName.substring(0, controllerName.lastIndexOf("."));
		
		System.out.println(controllerName);
		
		String className = "web2.MemberController";
		
		try {
			Executor executor = (Executor)Class.forName(className).newInstance();
			
			executor.execute(new MyRequest(request), response);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}












