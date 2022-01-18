package codegym.controllers;

import codegym.model.Branch;
import codegym.model.Staff;
import codegym.service.BranchService;
import codegym.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StaffController {
    @Autowired
    StaffService staffService;
    @Autowired
    BranchService branchService;

    @GetMapping("/staffs")
    public ModelAndView showStaff(){
        ModelAndView modelAndView = new ModelAndView("/show");
        modelAndView.addObject("staffs",staffService.findAll());

        return modelAndView;

    }
    @GetMapping("/create")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("staff",new Staff());
        modelAndView.addObject("branch",branchService.findALl());
        return modelAndView;
    }
    @PostMapping("/create")
    public ModelAndView create(@ModelAttribute Staff staff ,@RequestParam long idBranch){
        ModelAndView modelAndView  = new ModelAndView("/show");
        Branch branch = new Branch();
        branch.setId(idBranch);
        staff.setBranch(branch);
        staffService.save(staff);
        modelAndView.addObject("message","Create Success");
        modelAndView.addObject("staffs",staffService.findAll());
        return modelAndView;
    }
    @GetMapping("/delete")
    public ModelAndView delete(@RequestParam long id){
        ModelAndView modelAndView = new ModelAndView("/show");
        staffService.delete(id);
        modelAndView.addObject("message","Delete Success");
        modelAndView.addObject("staffs",staffService.findAll());
        return modelAndView;
    }
    @GetMapping("/edit")
    public ModelAndView showEditForm(@RequestParam long id){
        ModelAndView modelAndView = new ModelAndView("/edit");
        modelAndView.addObject("staff",staffService.findById(id));
        modelAndView.addObject("branch",branchService.findALl());
        return modelAndView;
    }
    @PostMapping("/edit")
    public ModelAndView edit(@ModelAttribute(value = "staff") Staff staff ,@RequestParam long idBranch){
        ModelAndView modelAndView  = new ModelAndView("/show");
        Branch branch = new Branch();
        branch.setId(idBranch);
        staff.setBranch(branch);
        staffService.save(staff);
        modelAndView.addObject("message","Edit Success");
        modelAndView.addObject("staffs",staffService.findAll());
        return modelAndView;
    }
    @GetMapping("/detail")
    public ModelAndView showStaffDetail(@RequestParam long id){
        ModelAndView modelAndView = new ModelAndView("/detail");
        modelAndView.addObject("staff",staffService.findById(id));

        return modelAndView;

    }
    @GetMapping("/sort")
    public ModelAndView sortByAge(){
        ModelAndView modelAndView = new ModelAndView("/show");
        modelAndView.addObject("staffs",staffService.sortByAge());
        return modelAndView;
    }
}
