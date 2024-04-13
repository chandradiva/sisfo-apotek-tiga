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
@Table(name = "transaksi_distribusi_obat")
public class TransaksiDistribusiObat {

    @Id
    @Column(name = "id", unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    @ManyToOne
    @JoinColumn(name = "distributor_obat_id")
    private DistributorObat distributorObat;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "tanggal_distribusi")
    private Date tanggalDistribusi;
    
    @Column(name = "keterangan")
    private String keterangan;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public DistributorObat getDistributorObat() {
        return distributorObat;
    }

    public void setDistributorObat(DistributorObat distributorObat) {
        this.distributorObat = distributorObat;
    }

    public Date getTanggalDistribusi() {
        return tanggalDistribusi;
    }

    public void setTanggalDistribusi(Date tanggalDistribusi) {
        this.tanggalDistribusi = tanggalDistribusi;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }
}
