package com.encore.spring.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.encore.spring.domain.Book;
import com.encore.spring.domain.User;
import com.encore.spring.model.BookService;
import com.encore.spring.model.UserService;

@Controller
public class BookController {
	
//	@Autowired
//	private UserService userService;
//	
//	@Autowired
//	private BookService bookService;
	
	@Resource
	private UserService userService;
	
	@Resource
	private BookService bookService;
	
	
	@RequestMapping("login.do")
	public ModelAndView login(HttpSession session, String id, String password) throws Exception{
		
		//System.out.println("login.do");
		
		String path = "error";
		
		User rvo = userService.getUser(id, password);
		if(rvo!=null) {
			session.setAttribute("vo", rvo);
			path = "user_result";
		}
		//System.out.println(new ModelAndView(path));
		return new ModelAndView(path);
	}
	
	@RequestMapping("bookRegister.do")
	public ModelAndView bookRegister(HttpServletRequest request, Book book) throws Exception{
		String[] isbnArr= request.getParameterValues("isbn");
		String isbn = "";
		for(String i : isbnArr) {
			if(i.equals(isbnArr[isbnArr.length-1])) isbn += i;
			else isbn += i + "-";
		}
		
		book.setIsbn(isbn);
		
		bookService.addBook(book);
		
		//System.out.println(book.getIsbn());
		
		return new ModelAndView("book_result","bvo",book);
	}
	
	@RequestMapping("bookList.do")
	public ModelAndView bookList() throws Exception{
		List<Book> list = bookService.getBookList();
		
		return new ModelAndView("bookList","list",list);
	}
	
	@RequestMapping("search.do")
	public ModelAndView search(String searchCategory, String search) throws Exception{
		String viewName = "";
		List<Book> list = null;
		
		if(searchCategory.equals("isbn")) {
			Book book = bookService.getBook(search);
			return new ModelAndView("bookList", "book", book);
		} else if(searchCategory.equals("all")) {
			list = bookService.getBookList();
		} else if(searchCategory.equals("title")) {
			list = bookService.getBooksByTitle(search);
		} else if(searchCategory.equals("author")) {
			list = bookService.getBooksByAuthor(search);
		} else if(searchCategory.equals("catalogue")) {
			list = bookService.getBooksByCatalogue(search);
		}
		
		return new ModelAndView("bookList", "list", list);
	}
	
	
}
