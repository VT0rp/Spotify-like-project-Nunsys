package com.example.demo.application.service.impl;

import com.example.demo.application.dto.HistorialDto;
import com.example.demo.application.mapper.HistorialMapper;
import com.example.demo.application.service.HistorialService;
import com.example.demo.domain.entity.Historial;
import com.example.demo.infraestructure.persistance.HistorialJpaRepository;
import org.springframework.stereotype.Service;

@Service
public class HistorialServiceImpl implements HistorialService {
    private final HistorialMapper historialMapper;
    private final HistorialJpaRepository historialJpaRepository;

    public HistorialServiceImpl(HistorialMapper historialMapper, HistorialJpaRepository historialJpaRepository){
        this.historialMapper = historialMapper;
        this.historialJpaRepository = historialJpaRepository;
    }
    @Override
    public HistorialDto createHistorial(HistorialDto historialDto) {
        Historial historial = historialMapper.toEntity(historialDto);
        historial = historialJpaRepository.save(historial);
        return historialMapper.toDto(historial);
    }
}
