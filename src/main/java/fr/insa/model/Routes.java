package fr.insa.model;

import javax.persistence.Entity;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="Routes")
public class Routes implements Serializable {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    private String date;
    private String x_start,y_start,x_end,y_end;

    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Users> users;

    public Routes(String date, String x_start, String y_start, String x_end, String y_end, List<Users> users) {
        this.date = date;
        this.x_start = x_start;
        this.y_start = y_start;
        this.x_end = x_end;
        this.y_end = y_end;
        this.users = users;
    }

    public Routes() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getX_start() {
        return x_start;
    }

    public void setX_start(String x_start) {
        this.x_start = x_start;
    }

    public String getY_start() {
        return y_start;
    }

    public void setY_start(String y_start) {
        this.y_start = y_start;
    }

    public String getX_end() {
        return x_end;
    }

    public void setX_end(String x_end) {
        this.x_end = x_end;
    }

    public String getY_end() {
        return y_end;
    }

    public void setY_end(String y_end) {
        this.y_end = y_end;
    }

    public List<Users> getUsers() {
        return users;
    }

    public void setUsers(List<Users> users) {
        this.users = users;
    }
}