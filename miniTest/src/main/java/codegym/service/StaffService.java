package codegym.service;

import codegym.model.Staff;
import codegym.repository.StaffRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
@Service
public class StaffService implements IStaffImpl{
    @Autowired
    StaffRepo staffRepo;
    public List<Staff>  findAll(){
        return (List<Staff>) staffRepo.findAll();
    }

    @Override
    public void save(Staff staff) {
        staffRepo.save(staff);
    }

    @Override
    public void delete(long id) {
        staffRepo.deleteById(id);
    }

    @Override
    public Staff findById(long id) {
        return staffRepo.findById(id).get();
    }
    public List<Staff> sortByAge(){
        List<Staff> list = findAll();
        list.sort(Comparator.comparing(Staff::getAge));
        return list;
    }
}
