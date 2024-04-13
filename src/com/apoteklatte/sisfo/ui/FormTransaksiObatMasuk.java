/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apoteklatte.sisfo.ui;

import com.apoteklatte.sisfo.abstractmodel.combo.AbsComboDistributorObat;
import com.apoteklatte.sisfo.abstractmodel.table.AbsTableModelObatMasuk;
import com.apoteklatte.sisfo.dao.impl.DistributorObatDaoImpl;
import com.apoteklatte.sisfo.dao.impl.MasterObatDaoImpl;
import com.apoteklatte.sisfo.dao.impl.TransaksiDetailDistribusiObatDaoImpl;
import com.apoteklatte.sisfo.dao.impl.TransaksiDistribusiObatDaoImpl;
import com.apoteklatte.sisfo.model.ModelObatMasuk;
import com.apoteklatte.sisfo.pojo.DistributorObat;
import com.apoteklatte.sisfo.pojo.MasterObat;
import com.apoteklatte.sisfo.pojo.TransaksiDetailDistribusiObat;
import com.apoteklatte.sisfo.pojo.TransaksiDistribusiObat;
import java.awt.Toolkit;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Sony Vaio
 */
public class FormTransaksiObatMasuk extends javax.swing.JFrame {

    /**
     * Creates new form FormTransaksiObatMasuk
     */
    private LandingForm __landingForm;
    private FormDetailTransaksiObatMasuk __detail;
    private FormViewTransaksiObatMasuk __view;
    private TransaksiDistribusiObat __transaksi;
    private int __mode;
    
    private DistributorObat __distObat;
    
    private DistributorObatDaoImpl distributorObatDaoImpl;
    private AbsComboDistributorObat absComboDistributorObat;
    
    private AbsTableModelObatMasuk absTableModelObatMasuk;
    private List<ModelObatMasuk> listObatMasuk;
    
    private TransaksiDistribusiObatDaoImpl transDistObatDaoImpl;
    private TransaksiDetailDistribusiObatDaoImpl transDetDistObatDaoImpl;
    private MasterObatDaoImpl masterObatDaoImpl;
    
    public FormTransaksiObatMasuk(TransaksiDistribusiObat transaksi, FormViewTransaksiObatMasuk view, 
            FormDetailTransaksiObatMasuk detail, List<ModelObatMasuk> listDetail, int mode) {
        initComponents();
        __detail = detail;
        __view = view;
        __transaksi = transaksi;
        __mode = mode;
        this.setLocationRelativeTo(this);
        setIcon();
        
        distributorObatDaoImpl = new DistributorObatDaoImpl();
        absComboDistributorObat = new AbsComboDistributorObat(distributorObatDaoImpl);
        absComboDistributorObat.setListDistributorObat(distributorObatDaoImpl.getListData());
        cbDistObat.setModel(absComboDistributorObat);
        cbDistObat.invalidate();
        
        absTableModelObatMasuk = new AbsTableModelObatMasuk();
        listObatMasuk = listDetail;
        absTableModelObatMasuk.setListObatMasuk(listObatMasuk);
        jTable1.setModel(absTableModelObatMasuk);
        this.settingTableObatMasuk();
        jTable1.invalidate();
        
        transDistObatDaoImpl = new TransaksiDistribusiObatDaoImpl();
        transDetDistObatDaoImpl = new TransaksiDetailDistribusiObatDaoImpl();
        masterObatDaoImpl = new MasterObatDaoImpl();
        
        cbDistObat.getModel().setSelectedItem(transaksi.getDistributorObat());
        txtAlamatDist.setText(transaksi.getDistributorObat().getAlamatDistributor());
        txtNamaDist.setText(transaksi.getDistributorObat().getNamaDistributor());
        __distObat = transaksi.getDistributorObat();
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");
        lblTglTrans.setText(sdf.format(transaksi.getTanggalDistribusi()));
        txtKetTrans.setText(transaksi.getKeterangan());
        
    }
    
    public FormTransaksiObatMasuk(LandingForm landingForm, int mode) {
        initComponents();
        __landingForm = landingForm;
        __mode = mode;
        this.setLocationRelativeTo(this);
        setIcon();
        
        Date today = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");
        lblTglTrans.setText(sdf.format(today));
        
        distributorObatDaoImpl = new DistributorObatDaoImpl();
        absComboDistributorObat = new AbsComboDistributorObat(distributorObatDaoImpl);
        absComboDistributorObat.setListDistributorObat(distributorObatDaoImpl.getListData());
        cbDistObat.setModel(absComboDistributorObat);
        cbDistObat.invalidate();
        
        absTableModelObatMasuk = new AbsTableModelObatMasuk();
        listObatMasuk = new ArrayList<ModelObatMasuk>();
        absTableModelObatMasuk.setListObatMasuk(listObatMasuk);
        jTable1.setModel(absTableModelObatMasuk);
        this.settingTableObatMasuk();
        jTable1.invalidate();
        
        transDistObatDaoImpl = new TransaksiDistribusiObatDaoImpl();
        transDetDistObatDaoImpl = new TransaksiDetailDistribusiObatDaoImpl();
        masterObatDaoImpl = new MasterObatDaoImpl();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        cbDistObat = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        txtNamaDist = new javax.swing.JTextField();
        txtAlamatDist = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtKetTrans = new javax.swing.JTextField();
        lblTglTrans = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Transaksi Obat Masuk");
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Transaksi Obat Masuk");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Data Distributor Obat", 0, 0, new java.awt.Font("Arial", 1, 13))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel2.setText("Pilih Distributor:");

        cbDistObat.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel3.setText("Nama Distributor:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel4.setText("Alamat:");

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jButton1.setText("Select Distributor");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jButton2.setText("Search Distributor");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton9.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jButton9.setText("Clear Data");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        txtNamaDist.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtNamaDist.setEnabled(false);

        txtAlamatDist.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtAlamatDist.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(cbDistObat, javax.swing.GroupLayout.Alignment.LEADING, 0, 240, Short.MAX_VALUE)
                    .addComponent(txtNamaDist, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtAlamatDist))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbDistObat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jButton2)
                    .addComponent(txtNamaDist, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jButton9)
                    .addComponent(txtAlamatDist, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Data Transaksi", 0, 0, new java.awt.Font("Arial", 1, 13))); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel5.setText("Tanggal:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel6.setText("Keterangan:");

        txtKetTrans.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N

        lblTglTrans.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        lblTglTrans.setText("tgl");

        jButton3.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jButton3.setText("Clear Form");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jButton4.setText("Back");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblTglTrans)
                    .addComponent(txtKetTrans))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(lblTglTrans))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtKetTrans, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Data Obat Masuk", 0, 0, new java.awt.Font("Arial", 1, 13))); // NOI18N

        jTable1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton5.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jButton5.setText("Search Data Obat");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jButton6.setText("Delete Data Obat");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jButton7.setText("Clear Data Obat");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jButton5)
                        .addGap(18, 18, 18)
                        .addComponent(jButton6)
                        .addGap(18, 18, 18)
                        .addComponent(jButton7)
                        .addGap(0, 32, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jButton8.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jButton8.setText("Proses Transaksi");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54)
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(362, 362, 362))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        if (__landingForm != null) {
            this.setVisible(false);
            __landingForm.setVisible(true);
        } else {
            this.setVisible(false);
            __view.setVisible(true);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.clearForm();
        JOptionPane.showMessageDialog(rootPane, "Data Transaksi dibersihkan dari Form !");
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int index = -1;
        index = cbDistObat.getSelectedIndex();
        if (index == -1) {
            JOptionPane.showMessageDialog(rootPane, "Pilih salah satu Data Distributor Obat !");
        } else {
            DistributorObat selected = absComboDistributorObat.getListDistributorObat().get(index);
            txtAlamatDist.setText(selected.getAlamatDistributor());
            txtNamaDist.setText(selected.getNamaDistributor());
            __distObat = selected;
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        this.setVisible(false);
        FormSearchDataObatMasuk formSearchDataObatMasuk = new FormSearchDataObatMasuk(this);
        formSearchDataObatMasuk.setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        int index = -1;
        index = jTable1.getSelectedRow();
        if (index == -1) {
            JOptionPane.showMessageDialog(rootPane, "Pilih salah satu Data Obat Masuk untuk dihapus !");
        } else {
            int result = JOptionPane.showConfirmDialog(rootPane, "Apakah anda yakin untuk menghapus Data Obat Masuk ini?", "Hapus Data Obat Masuk", JOptionPane.YES_NO_OPTION);
            if (result == JOptionPane.YES_OPTION) {
                listObatMasuk.remove(index);
                JOptionPane.showMessageDialog(rootPane, "Data Obat Masuk berhasil dihapus dari tabel !");
                this.refreshTableObatMasuk();
            }
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        int result = JOptionPane.showConfirmDialog(rootPane, "Apakah anda yakin untuk menghapus semua Data Obat Masuk ?", "Hapus Data Obat Masuk", JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) {
            listObatMasuk.removeAll(listObatMasuk);
            JOptionPane.showMessageDialog(rootPane, "Data Obat Masuk berhasil dibersihkan dari tabel !");
            this.refreshTableObatMasuk();
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        if (listObatMasuk.size() < 1 || __distObat == null 
                || txtKetTrans.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Semua Data Transaksi Obat Masuk harus dilengkapi !");
        } else if (__mode == 0) {
            //data baru
            int result = JOptionPane.showConfirmDialog(rootPane, "Apakah anda yakin untuk memproses Data Transaksi Obat Masuk ini?", "Transaksi Data Obat Masuk", JOptionPane.YES_NO_OPTION);
            if (result == JOptionPane.YES_OPTION) {
                TransaksiDistribusiObat transDistribusiObat = new TransaksiDistribusiObat();
                transDistribusiObat.setDistributorObat(__distObat);
                transDistribusiObat.setKeterangan(txtKetTrans.getText());
                transDistribusiObat.setTanggalDistribusi(new Date());
                transDistObatDaoImpl.save(transDistribusiObat);

                for (ModelObatMasuk item : listObatMasuk) {
                    TransaksiDetailDistribusiObat transDet = new TransaksiDetailDistribusiObat();
                    transDet.setTransaksiDistribusiObat(transDistribusiObat);
                    transDet.setObat(item.getObat());
                    transDet.setKeterangan(item.getKeterangan());
                    transDet.setJumlahObat(item.getJumlahObat());
                    transDet.setBatchNumber(item.getBatchNumber());
                    transDet.setExpireDate(item.getExpireDate());
                    transDetDistObatDaoImpl.save(transDet);

                    MasterObat masterObat = item.getObat();
                    masterObat.setStokObat(masterObat.getStokObat() + item.getJumlahObat());
                    masterObat.setLastBatchNumber(item.getBatchNumber());
                    masterObat.setLastExpireDate(item.getExpireDate());
                    masterObat.setLastUpdate(new Date());
                    masterObatDaoImpl.save(masterObat);
                }
                
                JOptionPane.showMessageDialog(rootPane, "Data Transaksi Obat Masuk berhasil disimpan !");
                this.clearForm();
                listObatMasuk.removeAll(listObatMasuk);
                this.refreshTableObatMasuk();
            }
        } else if (__mode == 1) {
            //mode edit
            int result = JOptionPane.showConfirmDialog(rootPane, "Apakah anda yakin untuk meng-update Data Transaksi Obat Masuk ini?", "Transaksi Data Obat Masuk", JOptionPane.YES_NO_OPTION);
            if (result == JOptionPane.YES_OPTION) {
                TransaksiDistribusiObat transDistribusiObat = __transaksi;
                transDistribusiObat.setDistributorObat(__distObat);
                transDistribusiObat.setKeterangan(txtKetTrans.getText());
                transDistribusiObat.setTanggalDistribusi(new Date());
                
                //kembalikan stok obat
                List<TransaksiDetailDistribusiObat> listDeleted = transDetDistObatDaoImpl.getListData((int) __transaksi.getId());
                for (TransaksiDetailDistribusiObat item : listDeleted) {
                    MasterObat masterObat = item.getObat();
                    masterObat.setStokObat(masterObat.getStokObat() - item.getJumlahObat());
                    masterObat.setLastBatchNumber("");
                    masterObat.setLastExpireDate(null);
                    masterObat.setLastUpdate(new Date());
                    masterObatDaoImpl.save(masterObat);
                }
                //hapus detail
                transDetDistObatDaoImpl.deleteData((int) __transaksi.getId());
                transDistObatDaoImpl.save(transDistribusiObat);

                for (ModelObatMasuk item : listObatMasuk) {
                    TransaksiDetailDistribusiObat transDet = new TransaksiDetailDistribusiObat();
                    transDet.setTransaksiDistribusiObat(transDistribusiObat);
                    transDet.setObat(item.getObat());
                    transDet.setKeterangan(item.getKeterangan());
                    transDet.setJumlahObat(item.getJumlahObat());
                    transDet.setBatchNumber(item.getBatchNumber());
                    transDet.setExpireDate(item.getExpireDate());
                    transDetDistObatDaoImpl.save(transDet);

                    MasterObat masterObat = item.getObat();
                    masterObat.setStokObat(masterObat.getStokObat() + item.getJumlahObat());
                    masterObat.setLastBatchNumber(item.getBatchNumber());
                    masterObat.setLastExpireDate(item.getExpireDate());
                    masterObat.setLastUpdate(new Date());
                    masterObatDaoImpl.save(masterObat);
                }
                
                JOptionPane.showMessageDialog(rootPane, "Data Transaksi Obat Masuk berhasil di-update !");
                this.clearForm();
                listObatMasuk.removeAll(listObatMasuk);
                this.refreshTableObatMasuk();
            }
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.setVisible(false);
        FormSearchDistributorObatMasuk formSearchDistributorObatMasuk = new FormSearchDistributorObatMasuk(this);
        formSearchDistributorObatMasuk.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        __distObat = null;
        cbDistObat.setSelectedIndex(-1);
        txtAlamatDist.setText("alamat dist");
        txtNamaDist.setText("nama dist");
        JOptionPane.showMessageDialog(rootPane, "Data Distributor Obat dibersihkan dari Form !");
    }//GEN-LAST:event_jButton9ActionPerformed

    private void clearForm() {
        cbDistObat.setSelectedIndex(-1);
        txtAlamatDist.setText("alamat dist");
        txtNamaDist.setText("nama dist");
        txtKetTrans.setText("");
        __distObat = null;
    }
    
    public void addDataObat(MasterObat obat, int jumlahObat, String keterangan, String batch, Date expire) {
        ModelObatMasuk obatMasuk = new ModelObatMasuk();
        obatMasuk.setObat(obat);
        obatMasuk.setJumlahObat(jumlahObat);
        obatMasuk.setKeterangan(keterangan);
        obatMasuk.setBatchNumber(batch);
        obatMasuk.setExpireDate(expire);
        listObatMasuk.add(obatMasuk);
        
        this.refreshTableObatMasuk();
    }
    
    public void addDataDistributor(DistributorObat distObat) {
        txtAlamatDist.setText(distObat.getAlamatDistributor());
        txtNamaDist.setText(distObat.getNamaDistributor());
        cbDistObat.getModel().setSelectedItem(distObat);
        __distObat = distObat;
    }
    
    private void settingTableObatMasuk() {
        jTable1.getColumnModel().getColumn(0).setMaxWidth(200);
        jTable1.getColumnModel().getColumn(1).setMaxWidth(100);
        jTable1.getColumnModel().getColumn(2).setMaxWidth(150);
        jTable1.getColumnModel().getColumn(3).setMaxWidth(150);
        jTable1.getColumnModel().getColumn(4).setMaxWidth(150);
    }
    
    private void refreshTableObatMasuk() {
        absTableModelObatMasuk = new AbsTableModelObatMasuk();
        absTableModelObatMasuk.setListObatMasuk(listObatMasuk);
        jTable1.setModel(absTableModelObatMasuk);
        this.settingTableObatMasuk();
        jTable1.invalidate();
    }
    
    private void setIcon() {
        ClassLoader cl = this.getClass().getClassLoader();
        setIconImage(Toolkit.getDefaultToolkit().getImage(cl.getResource("pharmacy_icon.png")));
    }
    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(FormTransaksiObatMasuk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(FormTransaksiObatMasuk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(FormTransaksiObatMasuk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(FormTransaksiObatMasuk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new FormTransaksiObatMasuk().setVisible(true);
//            }
//        });
//    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cbDistObat;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblTglTrans;
    private javax.swing.JTextField txtAlamatDist;
    private javax.swing.JTextField txtKetTrans;
    private javax.swing.JTextField txtNamaDist;
    // End of variables declaration//GEN-END:variables
}
