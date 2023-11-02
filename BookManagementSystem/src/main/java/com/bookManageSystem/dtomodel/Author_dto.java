package com.bookManageSystem.dtomodel;

import java.util.List;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.bookManageSystem.entity.Book_entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Author_dto {

	@NotNull
	private int a_id;
	@NotNull
	@Size(min = 2, max = 35, message = "please enter name between 2 to 35 characters...")
	@Column(name = "author_name", length = 35)
	private String a_name;
	@NotNull
	@Size(min = 2, max = 35, message = "please enter valid email with @***.***")
	@Column(name = "author_email", length = 35)
	private String a_email;
	@NotNull
	@Size(min = 10, max = 12, message = "please check and enter correct phone number")
	@Column(name = "author_phone", length = 12)
	private String a_phone;

	private boolean status = Boolean.TRUE;

	List<Book_entity> books;

}
