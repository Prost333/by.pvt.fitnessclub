package by.pvt.fitnesclub.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
@Data
@AllArgsConstructor
@Entity
@Table(schema = "testsh", name = "user")
public class User {
    @Id
    private  Long id;
    private  String name;
    private  String surname;
    private  Long age;
    private  String phoneNumber;
    private LocalDate date;
    private BigDecimal money;
    @Enumerated(EnumType.STRING)
    private Status status;

    public User() {
    }
}
