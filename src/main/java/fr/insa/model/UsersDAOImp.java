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
        personList.get(0).setPosts(null);
        personList.get(0).setComments(null);
        personList.get(0).setRoutes(null);

        return (personList.size()==1)?personList.get(0):new Users(null,null,null,null,null,null,null,null);
    }
    @SuppressWarnings("unchecked")
    public Users findById(int id) {
        Session sessionObj;
        sessionObj = configObj.buildSessionFactory().openSession();

        sessionObj.beginTransaction();
        List<Users> personList = sessionObj.createQuery("FROM Users U WHERE U.id="+id+"").list();
        sessionObj.getTransaction().commit();
        sessionObj.close();
        personList.get(0).setPosts(null);
        personList.get(0).setComments(null);
        personList.get(0).setRoutes(null);
        return (personList.size()==1)?personList.get(0):new Users(null,null,null,null,null,null,null,null);
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
            personList.get(i).setPosts(null);
            personList.get(i).setComments(null);
            personList.get(i).setRoutes(null);
            System.out.println(personList.get(i).getPosts());

        }

        return personList;
    }

}
