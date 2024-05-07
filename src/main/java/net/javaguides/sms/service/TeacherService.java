package net.javaguides.sms.service;

import net.javaguides.sms.entity.Student;
import net.javaguides.sms.entity.Teacher;

import java.util.List;

public interface TeacherService {
    List<Teacher> getAllTeacher();

    Teacher saveTeacher(Teacher teacher);

    Teacher getTeacherById(Long id);

    Teacher updateTeacher(Teacher teacher);

    void deleteTeacherById(Long id);
}
