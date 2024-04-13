/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apoteklatte.sisfo.dao.impl;

import com.apoteklatte.sisfo.connection.HibernateUtil;
import com.apoteklatte.sisfo.dao.PasienDao;
import com.apoteklatte.sisfo.pojo.Pasien;
import com.apoteklatte.sisfo.utility.HibernateTemplate;
import java.util.List;
import org.hibernate.CacheMode;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author FredillaPrima
 */
public class PasienDaoImpl extends HibernateTemplate<Pasien> implements PasienDao {

    @Override
    public void save(Pasien pasien) {
        saveData(pasien);
    }

    @Override
    public List<Pasien> getListData() {
        Session session = HibernateUtil.getSessionFactory().openSession();
	Query query = session.createQuery("FROM Pasien WHERE isActive = 1 ORDER BY id")
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
    public Pasien getPasien(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
	Query query = session.createQuery("FROM Pasien WHERE id = :id AND isActive = 1");
        query.setInteger("id", id);
	try {
            if (query.list().isEmpty()) {
                return null;
            }
            return (Pasien) query.list().get(0);	
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
	Query query = session.createQuery("UPDATE Pasien SET isActive = 0 WHERE id = :id");
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
    public List<Pasien> getListDeletedData() {
        Session session = HibernateUtil.getSessionFactory().openSession();
	Query query = session.createQuery("FROM Pasien WHERE isActive = 0 ORDER BY id")
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
	Query query = session.createQuery("UPDATE Pasien SET isActive = 1 WHERE id = :id");
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
    public List<Pasien> getListData(String name) {
        Session session = HibernateUtil.getSessionFactory().openSession();
	Query query = session.createQuery("FROM Pasien WHERE namaPasien LIKE :name AND isActive = 1 ORDER BY id")
            .setCacheable(true)
            .setCacheMode(CacheMode.REFRESH)
            .setCacheRegion("frontpages");
        query.setString("name", "%" + name + "%");
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
