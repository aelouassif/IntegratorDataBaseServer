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
    public List<Posts> list() {
        Session sessionObj;
        sessionObj = configObj.buildSessionFactory().openSession();

        sessionObj.beginTransaction();
        List<Posts> postList = sessionObj.createQuery("FROM Posts").list();
        System.out.println("postList : \n"+postList);
        sessionObj.getTransaction().commit();
        sessionObj.close();

        for(int i=0;i<postList.size();i++){
            postList.get(i).setUser(null);
            postList.get(i).setComment(null);
            System.out.println(postList.get(i).getContent());
        }
        return postList;
    }
}
