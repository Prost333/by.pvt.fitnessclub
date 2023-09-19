package by.pvt.fitnesclub.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
@Table(schema = "fitness", name = "activites")
public class Activites {

    @Id
    @GeneratedValue
    @Column(name="id")
    private  Long id;
    @Column(name="name")
    private String name;
    @Column(name="cost")
    private  Double cost;

}
