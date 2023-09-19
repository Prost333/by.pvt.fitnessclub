package by.pvt.fitnesclub.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Table(schema = "fitness", name ="Visit_User")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VisitUser {
    @Id
    @SequenceGenerator(name = "seq_visit_user", sequenceName = "visit_user_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_visit_user")
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "user_id")
    private Long clientId;
    @Column(name = "date_of_visit")
    private LocalDate dateOfVisit;
    @Column(name = "money")
    private BigDecimal moneySpent;
    @Column(name = "activity_id")
    private Long activityId;
}

