package com.bookstore.dao;

import jakarta.persistence.EntityManager;

import java.util.List;

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
}
