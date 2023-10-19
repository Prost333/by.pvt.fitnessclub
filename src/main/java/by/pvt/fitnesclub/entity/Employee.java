package by.pvt.fitnesclub.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import jakarta.persistence.*;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
@ToString
//@DiscriminatorValue(value = "EM")
@Table(schema = "fitness", name = "employee")
@PrimaryKeyJoinColumn(name= "em_id")
//select*from fitness.employee e join fitness.user u on e.em_id=u.id;
public class Employee extends User {
    private  String company;
    private  Long salary;
    private  LocalDate hiring;
    private LocalDate quite;
}
