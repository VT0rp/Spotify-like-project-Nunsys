package com.example.demo.infraestructure.rest;

import com.example.demo.application.dto.HistorialDto;
import com.example.demo.application.service.HistorialService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/historial")
public class HistorialController {

    private final HistorialService historialService;

    public HistorialController(HistorialService historialService){
        this.historialService = historialService;
    }

    @PostMapping("/create")
    public ResponseEntity<HistorialDto>crearHistorial(@RequestBody HistorialDto historialDto){
        HistorialDto historial = this.historialService.createHistorial(historialDto);
        return ResponseEntity.ok(historial);
    }
}
