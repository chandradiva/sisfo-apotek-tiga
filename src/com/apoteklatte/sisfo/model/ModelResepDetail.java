/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apoteklatte.sisfo.model;

import com.apoteklatte.sisfo.pojo.MasterObat;
import java.util.Date;

/**
 *
 * @author FredillaPrima
 */
public class ModelResepDetail {
    
    private MasterObat obat;
    private int signaObat;
    private int signaHari;
    private int qty;
    private Date tglHabis;
    private String keterangan;

    public MasterObat getObat() {
        return obat;
    }

    public void setObat(MasterObat obat) {
        this.obat = obat;
    }

    public int getSignaObat() {
        return signaObat;
    }

    public void setSignaObat(int signaObat) {
        this.signaObat = signaObat;
    }

    public int getSignaHari() {
        return signaHari;
    }

    public void setSignaHari(int signaHari) {
        this.signaHari = signaHari;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public Date getTglHabis() {
        return tglHabis;
    }

    public void setTglHabis(Date tglHabis) {
        this.tglHabis = tglHabis;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }
}
