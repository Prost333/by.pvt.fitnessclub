package by.pvt.fitnesclub.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
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
    @Column(name = "end")
    private LocalDate end;
    @Column(name = "statusUser")
    private String stausUser;
}
