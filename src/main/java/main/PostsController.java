package main;

import fr.insa.model.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class PostsController {


    @RequestMapping("/insertPost")
    public void insert(@RequestParam(value="content") String content, @RequestParam(value="date") String date,@RequestParam(value="position") String position,
                       @RequestParam(value="userId") String userId) {
        Users user = new UsersDAOImp().findById(Integer.parseInt(userId));

        ModelAndView mv = new ModelAndView();
        Posts posts = new Posts();
        posts.setContent(content);
        posts.setDate(date);
        posts.setPosition(position);
        posts.setUser(user);

        new PostsDAOImp().save(posts);
    }
    @RequestMapping("/findPostById")
    public Posts findById(@RequestParam(value="postId") String postId) {
        return new PostsDAOImp().findById(Integer.parseInt(postId));
    }
    @RequestMapping("/deletePost")
    public void deletePost(@RequestParam(value="postId") String postId) {
        PostsDAOImp postsDAOImp = new PostsDAOImp();
        postsDAOImp.delete(postsDAOImp.findById(Integer.parseInt(postId)));
    }

    @RequestMapping("/allPosts")
    public List<Posts> all() {

        return new PostsDAOImp().list();
    }
}
