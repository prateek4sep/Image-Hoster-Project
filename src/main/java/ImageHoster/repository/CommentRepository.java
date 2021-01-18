package ImageHoster.repository;

import ImageHoster.model.Comment;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.List;

//The annotation is a special type of @Component annotation which describes that the class defines a data repository
@Repository
public class CommentRepository {

    //Get an instance of EntityManagerFactory from persistence unit with name as 'imageHoster'
    @PersistenceUnit(unitName = "imageHoster")
    private EntityManagerFactory emf;

    //The method receives the Comment object to be persisted in the database
    //Creates an instance of EntityManager
    //Starts a transaction
    //The transaction is committed if it is successful
    //The transaction is rolled back in case of unsuccessful transaction
    public Comment addComment(Comment newComment) {

        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            em.persist(newComment);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }
        return newComment;
    }

    //The method receives the Comment object to be deleted from the database
    //Creates an instance of EntityManager
    //Starts a transaction
    //The transaction is committed if it is successful
    //The transaction is rolled back in case of unsuccessful transaction
    public void deleteComment(Comment comment) {

        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            Comment comment1 = em.find(Comment.class, comment.getId());
            em.remove(comment1);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }
    }

    //The method creates an instance of EntityManager
    //Executes JPQL query to fetch all the comments for an image from the database
    //Returns the list of all the comments for an image fetched from the database
    public List<Comment> getAllComments(Integer imageId) {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Comment> query = em.createQuery("SELECT c from Comment c where c.image.id=:imageId", Comment.class).setParameter("imageId", imageId);
        List<Comment> resultList = query.getResultList();
        return resultList;
    }

    // The method creates an instance of EntityManager
    // BUG FIX: Executes JPQL query to delete all the comments for an image from the database
    // Otherwise it won't allow to delete the image.
    // This function removes the dependencies
    public void deleteAllComments(Integer imageId) {
        List<Comment> imageComments = getAllComments(imageId);
        for(Comment c: imageComments){
            deleteComment(c);
        }
    }
}
