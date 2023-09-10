package by.pvt.fitnesclub.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
@Table(schema = "fitness", name = "office")
public class Office {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private  Long id;
    @Column(name="name")
    private  String name;
    @Column(name="inventarNumer", nullable = false)
    private  Long inventarNumer;
    @Column(name="status")
    private String status;
    @Column(name="maxUser")
    private Long maxUser;
    @Column(name="cost")
    private BigDecimal cost;

    public Office(String name, Long inventarNumer, String status, Long maxUser, BigDecimal cost) {
        this.name = name;
        this.inventarNumer = inventarNumer;
        this.status = status;
        this.maxUser = maxUser;
        this.cost = cost;
    }
}
