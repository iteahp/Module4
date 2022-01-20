package codegym.model;

import javax.persistence.*;
import javax.validation.constraints.*;



@Entity
public class Staff {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Pattern(regexp = "^[A-Za-z0-9 ]{5,10}$",message = " Code : 5-10 char a-z A-Z 0-9")
    private String code;
    @Pattern(regexp = "^[A-Za-z ]{5,10}$",message = " Name : 4-10 char a-z A-Z ")
    private String name;

    @Min(value = 18,message = " Age :min = 18")
    @Max(value = 60,message = "Age  : max = 60")
    private int age;
    private double salary;
    @ManyToOne
    @NotBlank(message = "not Blank")
    private Branch branch;
    public Staff() {
    }

    public Staff(String code, String name, int age, double salary, Branch branch) {
        this.code = code;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.branch = branch;
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
