package by.pvt.fitnesclub.entity;

import lombok.*;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;



@Entity
@Getter
@Setter
@ToString
@Table(schema = "fitness", name = "sale")
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "value")
    private BigDecimal value;
    @Column(name = "start")
    private LocalDate start;
    @Column(name = "stop")
    private LocalDate stop;
    @Column(name = "statusUser")
    private String stausUser;
}
