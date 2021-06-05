package com.example.financesmile.riwayat;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.financesmile.Transaksi;

import java.util.List;

public class RiwayatViewModel extends AndroidViewModel {

    private TransaksiRepository transaksiRepository;

    private final LiveData<List<Transaksi>> allTransaksi;

    public RiwayatViewModel(Application application){
        super(application);
        transaksiRepository = new TransaksiRepository(application);
        allTransaksi = transaksiRepository.getAllTransaksi();
    }

    public LiveData<List<Transaksi>> getAllTransaksi() {
        return allTransaksi;
    }

    void insert(Transaksi transaksi){
        transaksiRepository.insert(transaksi);
    }
    public void update(Transaksi transaksi){
        transaksiRepository.update(transaksi);
    }
    public void delete(Transaksi transaksi){
        transaksiRepository.delete(transaksi);
    }
    void deleteAllTransaksi(){
        transaksiRepository.deleteAllTransaksi();
    }
}
