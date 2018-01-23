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

    @RequestMapping("/allPosts")
    public List<Posts> all() {

        return new PostsDAOImp().list();
    }
    @RequestMapping("/test")
    public void test() throws InterruptedException {


//
//        Posts p1 = new Posts( "date1", "position1", "content1", null, null);
//        new PostsDAOImp().save(p1);

//        Posts p2 = new Posts( "date2", "position2", "content2", users1, null);
//        new PostsDAOImp().save(p2);

        new PostsDAOImp().list();


    }
}