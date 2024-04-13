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
public class ModelObatMasuk {
    
    private MasterObat obat;
    private int jumlahObat;
    private String keterangan;
    private String batchNumber;
    private Date expireDate;

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

    public String getBatchNumber() {
        return batchNumber;
    }

    public void setBatchNumber(String batchNumber) {
        this.batchNumber = batchNumber;
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }
}
