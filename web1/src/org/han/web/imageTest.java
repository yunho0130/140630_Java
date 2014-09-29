/**
 * �����ð��� ȸ������ ���� ���� �ߴ� ��. 
 */

package org.han.web;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class imageTest
 */
@WebServlet("/image")
public class imageTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public imageTest() {
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
		System.out.println("init.........");

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doGet.........");
		System.out.println("Hello Servlet " + this + " : " + Thread.currentThread().getName());
//		response.setContentType("text/html");
//		OutputStream out = response.getOutputStream();
//		out.write("<H1>Hello World</H1>".getBytes());
//		out.flush();
		OutputStream out = response.getOutputStream();
		response.setContentType("image/jpeg");
		BufferedImage image = new BufferedImage(400, 400, BufferedImage.TYPE_INT_RGB);
		Graphics g = image.getGraphics(); //��
		g.setColor(Color.pink); // ��ĥ
		g.fillRect(0, 0, 400, 400); // �簢���� ä��鼭 �׸� �̹�����ü
		g.setColor(Color.black);
		g.setFont(new Font("Serif",Font.BOLD,40));
//		g.drawString("AAAA", 100, 100); // ó�� �ǽ� �ڵ� ���� 100 / ���� 100 ũ�� ������ AAAAAA��� ���ڿ��� �ִ� �ڵ�
		g.drawString("" + (int)(Math.random()*10000), 100, 100);
		ImageIO.write(image, "JPG", out);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}