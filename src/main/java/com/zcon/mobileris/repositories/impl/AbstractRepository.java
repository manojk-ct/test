package com.zcon.mobileris.repositories.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author ManojK
 * @param <PK>
 * @param <T>
 */
public class AbstractRepository<PK extends Serializable, T> {

    @Autowired
    private SessionFactory sessionFactory;

    private final Class<T> persistentClass;

    @SuppressWarnings("unchecked")
    public AbstractRepository() {
        this.persistentClass = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
    }

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public T getByKey(PK key) {
        return (T) getSession().get(persistentClass, key);
    }

    public void persist(T entity) {
        getSession().persist(entity);
    }

    public void update(T entity) {
        getSession().update(entity);
    }

    public void delete(T entity) {
        getSession().delete(entity);
    }

    public Criteria createCriteria() {
        return getSession().createCriteria(persistentClass);
    }
}
