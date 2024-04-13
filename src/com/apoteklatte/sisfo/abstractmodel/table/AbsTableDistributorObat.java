/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apoteklatte.sisfo.abstractmodel.table;

import com.apoteklatte.sisfo.dao.impl.DistributorObatDaoImpl;
import com.apoteklatte.sisfo.pojo.DistributorObat;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Sony Vaio
 */
public class AbsTableDistributorObat extends AbstractTableModel {

    private List<DistributorObat> listDistributorObat;
    private DistributorObatDaoImpl distributorObatDaoImpl;

    public AbsTableDistributorObat(DistributorObatDaoImpl distributorObatDaoImpl) {
        this.distributorObatDaoImpl = distributorObatDaoImpl;
    }

    public List<DistributorObat> getListDistributorObat() {
        return listDistributorObat;
    }

    public void setListDistributorObat(List<DistributorObat> listDistributorObat) {
        this.listDistributorObat = listDistributorObat;
    }
    
    @Override
    public int getRowCount() {
        return listDistributorObat.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (columnIndex == 0) {
            return listDistributorObat.get(rowIndex).getId();
        } else if (columnIndex == 1) {
            return listDistributorObat.get(rowIndex).getNamaDistributor();
        } else if (columnIndex == 2) {
            return listDistributorObat.get(rowIndex).getNoTelp();
        } else if (columnIndex == 3) {
            return listDistributorObat.get(rowIndex).getEmail();
        } else if (columnIndex == 4) {
            return listDistributorObat.get(rowIndex).getAlamatDistributor();
        } else {
            return listDistributorObat.get(rowIndex).getKeterangan();
        }
    }

    @Override
    public String getColumnName(int column) {
        if (column == 0) {
            return "ID";
        } else if (column == 1) {
            return "Nama Distributor";
        } else if (column == 2) {
            return "No Telp";
        } else if (column == 3) {
            return "Email";
        } else if (column == 4) {
            return "Alamat Distributor";
        } else {
            return "Keterangan";
        }
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return listDistributorObat.getClass();
    }
}
