/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apoteklatte.sisfo.dao;

import com.apoteklatte.sisfo.pojo.MasterObat;
import java.util.List;

/**
 *
 * @author FredillaPrima
 */
public interface MasterObatDao {

    void save(MasterObat masterObat);
    List<MasterObat> getListData();
    MasterObat getMasterObat(int id);
    boolean delete(int id);
    
    List<MasterObat> getListDeletedData();
    boolean restore(int id);
    List<MasterObat> getListData(String nama);
}
