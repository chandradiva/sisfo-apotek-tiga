/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apoteklatte.sisfo.dao;

import com.apoteklatte.sisfo.pojo.TransaksiDetailResep;
import java.util.Date;
import java.util.List;

/**
 *
 * @author FredillaPrima
 */
public interface TransaksiDetailResepDao {
    
    void save(TransaksiDetailResep transaksiDetailResep);
    List<TransaksiDetailResep> getListData();
    List<TransaksiDetailResep> getListDataByResep(int resep);
    List<TransaksiDetailResep> getListDataByTgl(Date start, Date end);
    TransaksiDetailResep getTransaksiDetailResep(int id);
    
    List<TransaksiDetailResep> getListDataByDokter(int dokterId);
    List<TransaksiDetailResep> getListDataByPasien(String name);
    List<TransaksiDetailResep> getListDataByPasien(long pasienId, long resepId);
    boolean deleteData(int resepId);
}
