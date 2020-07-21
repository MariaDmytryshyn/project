package app.services;

import java.util.List;

public interface Service<T> {
    T findOne(int id);

    List<T> findAll();

    T insert(T entity);

    boolean update(T entity);

    boolean deleteById(int entityId);


}
