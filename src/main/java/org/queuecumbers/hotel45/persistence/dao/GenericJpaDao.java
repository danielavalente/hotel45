package org.queuecumbers.hotel45.persistence.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public abstract class GenericJpaDao<T> implements Dao<T> {

    private Class<T> modelType;

    @PersistenceContext
    protected EntityManager em;

    public GenericJpaDao(Class<T> modelType){
        this.modelType = modelType;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<T> findAll() {
        return null;
    }

    @Override
    public T findById(Integer id) {
        return null;
    }

    @Override
    public T saveOrUpdate(T object) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }
}


