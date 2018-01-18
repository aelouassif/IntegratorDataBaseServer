package fr.insa.model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="Posts")
public class Posts implements Serializable{
    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    private String date;
    private String position;
    private String content;


    @ManyToOne()
    private Users user;
    @OneToMany(cascade = CascadeType.ALL,mappedBy="post",fetch = FetchType.EAGER)
    private List<Comments> comment;

    public Posts(String date, String position, String content, Users user, List<Comments> comment) {
        this.date = date;
        this.position = position;
        this.content = content;
        this.user = user;
        this.comment = comment;
    }

    public List<Comments> getComment() {
        return comment;
    }

    public void setComment(List<Comments> comment) {
        this.comment = comment;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Posts() {
    }

}