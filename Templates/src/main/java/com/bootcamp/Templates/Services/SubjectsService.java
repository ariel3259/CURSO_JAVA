package com.bootcamp.Templates.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bootcamp.Templates.Model.Subjects;
import com.bootcamp.Templates.Repository.RegisterRepository;
import com.bootcamp.Templates.Repository.SubjectsRepository;

@Service
public class SubjectsService {
	
	@Autowired
	private SubjectsRepository subjectsRepository;
	
	@Autowired
	private RegisterRepository registerRepository;
	
	public List<Subjects> getAllSubjects(){
		return subjectsRepository.findAll();
	}

	public Page<Subjects> getAllSubjects(int numPage, int pageSize){
		Pageable pageable = PageRequest.of(numPage - 1, pageSize);
		return subjectsRepository.findAll(pageable);
	}
	
	public Page<Subjects> getByName(int pageNum, int pageSize, String name){
		Pageable pageable = PageRequest.of(pageNum - 1, pageSize);
		return subjectsRepository.findByName(name, pageable);
	}
	
	public Subjects getOne(int id) {
		return subjectsRepository.findById(id).get();
	}
	
	public boolean saveSubject(Subjects subject) {
		if(subjectsRepository.existsByCode(subject.getCode())) return false;
		subject.setState(true);
		subjectsRepository.save(subject);
		return true;
	}
	
	public boolean editSubject(Subjects subject) {
		if(!subjectsRepository.existsById(subject.getId())) return false;
		subject.setState(true);
		subjectsRepository.save(subject);
		return true;
	}
	
	@Transactional
	public boolean deleteSubject(int id) {
		if(!subjectsRepository.existsById(id)) return false;
		Subjects subjectToDelete = subjectsRepository.findById(id).get();
		if(registerRepository.existsBySubject(subjectToDelete)) registerRepository.deleteBySubjectId(id);
		subjectsRepository.deleteById(id);
		return true;
	}
}
