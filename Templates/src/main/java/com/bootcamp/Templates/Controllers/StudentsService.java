package com.bootcamp.Templates.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bootcamp.Templates.Model.RegisterRepository;
import com.bootcamp.Templates.Model.Students;
import com.bootcamp.Templates.Model.StudentsRepository;

@Service
public class StudentsService {
	
	@Autowired
	private StudentsRepository studentsRepository;
	
	@Autowired
	private RegisterRepository registerRepository;
	
	public List<Students> GetAllSudents(){
		return studentsRepository.findAll();
	}
	
	public boolean saveStudents(Students student) {
		if(studentsRepository.existsByPhone(student.getPhone()) || studentsRepository.existsByDni(student.getDni())) return false;
		student.setState(true);
		studentsRepository.save(student);
		return true;
	}
	
	public boolean updateStudent(Students student) {
		if(!studentsRepository.existsById(student.getId())) return false;
		student.setState(true);
		studentsRepository.save(student);
		return true;
	}
	
	@Transactional
	public boolean deleteStudent(int id){
		if(!studentsRepository.existsById(id)) return false;
		Students studentToDelete = studentsRepository.findById(id).get();
		if(registerRepository.existsByStudent(studentToDelete)) registerRepository.deleteByStudentId(id);
		studentsRepository.deleteById(id);	
		return true;
	}
	
	public Students getOne(int id) {
		return studentsRepository.findById(id).get();
	}
}
