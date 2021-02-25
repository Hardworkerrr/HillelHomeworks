import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.persistence.*;


@Entity
@Table(name = "students")
@Setter
@Getter
@ToString
@Accessors(chain = true)
public class Student {
    @Id
    @GeneratedValue
    @Column(name = "student_id")
    private Long id;

    @Column(name = "fullname")
    private String fullname;

    @Column(name = "group_name")
    private String group;

    @Column(name = "admission_year")
    private Integer admission_year;

}
