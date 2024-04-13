/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apoteklatte.sisfo.pojo;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Sony Vaio
 */
@Entity
@Table(name = "transaksi_detail_distribusi_obat")
public class TransaksiDetailDistribusiObat {

    @Id
    @Column(name = "id", unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    @ManyToOne
    @JoinColumn(name = "transaksi_distribusi_obat_id")
    private TransaksiDistribusiObat transaksiDistribusiObat;
    
    @ManyToOne
    @JoinColumn(name = "obat_id")
    private MasterObat obat;
    
    @Column(name = "jumlah_obat")
    private int jumlahObat;
    
    @Column(name = "keterangan")
    private String keterangan;
    
    @Column(name = "batch_number")
    private String batchNumber;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "expire_date")
    private Date expireDate;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public TransaksiDistribusiObat getTransaksiDistribusiObat() {
        return transaksiDistribusiObat;
    }

    public void setTransaksiDistribusiObat(TransaksiDistribusiObat transaksiDistribusiObat) {
        this.transaksiDistribusiObat = transaksiDistribusiObat;
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
