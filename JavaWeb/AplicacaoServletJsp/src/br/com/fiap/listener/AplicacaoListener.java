package br.com.fiap.listener;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class AplicacaoListener
 *
 */
@WebListener
public class AplicacaoListener implements ServletContextListener, HttpSessionListener, HttpSessionAttributeListener, ServletRequestListener {

    /**
     * Default constructor. 
     */
    public AplicacaoListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent arg0)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletRequestListener#requestDestroyed(ServletRequestEvent)
     */
    public void requestDestroyed(ServletRequestEvent arg0)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletRequestListener#requestInitialized(ServletRequestEvent)
     */
    public void requestInitialized(ServletRequestEvent arg0)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent arg0)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent event)  { 
    	gerarLog("Context finalizado: " + event.getServletContext().getContextPath() + " - " +
    			event.getServletContext().getServerInfo() + " - " + 
    			event.getServletContext().getVirtualServerName());
    }

	/**
     * @see HttpSessionAttributeListener#attributeAdded(HttpSessionBindingEvent)
     */
    public void attributeAdded(HttpSessionBindingEvent arg0)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see HttpSessionAttributeListener#attributeRemoved(HttpSessionBindingEvent)
     */
    public void attributeRemoved(HttpSessionBindingEvent arg0)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see HttpSessionAttributeListener#attributeReplaced(HttpSessionBindingEvent)
     */
    public void attributeReplaced(HttpSessionBindingEvent arg0)  { 
         // TODO Auto-generated method stub
    }

    public void contextInitialized(ServletContextEvent arg0)  { 
    	gerarLog("Context inicializado: " + arg0.getServletContext().getContextPath() + " - " +
    				arg0.getServletContext().getServerInfo() + " - " + 
    				arg0.getServletContext().getVirtualServerName());
    }
    
    private void gerarLog(final String log) {
    	try {
    		FileWriter fw = new FileWriter("D:\\rm48236\\log.txt", true);
			fw.write("\n" + new Date().toString() + " - " + log);
			fw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
	
}
