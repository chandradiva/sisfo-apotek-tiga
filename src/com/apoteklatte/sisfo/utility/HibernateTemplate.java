/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apoteklatte.sisfo.utility;

import com.apoteklatte.sisfo.connection.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author FredillaPrima
 */
public class HibernateTemplate <T>{
    
    private SessionFactory sessionFactory;
    
    public SessionFactory getSessionFactory() {
	return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
	
    public boolean saveData(Object object) throws HibernateException{
	Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.saveOrUpdate(object);
            transaction.commit();
            return true;
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
            System.out.println(e.getMessage());
            throw e;
        } finally {
            session.close();
        }
    }
	
    public boolean deleteData(Object object){
	Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.delete(object);
            transaction.commit();
            return true;
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
            throw e;
        } finally {
            session.close();
        }
    }
	
    public List<T> findData(String hql, int startPosition, int maxResult){
	Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            Query query = session.createQuery(hql);
            query.setFirstResult(startPosition);
            query.setMaxResults(maxResult);
            return findData(query);
        } catch (HibernateException e) {
            e.printStackTrace();
            throw e;
        } finally {
            session.close();
        }
    }
	
    public List<T> findData(Query query){
        try {
            @SuppressWarnings("unchecked")
            List<T> list=query.list();
            return list;
        } catch (HibernateException e) {
            e.printStackTrace();
            throw e;
        }
    }
	
    public boolean updateData(Object object){
	Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.saveOrUpdate(object);
            transaction.commit();
            return true;
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
            throw e;
        } finally {
            session.close();
        }
    }
}
