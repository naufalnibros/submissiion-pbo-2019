/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uas_oop_171080200234.database_service.models;

/**
 *
 * @author naufalnibros
 */
public class VCD {
    
    private String kode;
    
    private String nama;
    
    private int harga;
    
    private int Nilaidenda;

    private JenisFilm jenisFilm;

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public int getNilaidenda() {
        return Nilaidenda;
    }

    public void setNilaidenda(int Nilaidenda) {
        this.Nilaidenda = Nilaidenda;
    }

    public JenisFilm getJenisFilm() {
        return jenisFilm;
    }

    public void setJenisFilm(JenisFilm jenisFilm) {
        this.jenisFilm = jenisFilm;
    }
    
    
}