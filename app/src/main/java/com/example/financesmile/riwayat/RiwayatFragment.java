package com.example.financesmile.riwayat;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.financesmile.R;
import com.example.financesmile.Transaksi;

public class RiwayatFragment extends Fragment {

    private RiwayatViewModel riwayatViewModel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getParentFragmentManager().setFragmentResultListener("dataTransaksi", this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle bundle) {
                String tanggalTransaksi = bundle.getString("tanggalTransaksi");
                String jenisTransaksi = bundle.getString("jenisTransaksi");
                String namaTransaksi = bundle.getString("namaTransaksi");
                int nominalTransaksi = bundle.getInt("nominalTransaksi");
                String keteranganTransaksi = bundle.getString("keteranganTransaksi");

                Transaksi transaksi = new Transaksi(namaTransaksi, nominalTransaksi, keteranganTransaksi, tanggalTransaksi, jenisTransaksi);
                riwayatViewModel.insert(transaksi);
            }
        });
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        riwayatViewModel = new ViewModelProvider(this).get(RiwayatViewModel.class);
        View root = inflater.inflate(R.layout.fragment_riwayat, container, false);

        final TransaksiListAdapter adapter = new TransaksiListAdapter(new TransaksiListAdapter.TransaksiDiff(), getContext());

        RecyclerView recyclerView = root.findViewById(R.id.recyclerView);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        riwayatViewModel.getAllTransaksi().observe(getViewLifecycleOwner(), transaksis -> {
            adapter.submitList(transaksis);
        });

        return root;
    }
}