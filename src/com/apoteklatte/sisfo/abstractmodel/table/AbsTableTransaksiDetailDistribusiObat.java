/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apoteklatte.sisfo.abstractmodel.table;

import com.apoteklatte.sisfo.dao.impl.TransaksiDetailDistribusiObatDaoImpl;
import com.apoteklatte.sisfo.pojo.TransaksiDetailDistribusiObat;
import com.apoteklatte.sisfo.utility.UtilityClass;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author FredillaPrima
 */
public class AbsTableTransaksiDetailDistribusiObat extends AbstractTableModel {

    private TransaksiDetailDistribusiObatDaoImpl transaksiDetailDistribusiObatDaoImpl;
    private List<TransaksiDetailDistribusiObat> listDetail;

    public AbsTableTransaksiDetailDistribusiObat(TransaksiDetailDistribusiObatDaoImpl transaksiDetailDistribusiObatDaoImpl) {
        this.transaksiDetailDistribusiObatDaoImpl = transaksiDetailDistribusiObatDaoImpl;
    }

    public List<TransaksiDetailDistribusiObat> getListDetail() {
        return listDetail;
    }

    public void setListDetail(List<TransaksiDetailDistribusiObat> listDetail) {
        this.listDetail = listDetail;
    }
    
    @Override
    public int getRowCount() {
        return listDetail.size();
    }

    @Override
    public int getColumnCount() {
        return 7;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (columnIndex == 0) {
            return listDetail.get(rowIndex).getId();
        } else if (columnIndex == 1) {
            return listDetail.get(rowIndex).getObat().getNamaObat();
        } else if (columnIndex == 2) {
            return listDetail.get(rowIndex).getJumlahObat();
        } else if (columnIndex == 3) {
            return listDetail.get(rowIndex).getObat().getStokObat();
        } else if (columnIndex == 4) {
            return listDetail.get(rowIndex).getBatchNumber();
        } else if (columnIndex == 5) {
            String tgl = UtilityClass.formatDateToString(listDetail.get(rowIndex).getExpireDate());
            return tgl;
        } else {
            return listDetail.get(rowIndex).getKeterangan();
        }
    }

    @Override
    public String getColumnName(int column) {
        if (column == 0) {
            return "ID";
        } else if (column == 1) {
            return "Nama Obat";
        } else if (column == 2) {
            return "Jumlah Masuk";
        } else if (column == 3) {
            return "Stok Obat";
        } else if (column == 4) {
            return "Batch Number";
        } else if (column == 5) {
            return "Expire Date";
        } else {
            return "Keterangan";
        }
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return listDetail.getClass();
    }
    
}
