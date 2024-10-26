package org.example.chegirmalar.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Table(name = "")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Mahsulot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "sotuvchi_id", nullable = false)
    private Sotuvchi sotuvchi;

    @Column(nullable = false, length = 25)
    private String title;
    private String body;
    private String image;

    @Column(nullable = false)
    private Double price;

    private Double discount;

    private LocalDateTime fromDate;
    private LocalDateTime toDate;

    private LocalDateTime created_at;

    private LocalDateTime set() {
        return created_at = LocalDateTime.now();
    }
}
