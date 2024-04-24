/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apoteklatte.sisfo.abstractmodel.table;

import com.apoteklatte.sisfo.model.ModelResepDetail;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author FredillaPrima
 */
public class AbsTableModelResepDetail extends AbstractTableModel {

    private List<ModelResepDetail> listDetail;

    public List<ModelResepDetail> getListDetail() {
        return listDetail;
    }

    public void setListDetail(List<ModelResepDetail> listDetail) {
        this.listDetail = listDetail;
    }
    
    @Override
    public int getRowCount() {
        return listDetail.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (columnIndex == 0) {
            return listDetail.get(rowIndex).getObat().getNamaObat();
        } else if (columnIndex == 1) {
            String signa = listDetail.get(rowIndex).getSignaObat() + " x " + listDetail.get(rowIndex).getSignaHari();
            return signa;
        } else if (columnIndex == 2) {
            return listDetail.get(rowIndex).getQty();
        } else if (columnIndex == 3) {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date tgl = listDetail.get(rowIndex).getTglHabis();
            
            return sdf.format(tgl);
        } else {
            return listDetail.get(rowIndex).getKeterangan();
        }
    }

    @Override
    public String getColumnName(int column) {
        if (column == 0) {
            return "Nama Obat";
        } else if (column == 1) {
            return "Signa Obat";
        } else if (column == 2) {
            return "QTY";
        } else if (column == 3) {
            return "Tanggal Habis";
        } else {
            return "Keterangan Obat";
        }
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return listDetail.getClass();
    }
}
