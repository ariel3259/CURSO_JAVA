package com.bootcamp.Templates.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootcamp.Templates.Repository.RegisterRepository;
import com.bootcamp.Templates.Repository.StudentsRepository;
import com.bootcamp.Templates.Repository.SubjectsRepository;
import com.bootcamp.Templates.Model.Register;
import com.bootcamp.Templates.Model.Students;
import com.bootcamp.Templates.Model.Subjects;

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
	
	public boolean save(int codeSubject, int studentDni) {
		if(!studentRepository.existsByDni(studentDni) || !subjectRepository.existsByCode(codeSubject)) return false;
		Students student = studentRepository.findByDni(studentDni);
		Subjects subject = subjectRepository.findByCode(codeSubject);
		if(registerRepository.existsByStudent(student) && registerRepository.existsBySubject(subject)) return false;
		Register register = new Register(subject, student);
		registerRepository.save(register);
		return true;
	}
	
	public boolean delete(int id) {
		if(!registerRepository.existsById(id)) return false;
		registerRepository.deleteById(id);
		return true;
	}
}
