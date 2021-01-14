package ImageHoster.service;

import ImageHoster.model.Comment;
import ImageHoster.model.Image;
import ImageHoster.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    //The method calls the addComment() method in the Repository and passes the comment to be persisted in the database
    public void addComment(Comment comment) {
        commentRepository.addComment(comment);
    }

    //The method creates an instance of EntityManager
    //Executes JPQL query to fetch all the comments for an image from the database
    //Returns the list of all the comments for the queried image fetched from the database
    public List<Comment> getAllComments(Integer imageId) {
        return commentRepository.getAllComments(imageId);
    }
}
