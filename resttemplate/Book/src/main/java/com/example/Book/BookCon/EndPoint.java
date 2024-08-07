package com.example.Book.BookCon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Book.BookDto.BookDto;
import com.example.Book.BookService.BookService;

@RestController
@RequestMapping("successed")
public class EndPoint{
	
	
	@Autowired
	private BookService Service;
	
	    @PostMapping
	    public ResponseEntity<String> createBook(@RequestBody BookDto book) {
	        BookDto savedBook = Service.saveBook(book);
	        return ResponseEntity.ok("Book created successfully with ID: " + savedBook.getBookid());
	    }

	    @GetMapping("/get")
	    public ResponseEntity<Object> getBook(@RequestParam int id) {
	        BookDto fetchBook = Service.getBybookId(id);
	        if (fetchBook != null) {
	            return ResponseEntity.ok("Book created successfully : " + fetchBook);
	        } else {
	            return ResponseEntity.status(404).body("Book not found with ID: " + id);
	        }
	    }
	

}
