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
@Table(name = "distributor_obat")
public class DistributorObat {
    
    @Id
    @Column(name = "id", unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    @Column(name = "nama_distributor")
    private String namaDistributor;
    
    @Column(name = "alamat_distributor")
    private String alamatDistributor;
    
    @Column(name = "no_telp")
    private String noTelp;
    
    @Column(name = "keterangan")
    private String keterangan;
    
    @Column(name = "is_active")
    private int isActive;
    
    @Column(name = "email")
    private String email;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNamaDistributor() {
        return namaDistributor;
    }

    public void setNamaDistributor(String namaDistributor) {
        this.namaDistributor = namaDistributor;
    }

    public String getAlamatDistributor() {
        return alamatDistributor;
    }

    public void setAlamatDistributor(String alamatDistributor) {
        this.alamatDistributor = alamatDistributor;
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
        return namaDistributor;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
