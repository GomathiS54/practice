package com.example.Book.BookCon;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.Book.BookDto.BookDto;
import com.example.Book.BookService.BookService;


@RestController
@RequestMapping("api/book")
public class BookCon {
	
	
	@Autowired
	private BookService Service;
	
	
	@Autowired
	private RestTemplate restTemplate;
	
	
	   @PostMapping("save")
       public String createBook(@RequestBody BookDto book) {
        
        BookDto savedBook = Service.saveBook(book);
        
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<BookDto> requestEntity = new HttpEntity<>(savedBook, headers);

        ResponseEntity<String> responseEntity = restTemplate.exchange(
            "http://127.0.0.1:8080/successed", HttpMethod.POST, requestEntity, String.class);

        return responseEntity.getBody();
    }
	
	   @GetMapping("getall")
	    public String getBybookid(@RequestParam int id) {
	        BookDto fetchBook = Service.getBybookId(id);
	        HttpHeaders headers = new HttpHeaders();
	        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	        HttpEntity<BookDto> entity = new HttpEntity<>(fetchBook, headers);

	        return restTemplate.exchange(
	            "http://127.0.0.1:8080/successed/get?id=" + id,HttpMethod.GET, entity, String.class).getBody();
	    }
	   
	   @PostMapping("get")
	    public String createBookid(@RequestBody BookDto book) {
	        BookDto savedBook = Service.saveBook(book);
	       
	        HttpHeaders headers = new HttpHeaders();
	        headers.setContentType(MediaType.APPLICATION_JSON);
	 
	        HttpEntity<BookDto> requestEntity = new HttpEntity<>(savedBook, headers);
	 
	        ResponseEntity<String> responseEntity = restTemplate.exchange(
	            "http://localhost:8080/successed/get?id=" + savedBook.getBookid(),
	            HttpMethod.GET, requestEntity, String.class);
	 
	        return responseEntity.getBody();
	}

	  
	

}
