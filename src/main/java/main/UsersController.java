
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
    @RequestMapping("/findUserById")
    public Users findById(@RequestParam(value="userId") String userId) {
        Users user = new Users();

        UsersDAOImp usersDAOImp = new UsersDAOImp();
//        usersDAOImp.save(user);
        user = usersDAOImp.findById(Integer.parseInt(userId));
        System.out.println(user);
        return user;
    }
    @RequestMapping("/deleteUser")
    public void delete(@RequestParam(value="login") String login, @RequestParam(value="password") String password) {
        Users user = new Users();
        user.setLogin(login);
        user.setPassword(password);

        UsersDAOImp usersDAOImp = new UsersDAOImp();
//        usersDAOImp.save(user);
        user = usersDAOImp.find(user);
        if(user.getLogin()!=null){
            new UsersDAOImp().delete(user);
        }
    }
    @RequestMapping("/insertUser")
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
        usersDAOImp.save(user);
    }
    @RequestMapping("/updateUser")
    public void updateUser(@RequestParam(value="login",defaultValue = "") String login, @RequestParam(value="password",defaultValue = "") String password,
                           @RequestParam(value="first_name",defaultValue = "") String first_name,@RequestParam(value="last_name",defaultValue = "") String last_name,
                           @RequestParam(value="email",defaultValue = "") String email,@RequestParam(value="userId") String userId,
                            @RequestParam(value="route_id") String route_id) {

        ModelAndView mv = new ModelAndView();
        UsersDAOImp usersDAOImp = new UsersDAOImp();
        Users user = usersDAOImp.findById(Integer.parseInt(userId));

        if(!login.equals(""))
            user.setLogin(login);
        if(!password.equals(""))
            user.setPassword(password);
        if(!email.equals(""))
            user.setEmail(email);
        if(!first_name.equals(""))
            user.setFirst_name(first_name);
        if(!last_name.equals(""))
            user.setLast_name(last_name);
        if(!route_id.equals(""))
            user.setRoute_id(Integer.parseInt(route_id));


        usersDAOImp.update(user);
    }

    @RequestMapping("/allUsers")
    public List<Users> all() {
        UsersDAOImp usersDAOImp = new UsersDAOImp();
        return usersDAOImp.list();
    }
}