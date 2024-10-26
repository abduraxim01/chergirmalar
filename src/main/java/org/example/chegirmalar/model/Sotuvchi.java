package org.example.chegirmalar.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.management.relation.Role;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Table(name = "sotuvchilar")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sotuvchi implements UserDetails  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false, length = 25)
    private String username;

    @Column(unique = true, nullable = false, length = 25)
    private String password;

    @Column(length = 25)
    private String name;

    @OneToMany(mappedBy = "sotuvchi", cascade = CascadeType.ALL)
    private List<Mahsulot> mahsulots;

    private String image;

    private LocalDateTime toDate;
    private Timestamp created_at;

    private Role role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }
}
