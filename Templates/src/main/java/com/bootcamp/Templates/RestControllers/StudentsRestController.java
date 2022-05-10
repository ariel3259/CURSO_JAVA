package com.bootcamp.Templates.RestControllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.util.DocumentFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bootcamp.Templates.Model.Students;
import com.bootcamp.Templates.ReporsConfigure.Excel.ExportExcelStudents;
import com.bootcamp.Templates.Services.StudentsService;

@RestController
@RequestMapping("/api/students")
public class StudentsRestController {
	
	@Autowired
	private StudentsService studentService;
	
	@GetMapping
	public ResponseEntity<List<Students>> getAll(){
		return ResponseEntity.status(200).body(studentService.GetAllSudents());
	}
	
	@GetMapping("/getAll/{pagNum}/{pagSize}")
	public ResponseEntity<Page<Students>> getAll(@PathVariable("pagNum") int pagNum, @PathVariable("pagSize") int pagSize){
		return ResponseEntity.status(200).body(studentService.GetAllStudents(pagNum, pagSize));
	}
	
	@GetMapping("/getByName/{pagNum}/{pagSize}/{name}")
	public ResponseEntity<Page<Students>> getByName(@PathVariable("pagNum") int pagNum, @PathVariable("pagSize") int pagSize, @PathVariable("name") String name){
		return ResponseEntity.status(200).body(studentService.getByName(pagNum, pagSize, name));
	}
	
	@GetMapping("/getByLastName/{pagNum}/{pagSize}/{lastName}")
	public ResponseEntity<Page<Students>> getByLastName(@PathVariable("pagNum") int pagNum, @PathVariable("pagSize") int pagSize, @PathVariable("lastName") String lastNAME){
		return ResponseEntity.status(200).body(studentService.getByLastName(pagNum, pagSize, lastNAME));
	}
	
	@GetMapping("/excel")
	public void writeExcelFile(HttpServletResponse response) throws IOException {
		response.setContentType("application/octet-stream");
		response.setHeader("Content-Disposition", "attachment;filename=students.xlsx");
		List<Students> students = studentService.GetAllSudents();
		ExportExcelStudents excel = new ExportExcelStudents(students);
		excel.CreateXcelFile(response);
		
	}
	
	@GetMapping("/getOne/{id}")
	public ResponseEntity<Students> getById(@PathVariable("id") int id){
		return ResponseEntity.status(200).body(studentService.getOne(id));
	}
	
	@PostMapping
	public ResponseEntity<String> save(@Validated @RequestBody Students student){
		if(!studentService.saveStudents(student)) return ResponseEntity.status(400).body("Falied to save a student");
		return ResponseEntity.status(201).body("Saved student");
	}
	
	@PutMapping
	public ResponseEntity<String> update(@Validated @RequestBody Students student){
		if(!studentService.updateStudent(student)) return ResponseEntity.status(400).body("Failed to update a student");
		return ResponseEntity.status(200).body("Updated an student");
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") int id){
		if(!studentService.deleteStudent(id)) return ResponseEntity.status(400).body("Failed  to delete a student");
		return ResponseEntity.status(200).body("Deleted a student");
	}
}
