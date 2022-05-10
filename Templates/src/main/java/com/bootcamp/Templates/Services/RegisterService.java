package com.bootcamp.Templates.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.bootcamp.Templates.Model.Register;
import com.bootcamp.Templates.Model.Students;
import com.bootcamp.Templates.Model.Subjects;
import com.bootcamp.Templates.Repository.RegisterRepository;
import com.bootcamp.Templates.Repository.StudentsRepository;
import com.bootcamp.Templates.Repository.SubjectsRepository;

@Service
public class RegisterService {

	@Autowired
	private RegisterRepository registerRepository;
	
	@Autowired 
	private StudentsRepository studentRepository;
	
	@Autowired
	private SubjectsRepository subjectRepository;
	
	public List<Register> getAll(){
		return registerRepository.findAll();
	}
	
	public Page<Register> getAll(int pagNum, int pagSize){
		Pageable page = PageRequest.of(pagNum - 1 , pagSize);
		return registerRepository.findAll(page);
	}
	
	public Page<Register> getBySubjectPage(int pagNum, int pagSize, String subjectName){
		Pageable page = PageRequest.of(pagNum - 1, pagSize);
		return registerRepository.findBySubjectName(subjectName, page);
	}
	
	public Page<Register> getByStudentPage(int pagNum, int pagSize, String studentName){
		Pageable page = PageRequest.of(pagNum - 1, pagSize);
		return registerRepository.findByStudentName(studentName, page);
	}
	
	public boolean save(int codeSubject, int studentDni) {
		if(!studentRepository.existsByDni(studentDni) || !subjectRepository.existsByCode(codeSubject)) return false;
		Students student = studentRepository.findByDni(studentDni);
		Subjects subject = subjectRepository.findByCode(codeSubject);
		if(registerRepository.existsByStudent(student) && registerRepository.existsBySubject(subject)) return false;
		Register register = new Register(subject, student);
		register.setState(true);
		registerRepository.save(register);
		return true;
	}
	
	
	public boolean delete(int id) {
		if(!registerRepository.existsById(id)) return false;
		registerRepository.deleteById(id);
		return true;
	}
}
