package org.han.mp3player;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.jni.File;

/**
 * Servlet implementation class ListController
 */
@WebServlet("*.han")
//�� ��θ� Ÿ�� ���´�
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Map<String, String> map;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontController() {
        super();
        map = new HashMap<>();
        map.put("/list.han","/WEB-INF/list.jsp");
        map.put("/listen.han","/WEB-INF/listen.jsp");
        map.put("/playFile.han","/WEB-INF/listen.jsp");
        //���� ��ο� ��°�θ� map���� �Է�
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		String path = req.getServletPath();
		//���� ��� ����
		System.out.println("path = " + path);
		
		if(path.equals("/playFile.han")){
			System.out.println("playFile�� ����");
			String filePath = req.getParameter("filePath");
			if(filePath == null){
				filePath = "c:\\zzz\\mp3\\";
			}
			res.setContentType("audio.mpeg");
			
			String fileName = req.getParameter("file");
			
			FileInputStream fin = new FileInputStream(filePath + fileName);
			System.out.println("������ϰ�� : " + filePath + fileName);
			ServletOutputStream fos = res.getOutputStream();
			
			byte[] buffer = new byte[1024*8];
			while(true){
				int count = fin.read(buffer);
				if(count == -1){
					break;
				}
				fos.write(buffer,0,count);
			}
			fin.close();
		}
		
		String nextPage = map.get(path);
		//��°�� ����
		
		if(nextPage.equals("/WEB-INF/list.jsp")){
			
			String filePath = req.getParameter("filePath");
			if(filePath == null){
				filePath = "c:\\zzz\\mp3";
			}
			File file = new File(filePath);
			
			String[] mp3List = file.list();
			req.setAttribute("mp3List", mp3List);
		}
		//mp3����Ʈ �������� ��� ���ϸ���Ʈ�� ������ ������ �߰�
		
		RequestDispatcher dispatcher = req.getRequestDispatcher(nextPage);
		//RequestDispatcher�� �̵���θ� ����
		System.out.println("���������� : " + nextPage);
		dispatcher.forward(req, res);
		//forward�� ���� �̵���η� �̵�
	}
}