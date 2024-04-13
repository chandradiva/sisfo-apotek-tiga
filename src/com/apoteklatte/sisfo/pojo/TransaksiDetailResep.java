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
 * @author FredillaPrima
 */
@Entity
@Table(name = "transaksi_detail_resep")
public class TransaksiDetailResep {
    
    @Id
    @Column(name = "id", unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    @ManyToOne
    @JoinColumn(name = "transaksi_resep_id")
    private TransaksiResep transaksiResep;
    
    @ManyToOne
    @JoinColumn(name = "obat_id")
    private MasterObat obat;
    
    @Column(name = "signa_obat")
    private int signaObat;
    
    @Column(name = "signa_hari")
    private int signaHari;
    
    @Column(name = "qty")
    private int qty;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "tgl_obat_habis")
    private Date tglObatHabis;
    
    @Column(name = "keterangan")
    private String keterangan;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public TransaksiResep getTransaksiResep() {
        return transaksiResep;
    }

    public void setTransaksiResep(TransaksiResep transaksiResep) {
        this.transaksiResep = transaksiResep;
    }

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

    public Date getTglObatHabis() {
        return tglObatHabis;
    }

    public void setTglObatHabis(Date tglObatHabis) {
        this.tglObatHabis = tglObatHabis;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }
}
