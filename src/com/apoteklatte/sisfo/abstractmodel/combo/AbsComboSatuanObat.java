/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apoteklatte.sisfo.abstractmodel.combo;

import com.apoteklatte.sisfo.dao.impl.SatuanObatDaoImpl;
import com.apoteklatte.sisfo.pojo.SatuanObat;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;

/**
 *
 * @author Sony Vaio
 */
public class AbsComboSatuanObat extends AbstractListModel implements ComboBoxModel, ListDataListener {

    private List<SatuanObat> listSatuanObat;
    private SatuanObatDaoImpl satuanObatDaoImpl;
    private Object selectedItem;

    public AbsComboSatuanObat(SatuanObatDaoImpl satuanObatDaoImpl) {
        this.satuanObatDaoImpl = satuanObatDaoImpl;
    }

    public List<SatuanObat> getListSatuanObat() {
        return listSatuanObat;
    }

    public void setListSatuanObat(List<SatuanObat> listSatuanObat) {
        this.listSatuanObat = listSatuanObat;
    }
    
    @Override
    public int getSize() {
        return listSatuanObat.size();
    }

    @Override
    public Object getElementAt(int index) {
        return listSatuanObat.get(index);
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
