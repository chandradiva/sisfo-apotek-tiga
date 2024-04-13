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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author FredillaPrima
 */
@Entity
@Table(name = "pasien")
public class Pasien {
    
    @Id
    @Column(name = "id", unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    @Column(name = "nama_pasien")
    private String namaPasien;
    
    @Column(name = "umur_pasien")
    private int umurPasien;
    
    @Column(name = "no_telp")
    private String noTelp;
    
    @Column(name = "jenis_kelamin")
    private String gender;
    
    @Column(name = "alamat_pasien")
    private String alamatPasien;
    
    @Column(name = "keterangan")
    private String keterangan;
    
    @Column(name = "is_active")
    private int isActive;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "last_tgl_obat_habis")
    private Date lastTglObatHabis;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNamaPasien() {
        return namaPasien;
    }

    public void setNamaPasien(String namaPasien) {
        this.namaPasien = namaPasien;
    }

    public int getUmurPasien() {
        return umurPasien;
    }

    public void setUmurPasien(int umurPasien) {
        this.umurPasien = umurPasien;
    }

    public String getNoTelp() {
        return noTelp;
    }

    public void setNoTelp(String noTelp) {
        this.noTelp = noTelp;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAlamatPasien() {
        return alamatPasien;
    }

    public void setAlamatPasien(String alamatPasien) {
        this.alamatPasien = alamatPasien;
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
        return namaPasien + " - " + umurPasien + " - " + noTelp;
    }

    public Date getLastTglObatHabis() {
        return lastTglObatHabis;
    }

    public void setLastTglObatHabis(Date lastTglObatHabis) {
        this.lastTglObatHabis = lastTglObatHabis;
    }
}
