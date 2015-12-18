package com.bakigoal.web.controller;

import com.bakigoal.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BookController {

	@Autowired
	private BookService bookService;

	@RequestMapping(value = "/books", method = RequestMethod.GET)
	public String books(ModelMap model) {

		model.addAttribute("books", bookService.getAllBooks());
		return "books";

	}

	@RequestMapping(value = "/createBook", method = RequestMethod.GET)
	public String  createRandomBook(ModelMap model) {

		bookService.createRandomBook();
		return "redirect:books";

	}

}