package com.javarush.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class GenericDao<T> {
    private final Class<T> tClass;
    private SessionFactory sessionFactory;

    public GenericDao(Class<T> tClass, SessionFactory sessionFactory) {
        this.tClass = tClass;
        this.sessionFactory = sessionFactory;
    }

    public T getById(final int id) {
        return getCurrentSession().get(tClass, id);
    }

    public List<T> getItems(int offset, int count) {
        Query<T> query = getCurrentSession().createQuery("from " + tClass.getName(), tClass);
        query.setFirstResult(offset);
        query.setMaxResults(count);
        return query.list();
    }

    public List<T> findAll() {
        return getCurrentSession().createQuery("from" + tClass.getName()).list();
    }

    public T save(T entity) {
        getCurrentSession().saveOrUpdate(entity);
        return entity;
    }

    public T update(final T entity) {
        return (T) getCurrentSession().merge(entity);
    }

    public void delete(final T entity) {
        getCurrentSession().delete(entity);
    }

    public void deleteById(int id) {
       final T entity = getById(id);
       getCurrentSession().delete(entity);
    }

    public Session getCurrentSession() {
        return sessionFactory.openSession();
    }

}
