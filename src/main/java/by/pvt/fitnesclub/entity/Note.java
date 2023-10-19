package by.pvt.fitnesclub.entity;

import lombok.*;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
@ToString
@Table(schema = "fitness", name = "note")
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    private LocalDateTime localDateTime;
    @ManyToOne
    @JoinColumn(name = "office_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Office office;
    @ManyToOne
    @JoinColumn(name = "visitor_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Visitor visitor;

}
