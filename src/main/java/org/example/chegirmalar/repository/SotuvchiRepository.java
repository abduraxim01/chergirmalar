package org.example.chegirmalar.repository;

import org.example.chegirmalar.model.Sotuvchi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SotuvchiRepository extends JpaRepository<Sotuvchi, Long> {

    Sotuvchi findByUsername(String username);
//    Optional<Sotuvchi> findById(Long id);
}
