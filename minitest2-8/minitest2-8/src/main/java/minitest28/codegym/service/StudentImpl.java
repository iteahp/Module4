package minitest28.codegym.service;

import minitest28.codegym.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface StudentImpl {
    Page<Student> findAll(Pageable pageable);

    Student save(Student student);

    void deleteById(long id);

    Student findById(long id);
    Page<Student> findAllByNameContaining(Pageable pageable,String nameFind);
}
