package com.bookManageSystem.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Book_management_system")
public class Book_entity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "book_id")
	private int b_id;
	@Column(name = "book_name", length = 35)
	private String b_name;
	@Column(name = "book_price", length = 5)
	private int b_price;
	@Column(name = "book_quntity", length = 5)
	private int b_quntity;
	@Column(name = "book_published_date", length = 15)
	private String b_published_date;

	private boolean status = Boolean.TRUE;

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "a_id")
	@JsonIgnoreProperties("books")
	private Author_entity author_entity;
}
