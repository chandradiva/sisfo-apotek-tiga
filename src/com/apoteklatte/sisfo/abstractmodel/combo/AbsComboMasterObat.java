/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apoteklatte.sisfo.abstractmodel.combo;

import com.apoteklatte.sisfo.dao.impl.MasterObatDaoImpl;
import com.apoteklatte.sisfo.pojo.MasterObat;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;

/**
 *
 * @author Sony Vaio
 */
public class AbsComboMasterObat extends AbstractListModel implements ComboBoxModel, ListDataListener {

    private Object selectedItem;
    private List<MasterObat> listMasterObat;
    private MasterObatDaoImpl masterObatDaoImpl;

    public AbsComboMasterObat(MasterObatDaoImpl masterObatDaoImpl) {
        this.masterObatDaoImpl = masterObatDaoImpl;
    }

    public List<MasterObat> getListMasterObat() {
        return listMasterObat;
    }

    public void setListMasterObat(List<MasterObat> listMasterObat) {
        this.listMasterObat = listMasterObat;
    }
    
    @Override
    public int getSize() {
        return listMasterObat.size();
    }

    @Override
    public Object getElementAt(int index) {
        return listMasterObat.get(index);
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
