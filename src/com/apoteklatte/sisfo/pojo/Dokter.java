/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apoteklatte.sisfo.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author FredillaPrima
 */
@Entity
@Table(name = "dokter")
public class Dokter {
    
    @Id
    @Column(name = "id", unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    @Column(name = "nama_dokter")
    private String namaDokter;
    
    @Column(name = "no_izin_praktek")
    private String noIzinPraktek;
    
    @Column(name = "jenis_kelamin")
    private String gender;
    
    @Column(name = "no_telp")
    private String noTelp;
    
    @Column(name = "alamat_dokter")
    private String alamatDokter;
    
    @Column(name = "keterangan")
    private String keterangan;
    
    @Column(name = "is_active")
    private int isActive;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNamaDokter() {
        return namaDokter;
    }

    public void setNamaDokter(String namaDokter) {
        this.namaDokter = namaDokter;
    }

    public String getNoIzinPraktek() {
        return noIzinPraktek;
    }

    public void setNoIzinPraktek(String noIzinPraktek) {
        this.noIzinPraktek = noIzinPraktek;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNoTelp() {
        return noTelp;
    }

    public void setNoTelp(String noTelp) {
        this.noTelp = noTelp;
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
        return namaDokter;
    }

    public String getAlamatDokter() {
        return alamatDokter;
    }

    public void setAlamatDokter(String alamatDokter) {
        this.alamatDokter = alamatDokter;
    }
}
