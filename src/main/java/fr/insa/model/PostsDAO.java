package fr.insa.model;

import java.util.List;

public interface PostsDAO {

    public void save(Posts p);
    public List<Posts> list();
}
