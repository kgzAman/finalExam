package kg.amancompany.demo.entity;

import javax.persistence.Column;
import java.util.List;

public class Place extends BaseEntity {

    @Column(name = "name_of_place")
    private String nameOfPlace;

    @Column(name = "description_of_place")
    private String description;

    @Column(name = "comments")
    private List<String> comment;

    @Column(name = "counter")
    private Double counter;
}
