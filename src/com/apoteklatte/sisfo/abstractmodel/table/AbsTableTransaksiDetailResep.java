/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apoteklatte.sisfo.abstractmodel.table;

import com.apoteklatte.sisfo.dao.impl.TransaksiDetailResepDaoImpl;
import com.apoteklatte.sisfo.pojo.TransaksiDetailResep;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author FredillaPrima
 */
public class AbsTableTransaksiDetailResep extends AbstractTableModel {

    private List<TransaksiDetailResep> listTransaksi;
    private TransaksiDetailResepDaoImpl transaksiDetailResepDaoImpl;

    public AbsTableTransaksiDetailResep(TransaksiDetailResepDaoImpl transaksiDetailResepDaoImpl) {
        this.transaksiDetailResepDaoImpl = transaksiDetailResepDaoImpl;
    }

    public List<TransaksiDetailResep> getListTransaksi() {
        return listTransaksi;
    }

    public void setListTransaksi(List<TransaksiDetailResep> listTransaksi) {
        this.listTransaksi = listTransaksi;
    }
    
    @Override
    public int getRowCount() {
        return listTransaksi.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (columnIndex == 0) {
            return listTransaksi.get(rowIndex).getId();
        } else if (columnIndex == 1) {
            return listTransaksi.get(rowIndex).getObat().getNamaObat();
        } else if (columnIndex == 2) {
            String signa = listTransaksi.get(rowIndex).getSignaObat() + " x " + listTransaksi.get(rowIndex).getSignaHari();
            return signa;
        } else if (columnIndex == 3) {
            return listTransaksi.get(rowIndex).getQty();
        } else if (columnIndex == 4) {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            String tgl = "";
            if (listTransaksi.get(rowIndex).getTglObatHabis() != null) {
                tgl = sdf.format(listTransaksi.get(rowIndex).getTglObatHabis());
            }
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
            return "Nama Obat";
        } else if (column == 2) {
            return "Signa Obat";
        } else if (column == 3) {
            return "QTY";
        } else if (column == 4) {
            return "Tanggal Habis";
        } else {
            return "Keterangan";
        }
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return listTransaksi.getClass();
    }
    
}
