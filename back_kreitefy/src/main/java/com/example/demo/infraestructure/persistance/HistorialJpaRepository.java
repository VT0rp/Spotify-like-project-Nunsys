package com.example.demo.infraestructure.persistance;

import com.example.demo.domain.entity.Historial;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistorialJpaRepository extends JpaRepository<Historial, Long> {
}
