/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apoteklatte.sisfo.abstractmodel.combo;

import com.apoteklatte.sisfo.pojo.TransaksiResep;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;

/**
 *
 * @author BISMILLAH
 */
public class AbsComboTransaksiResep extends AbstractListModel implements ComboBoxModel, ListDataListener {

    private List<TransaksiResep> listTransaksiResep;
    private Object selectedItem;
    
    @Override
    public int getSize() {
        if (listTransaksiResep == null) return 0;
        else return listTransaksiResep.size();
    }

    @Override
    public Object getElementAt(int index) {
        if (listTransaksiResep == null) return null;
        else return listTransaksiResep.get(index);
    }

    @Override
    public void setSelectedItem(Object anItem) {
        if ((selectedItem != null && !selectedItem.equals(anItem)) || selectedItem == null && anItem != null) {
            selectedItem = anItem;
            fireContentsChanged(this, -1, -1);
        }
    }

    @Override
    public Object getSelectedItem() {
        return selectedItem;
    }

    @Override
    public void intervalAdded(ListDataEvent e) {
        this.intervalAdded(e);
    }

    @Override
    public void intervalRemoved(ListDataEvent e) {
        this.intervalRemoved(e);
    }

    @Override
    public void contentsChanged(ListDataEvent e) {
        this.contentsChanged(e);
    }

    public List<TransaksiResep> getListTransaksiResep() {
        return listTransaksiResep;
    }

    public void setListTransaksiResep(List<TransaksiResep> listTransaksiResep) {
        this.listTransaksiResep = listTransaksiResep;
    }
    
}
