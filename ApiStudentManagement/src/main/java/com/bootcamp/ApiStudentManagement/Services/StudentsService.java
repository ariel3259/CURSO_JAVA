package com.bootcamp.ApiStudentManagement.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootcamp.ApiStudentManagement.Repository.StudentsRepository;
import com.bootcamp.ApiStudentManagement.Model.Students;

@Service	
public class StudentsService {
	
	@Autowired
	private StudentsRepository sr;
	
	public List<Students> getAllStudents(){
		return (List<Students>) sr.findAll();
	}
	
	public boolean saveStudent(Students student) {
		if(sr.existsByDni(student.getDni()) || sr.existsByPhone(student.getPhone())) return false;
		sr.save(student);
		return true;
	}
	
	public boolean modifyStudent(Students student) {
		if(!sr.existsById(student.getId())) return false;
		sr.save(student);
		return true;
	}
	
	public boolean modifyName(String name, int id) {
		if(!sr.existsById(id)) return false;
		sr.modifyName(name, id);
		return true;
	}
	
	public boolean modifyUsername(String username, int id) {
		if(!sr.existsById(id)) return false;
		sr.modifyUsername(username, id);
		return true;
	}
	
	public boolean deleteStudent(int id) {
		if(!sr.existsById(id)) return false;
		sr.deleteById(id);
		return true;
	}
	
	public Students getOneStudent(int id) {
		if(!sr.existsById(id)) return null;
		return sr.findById(id).get();
	}
	
	
}
