/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apoteklatte.sisfo.abstractmodel.combo;

import com.apoteklatte.sisfo.dao.impl.DokterDaoImpl;
import com.apoteklatte.sisfo.pojo.Dokter;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;

/**
 *
 * @author FredillaPrima
 */
public class AbsComboDokter extends AbstractListModel implements ComboBoxModel, ListDataListener{

    private Object selectedItem;
    private DokterDaoImpl dokterDaoImpl;
    private List<Dokter> listDokter;

    public AbsComboDokter(DokterDaoImpl dokterDaoImpl) {
        this.dokterDaoImpl = dokterDaoImpl;
    }

    public List<Dokter> getListDokter() {
        return listDokter;
    }

    public void setListDokter(List<Dokter> listDokter) {
        this.listDokter = listDokter;
    }
    
    @Override
    public int getSize() {
        return listDokter.size();
    }

    @Override
    public Object getElementAt(int index) {
        return listDokter.get(index);
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
