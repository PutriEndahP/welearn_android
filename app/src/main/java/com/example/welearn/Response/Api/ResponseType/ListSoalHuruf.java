package com.example.welearn.Response.Api.ResponseType;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ListSoalHuruf {
    @SerializedName("id_soal")
    @Expose
    private Integer idSoal;
    @SerializedName("id_jenis")
    @Expose
    private Integer idJenis;
    @SerializedName("id_level")
    @Expose
    private Integer idLevel;
    @SerializedName("soal")
    @Expose
    private String soal;
    @SerializedName("keterangan")
    @Expose
    private String keterangan;
    @SerializedName("jawaban")
    @Expose
    private String jawaban;

    public Integer getIdSoal() {
        return idSoal;
    }

    public void setIdSoal(Integer idSoal) {
        this.idSoal = idSoal;
    }

    public Integer getIdJenis() {
        return idJenis;
    }

    public void setIdJenis(Integer idJenis) {
        this.idJenis = idJenis;
    }

    public Integer getIdLevel() {
        return idLevel;
    }

    public void setIdLevel(Integer idLevel) {
        this.idLevel = idLevel;
    }

    public String getSoal() {
        return soal;
    }

    public void setSoal(String soal) {
        this.soal = soal;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public String getJawaban() {
        return jawaban;
    }

    public void setJawaban(String jawaban) {
        this.jawaban = jawaban;
    }
}
