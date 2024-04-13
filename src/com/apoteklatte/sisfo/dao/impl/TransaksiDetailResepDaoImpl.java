/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apoteklatte.sisfo.dao.impl;

import com.apoteklatte.sisfo.connection.HibernateUtil;
import com.apoteklatte.sisfo.dao.TransaksiDetailResepDao;
import com.apoteklatte.sisfo.pojo.TransaksiDetailResep;
import com.apoteklatte.sisfo.utility.HibernateTemplate;
import java.util.Date;
import java.util.List;
import org.hibernate.CacheMode;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author FredillaPrima
 */
public class TransaksiDetailResepDaoImpl extends HibernateTemplate<TransaksiDetailResep> implements TransaksiDetailResepDao {

    @Override
    public void save(TransaksiDetailResep transaksiDetailResep) {
        saveData(transaksiDetailResep);
    }

    @Override
    public List<TransaksiDetailResep> getListData() {
        Session session = HibernateUtil.getSessionFactory().openSession();
	Query query = session.createQuery("FROM TransaksiDetailResep ORDER BY id")
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
    public List<TransaksiDetailResep> getListDataByResep(int resep) {
        Session session = HibernateUtil.getSessionFactory().openSession();
	Query query = session.createQuery("FROM TransaksiDetailResep WHERE transaksiResep.id = :resep ORDER BY id")
            .setCacheable(true)
            .setCacheMode(CacheMode.REFRESH)
            .setCacheRegion("frontpages");
        query.setInteger("resep", resep);
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
    public List<TransaksiDetailResep> getListDataByTgl(Date start, Date end) {
        Session session = HibernateUtil.getSessionFactory().openSession();
	Query query = session.createQuery("FROM TransaksiDetailResep WHERE tglObatHabis BETWEEN :start AND :end ORDER BY id")
            .setCacheable(true)
            .setCacheMode(CacheMode.REFRESH)
            .setCacheRegion("frontpages");
        query.setDate("start", start);
        query.setDate("end", end);
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
    public TransaksiDetailResep getTransaksiDetailResep(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
	Query query = session.createQuery("FROM TransaksiDetailResep WHERE id = :id");
        query.setInteger("id", id);
	try {
            if (query.list().isEmpty()) {
                return null;
            }
            return (TransaksiDetailResep) query.list().get(0);
	} catch (Exception e) {
            e.printStackTrace();
            return null;
	} finally {
            session.close();
	}
    }

    @Override
    public List<TransaksiDetailResep> getListDataByDokter(int dokterId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
	Query query = session.createQuery("FROM TransaksiDetailResep WHERE transaksiResep.dokter.id = :dokter ORDER BY id")
            .setCacheable(true)
            .setCacheMode(CacheMode.REFRESH)
            .setCacheRegion("frontpages");
        query.setInteger("dokter", dokterId);
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
    public List<TransaksiDetailResep> getListDataByPasien(String name) {
        Session session = HibernateUtil.getSessionFactory().openSession();
	Query query = session.createQuery("FROM TransaksiDetailResep WHERE transaksiResep.pasien.namaPasien LIKE :pasien ORDER BY id")
            .setCacheable(true)
            .setCacheMode(CacheMode.REFRESH)
            .setCacheRegion("frontpages");
        query.setString("pasien", "%" + name + "%");
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
    public boolean deleteData(int resepId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
	Query query = session.createQuery("DELETE FROM TransaksiDetailResep WHERE transaksiResep.id = :resep");
        query.setInteger("resep", resepId);
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
