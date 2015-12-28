package com.bakigoal.web;

import com.bakigoal.model.Author;
import com.bakigoal.model.Book;
import com.bakigoal.model.UploadFile;
import com.bakigoal.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Controller
public class BooksController {

  @Autowired
  private BookService bookService;

  @RequestMapping(value = "/books/all", method = RequestMethod.GET)
  public String books(ModelMap model) {

    model.addAttribute("books", bookService.getAllBooks());
    return "books";

  }

  @RequestMapping(value = "/books/createRandomBook", method = RequestMethod.GET)
  public String createRandomBook(ModelMap model) {

    bookService.createRandomBook();
    return "redirect:all";

  }

  @RequestMapping(value = "/books/new", method = RequestMethod.GET)
  public String initCreationForm(ModelMap model) {
    Book book = new Book();
    book.setAuthor(new Author());
    model.addAttribute("book", book);
    model.addAttribute("yearList", getYears());
    return "createOrUpdateBookForm";
  }

  @RequestMapping(value = "/books/new", method = RequestMethod.POST)
  public String processCreationForm(ModelMap model, @Valid Book book, BindingResult result,
                                    @RequestParam CommonsMultipartFile[] file) {
    if (result.hasErrors()) {
      model.put("book", book);
      return "createOrUpdateBookForm";
    }
    if (file!= null && file.length > 0) {
      for (CommonsMultipartFile aFile : file) {
        if (aFile.getOriginalFilename() == null || aFile.getBytes().length < 1) {
          continue;
        }

        UploadFile uploadFile = new UploadFile();
        uploadFile.setFileName(aFile.getOriginalFilename());
        uploadFile.setData(aFile.getBytes());
        book.setPhoto(uploadFile);
      }
    }

    bookService.createOrUpdateBook(book);

    return "redirect:all";
  }

  /**
   * Handle request to download a PDF document
   */
  @RequestMapping(value = "/books/downloadPDF", method = RequestMethod.GET)
  public ModelAndView downloadExcel() {
    // create some sample data
    List<Book> listBooks = bookService.getAllBooks();

    // return a view which will be resolved by an excel view resolver
    return new ModelAndView("pdfView", "listBooks", listBooks);
  }

  private List<String> getYears() {
    List<String> years = new ArrayList<>();
    int year = Calendar.getInstance().get(Calendar.YEAR);
    for (int i = year; i >= 1970; i--) {
      years.add(String.valueOf(i));
    }
    return years;
  }


}