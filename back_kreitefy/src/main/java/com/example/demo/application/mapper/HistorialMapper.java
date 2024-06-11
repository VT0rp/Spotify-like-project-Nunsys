package com.example.demo.application.mapper;

import com.example.demo.application.dto.HistorialDto;
import com.example.demo.domain.entity.Historial;
import com.example.demo.domain.entity.Song;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface HistorialMapper extends EntityMapper<HistorialDto, Historial>{
    default Historial fromId(Long id){
        if(id == null){
            return null;
        }
        Historial historial = new Historial();
        historial.setId(id);
        return historial;
    }
}
