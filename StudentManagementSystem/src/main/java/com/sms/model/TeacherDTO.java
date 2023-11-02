package com.sms.model;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.sms.entity.Student_ent;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TeacherDTO {

	@NotNull
	private int t_id;

	@NotNull
	@Size(min = 2, max = 35, message = "your name should be minmum 2 or maximum 35 characters...")
	private String name;

	@NotNull
	@Size(min = 10, max = 100, message = "your adderess should be minmum 10 or maximum 100 characters...")
	private String adderess;

	@NotNull
	private String phone;

	private boolean status = Boolean.TRUE;

	List<Student_ent> students;

}
