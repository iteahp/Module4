package codegym.controller;

import codegym.model.ClassRoom;
import codegym.model.Student;
import codegym.service.IClassZoomService;
import codegym.service.IStudentService;
import codegym.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;

@Controller
public class StudentController {
    @Autowired
    IStudentService studentService;

    @Autowired
    IClassZoomService classZoomService;

    @GetMapping("/students")
    public ModelAndView showAll() {
        ModelAndView modelAndView = new ModelAndView("show");
        modelAndView.addObject("students", studentService.findAll());
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreate() {
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("student", new Student());
        modelAndView.addObject("classZooms", classZoomService.findAll());
        return modelAndView;
    }

    @PostMapping("/create")
    public String create(@ModelAttribute(value = "student") Student student, @RequestParam long idClassZoom, @RequestParam MultipartFile upImg) {
        ClassRoom classRoom = new ClassRoom();
        classRoom.setId(idClassZoom);
        student.setClassRoom(classRoom);

        String nameFile = upImg.getOriginalFilename();
        try {
            FileCopyUtils.copy(upImg.getBytes(), new File("/Users/johntoan98gmail.com/Desktop/Module3/Demo_Spring_Repository/src/main/webapp/WEB-INF/img/" + nameFile));
            student.setImg("/img/" + nameFile);
            studentService.save(student);

        } catch (IOException e) {
            student.setImg("/img/abc.jpeg");
            studentService.save(student);
            e.printStackTrace();
        }
        return "redirect:/students";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam long id) {
        if (studentService.findById(id).getImg()!=null){
            File file = new File("C:\\Users\\MSI\\Desktop\\Module4\\Demo_Repository_JPA\\src\\main\\webapp\\WEB-INF\\" +studentService.findById(id).getImg());
            file.delete();
        }
        studentService.delete(id);
        return "redirect:/students";
    }

    @GetMapping("/edit")
    public ModelAndView showEdit(@RequestParam long id) {
        ModelAndView modelAndView = new ModelAndView("/edit");
        modelAndView.addObject("student", studentService.findById(id));
        modelAndView.addObject("classZooms", classZoomService.findAll());
        return modelAndView;
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute(value = "student") Student student, MultipartFile upImg, @RequestParam long idClassZoom) {
        ClassRoom classRoom = new ClassRoom();
        classRoom.setId(idClassZoom);
        student.setClassRoom(classRoom);
        if (upImg.getSize() != 0) {
            String imgFile = upImg.getOriginalFilename();
            try {
                FileCopyUtils.copy(upImg.getBytes(), new File("C:\\Users\\MSI\\Desktop\\Module4\\Demo_Repository_JPA\\src\\main\\webapp\\WEB-INF\\img/" + imgFile));
                if (student.getImg()!=null){
                    File file = new File("C:\\Users\\MSI\\Desktop\\Module4\\Demo_Repository_JPA\\src\\main\\webapp\\WEB-INF\\" + student.getImg());
                    file.delete();
                }
                student.setImg("/img/"+imgFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        studentService.save(student);
        return "redirect:/students";
    }
}

