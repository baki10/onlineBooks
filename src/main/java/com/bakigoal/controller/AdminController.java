package com.bakigoal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by ilmir on 29.12.15.
 */
@Controller
@RequestMapping(value = "/admin")
public class AdminController {

  @RequestMapping
  public ModelAndView adminPage() {

    ModelAndView model = new ModelAndView();
    model.addObject("title", "Spring Security Hello World");
    model.addObject("message", "This is protected page - Admin Page!");
    model.setViewName("admin");

    return model;

  }
}
