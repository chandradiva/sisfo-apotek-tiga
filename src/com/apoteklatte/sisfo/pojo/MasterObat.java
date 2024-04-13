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
@Table(name = "master_obat")
public class MasterObat {

    @Id
    @Column(name = "id", unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    @ManyToOne
    @JoinColumn(name = "satuan_obat_id")
    private SatuanObat satuanObat;
    
    @Column(name = "nama_obat")
    private String namaObat;
    
    @Column(name = "stok_obat")
    private int stokObat;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_update")
    private Date lastUpdate;
    
    @Column(name = "keterangan")
    private String keterangan;
    
    @Column(name = "is_active")
    private int isActive;
    
    @Column(name = "last_batch_number")
    private String lastBatchNumber;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "last_expire_date")
    private Date lastExpireDate;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public SatuanObat getSatuanObat() {
        return satuanObat;
    }

    public void setSatuanObat(SatuanObat satuanObat) {
        this.satuanObat = satuanObat;
    }

    public String getNamaObat() {
        return namaObat;
    }

    public void setNamaObat(String namaObat) {
        this.namaObat = namaObat;
    }

    public int getStokObat() {
        return stokObat;
    }

    public void setStokObat(int stokObat) {
        this.stokObat = stokObat;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public int getIsActive() {
        return isActive;
    }

    public void setIsActive(int isActive) {
        this.isActive = isActive;
    }

    @Override
    public String toString() {
        return namaObat;
    }

    public String getLastBatchNumber() {
        return lastBatchNumber;
    }

    public void setLastBatchNumber(String lastBatchNumber) {
        this.lastBatchNumber = lastBatchNumber;
    }

    public Date getLastExpireDate() {
        return lastExpireDate;
    }

    public void setLastExpireDate(Date lastExpireDate) {
        this.lastExpireDate = lastExpireDate;
    }
}
