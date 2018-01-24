package fr.insa.model;

import java.util.List;

public interface UsersDAO {

    public void save(Users u);
    public void update(Users u);
    public void delete(Users u);
    public Users find(Users u);
    public Users findById(int i);
    public List<Users> list();
}
