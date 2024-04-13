/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apoteklatte.sisfo.dao;

import com.apoteklatte.sisfo.pojo.TransaksiResep;
import java.util.Date;
import java.util.List;

/**
 *
 * @author FredillaPrima
 */
public interface TransaksiResepDao {
    
    void save(TransaksiResep transaksiResep);
    List<TransaksiResep> getListData();
    List<TransaksiResep> getListDataByDokter(int dokter);
    List<TransaksiResep> getListDataByPasien(int pasien);
    TransaksiResep getTransaksiResep(int id);
    
    List<TransaksiResep> getListData(int start, int end, int tahun, String pasien);
    List<TransaksiResep> getListData(Date start, Date end);
    List<TransaksiResep> getListData(String pasien);
}
