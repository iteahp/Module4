package minitest28.codegym.controller;

import minitest28.codegym.model.Student;
import minitest28.codegym.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/students")
public class StudentController {
    @Autowired
    StudentService studentService;
    @GetMapping
    public ResponseEntity<Page<Student>> showListStudent(@RequestParam(defaultValue = "0") int page){
        return new ResponseEntity<>(studentService.findAll(PageRequest.of(page,4)), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Student> saveStudent(@RequestBody Student student){
        return new ResponseEntity<>(studentService.save(student),HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable long id){
        studentService.deleteById(id);
    }
    @PutMapping
    public Student editStudent(@RequestBody Student student){
       return studentService.save(student);
    }
    @GetMapping("/{id}")
    public Student findStudentById(@PathVariable long id){
        return studentService.findById(id);
    }
    @GetMapping("/find")
   public Page<Student> findAllByNameContaining(@RequestParam(defaultValue = "0") int page,@RequestParam String nameFind){
        return studentService.findAllByNameContaining(PageRequest.of(page,2),nameFind);
    }
}
