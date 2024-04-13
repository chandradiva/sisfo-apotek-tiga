/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apoteklatte.sisfo.abstractmodel.combo;

import com.apoteklatte.sisfo.dao.impl.DistributorObatDaoImpl;
import com.apoteklatte.sisfo.pojo.DistributorObat;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;

/**
 *
 * @author Sony Vaio
 */
public class AbsComboDistributorObat extends AbstractListModel implements ComboBoxModel, ListDataListener {

    private List<DistributorObat> listDistributorObat;
    private DistributorObatDaoImpl distributorObatDaoImpl;
    private Object selectedItem;

    public AbsComboDistributorObat(DistributorObatDaoImpl distributorObatDaoImpl) {
        this.distributorObatDaoImpl = distributorObatDaoImpl;
    }

    public List<DistributorObat> getListDistributorObat() {
        return listDistributorObat;
    }

    public void setListDistributorObat(List<DistributorObat> listDistributorObat) {
        this.listDistributorObat = listDistributorObat;
    }
    
    @Override
    public int getSize() {
        return listDistributorObat.size();
    }

    @Override
    public Object getElementAt(int index) {
        return listDistributorObat.get(index);
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
