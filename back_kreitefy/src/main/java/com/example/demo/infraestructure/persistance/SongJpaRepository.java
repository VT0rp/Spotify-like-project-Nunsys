package com.example.demo.infraestructure.persistance;

import com.example.demo.domain.entity.Song;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SongJpaRepository extends JpaRepository<Song, Long> {
    List<Song> findTop5ByOrderByIdDesc();
}
