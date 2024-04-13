/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apoteklatte.sisfo.dao;

import com.apoteklatte.sisfo.pojo.Pasien;
import java.util.List;

/**
 *
 * @author FredillaPrima
 */
public interface PasienDao {
    
    void save(Pasien pasien);
    List<Pasien> getListData();
    Pasien getPasien(int id);
    boolean delete(int id);
    
    List<Pasien> getListDeletedData();
    boolean restore(int id);
    List<Pasien> getListData(String name);
}
