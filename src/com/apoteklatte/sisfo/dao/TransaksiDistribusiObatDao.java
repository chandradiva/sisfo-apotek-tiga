/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apoteklatte.sisfo.dao;

import com.apoteklatte.sisfo.pojo.TransaksiDistribusiObat;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Sony Vaio
 */
public interface TransaksiDistribusiObatDao {

    void save(TransaksiDistribusiObat transaksiDistribusiObat);
    List<TransaksiDistribusiObat> getListData();
    List<TransaksiDistribusiObat> getListDataByDistributor(int distId);
    List<TransaksiDistribusiObat> getListDataByRangeTanggal(Date start, Date end);
    List<TransaksiDistribusiObat> getListDataByRangeBulan(int start, int end);
    List<TransaksiDistribusiObat> getListDataByTahun(int tahun);
    TransaksiDistribusiObat getTransaksiDistribusiObat(int id);
    
    List<TransaksiDistribusiObat> getListDataByRangeBulanDistributor(int tahun, int start, int end, String dist);
    List<TransaksiDistribusiObat> getListDataHistory();
    List<TransaksiDistribusiObat> getListDataByDistributor(String distName);
}
