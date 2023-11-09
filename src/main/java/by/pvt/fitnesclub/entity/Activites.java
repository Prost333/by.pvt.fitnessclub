package by.pvt.fitnesclub.entity;

import lombok.*;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import jakarta.persistence.*;

import java.util.List;
@Data
@EqualsAndHashCode
@ToString
@Getter
@Setter
@AllArgsConstructor
@Entity
@NoArgsConstructor
@Table(schema = "fitness", name = "activites")
@org.hibernate.annotations.Cache( usage = CacheConcurrencyStrategy.READ_WRITE, region = "activites")
public class Activites {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private  Long id;
    @Column(name="name")
    private String name;
    @Column(name="cost")
    private  Long cost;
//    @OneToMany
//    @JoinColumn(name= "activ_id")
//    @ToString.Exclude
//    @EqualsAndHashCode.Exclude
//    private List<Office> office;

}
