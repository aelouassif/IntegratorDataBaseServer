package main;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import fr.insa.model.Users;
import fr.insa.model.UsersDAOImp;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class DataBaseController {


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
    public void insert(@RequestParam(value="login") String login, @RequestParam(value="password") String password) {
        ModelAndView mv = new ModelAndView();
        Users user = new Users();
        user.setLogin(login);
        user.setPassword(password);

        UsersDAOImp usersDAOImp = new UsersDAOImp();
//        usersDAOImp.save(user);
        usersDAOImp.save(user);
    }

    @RequestMapping("/all")
    public List<Users> all() {
        UsersDAOImp usersDAOImp = new UsersDAOImp();
        return usersDAOImp.list();
    }
}