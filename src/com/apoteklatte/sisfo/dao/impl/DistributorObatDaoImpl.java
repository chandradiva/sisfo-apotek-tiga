/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apoteklatte.sisfo.dao.impl;

import com.apoteklatte.sisfo.connection.HibernateUtil;
import com.apoteklatte.sisfo.dao.DistributorObatDao;
import com.apoteklatte.sisfo.pojo.DistributorObat;
import com.apoteklatte.sisfo.utility.HibernateTemplate;
import java.util.List;
import org.hibernate.CacheMode;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author FredillaPrima
 */
public class DistributorObatDaoImpl extends HibernateTemplate<DistributorObat> implements DistributorObatDao {

    @Override
    public void save(DistributorObat distributorObat) {
        saveData(distributorObat);
    }

    @Override
    public List<DistributorObat> getListData() {
        Session session = HibernateUtil.getSessionFactory().openSession();
	Query query = session.createQuery("FROM DistributorObat WHERE isActive = 1 ORDER BY id")
            .setCacheable(true)
            .setCacheMode(CacheMode.REFRESH)
            .setCacheRegion("frontpages");
	try {
            return query.list();	
	} catch (Exception e) {
            e.printStackTrace();
            return null;
	} finally {
            session.close();
	}
    }

    @Override
    public DistributorObat getDistributorObat(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
	Query query = session.createQuery("FROM DistributorObat WHERE id = :id AND isActive = 1");
        query.setInteger("id", id);
	try {
            if (query.list().isEmpty()) {
                return null;
            }
            return (DistributorObat) query.list().get(0);	
	} catch (Exception e) {
            e.printStackTrace();
            return null;
	} finally {
            session.close();
	}
    }

    @Override
    public boolean delete(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
	Query query = session.createQuery("UPDATE DistributorObat SET isActive = 0 WHERE id =:id");
        query.setInteger("id", id);
	try {
            if (query.executeUpdate() == 1) {
                return true;
            } else {
                return false;
            }
	} catch (Exception e) {
            e.printStackTrace();
            return false;
	} finally {
            session.close();
	}
    }

    @Override
    public List<DistributorObat> getListDeletedData() {
        Session session = HibernateUtil.getSessionFactory().openSession();
	Query query = session.createQuery("FROM DistributorObat WHERE isActive = 0 ORDER BY id")
            .setCacheable(true)
            .setCacheMode(CacheMode.REFRESH)
            .setCacheRegion("frontpages");
	try {
            return query.list();	
	} catch (Exception e) {
            e.printStackTrace();
            return null;
	} finally {
            session.close();
	}
    }

    @Override
    public boolean restore(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
	Query query = session.createQuery("UPDATE DistributorObat SET isActive = 1 WHERE id = :id");
        query.setInteger("id", id);
	try {
            if (query.executeUpdate() == 1) {
                return true;
            } else {
                return false;
            }
	} catch (Exception e) {
            e.printStackTrace();
            return false;
	} finally {
            session.close();
	}
    }

    @Override
    public List<DistributorObat> getListData(String nama) {
        Session session = HibernateUtil.getSessionFactory().openSession();
	Query query = session.createQuery("FROM DistributorObat WHERE namaDistributor LIKE :nama AND isActive = 1 ORDER BY id")
            .setCacheable(true)
            .setCacheMode(CacheMode.REFRESH)
            .setCacheRegion("frontpages");
        query.setString("nama", "%" + nama + "%");
	try {
            return query.list();	
	} catch (Exception e) {
            e.printStackTrace();
            return null;
	} finally {
            session.close();
	}
   
    }   
}
