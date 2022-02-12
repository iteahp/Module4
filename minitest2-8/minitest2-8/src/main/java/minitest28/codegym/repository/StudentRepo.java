package minitest28.codegym.repository;

import minitest28.codegym.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface StudentRepo extends PagingAndSortingRepository<Student,Long>{
    Page<Student> findAllByNameContaining(Pageable pageable,String nameFind);
}
