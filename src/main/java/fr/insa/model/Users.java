package fr.insa.model;


import javafx.geometry.Pos;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="Users")
public class Users implements Serializable{
    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    private String login;
    private String password;

    private String first_name;
    private String last_name;
    private String email;

    @OneToMany(mappedBy="user",cascade = CascadeType.ALL)
    private List<Posts> posts;
    @ManyToMany(mappedBy="users",cascade = CascadeType.ALL)
    private List<Routes> routes;
    @OneToMany(mappedBy="user",cascade = CascadeType.ALL)
    private List<Comments> comments;

    public Users(String login, String password, String first_name, String last_name, String email, List<Posts> posts, List<Routes> routes, List<Comments> comments) {
        this.login = login;
        this.password = password;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.posts = posts;
        this.routes = routes;
        this.comments = comments;
    }

    public List<Posts> getPosts() {
        return posts;
    }

    public void setPosts(List<Posts> posts) {
        this.posts = posts;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }


    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Users() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}