package com.bakigoal.controller;

import com.bakigoal.model.User;
import com.bakigoal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class UserController {
  @Autowired
  UserService userService;

  @RequestMapping(value = "/newUser", method = RequestMethod.GET)
  public String newRegistration(ModelMap model) {
    User user = new User();
    model.addAttribute("user", user);
    return "newUser";
  }

  /*
   * This method will be called on form submission, handling POST request It
   * also validates the user input
   */
  @RequestMapping(value = "/newUser", method = RequestMethod.POST)
  public String saveRegistration(@Valid User user,
                                 BindingResult result, ModelMap model) {

    if (result.hasErrors()) {
      return "newUser";
    }
    userService.save(user);

    model.addAttribute("title", "User " + user.getUsername() + " has been registered successfully");
    return "redirect:/home";
  }

}