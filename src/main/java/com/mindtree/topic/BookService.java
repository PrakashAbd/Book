package com.mindtree.topic;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
	
	@Autowired
	private BookRepository bookRepository;
	
	public List<Book> getAllBooks(){
		List<Book> topics = new ArrayList<>();
		bookRepository
				.findAll()
				.forEach(topics::add);
		return topics;
	}
	
	public Optional<Book> getBook(String id) {
		return bookRepository.findById(id);
	}

	public void addTopic(Book topic) {
		bookRepository.save(topic);
	}
	
	public void updateBook(Book topic, String id) {
		bookRepository.save(topic);
	}
	public void deleteBook(Book topic, String id) {
		bookRepository.deleteById(id);
	}
}
