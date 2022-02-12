package minitest28.codegym.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long id;
    private String name;
    private String dateBirth;
    private String address;
    private String phoneNumber;
    private String email;
    @ManyToOne
    private ClassRoom classRoom;
}
