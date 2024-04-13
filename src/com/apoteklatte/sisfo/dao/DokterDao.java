/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apoteklatte.sisfo.dao;

import com.apoteklatte.sisfo.pojo.Dokter;
import java.util.List;

/**
 *
 * @author FredillaPrima
 */
public interface DokterDao {
    
    void save(Dokter dokter);
    List<Dokter> getListData();
    Dokter getDokter(int id);
    Dokter getDokter(String noIjinPraktek);
    boolean delete(int id);
    
    List<Dokter> getListDeletedData();
    boolean restore(int id);
    List<Dokter> getListData(String nama);
}
