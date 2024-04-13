/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apoteklatte.sisfo.abstractmodel.table;

import com.apoteklatte.sisfo.model.ModelObatMasuk;
import com.apoteklatte.sisfo.utility.UtilityClass;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author FredillaPrima
 */
public class AbsTableModelObatMasuk extends AbstractTableModel{

    private List<ModelObatMasuk> listObatMasuk;

    public List<ModelObatMasuk> getListObatMasuk() {
        return listObatMasuk;
    }

    public void setListObatMasuk(List<ModelObatMasuk> listObatMasuk) {
        this.listObatMasuk = listObatMasuk;
    }
    
    @Override
    public int getRowCount() {
        return listObatMasuk.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (columnIndex == 0) {
            return listObatMasuk.get(rowIndex).getObat().getNamaObat();
        } else if (columnIndex == 1) {
            return listObatMasuk.get(rowIndex).getJumlahObat();
        } else if (columnIndex == 2) {
            return listObatMasuk.get(rowIndex).getBatchNumber();
        } else if (columnIndex == 3) {
            String tgl = "";
            if (listObatMasuk.get(rowIndex).getExpireDate() != null) {
                UtilityClass.formatDateTimeToString(listObatMasuk.get(rowIndex).getExpireDate());
            }
            return tgl;
        } else {
            return listObatMasuk.get(rowIndex).getKeterangan();
        }
    }

    @Override
    public String getColumnName(int column) {
        if (column == 0) {
            return "Nama Obat";
        } else if (column == 1) {
            return "Jumlah Obat";
        } else if (column == 2) {
            return "Batch Number";
        } else if (column == 3) {
            return "Expire Date";
        } else {
            return "Keterangan";
        }
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return listObatMasuk.getClass();
    }
    
}
