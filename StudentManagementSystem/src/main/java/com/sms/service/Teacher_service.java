package com.sms.service;

import java.util.List;

import com.sms.entity.Teacher_ent;
import com.sms.model.TeacherDTO;

public interface Teacher_service {

//	create new teacher
	TeacherDTO registerTeacher(Teacher_ent teacher_ent);

//	assign student to teacher
	String assignStudentToTeacher(int t_id, int s_id);

//	get all teachers
	List<TeacherDTO> getallteachers();

//	get teacher by id
	TeacherDTO getbyidteacher(int id);

//	delete by id 
	String deletebyid(int id);

//	update by id
	TeacherDTO updatebyid(int id, Teacher_ent teacher_ent);
}
