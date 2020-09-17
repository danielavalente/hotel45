package org.queuecumbers.hotel45.persistence.dao;

import java.util.List;

public interface Dao<T> {

    public List<T> findAll();
    public T findById (Integer id);
    public T saveOrUpdate (T object);
    public void delete(Integer id);

}
