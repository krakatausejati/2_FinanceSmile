package com.example.financesmile;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.financesmile.riwayat.RiwayatFragment;
import com.example.financesmile.riwayat.RiwayatViewModel;

import static java.security.AccessController.getContext;

public class DetailTransaksiActivity extends AppCompatActivity {
    TextView namaTransaksi, nominalTransaksi, tanggalTransaksi, keterangan, jenisTransaksi;
    private RiwayatViewModel riwayatViewModel;
    Button deleteButton, updateButton;

    String data1, data3, data4, data5;
    int data2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // hide the title bar
        setContentView(R.layout.activity_detail);

        deleteButton = findViewById(R.id.buttonDelete);
        updateButton = findViewById(R.id.buttonUpdate);
        namaTransaksi = findViewById(R.id.titleTransaksi);
        nominalTransaksi = findViewById(R.id.nominal);
        tanggalTransaksi = findViewById(R.id.tanggal);
        keterangan = findViewById(R.id.keterangan);
        jenisTransaksi = findViewById(R.id.jenis);

        Intent intent = getIntent();

        Transaksi transaksi = intent.getParcelableExtra("Transaksi");

        data1 = transaksi.getJenisTransaksi();
        data2 = transaksi.getNominalTransaksi();
        data3 = transaksi.getTanggalTransaksi();
        data4 = transaksi.getNamaTransaksi();
        data5 = transaksi.getKeteranganTransaksi();

        jenisTransaksi.setText(data1);
        nominalTransaksi.setText(Integer.toString(data2));
        tanggalTransaksi.setText(data3);
        namaTransaksi.setText(data4);
        keterangan.setText(data5);

        riwayatViewModel = new ViewModelProvider(this, new ViewModelProvider.AndroidViewModelFactory(getApplication())).get(RiwayatViewModel.class);
        deleteButton.setOnClickListener(View -> {
            riwayatViewModel.delete(transaksi);
            Toast.makeText(DetailTransaksiActivity.this, "Data Transaksi Berhasil dihapus", Toast.LENGTH_SHORT).show();
            finish();
        });
        updateButton.setOnClickListener(View -> {
            riwayatViewModel.update(transaksi);
            Toast.makeText(DetailTransaksiActivity.this, "Data Transaksi Belum Bisa diupdate", Toast.LENGTH_SHORT).show();
            finish();
        });
        ImageButton backButton = (ImageButton)findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
}
