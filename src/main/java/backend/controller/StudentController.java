package backend.controller;

import backend.models.Student;
import backend.services.StudentService;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
@CrossOrigin(origins = "*")
public class StudentController {

    @Autowired
    private StudentService ss;

    @GetMapping("/helloWorld")
    public String helloWorld() {
        return "Hello World!";
    }

    @GetMapping("/getAll")
    public List<Student> getAll() {
        return ss.getAll();
    }

    @PostMapping("")
    public ResponseEntity addStudent(@RequestBody final @NotNull Student s) {
        return ss.addStudent(s);
    }

    @PostMapping("/{id}/update")
    public ResponseEntity updateStudent(@PathVariable final @NotNull Integer id, @RequestBody final @NotNull Student s) {
        return ss.updateStudent(id, s);
    }

    @PostMapping("/{id}/delete")
    public ResponseEntity deleteStudent(@PathVariable final @NotNull Integer id) {
        return ss.deleteStudent(id);
    }
}