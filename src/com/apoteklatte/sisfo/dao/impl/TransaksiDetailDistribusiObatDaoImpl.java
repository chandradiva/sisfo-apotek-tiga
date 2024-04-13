/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apoteklatte.sisfo.dao.impl;

import com.apoteklatte.sisfo.connection.HibernateUtil;
import com.apoteklatte.sisfo.dao.TransaksiDetailDistribusiObatDao;
import com.apoteklatte.sisfo.pojo.TransaksiDetailDistribusiObat;
import com.apoteklatte.sisfo.utility.HibernateTemplate;
import java.util.List;
import org.hibernate.CacheMode;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Sony Vaio
 */
public class TransaksiDetailDistribusiObatDaoImpl extends HibernateTemplate<TransaksiDetailDistribusiObat> implements TransaksiDetailDistribusiObatDao {

    @Override
    public void save(TransaksiDetailDistribusiObat transaksiDetailDistribusiObat) {
        saveData(transaksiDetailDistribusiObat);
    }

    @Override
    public List<TransaksiDetailDistribusiObat> getListData() {
        Session session = HibernateUtil.getSessionFactory().openSession();
	Query query = session.createQuery("FROM TransaksiDetailDistribusiObat ORDER BY id")
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
    public List<TransaksiDetailDistribusiObat> getListData(int transId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
	Query query = session.createQuery("FROM TransaksiDetailDistribusiObat "
                + "WHERE transaksiDistribusiObat.id = :trans ORDER BY id")
            .setCacheable(true)
            .setCacheMode(CacheMode.REFRESH)
            .setCacheRegion("frontpages");
        query.setInteger("trans", transId);
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
    public List<TransaksiDetailDistribusiObat> getListDataByObat(int obatId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
	Query query = session.createQuery("FROM TransaksiDetailDistribusiObat "
                + "WHERE obat.id :obat ORDER BY id")
            .setCacheable(true)
            .setCacheMode(CacheMode.REFRESH)
            .setCacheRegion("frontpages");
        query.setInteger("obat", obatId);
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
    public TransaksiDetailDistribusiObat getTransaksiDetailDistribusiObat(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
	Query query = session.createQuery("FROM TransaksiDetailDistribusiObat WHERE id = :id")
            .setCacheable(true)
            .setCacheMode(CacheMode.REFRESH)
            .setCacheRegion("frontpages");
        query.setInteger("id", id);
	try {
            if (query.list().size() < 0) {
                return null;
            }
            return (TransaksiDetailDistribusiObat) query.list().get(0);
	} catch (Exception e) {
            e.printStackTrace();
            return null;
	} finally {
            session.close();
	}
    }

    @Override
    public boolean deleteData(int transId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
	Query query = session.createQuery("DELETE FROM TransaksiDetailDistribusiObat WHERE transaksiDistribusiObat.id = :trans");
        query.setInteger("trans", transId);
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
    
}
