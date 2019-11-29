package com.example.SI_KRS.Model;

public class Krs {
    private String kode;
    private String Matkul;
    private String hari;
    private String sks;
    private String sesi;
    private String Krs;
    private String Mahasiswa;

    public Krs(String kodeKrs, String namaMatkul, String hari, String sks, String sesi,
               String dosenKrs, String jmlMhs) {
        this.kode = kodeKrs;
        this.Matkul = namaMatkul;
        this.hari = hari;
        this.sks = sks;
        this.sesi = sesi;
        this.Krs = dosenKrs;
        this.Mahasiswa = jmlMhs;
    }

    public String getKodeKrs() {
        return kode;
    }

    public void setKodeKrs(String kodeKrs) {
        this.kode = kode;
    }

    public String getNamaMatkul() {
        return Matkul;
    }

    public void setNamaMatkul(String Matkul) {
        this.Matkul = Matkul;
    }

    public String getHari() {
        return hari;
    }

    public void setHari(String hari) {
        this.hari = hari;
    }

    public String getSks() {
        return sks;
    }

    public void setSks(String sks) {
        this.sks = sks;
    }

    public String getSesi() {
        return sesi;
    }

    public void setSesi(String sesi) {
        this.sesi = sesi;
    }

    public String getDosenKrs() {
        return Krs;
    }

    public void setDosenKrs(String Krs) {
        this.Krs = Krs;
    }

    public String getJmlMhs() {
        return Mahasiswa;
    }

    public void setJmlMhs(String Mahasiswa) {
        this.Mahasiswa = Mahasiswa;
    }
}
