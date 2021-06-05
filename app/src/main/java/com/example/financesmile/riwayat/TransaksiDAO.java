package com.example.financesmile.riwayat;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.financesmile.Transaksi;

import java.util.List;

@Dao
public interface TransaksiDAO {

    @Insert
    void insert(Transaksi transaksi);

    @Delete
    void delete(Transaksi transaksi);

    @Update
    void update(Transaksi transaksi);

    @Query("DELETE FROM tabel_transaksi")
    void deleteAlltransaksi();

    @Query("SELECT * FROM tabel_transaksi")
    LiveData<List<Transaksi>> getAlltransaksi();
}
