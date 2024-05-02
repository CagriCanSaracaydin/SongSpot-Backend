package dev.chagri.songs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "songs")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Song {

    @Id
    private String id;
    private String name;
    private String artist;
    private String genre;
    private int year;
}
