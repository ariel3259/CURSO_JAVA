package com.bootcamp.Templates.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootcamp.Templates.Model.Students;
import com.bootcamp.Templates.Repository.StudentsRepository;

@Service
public class StudentsService {
	
	@Autowired
	private StudentsRepository studentsRepository;
	
	public List<Students> GetAllSudents(){
		return (List<Students>) studentsRepository.findAll();
	}
	
	public boolean saveStudents(Students student) {
		if(studentsRepository.existsByPhone(student.getPhone()) || studentsRepository.existsByDni(student.getDni())) return false;
		studentsRepository.save(student);
		return true;
	}
	
	public boolean updateStudent(Students student) {
		if(!studentsRepository.existsById(student.getId())) return false;
		studentsRepository.save(student);
		return true;
	}
	
	public boolean deleteStudent(int id){
		if(!studentsRepository.existsById(id)) return false;
		studentsRepository.deleteById(id);
		return true;
	}
	
	public Students getOne(int id) {
		return studentsRepository.findById(id).get();
	}
}
