package codegym.service;

import codegym.model.Staff;

import java.util.List;

public interface IStaffImpl {
     List<Staff> findAll();
        void save(Staff staff);
        void delete(long id);
        Staff findById(long id);
        List<Staff> sortByAge();
}
