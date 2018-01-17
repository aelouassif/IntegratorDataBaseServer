package fr.insa.model;


import javax.persistence.*;

@Entity
@Table(name="Posts")
public class Posts{
    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    private String date;
    private String position;
    private String content;

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

    public Posts(String date, String position, String content) {

        this.date = date;
        this.position = position;
        this.content = content;
    }
}