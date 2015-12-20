package com.bakigoal.servlet.config;

import com.bakigoal.util.FilesUtil;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * @author ilmir
 */
@WebListener
public class SessionListener implements HttpSessionListener {

  private static final String FILES_DIR = "src/main/webapp/WEB-INF/resources/files/";

  @Override
  public void sessionCreated(HttpSessionEvent se) {
    System.out.println("----------------------------------session start --------------------------------");
  }

  @Override
  public void sessionDestroyed(HttpSessionEvent se) {
    System.out.println("----------------------------------session finish--------------------------------");
//        Object obj = se.getSession().getAttribute("items");

//        ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(se.getSession().getServletContext());
//        ItemService itemService = (ItemService) ctx.getBean("itemService");
    FilesUtil.deleteAllFilesInDirectory(FILES_DIR);

  }

}
