package com.example.welearn.Response.Api.ResponseType;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ListSoalHuruf implements Parcelable {
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(idSoal);
        dest.writeInt(idJenis);
        dest.writeInt(idLevel);
        dest.writeString(soal);
        dest.writeString(keterangan);
        dest.writeString(jawaban);
    }

    public ListSoalHuruf(Parcel in) {
        idSoal = in.readInt();
        idJenis = in.readInt();
        idLevel = in.readInt();
        soal = in.readString();
        keterangan = in.readString();
        jawaban = in.readString();
    }

    public static final Parcelable.Creator<ListSoalHuruf> CREATOR = new Parcelable.Creator<ListSoalHuruf>() {
        public ListSoalHuruf createFromParcel(Parcel in) {
            return new ListSoalHuruf(in);
        }

        public ListSoalHuruf[] newArray(int size) {
            return new ListSoalHuruf[size];
        }
    };
}
