/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apoteklatte.sisfo.dao.impl;

import com.apoteklatte.sisfo.connection.HibernateUtil;
import com.apoteklatte.sisfo.dao.TransaksiResepDao;
import com.apoteklatte.sisfo.pojo.TransaksiResep;
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
public class TransaksiResepDaoImpl extends HibernateTemplate <TransaksiResep> implements TransaksiResepDao {

    @Override
    public void save(TransaksiResep transaksiResep) {
        saveData(transaksiResep);
    }

    @Override
    public List<TransaksiResep> getListData() {
        Session session = HibernateUtil.getSessionFactory().openSession();
	Query query = session.createQuery("FROM TransaksiResep ORDER BY id DESC")
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
    public List<TransaksiResep> getListDataByDokter(int dokter) {
        Session session = HibernateUtil.getSessionFactory().openSession();
	Query query = session.createQuery("FROM TransaksiResep WHERE dokter.id = :dokter ORDER BY id")
            .setCacheable(true)
            .setCacheMode(CacheMode.REFRESH)
            .setCacheRegion("frontpages");
        query.setInteger("dokter", dokter);
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
    public List<TransaksiResep> getListDataByPasien(int pasien) {
        Session session = HibernateUtil.getSessionFactory().openSession();
	Query query = session.createQuery("FROM TransaksiResep WHERE pasien.id = :pasien ORDER BY id")
            .setCacheable(true)
            .setCacheMode(CacheMode.REFRESH)
            .setCacheRegion("frontpages");
        query.setInteger("pasien", pasien);
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
    public TransaksiResep getTransaksiResep(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
	Query query = session.createQuery("FROM TransaksiResep WHERE id = :id");
        query.setInteger("id", id);
	try {
            if (query.list().isEmpty()) {
                return null;
            }
            return (TransaksiResep) query.list().get(0);
	} catch (Exception e) {
            e.printStackTrace();
            return null;
	} finally {
            session.close();
	}
    }

    @Override
    public List<TransaksiResep> getListData(int start, int end, int tahun, String pasien) {
        Session session = HibernateUtil.getSessionFactory().openSession();
	Query query = session.createQuery("FROM TransaksiResep WHERE "
                + "MONTH(tglPembuatan) BETWEEN :start AND :end AND "
                + "YEAR(tglPembuatan) = :thn AND "
                + "pasien.namaPasien LIKE :pasien ORDER BY id")
            .setCacheable(true)
            .setCacheMode(CacheMode.REFRESH)
            .setCacheRegion("frontpages");
        
        query.setInteger("start", start);
        query.setInteger("end", end);
        query.setInteger("thn", tahun);
        query.setString("pasien", "%" + pasien + "%");
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
    public List<TransaksiResep> getListData(Date start, Date end) {
        Session session = HibernateUtil.getSessionFactory().openSession();
	Query query = session.createQuery("FROM TransaksiResep "
                + "WHERE tglPembuatan BETWEEN :start AND :end ORDER BY id")
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
    public List<TransaksiResep> getListData(String pasien) {
        Session session = HibernateUtil.getSessionFactory().openSession();
	Query query = session.createQuery("FROM TransaksiResep WHERE pasien.namaPasien LIKE :pasien ORDER BY id DESC")
            .setCacheable(true)
            .setCacheMode(CacheMode.REFRESH)
            .setCacheRegion("frontpages");
        query.setString("pasien", "%" + pasien + "%");
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
    public TransaksiResep getLatestByPasien(long pasienId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
	Query query = session.createQuery("FROM TransaksiResep WHERE pasien.id = :pasienId ORDER BY id DESC");
        
        query.setMaxResults(1);
        query.setLong("pasienId", pasienId);
        
	try {
            if (query.list().isEmpty()) {
                return null;
            }
            
            return (TransaksiResep) query.list().get(0);
	} catch (Exception e) {
            e.printStackTrace();
            return null;
	} finally {
            session.close();
	}
    }

    @Override
    public List<TransaksiResep> getListDataByPasienDesc(long pasienId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
	Query query = session.createQuery("FROM TransaksiResep WHERE pasien.id = :pasienId ORDER BY id DESC")
            .setCacheable(true)
            .setCacheMode(CacheMode.REFRESH)
            .setCacheRegion("frontpages");
        query.setLong("pasienId", pasienId);
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
