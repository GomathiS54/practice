package com.example.Book.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Book.BookDto.BookDto;
import com.example.Book.Bookrepo.BookRepo;

@Service
public class BookService {

	    @Autowired
	   BookRepo repo;
	    
	    public BookDto saveBook(BookDto book) {
	    	return repo.save(book);
	    }
	    
	    
	    public BookDto getBybookId(int id) {
	    	 
	    	java.util.Optional<BookDto> optional= repo.findById(id);
	    	if(optional.isPresent()) {
	    		return optional.get();
	    	}
	    	
	    	return null;
	    }
	    
	
	
}
