package by.pvt.fitnesclub.entity;

import lombok.*;
import org.hibernate.annotations.Where;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
//@ToString
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
//@Inheritance (strategy = InheritanceType.SINGLE_TABLE)
//@MappedSuperclass
//@DiscriminatorColumn(name= "TYPY_OF_USER")
@Inheritance(strategy = InheritanceType.JOINED)
@Table(schema = "fitness", name = "user")
@Entity
public class User  implements UserDetails{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "age")
    private Long age;

    @Column(name = "password")
    private  String password;
    @Embedded
    private Address address;

    @Column(name="status")
    private  String status;

    @OneToMany(mappedBy = "user")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Sale> sale;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return new ArrayList<>();
    }

    @Override
    public String getUsername() {
        return name;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
