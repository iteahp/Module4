package codegym.repository;

import codegym.model.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface StaffRepo extends PagingAndSortingRepository<Staff,Long> {
    public List<Staff> findAllByNameContains(String nameFind);
    @Query(value = "select s from Staff s")
    public  List<Staff> findAllList();

}
