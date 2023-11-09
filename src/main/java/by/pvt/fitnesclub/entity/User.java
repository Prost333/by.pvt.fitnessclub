package by.pvt.fitnesclub.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.Where;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
//@ToString
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
//@Inheritance (strategy = InheritanceType.SINGLE_TABLE)
//@MappedSuperclass
//@DiscriminatorColumn(name= "TYPY_OF_USER")
@Inheritance(strategy = InheritanceType.JOINED)
@Table(schema = "fitness", name = "user")
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @Column(name="name")
    private String name;
    @Column(name="surname")
    private String surname;
    @Column(name="age")
    private Long age;
    @Embedded
    private  Address address;


}
