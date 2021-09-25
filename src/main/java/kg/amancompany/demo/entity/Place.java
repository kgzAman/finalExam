package kg.amancompany.demo.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;


@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "places")
public class Place extends BaseEntity {

    @Column(name = "name_of_place")
    private String nameOfPlace;

    @Column(name = "description_of_place")
    private String description;

    @Column(name = "comments")
    @OneToMany
    private List<Comment> comment;

    @Column(name = "counter")
    private Double counter;
}
