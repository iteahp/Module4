package minitest28.codegym.service;

import minitest28.codegym.model.ClassRoom;
import minitest28.codegym.repository.ClassRoomRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ClassRoomService implements ClassRoomImpl{
    @Autowired
    ClassRoomRepo classRoomRepo;
    @Override
    public List<ClassRoom> findAll() {
        return (List<ClassRoom>) classRoomRepo.findAll();
    }
}
