package fr.insa.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class PostsDAOImp implements PostsDAO {
    private Configuration configObj;

    public PostsDAOImp(){
        configObj = ConfigObj.getConfigObj();
    }

    @SuppressWarnings("unchecked")
    public void save(Posts p) {
        Session sessionObj;
        sessionObj = configObj.buildSessionFactory().openSession();

        sessionObj.beginTransaction();
        sessionObj.save(p);
        System.out.println(p);
        sessionObj.getTransaction().commit();
        sessionObj.close();
    }

    @SuppressWarnings("unchecked")
    public Posts find(Posts p) {
        Session sessionObj;
        sessionObj = configObj.buildSessionFactory().openSession();

        sessionObj.beginTransaction();
        List<Posts> postList = sessionObj.createQuery("FROM Posts p WHERE p.id='"+p.getId()+"'").list();
        sessionObj.save(p);
        System.out.println("test" + postList);
        sessionObj.close();

        return (postList.size()==1)?postList.get(0):new Posts(null,null,null,null,null);
    }

    @SuppressWarnings("unchecked")
    public List<Posts> list() {
        Session sessionObj;
        sessionObj = configObj.buildSessionFactory().openSession();
        sessionObj.beginTransaction();

        List<Posts> postList = sessionObj.createQuery("FROM Posts").list();
        System.out.println("qlq"+postList);
        sessionObj.close();
        return postList;
    }
}
