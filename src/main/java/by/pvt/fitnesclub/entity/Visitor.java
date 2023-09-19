package by.pvt.fitnesclub.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
@ToString
//@DiscriminatorValue(value = "Vis")
@Table(schema = "fitness", name = "visitor")
@PrimaryKeyJoinColumn(name= "vs_id")
//select*from fitness.visitor e join fitness.user u on e.vs_id=u.id;
public class Visitor extends User{
    private String phoneNumber;
    private LocalDate date;
    private BigDecimal money;
    @Enumerated(EnumType.STRING)
    private Status status;
}
