/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apoteklatte.sisfo.abstractmodel.table;

import com.apoteklatte.sisfo.dao.impl.DokterDaoImpl;
import com.apoteklatte.sisfo.pojo.Dokter;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author FredillaPrima
 */
public class AbsTableDokter extends AbstractTableModel{

    private DokterDaoImpl dokterDaoImpl;
    private List<Dokter> listDokter;

    public AbsTableDokter(DokterDaoImpl dokterDaoImpl) {
        this.dokterDaoImpl = dokterDaoImpl;
    }

    public List<Dokter> getListDokter() {
        return listDokter;
    }

    public void setListDokter(List<Dokter> listDokter) {
        this.listDokter = listDokter;
    }
    
    @Override
    public int getRowCount() {
        return listDokter.size();
    }

    @Override
    public int getColumnCount() {
        return 7;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (columnIndex == 0) {
            return listDokter.get(rowIndex).getId();
        } else if (columnIndex == 1) {
            return listDokter.get(rowIndex).getNamaDokter();
        } else if (columnIndex == 2) {
            return listDokter.get(rowIndex).getNoIzinPraktek();
        } else if (columnIndex == 3) {
            return listDokter.get(rowIndex).getGender();
        } else if (columnIndex == 4) {
            return listDokter.get(rowIndex).getNoTelp();
        } else if (columnIndex == 5) {
            return listDokter.get(rowIndex).getAlamatDokter();
        } else {
            return listDokter.get(rowIndex).getKeterangan();
        }
    }

    @Override
    public String getColumnName(int column) {
        if (column == 0) {
            return "ID";
        } else if (column == 1) {
            return "Nama Dokter";
        } else if (column == 2) {
            return "No Izin Praktek";
        } else if (column == 3) {
            return "Jenis Kelamin";
        } else if (column == 4) {
            return "No Telp";
        } else if (column == 5) {
            return "Alamat Dokter";
        } else {
            return "Keterangan";
        }
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return listDokter.getClass();
    }
    
}
