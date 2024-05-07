package net.javaguides.sms.RestController;



        import net.javaguides.sms.entity.Teacher;
        import net.javaguides.sms.service.TeacherService;
        import org.springframework.http.HttpStatus;
        import org.springframework.http.ResponseEntity;
        import org.springframework.stereotype.Controller;
        import org.springframework.web.bind.annotation.*;

        import java.util.List;

@Controller
@RequestMapping("/api/teachers")
public class TeacherRestController {

    private final TeacherService teacherService;

    public TeacherRestController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping
    public ResponseEntity<List<Teacher>> listTeachers() {
        List<Teacher> teachers = teacherService.getAllTeacher();
        return ResponseEntity.ok(teachers);
    }

    @PostMapping
    public ResponseEntity<Teacher> saveTeacher(@RequestBody Teacher teacher) {
        Teacher savedTeacher = teacherService.saveTeacher(teacher);
        return new ResponseEntity<>(savedTeacher, HttpStatus.CREATED);
    }

    @GetMapping("/edit/{id}")
    public ResponseEntity<Teacher> editTeacherForm(@PathVariable Long id) {
        Teacher teacher = teacherService.getTeacherById(id);
        if (teacher == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(teacher);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Teacher> updateTeacher(@PathVariable Long id, @RequestBody Teacher teacher) {
        Teacher existingTeacher = teacherService.getTeacherById(id);
        if (existingTeacher == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        existingTeacher.setFirstName(teacher.getFirstName());
        existingTeacher.setLastName(teacher.getLastName());
        existingTeacher.setEmail(teacher.getEmail());
        Teacher updatedTeacher = teacherService.updateTeacher(existingTeacher);
        return ResponseEntity.ok(updatedTeacher);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTeacher(@PathVariable Long id) {
        try {
            teacherService.deleteTeacherById(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}

