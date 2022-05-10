package com.bootcamp.Templates.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bootcamp.Templates.Model.Students;
import com.bootcamp.Templates.Model.Users;
import com.bootcamp.Templates.Repository.RegisterRepository;
import com.bootcamp.Templates.Repository.StudentsRepository;

@Service
public class StudentsService {
	
	@Autowired
	private StudentsRepository studentsRepository;
	
	@Autowired
	private RegisterRepository registerRepository;
	
	public List<Students> GetAllSudents(){
		return studentsRepository.findAll();
	}
	
	public Page<Students> GetAllStudents(int pagNum, int pagSize){
		Pageable length = PageRequest.of(pagNum, pagSize);
		return studentsRepository.findAll(length);
	}
	
	public Page<Students> getByName(int pagNum, int pageSize, String name){
		Pageable length = PageRequest.of(pagNum - 1, pageSize);
		return studentsRepository.findByNameContaining(name, length);
	}
	
	public Page<Students> getByLastName(int pagNum, int pageSize, String lastName){
		Pageable length = PageRequest.of(pagNum - 1, pageSize);
		return studentsRepository.findByLastNameContaining(lastName, length);
	}
	
	public List<Students> getOrderByLastName(){
		return studentsRepository.findByOrderAsc();
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
