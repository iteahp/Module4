package minitest28.codegym.service;

import minitest28.codegym.model.Student;
import minitest28.codegym.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class StudentService implements StudentImpl{
    @Autowired
    StudentRepo studentRepo;

    @Override
    public Page<Student> findAll(Pageable pageable) {
        return studentRepo.findAll(pageable);
    }

    @Override
    public Student save(Student student) {
        return studentRepo.save(student);
    }

    @Override
    public void deleteById(long id) {
        studentRepo.deleteById(id);
    }

    @Override
    public Student findById(long id) {
        return studentRepo.findById(id).get();
    }

    @Override
    public Page<Student> findAllByNameContaining(Pageable pageable, String nameFind) {
        return studentRepo.findAllByNameContaining(pageable,nameFind);
    }
}
