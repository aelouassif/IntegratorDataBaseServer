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
        sessionObj.getTransaction().commit();
        sessionObj.close();
    }


    @SuppressWarnings("unchecked")
    public List<Posts> list() {
        Session sessionObj;
        sessionObj = configObj.buildSessionFactory().openSession();

        sessionObj.beginTransaction();
        List<Posts> postList = sessionObj.createQuery("FROM Posts").list();
        sessionObj.getTransaction().commit();
        sessionObj.close();

        for(int i=0;i<postList.size();i++){
            postList.get(i).setUser(Transform.transformUser(postList.get(i).getUser()));
            postList.get(i).setComment(Transform.transformComments(postList.get(i).getComment()));
        }
        return postList;
    }

    @Override
    public void delete(Posts p) {
        Session sessionObj;
        sessionObj = configObj.buildSessionFactory().openSession();
        sessionObj.beginTransaction();
        sessionObj.delete(p);
        sessionObj.getTransaction().commit();
        sessionObj.close();

    }

    @Override
    public Posts findById(int id) {
        Session sessionObj;
        sessionObj = configObj.buildSessionFactory().openSession();

        sessionObj.beginTransaction();
        List<Posts> postsList = sessionObj.createQuery("FROM Posts P WHERE P.id="+id).list();
        sessionObj.getTransaction().commit();
        sessionObj.close();
        postsList.get(0).setComment(null);
        postsList.get(0).setUser(null);
        return (postsList.size()==1)?postsList.get(0):null;

    }
}
