/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apoteklatte.sisfo.abstractmodel.table;

import com.apoteklatte.sisfo.dao.impl.SatuanObatDaoImpl;
import com.apoteklatte.sisfo.pojo.SatuanObat;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Sony Vaio
 */
public class AbsTableSatuanObat extends AbstractTableModel{

    private List<SatuanObat> listSatuanObat;
    private SatuanObatDaoImpl satuanObatDaoImpl;

    public AbsTableSatuanObat(SatuanObatDaoImpl satuanObatDaoImpl) {
        this.satuanObatDaoImpl = satuanObatDaoImpl;
    }

    public List<SatuanObat> getListSatuanObat() {
        return listSatuanObat;
    }

    public void setListSatuanObat(List<SatuanObat> listSatuanObat) {
        this.listSatuanObat = listSatuanObat;
    }
    
    @Override
    public int getRowCount() {
        return listSatuanObat.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (columnIndex == 0) {
            return listSatuanObat.get(rowIndex).getId();
        } else if (columnIndex == 1) {
            return listSatuanObat.get(rowIndex).getName();
        } else {
            return listSatuanObat.get(rowIndex).getDescription();
        }
    }

    @Override
    public String getColumnName(int column) {
        if (column == 0) {
            return "ID";
        } else if (column == 1) {
            return "Nama Satuan Obat";
        } else {
            return "Description";
        }
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return listSatuanObat.getClass();
    }
    
}
