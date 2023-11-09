package backend.controller;

import backend.models.Student;
import backend.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService ss;

    @GetMapping("/getAll")
    public String getAll() {
        return "Hola Mundo!";
    }

    /*
    @GetMapping("/getAll")
    public List<Student> getAll() {
        return ss.getAll();
    }

    @PostMapping("")
    public ResponseEntity addStudent(@RequestBody final Student s) {
        return ss.addStudent(s);
    }

    @PostMapping("/{id}/update")
    public ResponseEntity updateStudent(@PathVariable final Integer id, @RequestBody final Student s) {
        return ss.updateStudent(id, s);
    }

    @PostMapping("/{id}/delete")
    public ResponseEntity deleteStudent(@PathVariable final Integer id) {
        return ss.deleteStudent(id);
    }
    */
}