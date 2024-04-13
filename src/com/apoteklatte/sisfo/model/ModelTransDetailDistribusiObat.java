/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apoteklatte.sisfo.model;

import com.apoteklatte.sisfo.pojo.MasterObat;

/**
 *
 * @author FredillaPrima
 */
public class ModelTransDetailDistribusiObat {
    
    private int no;
    private MasterObat obat;
    private int jumlahObat;
    private String keterangan;

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public MasterObat getObat() {
        return obat;
    }

    public void setObat(MasterObat obat) {
        this.obat = obat;
    }

    public int getJumlahObat() {
        return jumlahObat;
    }

    public void setJumlahObat(int jumlahObat) {
        this.jumlahObat = jumlahObat;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }
}
