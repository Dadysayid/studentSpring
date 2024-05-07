package net.javaguides.sms.service;

import java.util.List;

import net.javaguides.sms.entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface StudentService {
	List<Student> getAllStudents();
	Page<Student> getAllStudent(Pageable pageable);
	
	Student saveStudent(Student student);
	
	Student getStudentById(Long id);
	
	Student updateStudent(Student student);

	void deleteStudentById(Long id);
}
