package main;

import fr.insa.model.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class CommentsController {


    @RequestMapping("/insertComment")
    public void insert(@RequestParam(value="content") String content, @RequestParam(value="date") String date, @RequestParam(value="position") String position,
                       @RequestParam(value="userId") String userId,@RequestParam(value="postId") String postId) {

        Users user = new UsersDAOImp().findById(Integer.parseInt(userId));
        Posts post = new PostsDAOImp().findById(Integer.parseInt(postId));

        ModelAndView mv = new ModelAndView();
        Comments comment = new Comments(date,position,content,user,post);

        new CommentsDAOImp().save(comment);
    }
    @RequestMapping("/findCommentById")
    public Comments findById(@RequestParam(value="commentId") String CommentId) {
        return new CommentsDAOImp().findById(Integer.parseInt(CommentId));
    }
    @RequestMapping("/deleteComment")
    public void deletePost(@RequestParam(value="commentId") String CommentId) {
        CommentsDAOImp postsDAOImp = new CommentsDAOImp();
        postsDAOImp.delete(postsDAOImp.findById(Integer.parseInt(CommentId)));
    }
//
//    @RequestMapping("/allPosts")
//    public List<Posts> all() {
//
//        return new PostsDAOImp().list();
//    }
}
