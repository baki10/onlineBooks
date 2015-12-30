package com.bakigoal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

  @RequestMapping(value = "/login", method = RequestMethod.GET)
  public String loginPage(Model model){
    return "login";
  }

  @RequestMapping(value = "/error", method = RequestMethod.GET)
  public String errorPage(Model model){
    model.addAttribute("errorMessage", "Access denied!!!");
    return "hello";
  }

}