/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apoteklatte.sisfo.dao.impl;

import com.apoteklatte.sisfo.connection.HibernateUtil;
import com.apoteklatte.sisfo.dao.TransaksiDistribusiObatDao;
import com.apoteklatte.sisfo.pojo.TransaksiDistribusiObat;
import com.apoteklatte.sisfo.utility.HibernateTemplate;
import java.util.Date;
import java.util.List;
import org.hibernate.CacheMode;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Sony Vaio
 */
public class TransaksiDistribusiObatDaoImpl extends HibernateTemplate<TransaksiDistribusiObat> implements TransaksiDistribusiObatDao {

    @Override
    public void save(TransaksiDistribusiObat transaksiDistribusiObat) {
        saveData(transaksiDistribusiObat);
    }

    @Override
    public List<TransaksiDistribusiObat> getListData() {
        Session session = HibernateUtil.getSessionFactory().openSession();
	Query query = session.createQuery("FROM TransaksiDistribusiObat ORDER BY id DESC")
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
    public List<TransaksiDistribusiObat> getListDataByDistributor(int distId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
	Query query = session.createQuery("FROM TransaksiDistribusiObat "
                + "WHERE distributorObat.id = :dist ORDER BY id")
            .setCacheable(true)
            .setCacheMode(CacheMode.REFRESH)
            .setCacheRegion("frontpages");
        query.setInteger("dist", distId);
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
    public List<TransaksiDistribusiObat> getListDataByRangeTanggal(Date start, Date end) {
        Session session = HibernateUtil.getSessionFactory().openSession();
	Query query = session.createQuery("FROM TransaksiDistribusiObat "
                + "WHERE tanggalDistribusi BETWEEN :start AND :end ORDER BY id")
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
    public List<TransaksiDistribusiObat> getListDataByRangeBulan(int start, int end) {
        Session session = HibernateUtil.getSessionFactory().openSession();
	Query query = session.createQuery("FROM TransaksiDistribusiObat "
                + "WHERE MONTH(tanggalDistribusi) BETWEEN :start AND :end ORDER BY id")
            .setCacheable(true)
            .setCacheMode(CacheMode.REFRESH)
            .setCacheRegion("frontpages");
        query.setInteger("start", start);
        query.setInteger("end", end);
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
    public List<TransaksiDistribusiObat> getListDataByTahun(int tahun) {
        Session session = HibernateUtil.getSessionFactory().openSession();
	Query query = session.createQuery("FROM Dokter TransaksiDistribusiObat "
                + "WHERE YEAR(tanggalDistribusi) = :thn ORDER BY id")
            .setCacheable(true)
            .setCacheMode(CacheMode.REFRESH)
            .setCacheRegion("frontpages");
        query.setInteger("thn", tahun);
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
    public TransaksiDistribusiObat getTransaksiDistribusiObat(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
	Query query = session.createQuery("FROM TransaksiDistribusiObat WHERE id = :id")
            .setCacheable(true)
            .setCacheMode(CacheMode.REFRESH)
            .setCacheRegion("frontpages");
        query.setInteger("id", id);
	try {
            if (query.list().size() < 0) {
                return null;
            }
            return (TransaksiDistribusiObat) query.list().get(0);
	} catch (Exception e) {
            e.printStackTrace();
            return null;
	} finally {
            session.close();
	}
    }

    @Override
    public List<TransaksiDistribusiObat> getListDataByRangeBulanDistributor(int tahun, int start, int end, String dist) {
        Session session = HibernateUtil.getSessionFactory().openSession();
	Query query = session.createQuery("FROM TransaksiDistribusiObat "
                + "WHERE YEAR(tanggalDistribusi) = :thn "
                + "AND MONTH(tanggalDistribusi) BETWEEN :start AND :end "
                + "AND distributorObat.namaDistributor LIKE :dist ORDER BY id")
            .setCacheable(true)
            .setCacheMode(CacheMode.REFRESH)
            .setCacheRegion("frontpages");
        query.setInteger("thn", tahun);
        query.setInteger("start", start);
        query.setInteger("end", end);
        query.setString("dist", "%" + dist + "%");
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
    public List<TransaksiDistribusiObat> getListDataHistory() {
        Session session = HibernateUtil.getSessionFactory().openSession();
	Query query = session.createQuery("FROM TransaksiDistribusiObat ORDER BY id DESC")
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
    public List<TransaksiDistribusiObat> getListDataByDistributor(String distName) {
        Session session = HibernateUtil.getSessionFactory().openSession();
	Query query = session.createQuery("FROM TransaksiDistribusiObat "
                + "WHERE distributorObat.namaDistributor LIKE :dist ORDER BY id")
            .setCacheable(true)
            .setCacheMode(CacheMode.REFRESH)
            .setCacheRegion("frontpages");
        query.setString("dist", "%" + distName + "%");
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
