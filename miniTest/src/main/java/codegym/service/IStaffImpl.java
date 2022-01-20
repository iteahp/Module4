package codegym.service;

import codegym.model.Staff;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IStaffImpl {
    List<Staff> findAll();
     Page<Staff> findAll(Pageable pageable);
        void save(Staff staff);
        void delete(long id);
        Staff findById(long id);
    List<Staff> findAllByNameContains(String nameFind);
}
