package by.pvt.fitnesclub.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;


@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
@Table(schema = "fitness", name = "user")
public class User {
    @Id
//    @GeneratedValue
    private Long id;
    private String name;
    private String surname;
    private Long age;
    private String phoneNumber;
    private LocalDate date;
    private BigDecimal money;
    @Enumerated(EnumType.STRING)
    private Status status;

    public User(String name, String surname, Long age, String phoneNumber, LocalDate date, BigDecimal money, Status status) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.date = date;
        this.money = money;
        this.status = status;
    }
}
