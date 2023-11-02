package com.bookManageSystem.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bookManageSystem.dtomodel.Book_dto;
import com.bookManageSystem.entity.Book_entity;
import com.bookManageSystem.exception.ResourceNotFoundException;
import com.bookManageSystem.repository.Book_repository;
import com.bookManageSystem.service.Book_service;
import com.bookManageSystem.utility.Converter;

@Service
public class Book_serviceImpl implements Book_service {

	@Autowired
	private Book_repository bookRepo;

	@Autowired
	private Converter converter;

	@Override
	public Book_dto createBook(Book_entity book_entity) {
		Book_entity booEntity1 = bookRepo.save(book_entity);
		return converter.convertToDTO(booEntity1);
	}

	@Override
	public List<Book_dto> getAllBook() {
		List<Book_entity> bookEntity2 = bookRepo.findAll();
		List<Book_dto> dtoList = new ArrayList<>();

		for (Book_entity bookEntity3 : bookEntity2) {
			dtoList.add(converter.convertToDTO(bookEntity3));
		}
		return dtoList;
	}

	@Override
	public Book_dto getBookById(int id) {
		Book_entity bookEntity4 = bookRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("book ", " id:- ", id));
		return converter.convertToDTO(bookEntity4);
	}

	@Override
	public String deletebyid(int id) {
		bookRepo.deleteById(id);
		return "deleted successfully id no.:- " + id;
	}

	@Override
	public Book_dto updatebyid(int id, Book_entity book_entity) {

		Book_entity bookEntity5 = bookRepo.findById(id).get();
		bookEntity5.setB_name(book_entity.getB_name());
		bookEntity5.setB_price(book_entity.getB_price());
		bookEntity5.setB_quntity(book_entity.getB_quntity());
		bookEntity5.setB_published_date(book_entity.getB_published_date());

		Book_entity bookEntUpdate = bookRepo.save(bookEntity5);

		return converter.convertToDTO(bookEntUpdate);
	}

//	-----------------------------------------------------------------------------------------------------------------------

//	@Override
//	public Book_entity createBook(Book_entity book_entity) {
//		return bookRepo.save(book_entity);
//	}
//
//	@Override
//	public List<Book_entity> getAllBook() {
//		return bookRepo.findAll();
//	}
//
//	@Override
//	public Book_entity getBookById(int id) {
//		Book_entity bookEnt = bookRepo.findById(id).get();
//		return bookEnt;
//	}
//
//	@Override
//	public String deletebyid(int id) {
//		bookRepo.deleteById(id);
//		return "deleted successfully id no.:- " + id;
//	}
//
//	@Override
//	public Book_entity updatebyid(int id, Book_entity book_entity) {
//
//		Book_entity bookEnt2 = bookRepo.findById(id).get();
//		bookEnt2.setB_name(book_entity.getB_name());
//		bookEnt2.setB_author(book_entity.getB_author());
//		bookEnt2.setB_price(book_entity.getB_price());
//		bookEnt2.setB_published_date(book_entity.getB_published_date());
//
//		Book_entity bookEnt3 = bookRepo.save(bookEnt2);
//
//		return bookEnt3;
//	}

}
