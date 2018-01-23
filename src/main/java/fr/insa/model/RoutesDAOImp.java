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
        System.out.println(route);
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
            routeList.get(i).setUsers(null);
            System.out.println(routeList.get(i).getDate());
        }
        return routeList;
    }
}
