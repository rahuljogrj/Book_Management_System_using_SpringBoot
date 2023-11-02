package com.bookManageSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookManageSystem.dtomodel.Author_dto;
import com.bookManageSystem.entity.Author_entity;
import com.bookManageSystem.service.Author_service;
import com.bookManageSystem.utility.Converter;

@RestController
@RequestMapping("/api")
public class Author_controller {

	@Autowired
	Author_service author_service;

	@Autowired
	Converter converter;

	@PostMapping("/createauthor")
	ResponseEntity<Author_dto> createAuthor(@RequestBody Author_dto author_dto) {
		final Author_entity autEntity = converter.convertToAuthorEntity(author_dto);
		return new ResponseEntity<Author_dto>(author_service.createAuthor(autEntity), HttpStatus.CREATED);
	}

	@PostMapping("/assignbooktoauthor/{b_id}/{a_id}")
	public String assingBookToAuthor(@PathVariable("b_id") int b_id, @PathVariable("a_id") int a_id) {
		return author_service.assignBookToauthor(b_id, a_id);

	}

	@GetMapping("/getallauthor")
	List<Author_dto> getallauthor() {
		return author_service.getallauthor();
	}

	@GetMapping("/getbyidauthor/{a_id}")
	Author_dto getbyidauthor(@PathVariable("a_id") int id) {
		return author_service.getbyidauthor(id);
	}

	@DeleteMapping("/deletebyidauthor/{a_id}")
	String deletebyid(@PathVariable("a_id") int id) {
		String deleteteacher = author_service.deletebyid(id);
		return deleteteacher;
	}

	@PutMapping("/updatebyidauthor/{a_id}")
	Author_dto updatebyid(@PathVariable("a_id") int id, @RequestBody Author_dto author_dto) {
		final Author_entity authorEnt = converter.convertToAuthorEntity(author_dto);
		return author_service.updatebyid(id, authorEnt);

	}

}
