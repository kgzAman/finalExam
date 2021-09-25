package kg.amancompany.demo.entity;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "comments")
public class Comment extends BaseEntity {

    @Column(name = "context")
    private String context;

    @Column(name = "created_date")
    private LocalDate createdDate;

    @OneToOne
    private User user;
}
