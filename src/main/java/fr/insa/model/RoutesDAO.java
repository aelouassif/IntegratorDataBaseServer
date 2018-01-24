package fr.insa.model;

import java.util.List;

public interface RoutesDAO {
    public void save(Routes route);
    public List<Routes> list();

    public void delete(Routes r);
    public Routes findById(int id);

}
