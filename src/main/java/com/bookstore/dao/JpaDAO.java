package com.bookstore.dao;

import com.bookstore.entity.Users;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import java.io.ObjectStreamClass;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class JpaDAO<E> {
    private static EntityManagerFactory entityManagerFactory;

    static {
        entityManagerFactory = Persistence.createEntityManagerFactory("BookStoreWebsite");
    }

    public JpaDAO() {
    }

    public E create(E entity) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.flush();
        entityManager.refresh(entity);
        entityManager.getTransaction().commit();
        entityManager.close();
        return entity;
    }

//    @Override
    public E update(E entity) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entity = entityManager.merge(entity);
        entityManager.getTransaction().commit();
        entityManager.close();
        return entity;
    }

//    @Override
    public E get(Object id) {
        return null;
    }

    public E find(Class<E> type, Object id){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        E entity = entityManager.find(type, id);
        if (entity != null) {
            entityManager.refresh(entity);
        }
        entityManager.close();
        return entity;
    }

//    @Override
    public void delete(Class<E> type,Object id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Object reference = entityManager.getReference(type, id);
        entityManager.remove(reference);
        entityManager.getTransaction().commit();
        entityManager.close();

    }


//    @Override
    public List<E> listAll() {
        return null;
    }

//    @Override
    public long count() {
        return 0;
    }

    public List<E> findWithNamedQuery(String queryName) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Query query = entityManager.createNamedQuery(queryName);
        List<E> result = query.getResultList();

        entityManager.close();

        return result;
    }

    public List<E> findWithNamedQuery(String queryName, int firstResult, int maxResult) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Query query = entityManager.createNamedQuery(queryName);
        query.setFirstResult(firstResult);
        query.setMaxResults(maxResult);

        List<E> result = query.getResultList();

        entityManager.close();

        return result;
    }

    public List<Object[]> findWithNamedQueryObjects(String queryName, int firstResult, int maxResult) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Query query = entityManager.createNamedQuery(queryName);
        query.setFirstResult(firstResult);
        query.setMaxResults(maxResult);

        List<Object[]> result = query.getResultList();

        entityManager.close();

        return result;
    }

    public List<E> findWithNamedQuery(String queryName, String paramName, Object paramValue) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.createNamedQuery(queryName);

        query.setParameter(paramName, paramValue);

        List<E> result = query.getResultList();

        entityManager.close();

        return result;
    }

    public List<E> findWithNamedQuery(String queryName, Map<String, Object> parameters) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.createNamedQuery(queryName);

        Set<Map.Entry<String, Object>> setParameters = parameters.entrySet();

        for (Map.Entry<String, Object> entry : setParameters) {
            query.setParameter(entry.getKey(), entry.getValue());
        }

        List<E> result = query.getResultList();

        entityManager.close();

        return result;
    }

    public long countWithNamedQuery(String queryName){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.createNamedQuery(queryName);
        long result = (long) query.getSingleResult();
        entityManager.close();
        return result;
    }

    public long countWithNamedQuery(String queryName, String paramName, Object paramValue) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.createNamedQuery(queryName);
        query.setParameter(paramName, paramValue);

        long result = (long) query.getSingleResult();
        entityManager.close();

        return result;
    }

    public void close() {
        if (entityManagerFactory != null) {
            entityManagerFactory.close();
        }
    }

}
