package org.queuecumbers.hotel45.persistence.dao;

public abstract class GenericJpaDao<T> {

    private T modelType;

    public GenericJpaDao(T modelType) {
        this.modelType = modelType;
    };

    public T findAll() {

    };

    public T findById(Integer id) {

    };

    public T saveOrUpdate(T modelType) {

    };

    public T delete(Integer id) {

    };


}


