/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apoteklatte.sisfo.abstractmodel.table;

import com.apoteklatte.sisfo.dao.impl.MasterObatDaoImpl;
import com.apoteklatte.sisfo.pojo.MasterObat;
import com.apoteklatte.sisfo.utility.UtilityClass;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Sony Vaio
 */
public class AbsTableMasterObat extends AbstractTableModel {

    private List<MasterObat> listMasterObat;
    private MasterObatDaoImpl masterObatDaoImpl;

    public AbsTableMasterObat(MasterObatDaoImpl masterObatDaoImpl) {
        this.masterObatDaoImpl = masterObatDaoImpl;
    }

    public List<MasterObat> getListMasterObat() {
        return listMasterObat;
    }

    public void setListMasterObat(List<MasterObat> listMasterObat) {
        this.listMasterObat = listMasterObat;
    }
    
    @Override
    public int getRowCount() {
        return listMasterObat.size();
    }

    @Override
    public int getColumnCount() {
        return 8;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (columnIndex == 0) {
            return listMasterObat.get(rowIndex).getId();
        } else if (columnIndex == 1) {
            return listMasterObat.get(rowIndex).getSatuanObat().getName();
        } else if (columnIndex == 2) {
            return listMasterObat.get(rowIndex).getNamaObat();
        } else if (columnIndex == 3) {
            return listMasterObat.get(rowIndex).getStokObat();
        } else if (columnIndex == 4) {
            String tgl = UtilityClass.formatDateTimeToString(listMasterObat.get(rowIndex).getLastUpdate());
            return tgl;
        } else if (columnIndex == 5) {
            return listMasterObat.get(rowIndex).getLastBatchNumber();
        } else if (columnIndex == 6) {
            String tgl = UtilityClass.formatDateToString(listMasterObat.get(rowIndex).getLastExpireDate());
            return tgl;
        } else {
            return listMasterObat.get(rowIndex).getKeterangan();
        }
    }

    @Override
    public String getColumnName(int column) {
        if (column == 0) {
            return "ID";
        } else if (column == 1) {
            return "Satuan Obat";
        } else if (column == 2) {
            return "Nama Obat";
        } else if (column == 3) {
            return "Stok Obat";
        } else if (column == 4) {
            return "Last Update";
        } else if (column == 5) {
            return "Last Batch Number";
        } else if (column == 6) {
            return "Last Expire Date";
        } else {
            return "Keterangan";
        }
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return listMasterObat.getClass();
    }
    
}
