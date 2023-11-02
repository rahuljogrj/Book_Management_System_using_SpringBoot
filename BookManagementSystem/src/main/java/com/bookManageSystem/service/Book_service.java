package com.bookManageSystem.service;

import java.util.List;

import com.bookManageSystem.dtomodel.Book_dto;
import com.bookManageSystem.entity.Book_entity;

public interface Book_service {

//	create new book
//	Book_entity createBook(Book_entity book_entity);
	Book_dto createBook(Book_entity book_entity);

//	fetch all books from table
//	List<Book_entity> getAllBook();
	List<Book_dto> getAllBook();

//	find by id from book table
//	Book_entity getBookById(int id);
	Book_dto getBookById(int id);

//	delete by id from book table
//	String deletebyid(int id);
	String deletebyid(int id);

// update by id from book table
//	Book_entity updatebyid(int id, Book_entity book_entity);FS
	Book_dto updatebyid(int id, Book_entity book_entity);

}
