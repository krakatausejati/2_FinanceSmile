package com.example.financesmile.riwayat;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.financesmile.R;

public class TransaksiViewHolder extends RecyclerView.ViewHolder {

    private final TextView namaTransaksi, jenisTransaksi, nominalTransaksi;
    ConstraintLayout detailButton;

    private TransaksiViewHolder(View itemView){
        super(itemView);
        namaTransaksi = itemView.findViewById(R.id.nama_transaksi);
        jenisTransaksi = itemView.findViewById(R.id.jenis_transaksi);
        nominalTransaksi = itemView.findViewById(R.id.nominal_transaksi);
        detailButton = itemView.findViewById(R.id.transaksiLayout);
    }

    public void bind(String namaTransaksi, String jenisTransaksi, int nominalTransaksi) {
        this.namaTransaksi.setText(namaTransaksi);
        this.jenisTransaksi.setText(jenisTransaksi);
        this.nominalTransaksi.setText(Integer.toString(nominalTransaksi));
    }

    static TransaksiViewHolder create(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_transaksi, parent, false);
        return new TransaksiViewHolder(view);
    }
}
