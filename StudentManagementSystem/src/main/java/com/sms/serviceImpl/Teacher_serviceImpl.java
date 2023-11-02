package com.sms.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sms.entity.Student_ent;
import com.sms.entity.Teacher_ent;
import com.sms.exception.ResourceNotFoundException;
import com.sms.model.TeacherDTO;
import com.sms.repository.Student_repo;
import com.sms.repository.Teacher_repo;
import com.sms.service.Teacher_service;
import com.sms.utility.Converter;

@Service
public class Teacher_serviceImpl implements Teacher_service {

	@Autowired
	private Teacher_repo teacher_repo;

	@Autowired
	private Student_repo stdRepo;

	@Autowired
	private Converter converter;

	@Override
	public TeacherDTO registerTeacher(Teacher_ent teacher_ent) {
		return converter.convertToTeacherDTO(teacher_repo.save(teacher_ent));
	}

	@Override
	public String assignStudentToTeacher(int t_id, int s_id) {

		Student_ent stdEnts = stdRepo.findById(s_id)
				.orElseThrow(() -> new ResourceNotFoundException("Student ", " s_id ", s_id));

		Teacher_ent teachEnts = teacher_repo.findById(t_id)
				.orElseThrow(() -> new ResourceNotFoundException("Student ", " t_id ", t_id));

		List<Student_ent> students = new ArrayList<>();
		students.add(stdEnts);

		teachEnts.setStudents(students);
		stdEnts.setTeacher(teachEnts);

		teacher_repo.save(teachEnts);

		return "Student id:- " + s_id + " assign to a teacher id:- " + t_id + " !!!! successfully.....";
	}

	@Override
	public List<TeacherDTO> getallteachers() {
		List<Teacher_ent> teachEnt = teacher_repo.findAll();
		List<TeacherDTO> teachList = new ArrayList<>();

		for (Teacher_ent teacher_ent : teachEnt) {
			teachList.add(converter.convertToTeacherDTO(teacher_ent));
		}

		return teachList;
	}

	@Override
	public TeacherDTO getbyidteacher(int id) {
		Teacher_ent teachEnt = teacher_repo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Teacher ", " not found with id:- ", id));
		return converter.convertToTeacherDTO(teachEnt);
	}

	@Override
	public String deletebyid(int id) {
		teacher_repo.deleteById(id);
		return "delete successfully teacher id:- " + id;
	}

	@Override
	public TeacherDTO updatebyid(int id, Teacher_ent teacher_ent) {
		Teacher_ent teachEnt = teacher_repo.findById(id).get();
		teachEnt.setName(teacher_ent.getName());
		teachEnt.setAdderess(teacher_ent.getAdderess());
		teachEnt.setPhone(teacher_ent.getPhone());

		return converter.convertToTeacherDTO(teacher_repo.save(teachEnt));
	}
}
