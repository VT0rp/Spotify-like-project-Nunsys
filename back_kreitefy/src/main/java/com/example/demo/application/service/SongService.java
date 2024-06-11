package com.example.demo.application.service;

import com.example.demo.application.dto.SongDto;
import com.example.demo.domain.entity.Song;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface SongService {

    public List<Song> getLastSongs();
    SongDto createSong(SongDto songDto);
    void deleteSong(Long id);
    Optional<SongDto> getSong(Long id);
    SongDto updateSong(Long id, SongDto songUpdated);
}
