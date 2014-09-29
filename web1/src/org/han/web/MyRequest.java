/**
 * 문자열 -> double 형으로 변환
 */

package org.han.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class MyRequest extends HttpServletRequestWrapper {

	private final HttpServletRequest req;
	
	public MyRequest(HttpServletRequest request) {
		super(request);
		this.req = request;
		// TODO Auto-generated constructor stub
	}
	
	public double getDoubleParameter(String param){
		return Double.parseDouble(req.getParameter(param));
	}
	
	public int getIntParameter(String param){
		return Integer.parseInt(req.getParameter(param));
	}

	public String doubleToString(double var) {
		return "" + var + "";
	}
	
	

}
