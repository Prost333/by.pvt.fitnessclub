package by.pvt.fitnesclub.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
@ToString
@Table(schema = "fitness", name = "visitor")
@PrimaryKeyJoinColumn(name = "vs_id")
//select*from fitness.visitor e join fitness.user u on e.vs_id=u.id;
public class Visitor extends User {
    private String phoneNumber;
    private LocalDate date;
    private BigDecimal money;
    @Enumerated(EnumType.STRING)
    private Status status;
    @OneToMany
    @JoinColumn(name = "visit_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<VisitUser> visitUser;
    @OneToMany(mappedBy = "visitor", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Note> note;
}
