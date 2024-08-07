package com.example.Book.Bookrepo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Book.BookDto.BookDto;

public interface BookRepo extends JpaRepository<BookDto, Integer>{

}
