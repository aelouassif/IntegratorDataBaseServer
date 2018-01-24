package fr.insa.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.util.List;

public class UsersDAOImp implements UsersDAO {

    private Configuration configObj;

    public UsersDAOImp(){
        configObj = ConfigObj.getConfigObj();
    }

    public void save(Users u) {
        Session sessionObj;
        sessionObj = configObj.buildSessionFactory().openSession();
        sessionObj.beginTransaction();
        sessionObj.save(u);
        System.out.println(u);
        sessionObj.getTransaction().commit();
        sessionObj.close();
    }
    public void delete(Users u) {
        Session sessionObj;
        sessionObj = configObj.buildSessionFactory().openSession();
        sessionObj.beginTransaction();
        sessionObj.delete(u);
        sessionObj.getTransaction().commit();
        sessionObj.close();
    }
    @SuppressWarnings("unchecked")
    public Users find(Users u) {
        Session sessionObj;
        sessionObj = configObj.buildSessionFactory().openSession();

        sessionObj.beginTransaction();
        List<Users> personList = sessionObj.createQuery("FROM Users U WHERE U.login='"+u.getLogin()+"' AND U.password='"+u.getPassword()+"'").list();
        sessionObj.getTransaction().commit();
        sessionObj.close();
        personList.get(0).setPosts(Transform.transformPosts(personList.get(0).getPosts()));
        personList.get(0).setComments(Transform.transformComments(personList.get(0).getComments()));
        personList.get(0).setRoutes(Transform.transformRoutes(personList.get(0).getRoutes()));

        return (personList.size()==1)?personList.get(0):new Users(null,null,null,null,null,null,null,null);
    }
    @SuppressWarnings("unchecked")
    public Users findById(int id) {
        Users user = new Users();
        Session sessionObj;
        sessionObj = configObj.buildSessionFactory().openSession();
        sessionObj.beginTransaction();
        user = (Users) sessionObj.get(Users.class,id);
        sessionObj.getTransaction().commit();
        sessionObj.close();

        user.setRoutes(Transform.transformRoutes(user.getRoutes()));
        user.setPosts(Transform.transformPosts(user.getPosts()));
        user.setComments(Transform.transformComments(user.getComments()));
        return user;
    }

    @SuppressWarnings("unchecked")
    public List<Users> list() {
        Session sessionObj;
        sessionObj = configObj.buildSessionFactory().openSession();

        sessionObj.beginTransaction();
        List<Users> personList = sessionObj.createQuery("FROM Users").list();
        System.out.println("personList : \n"+personList);
        sessionObj.getTransaction().commit();
        sessionObj.close();

        for(int i=0;i<personList.size();i++ ){
            personList.get(i).setPosts(Transform.transformPosts(personList.get(i).getPosts()));
            personList.get(i).setComments(Transform.transformComments(personList.get(i).getComments()));
            personList.get(i).setRoutes(Transform.transformRoutes(personList.get(i).getRoutes()));
            System.out.println(personList.get(i).getPosts());

        }

        return personList;
    }

}
