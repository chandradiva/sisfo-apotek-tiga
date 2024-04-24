/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apoteklatte.sisfo.abstractmodel.table;

import com.apoteklatte.sisfo.dao.impl.TransaksiResepDaoImpl;
import com.apoteklatte.sisfo.pojo.TransaksiResep;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author FredillaPrima
 */
public class AbsTableTransaksiResep extends AbstractTableModel {

    private List<TransaksiResep> listTransaksi;
    private TransaksiResepDaoImpl transaksiResepDaoImpl;

    public AbsTableTransaksiResep(TransaksiResepDaoImpl transaksiResepDaoImpl) {
        this.transaksiResepDaoImpl = transaksiResepDaoImpl;
    }

    public List<TransaksiResep> getListTransaksi() {
        return listTransaksi;
    }

    public void setListTransaksi(List<TransaksiResep> listTransaksi) {
        this.listTransaksi = listTransaksi;
    }
    
    @Override
    public int getRowCount() {
        return listTransaksi.size();
    }

    @Override
    public int getColumnCount() {
        return 8;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        if (columnIndex == 0) {
            return listTransaksi.get(rowIndex).getId();
        } else if (columnIndex == 1) {
            return listTransaksi.get(rowIndex).getDokter().getNamaDokter();
        } else if (columnIndex == 2) {
            return listTransaksi.get(rowIndex).getPasien().getNamaPasien();
        } else if (columnIndex == 3) {
            return listTransaksi.get(rowIndex).getPasien().getAlamatPasien();
        } else if (columnIndex == 4) {
            return listTransaksi.get(rowIndex).getNoResep();
        } else if (columnIndex == 5) {
            String tgl = "";
            if (listTransaksi.get(rowIndex).getTglPembuatan() != null) {
                tgl = sdf.format(listTransaksi.get(rowIndex).getTglPembuatan());
            }
            return tgl;
        } else if (columnIndex == 6) {
            String tgl = "";
            if (listTransaksi.get(rowIndex).getTglPengambilan() != null) {
                tgl = sdf.format(listTransaksi.get(rowIndex).getTglPengambilan());
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
            return "Nama Dokter";
        } else if (column == 2) {
            return "Nama Pasien";
        } else if (column == 3) {
            return "Alamat Pasien";
        } else if (column == 4) {
            return "No Resep";
        } else if (column == 5) {
            return "Tanggal Dibuat";
        } else if (column == 6) {
            return "Tanggal Pengambilan";
        } else {
            return "Keterangan Resep";
        }
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return String.class;
    }
    
}
