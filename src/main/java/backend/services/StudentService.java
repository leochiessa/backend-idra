package backend.services;

import backend.models.Student;
import backend.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@Service
public class StudentService {

    private final StudentRepository sr;

    @Autowired
    public StudentService(StudentRepository sr) {
        this.sr = sr;
    }

    public List<Student> getAll() {
        return sr.findAll();
    }

    public ResponseEntity addStudent(Student s) {
        try {
            sr.save(s);
            return ResponseEntity.status(CREATED).build();
        } catch (Exception e) {
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).build();
        }
    }

    public ResponseEntity updateStudent(Integer id, Student s) {
        try {
            Student st = sr.findById(id).orElseThrow(() -> new HttpClientErrorException(HttpStatus.BAD_REQUEST, "estudiante no encontrado"));
            st.setDni(s.getDni());
            st.setLastName(s.getLastName());
            st.setFirstName(s.getFirstName());
            st.setEmail(s.getEmail());
            st.setCohort(s.getCohort());
            st.setStatus(s.getStatus());
            st.setGender(s.getGender());
            st.setAddress(s.getAddress());
            st.setPhone(s.getPhone());
            sr.save(st);
            return ResponseEntity.status(OK).build();
        } catch (Exception e) {
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).build();
        }
    }

    public ResponseEntity deleteStudent(Integer id) {
        try {
            sr.deleteById(id);
            return ResponseEntity.status(OK).build();
        } catch (Exception e) {
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).build();
        }
    }
}