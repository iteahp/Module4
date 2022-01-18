package codegym.service;

import codegym.model.Branch;
import codegym.repository.BranchRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BranchService implements  IBranchImpl{
    @Autowired
    BranchRepo branchRepo;
    @Override
    public List<Branch> findALl() {
        return (List<Branch>) branchRepo.findAll();
    }
}
