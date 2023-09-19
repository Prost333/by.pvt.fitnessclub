package by.pvt.fitnesclub.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Subselect("select o.id as id, o.name as name, o.cost as cost, o.inventarnumer as inventarNumer  from fitness.office o where maxuser<15")
@Immutable
public class OfficeWithSubSelect {
    @Id
    private  Long id;
    private  String name;
    private BigDecimal cost;
    private  Long inventarNumer;


}
