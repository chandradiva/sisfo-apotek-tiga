/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apoteklatte.sisfo.abstractmodel.combo;

import com.apoteklatte.sisfo.dao.impl.PasienDaoImpl;
import com.apoteklatte.sisfo.pojo.Pasien;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;

/**
 *
 * @author Sony Vaio
 */
public class AbsComboPasien extends AbstractListModel implements ComboBoxModel, ListDataListener{

    private List<Pasien> listPasien;
    private PasienDaoImpl pasienDaoImpl;
    private Object selectedItem;

    public AbsComboPasien(PasienDaoImpl pasienDaoImpl) {
        this.pasienDaoImpl = pasienDaoImpl;
    }

    public List<Pasien> getListPasien() {
        return listPasien;
    }

    public void setListPasien(List<Pasien> listPasien) {
        this.listPasien = listPasien;
    }
    
    @Override
    public int getSize() {
        return listPasien.size();
    }

    @Override
    public Object getElementAt(int index) {
        return listPasien.get(index);
    }

    @Override
    public void setSelectedItem(Object anItem) {
        if ((selectedItem != null && !selectedItem.equals(anItem))
                || selectedItem == null && anItem != null) {
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
    
}
