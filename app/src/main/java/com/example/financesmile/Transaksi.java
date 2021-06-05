package com.example.financesmile;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "tabel_transaksi")
public class Transaksi implements Parcelable {

    @PrimaryKey
    @NonNull
    private String namaTransaksi;
    private int nominalTransaksi;
    private String keteranganTransaksi;
    private String tanggalTransaksi;
    private String jenisTransaksi;

    public Transaksi(@NonNull String namaTransaksi, int nominalTransaksi, String keteranganTransaksi, String tanggalTransaksi, String jenisTransaksi) {
        this.namaTransaksi = namaTransaksi;
        this.nominalTransaksi = nominalTransaksi;
        this.keteranganTransaksi = keteranganTransaksi;
        this.tanggalTransaksi = tanggalTransaksi;
        this.jenisTransaksi = jenisTransaksi;
    }

    public Transaksi(Parcel in) {
        namaTransaksi = in.readString();
        nominalTransaksi = in.readInt();
        keteranganTransaksi = in.readString();
        tanggalTransaksi = in.readString();
        jenisTransaksi = in.readString();
    }

    @NonNull
    public String getNamaTransaksi() {
        return namaTransaksi;
    }

    public void setNamaTransaksi(@NonNull String namaTransaksi) {
        this.namaTransaksi = namaTransaksi;
    }

    public int getNominalTransaksi() {
        return nominalTransaksi;
    }

    public void setNominalTransaksi(int nominalTransaksi) {
        this.nominalTransaksi = nominalTransaksi;
    }

    public String getKeteranganTransaksi() {
        return keteranganTransaksi;
    }

    public void setKeteranganTransaksi(String keteranganTransaksi) {
        this.keteranganTransaksi = keteranganTransaksi;
    }

    public String getTanggalTransaksi() {
        return tanggalTransaksi;
    }

    public void setTanggalTransaksi(String tanggalTransaksi) {
        this.tanggalTransaksi = tanggalTransaksi;
    }

    public String getJenisTransaksi() {
        return jenisTransaksi;
    }

    public void setJenisTransaksi(String jenisTransaksi) {
        this.jenisTransaksi = jenisTransaksi;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(namaTransaksi);
        dest.writeInt(nominalTransaksi);
        dest.writeString(keteranganTransaksi);
        dest.writeString(tanggalTransaksi);
        dest.writeString(jenisTransaksi);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Transaksi> CREATOR = new Creator<Transaksi>() {
        @Override
        public Transaksi createFromParcel(Parcel in) {
            return new Transaksi(in);
        }

        @Override
        public Transaksi[] newArray(int size) {
            return new Transaksi[size];
        }
    };
}
