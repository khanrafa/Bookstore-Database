package ca.sheridancollege.khanrafa.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ca.sheridancollege.khanrafa.bean.Book;
import ca.sheridancollege.khanrafa.dao.BookDatabaseAccess;


@Controller
public class BookController {
	
	ArrayList<Book> books = new ArrayList<>();

	@GetMapping("/index")
	public String index() {
		return "index";
	}

	@GetMapping("/userInput")
	public String userInputForm(Model model) {
		model.addAttribute("book", new Book());
		return "userInput";
	}

	@Autowired
	private BookDatabaseAccess da;

	@PostMapping("/userInput")
	  public String addBook(Model model, @ModelAttribute
			  Book book) {
	     long numberOfRows = da.addBook(book);
	    return "index";
	  }


	@GetMapping ("/bookList")
	public String viewBookList(Model model) {
		List<Book> bookList = da.selectBooks();
        model.addAttribute("books", bookList);
	return "bookList";
	}
	
	@GetMapping("/bookSearch")
	public String bookSearch(Model model) {
		model.addAttribute("book", new Book());
		return "bookSearch";
	}



	@PostMapping("/bookSearch")
	  public String bookSearch(Model model, @ModelAttribute
			  Book book) {
	     long numberOfRows = da.addBook(book);
	    return "index";
	  }
	
	@GetMapping ("/searchResult")
	public String searchResult(Model model) {
		List<Book> bookList = da.selectBooks();
        model.addAttribute("books", bookList);
	return "searchResult";
	}
//	@GetMapping ("/bookSearch")
//		public String bookSearch() {
//			return "bookSearch";
//	}
//	
//	@GetMapping ("/bookResult")
//		public String viewSearchResult (Model model) {
//		List<Book> bookSearch = da.selectBooks();
//		return "bookSearch";
//	}


	
}


