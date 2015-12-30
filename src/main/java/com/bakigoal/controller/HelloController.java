package com.bakigoal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
public class HelloController {

  @RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
  public String printWelcome(ModelMap model) {

    model.addAttribute("message", "Spring 4 MVC Hello World");
    model.addAttribute("name", "Bakigoal");
    model.addAttribute("title", "Title from HelloController");
    return "hello";

  }

  @RequestMapping(value = {"/endSession"}, method = RequestMethod.GET)
  public String printWelcome(HttpSession session) {
    session.invalidate();
    return "redirect:/home";
  }

}