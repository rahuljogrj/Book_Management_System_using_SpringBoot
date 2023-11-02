package com.bookManageSystem.utility;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.bookManageSystem.dtomodel.Author_dto;
import com.bookManageSystem.dtomodel.Book_dto;
import com.bookManageSystem.entity.Author_entity;
import com.bookManageSystem.entity.Book_entity;

@Component
public class Converter {

//	convert from DTO to Entity
	public Book_entity convertToEntity(Book_dto book_dto) {

		Book_entity bookEnt = new Book_entity();
		if (book_dto != null) {
			BeanUtils.copyProperties(book_dto, bookEnt);
		}
		return bookEnt;
	}

//	convert from DTO to Entity
	public Book_dto convertToDTO(Book_entity bookEnt) {

		Book_dto bookDto = new Book_dto();
		if (bookEnt != null) {
			BeanUtils.copyProperties(bookEnt, bookDto);
		}
		return bookDto;
	}

//	convert from DTO to Entity
	public Author_entity convertToAuthorEntity(Author_dto author_dto) {

		Author_entity authEntity = new Author_entity();
		if (author_dto != null) {
			BeanUtils.copyProperties(author_dto, authEntity);
		}
		return authEntity;
	}

//	convert from DTO to Entity
	public Author_dto convertToAuthorDTO(Author_entity Author_entity) {

		Author_dto authordto = new Author_dto();
		if (Author_entity != null) {
			BeanUtils.copyProperties(Author_entity, authordto);
		}
		return authordto;
	}

}
