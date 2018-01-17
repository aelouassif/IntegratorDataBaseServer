package fr.insa.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.util.List;

public class UsersDAOImp implements UsersDAO {

    Configuration configObj;

    public UsersDAOImp(){

        configObj = new Configuration().configure("hibernate.cfg.xml");

    }

    public void save(Users u) {
        Session sessionObj;
        SessionFactory sessionFactoryObj;

        sessionFactoryObj = configObj.buildSessionFactory();
        sessionObj = sessionFactoryObj.openSession();
        sessionObj.beginTransaction();
        sessionObj.save(u);
        System.out.println(u);
        sessionObj.getTransaction().commit();
        sessionObj.close();
    }

    @SuppressWarnings("unchecked")
    public Users find(Users u) {
        Session sessionObj;
        SessionFactory sessionFactoryObj;

        sessionFactoryObj = configObj.buildSessionFactory();
        sessionObj = sessionFactoryObj.openSession();
        sessionObj.beginTransaction();
        List<Users> personList = sessionObj.createQuery("FROM Users U WHERE U.login='"+u.getLogin()+"' AND U.password='"+u.getPassword()+"'").list();
        sessionObj.save(u);
        System.out.println("test" + personList);
        sessionObj.close();

        return (personList.size()==1)?personList.get(0):new Users(null,null,null,null,null);
    }

    @SuppressWarnings("unchecked")
    public List<Users> list() {
        Session sessionObj;
        SessionFactory sessionFactoryObj;

        sessionFactoryObj = configObj.buildSessionFactory();
        sessionObj = sessionFactoryObj.openSession();
        List<Users> personList = sessionObj.createQuery("FROM Users").list();
        System.out.println("qlq"+personList);
        sessionObj.close();
        return personList;
    }

}
