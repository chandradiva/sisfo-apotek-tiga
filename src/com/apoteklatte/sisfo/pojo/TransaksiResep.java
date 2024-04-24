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
@Table(name = "transaksi_resep")
public class TransaksiResep {
    
    @Id
    @Column(name = "id", unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    @ManyToOne
    @JoinColumn(name = "dokter_id")
    private Dokter dokter;
    
    @ManyToOne
    @JoinColumn(name = "pasien_id")
    private Pasien pasien;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "tgl_pembuatan")
    private Date tglPembuatan;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "tgl_pengambilan")
    private Date tglPengambilan;
    
    @Column(name = "keterangan")
    private String keterangan;
    
    @Column(name = "no_resep")
    private String noResep;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Dokter getDokter() {
        return dokter;
    }

    public void setDokter(Dokter dokter) {
        this.dokter = dokter;
    }

    public Pasien getPasien() {
        return pasien;
    }

    public void setPasien(Pasien pasien) {
        this.pasien = pasien;
    }

    public Date getTglPembuatan() {
        return tglPembuatan;
    }

    public void setTglPembuatan(Date tglPembuatan) {
        this.tglPembuatan = tglPembuatan;
    }

    public Date getTglPengambilan() {
        return tglPengambilan;
    }

    public void setTglPengambilan(Date tglPengambilan) {
        this.tglPengambilan = tglPengambilan;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public String getNoResep() {
        return noResep;
    }

    public void setNoResep(String noResep) {
        this.noResep = noResep;
    }
    
    @Override
    public String toString() {
        return noResep + " (" + dokter.getNamaDokter() + ")";
    }
    
}
