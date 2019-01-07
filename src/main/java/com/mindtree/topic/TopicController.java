package com.mindtree.topic;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController {

	@Autowired
	private BookService bookService;
	
	@RequestMapping("/display")
	public List<Book> getAllTopics() {
		return bookService.getAllBooks();
	}
	
	@RequestMapping("display/{id}")
	public Optional<Book> getTopic(@PathVariable String id) {
		return bookService.getBook(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/add")
	public void addTopic(@RequestBody Book book) {
		bookService.addTopic(book);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/update/{id}")
	public void updateTopic(@RequestBody Book book, @PathVariable String id) {
		bookService.updateBook(book,id);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/delete/{id}")
	public void deleteTopic(@RequestBody Book book, @PathVariable String id) {
		bookService.deleteBook(book,id);
	}
	
}
