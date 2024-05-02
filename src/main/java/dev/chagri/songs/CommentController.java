package dev.chagri.songs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/comments")
public class CommentController {
    @Autowired
    private CommentService commentService;

    // Endpoint to retrieve all comments for a specific song
    @GetMapping("/song/{songId}")
    public ResponseEntity<List<Comment>> getCommentsBySongId(@PathVariable String songId) {
        List<Comment> comments = commentService.findCommentsBySongId(songId);
        if (comments.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(comments, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createComment(@RequestBody Comment comment) {
        Comment savedComment = commentService.addComment(comment);
        if (savedComment != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(Map.of("result", "success"));
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("result", "error", "message", "Failed to save the comment"));
        }
    }

}
