package com.bookManageSystem.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookManageSystem.dtomodel.Author_dto;
import com.bookManageSystem.entity.Author_entity;
import com.bookManageSystem.entity.Book_entity;
import com.bookManageSystem.exception.ResourceNotFoundException;
import com.bookManageSystem.repository.Author_repository;
import com.bookManageSystem.repository.Book_repository;
import com.bookManageSystem.service.Author_service;
import com.bookManageSystem.utility.Converter;

@Service
public class Author_serviceImpl implements Author_service {

	@Autowired
	Author_repository autRepository;

	@Autowired
	Book_repository book_repository;

	@Autowired
	Converter converter;

	@Override
	public Author_dto createAuthor(Author_entity author_entity) {
		final Author_entity authEntity = autRepository.save(author_entity);
		return converter.convertToAuthorDTO(authEntity);
	}

	@Override
	public String assignBookToauthor(int b_id, int a_id) {

		Author_entity authorEnts = autRepository.findById(a_id)
				.orElseThrow(() -> new ResourceNotFoundException("Author ", " a_id ", a_id));

		Book_entity bookEnts = book_repository.findById(b_id)
				.orElseThrow(() -> new ResourceNotFoundException("Book ", " b_id ", b_id));

		List<Book_entity> books = new ArrayList<>();
		books.add(bookEnts);

		authorEnts.setBooks(books);
		bookEnts.setAuthor_entity(authorEnts);

		autRepository.save(authorEnts);

		return "Book id:- " + b_id + " assign to a Author id:- " + a_id + " !!!! successfully.....";
	}

	@Override
	public List<Author_dto> getallauthor() {
		List<Author_entity> authEntity = autRepository.findAll();
		List<Author_dto> authList = new ArrayList<>();

		for (Author_entity author_entity : authEntity) {
			authList.add(converter.convertToAuthorDTO(author_entity));
		}
		return authList;
	}

	@Override
	public Author_dto getbyidauthor(int id) {
		Author_entity authEntity = autRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Author  ", " not found with id:- ", id));
		return converter.convertToAuthorDTO(authEntity);
	}

	@Override
	public String deletebyid(int id) {
		autRepository.deleteById(id);
		return "delete successfully Author id:- " + id;
	}

	@Override
	public Author_dto updatebyid(int id, Author_entity author_entity) {
		Author_entity authEntity = autRepository.findById(id).get();
		authEntity.setA_name(author_entity.getA_name());
		authEntity.setA_email(author_entity.getA_email());
		authEntity.setA_phone(author_entity.getA_phone());

		return converter.convertToAuthorDTO(autRepository.save(authEntity));
	}

}
