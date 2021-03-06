package daos;

import java.util.List;

public interface CrudDAO <T> {
    int save(T obj);

    List<T> findAll();

    T findById(int id);

    List<T> findAllById();

    boolean update(T updatedObj);

    boolean removeById(String id);
}
