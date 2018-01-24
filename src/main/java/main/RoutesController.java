package main;

import fr.insa.model.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@RestController
public class RoutesController {


    @RequestMapping("/insertRoute")
    public void insert( @RequestParam(value="date") String date, @RequestParam(value="x_start") String x_start,@RequestParam(value="y_start") String y_start,
                       @RequestParam(value="x_end") String x_end, @RequestParam(value="y_end") String y_end,@RequestParam(value="userId") String userId) {
        Users user = new UsersDAOImp().findById(Integer.parseInt(userId));
        List<Users> users = new ArrayList<Users>();
        users.add(user);

        ModelAndView mv = new ModelAndView();
        Routes route = new Routes(date,x_start,y_start,x_end,y_end,users);
        new RoutesDAOImp().save(route);
    }

    @RequestMapping("/findRouteById")
    public Routes findById(@RequestParam(value="routeId") String routeId) {
        return new RoutesDAOImp().findById(Integer.parseInt(routeId));
    }
    @RequestMapping("/deleteRoute")
    public void deletePost(@RequestParam(value="routeId") String routeId) {
        RoutesDAOImp routesDAOImp = new RoutesDAOImp();
        routesDAOImp.delete(routesDAOImp.findById(Integer.parseInt(routeId)));
    }
//
//    @RequestMapping("/allPosts")
//    public List<Posts> all() {
//
//        return new PostsDAOImp().list();
//    }
}
