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
public class JenisFilm {
    
    private int no = 0;
    
    private String kode;
    
    private String jenis;

    public JenisFilm(String kode, String jenis) {
        this.kode = kode;
        this.jenis = jenis;
    }

    public JenisFilm(int no, String kode, String jenis) {
        this.no = no;
        this.kode = kode;
        this.jenis = jenis;
    }

    public JenisFilm() {
        
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    @Override
    public String toString() {
        return jenis ;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }
    
    
    
}
