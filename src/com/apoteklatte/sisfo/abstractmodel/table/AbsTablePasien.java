/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apoteklatte.sisfo.abstractmodel.table;

import com.apoteklatte.sisfo.dao.impl.PasienDaoImpl;
import com.apoteklatte.sisfo.pojo.Pasien;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Sony Vaio
 */
public class AbsTablePasien extends AbstractTableModel {

    private PasienDaoImpl pasienDaoImpl;
    private List<Pasien> listPasien;

    public AbsTablePasien(PasienDaoImpl pasienDaoImpl) {
        this.pasienDaoImpl = pasienDaoImpl;
    }

    public List<Pasien> getListPasien() {
        return listPasien;
    }

    public void setListPasien(List<Pasien> listPasien) {
        this.listPasien = listPasien;
    }
    
    @Override
    public int getRowCount() {
        return listPasien.size();
    }

    @Override
    public int getColumnCount() {
        return 8;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        if (columnIndex == 0) {
            return listPasien.get(rowIndex).getId();
        } else if (columnIndex == 1) {
            return listPasien.get(rowIndex).getNamaPasien();
        } else if (columnIndex == 2) {
            return listPasien.get(rowIndex).getUmurPasien();
        } else if (columnIndex == 3) {
            return listPasien.get(rowIndex).getNoTelp();
        } else if (columnIndex == 4) {
            return listPasien.get(rowIndex).getGender();
        } else if (columnIndex == 5) {
            return listPasien.get(rowIndex).getAlamatPasien();
        } else if (columnIndex == 6) {
            return listPasien.get(rowIndex).getKeterangan();
        } else {
            String tgl = "";
            if (listPasien.get(rowIndex).getLastTglObatHabis() != null) {
                tgl = sdf.format(listPasien.get(rowIndex).getLastTglObatHabis());
            }
            return tgl;
        }
    }

    @Override
    public String getColumnName(int column) {
        if (column == 0) {
            return "ID";
        } else if (column == 1) {
            return "Nama Pasien";
        } else if (column == 2) {
            return "Umur";
        } else if (column == 3) {
            return "No Telp";
        } else if (column == 4) {
            return "Jenis Kelamin";
        } else if (column == 5) {
            return "Alamat";
        } else if (column == 6) {
            return "Keterangan";
        } else {
            return "Tgl Obat Habis";
        }
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return listPasien.getClass();
    }   
}
