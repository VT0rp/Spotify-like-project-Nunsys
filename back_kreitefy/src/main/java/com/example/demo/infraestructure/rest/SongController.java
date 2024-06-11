package com.example.demo.infraestructure.rest;

import com.example.demo.application.dto.SongDto;
import com.example.demo.application.service.SongService;
import com.example.demo.domain.entity.Song;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/canciones")
public class SongController {

    private final SongService songService;

    public SongController(SongService songService){
        this.songService = songService;
    }

    @GetMapping("/novedades")
    public List<Song> getNovedades(){
        return this.songService.getLastSongs();
    }

    @GetMapping("/cancion/{id}")
    public ResponseEntity<SongDto> getSong(@PathVariable("id") Long id){
        Optional<SongDto> song = this.songService.getSong(id);
        if(!song.isEmpty()){
            return ResponseEntity.ok(song.get());
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/reproduction/{id}")
    public ResponseEntity<SongDto> addReproduction(@PathVariable("id") Long id){
        Optional<SongDto> song = this.songService.getSong(id);
        if(!song.isEmpty()){
            song.get().setReproductions(song.get().getReproductions() + 1);
            SongDto songUpdated = this.songService.updateSong(id, song.get());
            return ResponseEntity.ok(songUpdated);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/stars/{id}/{estrellas}")
    public ResponseEntity<SongDto> setStars(@PathVariable("id") Long id, @PathVariable("estrellas") int estrellas){
        Optional<SongDto> song = this.songService.getSong(id);
        if(!song.isEmpty()){
            song.get().setEstrellas(estrellas);
            SongDto songUpdated = this.songService.updateSong(id, song.get());
            return ResponseEntity.ok(songUpdated);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

}
