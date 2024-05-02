package dev.chagri.songs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class RatingService {

    @Autowired
    private RatingRepository ratingRepository;

    public List<Rating> findAllRatings() {
        return ratingRepository.findAll();
    }

    public Optional<Rating> findRatingById(String id) {
        return ratingRepository.findById(id);
    }

    public Rating saveRating(Rating rating) {
        return ratingRepository.save(rating);
    }

    public List<Rating> findRatingsBySongId(String songId) {
        return ratingRepository.findBySongId(songId);
    }
}
