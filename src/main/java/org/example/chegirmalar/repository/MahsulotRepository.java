package org.example.chegirmalar.repository;

import org.example.chegirmalar.model.Mahsulot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MahsulotRepository extends JpaRepository<Mahsulot, Long> {
}
