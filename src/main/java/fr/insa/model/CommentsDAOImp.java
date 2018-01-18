package fr.insa.model;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class CommentsDAOImp implements CommentsDAO {

    private Configuration configObj;

    public CommentsDAOImp(){
        configObj = ConfigObj.getConfigObj();
    }

    @Override
    public void save(Comments comments) {
        Session sessionObj;
        sessionObj = configObj.buildSessionFactory().openSession();

        sessionObj.beginTransaction();
        sessionObj.save(comments);
        System.out.println(comments);
        sessionObj.getTransaction().commit();
        sessionObj.close();
    }

    @Override
    public List<Comments> list() {
        Session sessionObj;
        sessionObj = configObj.buildSessionFactory().openSession();

        sessionObj.beginTransaction();
        List<Comments> commentsList = sessionObj.createQuery("FROM Comments ").list();
        System.out.println("commentsList : \n"+commentsList);
        sessionObj.getTransaction().commit();
        sessionObj.close();

//        for(int i=0;i<postList.size();i++){
//            System.out.println(commentsList.get(i).getDate());
//        }
        return commentsList;

    }
}
