package minitest28.codegym.controller;

import minitest28.codegym.model.ClassRoom;
import minitest28.codegym.service.ClassRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/classrooms")
public class ClassRoomController {
    @Autowired
    ClassRoomService classRoomService;
 @GetMapping
    public List<ClassRoom> showClassRoom(){
     return classRoomService.findAll();
 }
}
