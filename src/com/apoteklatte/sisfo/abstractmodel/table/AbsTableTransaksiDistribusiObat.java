/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apoteklatte.sisfo.abstractmodel.table;

import com.apoteklatte.sisfo.dao.impl.TransaksiDistribusiObatDaoImpl;
import com.apoteklatte.sisfo.pojo.TransaksiDistribusiObat;
import com.apoteklatte.sisfo.utility.UtilityClass;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author FredillaPrima
 */
public class AbsTableTransaksiDistribusiObat extends AbstractTableModel {

    private List<TransaksiDistribusiObat> listTransaksi;
    private TransaksiDistribusiObatDaoImpl transaksiDistribusiObatDaoImpl;

    public AbsTableTransaksiDistribusiObat(TransaksiDistribusiObatDaoImpl transaksiDistribusiObatDaoImpl) {
        this.transaksiDistribusiObatDaoImpl = transaksiDistribusiObatDaoImpl;
    }

    public List<TransaksiDistribusiObat> getListTransaksi() {
        return listTransaksi;
    }

    public void setListTransaksi(List<TransaksiDistribusiObat> listTransaksi) {
        this.listTransaksi = listTransaksi;
    }
    
    @Override
    public int getRowCount() {
        return listTransaksi.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (columnIndex == 0) {
            return listTransaksi.get(rowIndex).getId();
        } else if (columnIndex == 1) {
            return listTransaksi.get(rowIndex).getDistributorObat().getNamaDistributor();
        } else if (columnIndex == 2) {
            return listTransaksi.get(rowIndex).getDistributorObat().getNoTelp();
        } else if (columnIndex == 3) {
            String tgl = UtilityClass.formatDateTimeToString(listTransaksi.get(rowIndex).getTanggalDistribusi());
            return tgl;
        } else {
            return listTransaksi.get(rowIndex).getKeterangan();
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
            return "Tanggal Transaksi";
        } else {
            return "Keterangan";
        }
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return listTransaksi.getClass();
    }
}
