package dev.chagri.songs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SongService {
    @Autowired
    private SongRepository songRepository;

    public List<Song> allSongs(){
        return songRepository.findAll();
    }

    public Optional<Song> findSongById(String id) {
        return songRepository.findById(id);
    }

    public List<Song> findSongsByGenre(String genre) {
        return songRepository.findByGenre(genre);
    }

    public List<String> findAllGenres() {
        // Fetch all songs, map to their genres, and collect as a set to ensure uniqueness
        return songRepository.findAll().stream()
                .map(Song::getGenre)
                .distinct()
                .collect(Collectors.toList());
    }
}
