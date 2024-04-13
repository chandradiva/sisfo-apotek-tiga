/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apoteklatte.sisfo.dao.impl;

import com.apoteklatte.sisfo.connection.HibernateUtil;
import com.apoteklatte.sisfo.dao.SatuanObatDao;
import com.apoteklatte.sisfo.pojo.SatuanObat;
import com.apoteklatte.sisfo.utility.HibernateTemplate;
import java.util.List;
import org.hibernate.CacheMode;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author FredillaPrima
 */
public class SatuanObatDaoImpl extends HibernateTemplate<SatuanObat> implements SatuanObatDao {

    @Override
    public void save(SatuanObat satuanObat) {
        saveData(satuanObat);
    }

    @Override
    public List<SatuanObat> getListData() {
        Session session = HibernateUtil.getSessionFactory().openSession();
	Query query = session.createQuery("FROM SatuanObat ORDER BY id")
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
    public SatuanObat getSatuanObat(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
	Query query = session.createQuery("FROM SatuanObat WHERE id = :id");
        query.setInteger("id", id);
	try {
            if (query.list().isEmpty()) {
                return null;
            }
            return (SatuanObat) query.list().get(0);	
	} catch (Exception e) {
            e.printStackTrace();
            return null;
	} finally {
            session.close();
	}
    }
    
}
