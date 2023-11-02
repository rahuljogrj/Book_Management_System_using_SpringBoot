//DTO:- Data transfer object

package com.bookManageSystem.dtomodel;

import javax.persistence.Column;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.bookManageSystem.entity.Author_entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name = "Book_management_system")
public class Book_dto {

	@NotNull
	@Column(name = "book_id")
	private int b_id;

	@NotNull
	@Size(min = 2, max = 35, message = "your name should be minmum 2 or maximum 35 characters...")
	@Column(name = "book_name")
	private String b_name;

	@NotNull
	@Column(name = "book_price")
	private int b_price;

	@NotNull
	@Column(name = "book_quntity", length = 5)
	private int b_quntity;

	@NotNull
	@Column(name = "book_published_date")
	private String b_published_date;

	private Author_entity author_entity;
}
