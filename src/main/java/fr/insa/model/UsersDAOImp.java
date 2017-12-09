package fr.insa.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.util.List;

public class UsersDAOImp implements UsersDAO {

    private SessionFactory sessionFactory;
    static Session sessionObj;
    static SessionFactory sessionFactoryObj;

    public UsersDAOImp(){
        Configuration configObj = new Configuration();
        configObj.configure("hibernate.cfg.xml");
        ServiceRegistry serviceRegistryObj = new StandardServiceRegistryBuilder().applySettings(configObj.getProperties()).build();
        sessionFactoryObj = configObj.buildSessionFactory(serviceRegistryObj);


    }

    public void save(Users u) {
        sessionObj = sessionFactoryObj.openSession();
        sessionObj.beginTransaction();
        sessionObj.save(u);
        sessionObj.getTransaction().commit();
        sessionObj.close();
    }

    @SuppressWarnings("unchecked")
    public Users find(Users u) {
        sessionObj = sessionFactoryObj.openSession();
        sessionObj.beginTransaction();
        List<Users> personList = sessionObj.createQuery("FROM Users U WHERE U.login='"+u.getLogin()+"' AND U.password='"+u.getPassword()+"'").list();
        sessionObj.save(u);
        System.out.println("test" + personList);
        sessionObj.close();

        return (personList.size()==1)?personList.get(0):new Users(null,null);
    }

    @SuppressWarnings("unchecked")
    public List<Users> list() {
        sessionObj = sessionFactoryObj.openSession();
        List<Users> personList = sessionObj.createQuery("FROM Users").list();
        System.out.println("qlq"+personList);
        sessionObj.close();
        return personList;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
