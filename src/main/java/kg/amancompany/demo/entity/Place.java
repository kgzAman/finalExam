package kg.amancompany.demo.entity;

import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
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

    @Column(name = "main_photo_path")
    private String mainPhotoPath;

    @Column(name = "description_of_place")
    private String description;

    @Column(name = "comments")
    @OneToMany
    private List<Comment> comment;

    @Column(name = "counter")
    private Double counter;

    @Column(name = "photos")
    @OneToMany(cascade = CascadeType.PERSIST)
    private List<Photo> photos;

}
