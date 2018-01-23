package fr.insa.model;

import java.util.List;

public interface CommentsDAO {
    public void save(Comments comments);
    public List<Comments> list();

    public void delete(Comments c);
    public Comments findById(int id);


}
