package com.example.financesmile.riwayat;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.financesmile.Transaksi;

import java.util.List;

class TransaksiRepository {
    private TransaksiDAO transaksiDAO;
    private LiveData<List<Transaksi>> allTransaksi;

    TransaksiRepository(Application application){
        TransaksiDatabase database = TransaksiDatabase.getInstance(application);
        transaksiDAO = database.transaksiDAO();
        allTransaksi = transaksiDAO.getAlltransaksi();
    }

    LiveData<List<Transaksi>> getAllTransaksi() {
        return allTransaksi;
    }

    void insert(Transaksi transaksi){
        TransaksiDatabase.databaseWriteExecutor.execute(() -> {
            transaksiDAO.insert(transaksi);
        });
    }
    void update(Transaksi transaksi){
        TransaksiDatabase.databaseWriteExecutor.execute(() ->{
           transaksiDAO.update(transaksi);
        });
    }
    void delete(Transaksi transaksi){
        TransaksiDatabase.databaseWriteExecutor.execute(() ->{
            transaksiDAO.delete(transaksi);
        });
    }
    void deleteAllTransaksi(){
        TransaksiDatabase.databaseWriteExecutor.execute(() ->{
            transaksiDAO.deleteAlltransaksi();
        });
    }
}
