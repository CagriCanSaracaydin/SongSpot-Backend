package dev.chagri.songs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    /**
     * Fetch all comments from the database.
     * @return List of all comments
     */
    public List<Comment> findAllComments() {
        return commentRepository.findAll();
    }

    /**
     * Fetch a specific comment by its ID.
     * @param id The ID of the comment to retrieve
     * @return An Optional containing the comment if found, or an empty Optional if not found
     */
    public Optional<Comment> findCommentById(String id) {
        return commentRepository.findById(id);
    }

    /**
     * Add a new comment to the database.
     * @param comment The Comment object to add
     * @return The Comment object after it has been saved (with updated ID)
     */
    public Comment addComment(Comment comment) {
        return commentRepository.save(comment);
    }

    /**
     * Fetch all comments for a specific song.
     * @param songId The ID of the song for which comments are to be retrieved
     * @return List of comments associated with the specified song
     */
    public List<Comment> findCommentsBySongId(String songId) {
        return commentRepository.findBySongId(songId);
    }
}
