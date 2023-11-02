package com.bookManageSystem.service;

import java.util.List;

import com.bookManageSystem.dtomodel.Author_dto;
import com.bookManageSystem.entity.Author_entity;

public interface Author_service {

//	create new author
	Author_dto createAuthor(Author_entity author_entity);

// assign books to author
	String assignBookToauthor(int b_id, int a_id);

//	get all teachers
	List<Author_dto> getallauthor();

//	get teacher by id
	Author_dto getbyidauthor(int id);

//	delete by id 
	String deletebyid(int id);

//	update by id
	Author_dto updatebyid(int id, Author_entity author_entity);
}
