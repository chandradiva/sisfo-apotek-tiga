/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apoteklatte.sisfo.dao;

import com.apoteklatte.sisfo.pojo.DistributorObat;
import java.util.List;

/**
 *
 * @author FredillaPrima
 */
public interface DistributorObatDao {
    
    void save(DistributorObat distributorObat);
    List<DistributorObat> getListData();
    DistributorObat getDistributorObat(int id);
    boolean delete(int id);
    
    List<DistributorObat> getListDeletedData();
    boolean restore(int id);
    List<DistributorObat> getListData(String nama);
}
