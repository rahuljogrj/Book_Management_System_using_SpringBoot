package com.bookManageSystem.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Author_entity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "author_id")
	private int a_id;
	@Column(name = "author_name", length = 35)
	private String a_name;
	@Column(name = "author_email", length = 35)
	private String a_email;
	@Column(name = "author_phone", length = 12)
	private String a_phone;

	private boolean status = Boolean.TRUE;

	@OneToMany(mappedBy = "author_entity", cascade = CascadeType.PERSIST)
	@JsonIgnoreProperties("author_entity")
	List<Book_entity> books;

}
