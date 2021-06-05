package com.example.financesmile.dompet;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.financesmile.R;

import static android.app.Activity.RESULT_OK;

public class dompetFragment extends Fragment {

    private Button editfoto;
    private ImageView fotoprofile;
    private Uri file;
    final int kodeGallery = 100, kodeKamera = 99;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_dompet, container, false);

        editfoto = root.findViewById(R.id.profileButton);
        fotoprofile = root.findViewById(R.id.foto_profile);

        editfoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentGallery = new Intent(Intent.ACTION_PICK,MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intentGallery, kodeGallery);
            }
        });

        return root;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == kodeGallery && resultCode == RESULT_OK){
            file = data.getData();
            fotoprofile.setImageURI(file);
        }
    }
}