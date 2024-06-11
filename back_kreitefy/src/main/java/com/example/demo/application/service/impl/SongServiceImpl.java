package com.example.demo.application.service.impl;

import com.example.demo.application.dto.SongDto;
import com.example.demo.application.mapper.SongMapper;
import com.example.demo.application.service.SongService;
import com.example.demo.domain.entity.Song;
import com.example.demo.infraestructure.persistance.SongJpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SongServiceImpl implements SongService {
    private final SongJpaRepository songJpaRepository;

    private final SongMapper songMapper;

    public SongServiceImpl(SongJpaRepository songJpaRepository, SongMapper songMapper){
        this.songJpaRepository = songJpaRepository;
        this.songMapper = songMapper;
    }

    @Override
    public List<Song> getLastSongs(){
        return songJpaRepository.findTop5ByOrderByIdDesc();
    }

    @Override
    public SongDto createSong(SongDto songDto) {
        Song song = songMapper.toEntity(songDto);
        song = songJpaRepository.save(song);
        return songMapper.toDto(song);
    }

    @Override
    public void deleteSong(Long id) {
        songJpaRepository.deleteById(id);
    }

    @Override
    public Optional<SongDto> getSong(Long id) {
        Optional<Song> song = songJpaRepository.findById(id);
        if(song.isPresent()){
            return Optional.of(songMapper.toDto(song.get()));
        }else{
            return Optional.empty();
        }
    }

    @Override
    public SongDto updateSong(Long id, SongDto songUpdated) {
        Song song = songJpaRepository.findById(id).orElse(null);
        if (song != null) {
            song.setName(songUpdated.getName());
            song.setAlbum(songUpdated.getAlbum());
            song.setArtist(songUpdated.getArtist());
            song.setDuration(songUpdated.getDuration());
            song.setEstrellas(songUpdated.getEstrellas());
            song.setReproductions(songUpdated.getReproductions());
            song.setStyle(songUpdated.getStyle());
            song.setImage(songUpdated.getImage());
            song = songJpaRepository.save(song);
            return songMapper.toDto(song);
        } else {
            return null;
        }
    }
}
