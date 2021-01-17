package ImageHoster.controller;

import ImageHoster.model.Comment;
import ImageHoster.model.Image;
import ImageHoster.model.User;
import ImageHoster.service.CommentService;
import ImageHoster.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Controller
public class CommentController {

    @Autowired(required = true)
    private CommentService commentService;

    @Autowired
    private ImageService imageService;

    // NEW FEATURE: This method returns all the comments for a particular image
    @RequestMapping("comments")
    public String getComments(@PathVariable(name = "imageId") Integer imageId, Model model) {
        List<Comment> comments = commentService.getAllComments(imageId);
        model.addAttribute("comments", comments);
        return "comments";
    }

    // NEW FEATURE: This method creates a comment corresponding to the image provided as parameter
    @RequestMapping(value = "/image/{imageId}/{imageTitle}/comments", method = RequestMethod.POST)
    public String createComment(@PathVariable(name = "imageId") Integer imageId, @PathVariable(value = "imageTitle") String title, @RequestParam(value = "comment") String newComment, HttpSession session, Model model) {
        User user = (User) session.getAttribute("loggeduser");
        Image image = imageService.getImage(imageId);
        Comment comment = new Comment(newComment,new Date(), user, image);
        commentService.addComment(comment);
        return "redirect:/images/" + image.getId() + "/" + title;

    }
}