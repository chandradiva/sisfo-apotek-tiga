/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apoteklatte.sisfo.dao.impl;

import com.apoteklatte.sisfo.connection.HibernateUtil;
import com.apoteklatte.sisfo.dao.DokterDao;
import com.apoteklatte.sisfo.pojo.Dokter;
import com.apoteklatte.sisfo.utility.HibernateTemplate;
import java.util.List;
import org.hibernate.CacheMode;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author FredillaPrima
 */
public class DokterDaoImpl extends HibernateTemplate<Dokter> implements DokterDao {

    @Override
    public void save(Dokter dokter) {
        saveData(dokter);
    }

    @Override
    public List<Dokter> getListData() {
        Session session = HibernateUtil.getSessionFactory().openSession();
	Query query = session.createQuery("FROM Dokter WHERE isActive = 1 ORDER BY id")
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
    public Dokter getDokter(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
	Query query = session.createQuery("FROM Dokter WHERE id = :id AND isActive = 1");
        query.setInteger("id", id);
	try {
            if (query.list().isEmpty()) {
                return null;
            }
            return (Dokter) query.list().get(0);
	} catch (Exception e) {
            e.printStackTrace();
            return null;
	} finally {
            session.close();
	}
    }

    @Override
    public Dokter getDokter(String noIjinPraktek) {
        Session session = HibernateUtil.getSessionFactory().openSession();
	Query query = session.createQuery("FROM Dokter WHERE noIzinPraktek = :no AND isActive = 1");
        query.setString("no", noIjinPraktek);
	try {
            if (query.list().isEmpty()) {
                return null;
            }
            return (Dokter) query.list().get(0);
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
	Query query = session.createQuery("UPDATE Dokter SET isActive = 0 WHERE id = :id");
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
    public List<Dokter> getListDeletedData() {
        Session session = HibernateUtil.getSessionFactory().openSession();
	Query query = session.createQuery("FROM Dokter WHERE isActive = 0 ORDER BY id")
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
	Query query = session.createQuery("UPDATE Dokter SET isActive = 1 WHERE id = :id");
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
    public List<Dokter> getListData(String nama) {
        Session session = HibernateUtil.getSessionFactory().openSession();
	Query query = session.createQuery("FROM Dokter WHERE namaDokter LIKE :nama AND isActive = 1 ORDER BY id")
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
