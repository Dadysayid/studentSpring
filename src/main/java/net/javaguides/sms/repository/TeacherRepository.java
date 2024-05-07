package net.javaguides.sms.repository;


import net.javaguides.sms.entity.Student;
import net.javaguides.sms.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {

}
