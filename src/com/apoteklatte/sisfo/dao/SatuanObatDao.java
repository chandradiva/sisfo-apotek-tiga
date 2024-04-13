/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apoteklatte.sisfo.dao;

import com.apoteklatte.sisfo.pojo.SatuanObat;
import java.util.List;

/**
 *
 * @author FredillaPrima
 */
public interface SatuanObatDao {
    
    void save(SatuanObat satuanObat);
    List<SatuanObat> getListData();
    SatuanObat getSatuanObat(int id);
}
