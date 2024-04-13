/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apoteklatte.sisfo.dao;

import com.apoteklatte.sisfo.pojo.TransaksiDetailDistribusiObat;
import java.util.List;

/**
 *
 * @author Sony Vaio
 */
public interface TransaksiDetailDistribusiObatDao {

    void save(TransaksiDetailDistribusiObat transaksiDetailDistribusiObat);
    List<TransaksiDetailDistribusiObat> getListData();
    List<TransaksiDetailDistribusiObat> getListData(int transId);
    List<TransaksiDetailDistribusiObat> getListDataByObat(int obatId);
    TransaksiDetailDistribusiObat getTransaksiDetailDistribusiObat(int id);
    
    boolean deleteData(int transId);
}
