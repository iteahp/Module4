package codegym.controllers;

import codegym.model.Branch;
import codegym.model.Staff;
import codegym.service.BranchService;
import codegym.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.naming.Binding;
import javax.validation.Valid;

@Controller
public class StaffController {
    @Autowired
    StaffService staffService;
    @Autowired
    BranchService branchService;

    @GetMapping("/staffs")
    public ModelAndView showStaff(@RequestParam(defaultValue = "0")int page){
        ModelAndView modelAndView = new ModelAndView("/show");
        modelAndView.addObject("staffs",staffService.findAll(PageRequest.of(page,1)));
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
    public ModelAndView create(@Valid @ModelAttribute Staff staff , BindingResult bindingResult){
        ModelAndView modelAndView  = new ModelAndView("/show");
        if (bindingResult.hasErrors()){
            return new ModelAndView("/create").addObject("branch",branchService.findALl());
        }
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
    @GetMapping("/findByName")
    public ModelAndView showListByName(@RequestParam String nameFind){
        ModelAndView modelAndView = new ModelAndView("/show");
        modelAndView.addObject("staffs",staffService.findAllByNameContains(nameFind));
        return  modelAndView;
    }

}
