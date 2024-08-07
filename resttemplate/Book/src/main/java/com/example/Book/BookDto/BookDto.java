package com.example.Book.BookDto;

import jakarta.persistence.Entity;

import jakarta.persistence.Id;

@Entity
public class BookDto {
    
	@Id
    private int bookid;
	
    private String bookName;
	
	
    private String bookAuthor;
	
	
	public int getBookid() {
		return bookid;
	}

	public void setBookid(int bookid) {
		this.bookid = bookid;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	

	public String getBookAuthor() {
		return bookAuthor;
	}

	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}

	
}
