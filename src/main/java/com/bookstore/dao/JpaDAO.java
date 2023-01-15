package com.bookstore.dao;

import com.bookstore.entity.Users;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.io.ObjectStreamClass;
import java.util.List;
import java.util.Map;

public class JpaDAO<E> {
    protected EntityManager entityManager;

    public JpaDAO(EntityManager entityManager) {
        super();
        this.entityManager = entityManager;
    }

//    @Override
    public E create(E entity) {
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.flush();
        entityManager.refresh(entity);
        entityManager.getTransaction().commit();
        return entity;
    }

//    @Override
    public E update(E entity) {
        entityManager.getTransaction().begin();
        entity = entityManager.merge(entity);
        entityManager.getTransaction().commit();
        return entity;
    }

//    @Override
    public E get(Object id) {
        return null;
    }

    public E find(Class<E> type, Object id){
        E entity = entityManager.find(type, id);
        entityManager.refresh(entity);
        return entity;
    }

//    @Override
    public void delete(Class<E> type,Object id) {
        entityManager.getTransaction().begin();
        Object reference = entityManager.getReference(type, id);
        entityManager.remove(reference);
        entityManager.getTransaction().commit();

    }


//    @Override
    public List<E> listAll() {
        return null;
    }

//    @Override
    public long count() {
        return 0;
    }

    public List<E> findWithNamedQuery(String queryName){
        Query query = entityManager.createNamedQuery(queryName);
        return query.getResultList();
    }

    public List<E> findWithNamedQuery(String queryName, String paramName, Object paramValue){
        Query query = entityManager.createNamedQuery(queryName);
        query.setParameter(paramName, paramValue);
        return query.getResultList();

    }

//    public long countWithNamedQuery(String queryName){
//        Query query = entityManager.createNamedQuery(queryName);
//        return (long) query.getSingleResult();
//    }

}
