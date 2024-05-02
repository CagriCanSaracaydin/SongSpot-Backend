package dev.chagri.songs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/ratings")
public class RatingController {

    @Autowired
    private RatingService ratingService;

    @GetMapping
    public ResponseEntity<List<Rating>> getAllRatings() {
        return new ResponseEntity<>(ratingService.findAllRatings(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Rating> getRatingById(@PathVariable String id) {
        return ratingService.findRatingById(id)
                .map(rating -> new ResponseEntity<>(rating, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/song/{songId}")
    public ResponseEntity<List<Rating>> getRatingsBySongId(@PathVariable String songId) {
        List<Rating> ratings = ratingService.findRatingsBySongId(songId);
        if (ratings.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(ratings, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createRating(@RequestBody Rating rating) {
        Rating savedRating = ratingService.saveRating(rating);
        if (savedRating != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(Map.of("result", "success"));
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("result", "error", "message", "Failed to save the rating"));
        }
    }
}
