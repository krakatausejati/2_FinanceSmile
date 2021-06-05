package com.example.financesmile.addData;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.financesmile.R;

import java.util.Locale;

public class addDataFragment extends Fragment {

    private Button dateButton, saveButton;
    private EditText inputNamaTransaksi, inputNominal, inputKeterangan;
    private AddDataViewModel tambahDataViewModel;
    private Locale locale;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        tambahDataViewModel =
                new ViewModelProvider(this).get(AddDataViewModel.class);
        View root = inflater.inflate(R.layout.fragment_add_data, container, false);

        locale = getResources().getConfiguration().locale;

        dateButton = root.findViewById(R.id.buttonTanggal);

        dateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment datePicker = new DatePickerFragment();
                datePicker.show(getFragmentManager(), "date picker");
            }
        });

        Spinner spinner = (Spinner) root.findViewById(R.id.button_jenis_transaksi);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(), R.array.jenis_transaksi, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        saveButton = root.findViewById(R.id.savebutton);
        inputNamaTransaksi = root.findViewById(R.id.inputNamaTransaksi);
        inputNominal = root.findViewById(R.id.inputNominal);
        inputKeterangan = root.findViewById(R.id.inputKeterangan);

        inputNominal.setText("0");

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("jenisTransaksi", spinner.getSelectedItem().toString());
                bundle.putString("namaTransaksi", inputNamaTransaksi.getText().toString());
                bundle.putInt("nominalTransaksi", Integer.parseInt(inputNominal.getText().toString()));
                bundle.putString("keteranganTransaksi", inputKeterangan.getText().toString());
                bundle.putString("tanggalTransaksi", dateButton.getText().toString());

                Toast.makeText(getContext(), "Data berhasil ditambahkan", Toast.LENGTH_SHORT).show();
                getParentFragmentManager().setFragmentResult("dataTransaksi", bundle);
            }
        });

        return root;
    }
}