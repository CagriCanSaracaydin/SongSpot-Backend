package dev.chagri.songs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;

@Document(collection="ratings")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Rating {
    @Id
    private String id;
    private String songId;
    private String username;
    private int rating;
    private LocalDateTime timestamp;


}
