package app.model.dao;

import java.util.List;


public interface Dao<T> {

    T findOne(int id);

    List<T> findAll();

    T insert(T entity);

    boolean update(T entity);

    boolean deleteById(int entityId);
}
