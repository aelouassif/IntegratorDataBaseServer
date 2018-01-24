package fr.insa.model;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class RoutesDAOImp implements RoutesDAO {

    private Configuration configObj;

    public RoutesDAOImp(){
        configObj = ConfigObj.getConfigObj();
    }
    @Override
    public void save(Routes route) {
        Session sessionObj;
        sessionObj = configObj.buildSessionFactory().openSession();
        sessionObj.beginTransaction();
        sessionObj.save(route);
        sessionObj.getTransaction().commit();
        sessionObj.close();
    }

    @Override
    public List<Routes> list() {
        Session sessionObj;
        sessionObj = configObj.buildSessionFactory().openSession();
        sessionObj.beginTransaction();
        List<Routes> routeList = sessionObj.createQuery("FROM Routes ").list();
        System.out.println("routeList : \n"+routeList);
        sessionObj.getTransaction().commit();
        sessionObj.close();

        for(int i=0;i<routeList.size();i++){
            routeList.get(i).setUsers(Transform.transformUsers(routeList.get(i).getUsers()));
        }
        return routeList;
    }

    @Override
    public void delete(Routes r) {
        Session sessionObj;
        sessionObj = configObj.buildSessionFactory().openSession();
        sessionObj.beginTransaction();
        sessionObj.delete(r);
        sessionObj.getTransaction().commit();
        sessionObj.close();

    }

    @Override
    public Routes findById(int id) {
        Routes route = new Routes();
        Session sessionObj;
        sessionObj = configObj.buildSessionFactory().openSession();
        sessionObj.beginTransaction();
        route = (Routes) sessionObj.get(Routes.class,id);
        sessionObj.getTransaction().commit();
        sessionObj.close();

        route.setUsers(Transform.transformUsers(route.getUsers()));
        return route;
    }
}
