package fr.insa.model;




import java.util.List;

public interface UsersDAO {

    public void save(Users u);
    public boolean exist(Users u);
    public List<Users> list();
}
