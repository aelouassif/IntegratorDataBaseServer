package fr.insa.model;

import java.util.List;

public interface PostsDAO {

    public void save(Posts p);
    public List<Posts> list();

    public void delete(Posts p);
    public Posts findById(int id);
}
