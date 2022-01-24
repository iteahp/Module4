package demo.APIAJAX.demoAPIAJAX.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private double price;

    private String img;
    @ManyToOne
    private Category category;

}
