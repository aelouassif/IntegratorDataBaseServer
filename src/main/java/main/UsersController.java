
package main;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import fr.insa.model.Posts;
import fr.insa.model.PostsDAOImp;
import fr.insa.model.Users;
import fr.insa.model.UsersDAOImp;
import org.apache.tomcat.jni.Time;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class UsersController {


    @RequestMapping("/login")
    public Users greeting(@RequestParam(value="login") String login, @RequestParam(value="password") String password) {
        Users user = new Users();
        user.setLogin(login);
        user.setPassword(password);

        UsersDAOImp usersDAOImp = new UsersDAOImp();
//        usersDAOImp.save(user);
        user = usersDAOImp.find(user);


        return user;
    }
    @RequestMapping("/insert")
    public void insert(@RequestParam(value="login") String login, @RequestParam(value="password") String password,@RequestParam(value="first_name") String first_name,
                       @RequestParam(value="last_name") String last_name,@RequestParam(value="email") String email) {
        ModelAndView mv = new ModelAndView();
        Users user = new Users();
        user.setLogin(login);
        user.setPassword(password);
        user.setEmail(email);
        user.setFirst_name(first_name);
        user.setLast_name(last_name);

        UsersDAOImp usersDAOImp = new UsersDAOImp();
//        usersDAOImp.save(user);
        usersDAOImp.save(user);
    }

    @RequestMapping("/all")
    public List<Users> all() {
        UsersDAOImp usersDAOImp = new UsersDAOImp();
        return usersDAOImp.list();
    }
    @RequestMapping("/test")
    public void test() throws InterruptedException {
//        Users users = new Users("login1", "password", "first_name", "last_name", "email",
//                null,null,null);
//        new UsersDAOImp().save(users);
//
//        Users users1 = new Users("login", "password", "first_name", "last_name", "email",
//                null,null,null);
//        new UsersDAOImp().save(users1);

        Users users1 = new UsersDAOImp().find(new Users("login", "password", "lqq", null, null,
                null,null,null));
        System.out.println(users1);
        if(users1.getPosts()!=null && users1.getPosts().size()>0){
            System.out.println((users1.getPosts().size()));
            System.out.println("le commentaire est : " + users1.getPosts().get(0).getContent());
        }

//
//        Posts p1 = new Posts( "date1", "position1", "content1", users1, null);
//        Posts p2 = new Posts( "date2", "position2", "content2", users1, null);
//        new PostsDAOImp().save(p1);
//        new PostsDAOImp().save(p2);




    }
}