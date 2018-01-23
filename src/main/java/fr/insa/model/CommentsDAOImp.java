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
        sessionObj.getTransaction().commit();
        sessionObj.close();

        for(int i=0;i<commentsList.size();i++){
            commentsList.get(i).setPost(Transform.transformPost(commentsList.get(i).getPost()));
            commentsList.get(i).setUser(Transform.transformUser(commentsList.get(i).getUser()));
            System.out.println(commentsList.get(i).getDate());
        }
        return commentsList;
    }

    @Override
    public void delete(Comments c) {
        Session sessionObj;
        sessionObj = configObj.buildSessionFactory().openSession();
        sessionObj.beginTransaction();
        sessionObj.delete(c);
        sessionObj.getTransaction().commit();
        sessionObj.close();

    }

    @Override
    public Comments findById(int id) {
        Comments comment = new Comments();
        Session sessionObj;
        sessionObj = configObj.buildSessionFactory().openSession();
        comment = (Comments) sessionObj.get(Comments.class,id);
        sessionObj.beginTransaction();
        sessionObj.close();

        comment.setPost(Transform.transformPost(comment.getPost()));
        comment.setUser(Transform.transformUser(comment.getUser()));
        return comment;

    }
}
