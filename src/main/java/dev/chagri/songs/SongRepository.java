package dev.chagri.songs;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SongRepository extends MongoRepository<Song, String> {
    List<Song> findByGenre(String genre);
    @Query(value = "{}", fields = "{genre: 1}")
    List<Song> findAllGenres();
}
