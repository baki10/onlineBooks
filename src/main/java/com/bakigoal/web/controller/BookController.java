package com.bakigoal.web.controller;

import com.bakigoal.dao.entity.Book;
import com.bakigoal.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

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
  public String createRandomBook(ModelMap model) {

    bookService.createRandomBook();
    return "redirect:books";

  }

  /**
   * Handle request to download a PDF document
   */
  @RequestMapping(value = "/downloadPDF", method = RequestMethod.GET)
  public ModelAndView downloadExcel() {
    // create some sample data
    List<Book> listBooks = bookService.getAllBooks();

    // return a view which will be resolved by an excel view resolver
    return new ModelAndView("pdfView", "listBooks", listBooks);
  }

}