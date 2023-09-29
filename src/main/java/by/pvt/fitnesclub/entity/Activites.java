package by.pvt.fitnesclub.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@EqualsAndHashCode
@ToString
@Getter
@Setter
@AllArgsConstructor
@Entity
@NoArgsConstructor
@Table(schema = "fitness", name = "activites")
public class Activites {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private  Long id;
    @Column(name="name")
    private String name;
    @Column(name="cost")
    private  Double cost;
    @OneToMany
    @JoinColumn(name= "activ_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Office> office;

}
