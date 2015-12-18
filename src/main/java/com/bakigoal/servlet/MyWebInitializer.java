package com.bakigoal.servlet;

import com.bakigoal.config.HibernateConfig;
import com.bakigoal.config.SpringAppConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MyWebInitializer extends
    AbstractAnnotationConfigDispatcherServletInitializer {

  @Override
  protected Class<?>[] getServletConfigClasses() {
    return new Class[]{SpringAppConfig.class, HibernateConfig.class};
  }

  @Override
  protected String[] getServletMappings() {
    return new String[]{"/"};
  }

  @Override
  protected Class<?>[] getRootConfigClasses() {
    return null;
  }

}