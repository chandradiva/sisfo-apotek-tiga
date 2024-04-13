/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apoteklatte.sisfo.dao.impl;

import com.apoteklatte.sisfo.connection.HibernateUtil;
import com.apoteklatte.sisfo.dao.MasterObatDao;
import com.apoteklatte.sisfo.pojo.MasterObat;
import com.apoteklatte.sisfo.utility.HibernateTemplate;
import java.util.List;
import org.hibernate.CacheMode;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author FredillaPrima
 */
public class MasterObatDaoImpl extends HibernateTemplate<MasterObat> implements MasterObatDao {

    @Override
    public void save(MasterObat masterObat) {
        saveData(masterObat);
    }

    @Override
    public List<MasterObat> getListData() {
        Session session = HibernateUtil.getSessionFactory().openSession();
	Query query = session.createQuery("FROM MasterObat WHERE isActive = 1 ORDER BY id")
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
    public MasterObat getMasterObat(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
	Query query = session.createQuery("FROM MasterObat WHERE id = :id isActive = 1 ORDER BY id");
        query.setInteger("id", id);
	try {
            if (query.list().isEmpty()) {
                return null;
            }
            return (MasterObat) query.list().get(0);	
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
	Query query = session.createQuery("UPDATE MasterObat SET isActive = 0 WHERE id = :id");
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
    public List<MasterObat> getListDeletedData() {
        Session session = HibernateUtil.getSessionFactory().openSession();
	Query query = session.createQuery("FROM MasterObat WHERE isActive = 0 ORDER BY id")
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
	Query query = session.createQuery("UPDATE MasterObat SET isActive = 1 WHERE id = :id");
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
    public List<MasterObat> getListData(String nama) {
        Session session = HibernateUtil.getSessionFactory().openSession();
	Query query = session.createQuery("FROM MasterObat WHERE namaObat LIKE :param AND isActive = 1 ORDER BY id")
            .setCacheable(true)
            .setCacheMode(CacheMode.REFRESH)
            .setCacheRegion("frontpages");
        query.setString("param", "%" + nama + "%");
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
