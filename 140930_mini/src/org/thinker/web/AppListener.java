package org.thinker.web;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.thinker.dao.TimeDAO;
import org.thinker.service.TimeService;

/**
 * Application Lifecycle Listener implementation class AppListener
 *
 */
@WebListener
public class AppListener implements ServletContextListener {
	private static Logger logger = LoggerFactory.getLogger("AppListener");

    /**
     * Default constructor. 
     */
    public AppListener() {
        // TODO Auto-generated constructor stub
    }
    
    // 웹 어플리케이션이 올라갈 때 자동으로 내려가는 부분 -> 이벤트라고 한다. 
	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    }
    
    // 웹 어플리케이션이 올라갈 때 자동으로 호출되는 부분 -> 이벤트라고 한다. 
	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent event)  { 
         // TODO Auto-generated method stub
    	// 웹 어플리케이션의 메모리영역/경계. 
    	ServletContext ctx = event.getServletContext();
    	for (int i = 0; i < 10; i++) {
			logger.info("............." + i);
		}
    	
    	// 이 객체는 시내버스 처럼, 웹 어플리케이션의 컨택스트, 즉, 메모리 영역안에서 서버가 죽을 때 까지 유지된다. 
    	// 또 하나의 Singleton Pattern (싱글턴 패턴), 싱글턴은 아니지만 싱글턴처럼 사용가능.
    	ctx.setAttribute("timeDAO", new TimeDAO());
    	
    	TimeService service = new TimeService();
    	service.setDao(new TimeDAO());
    	ctx.setAttribute("timeService", service);
//    	ctx.setAttribute("timeService", new TimeService());

    }
	
}
