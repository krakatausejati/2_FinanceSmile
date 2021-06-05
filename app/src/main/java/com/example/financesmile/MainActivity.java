package com.example.financesmile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.DatePicker;

import com.example.financesmile.addData.DatePickerFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements DatePickerFragment.OnDateSetListener  {

    private Locale locale;
    private Button dateButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // hide the title bar
        setContentView(R.layout.activity_main);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.dompetFragment, R.id.addDataFragment,R.id.riwayatFragment)
                .build();
        NavController navController = Navigation.findNavController(this,  R.id.nav_host_fragment);
        NavigationUI.setupWithNavController(bottomNavigationView, navController);
        dateButton = findViewById(R.id.buttonTanggal);

        locale = getResources().getConfiguration().locale;
        locale.setDefault(locale);
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int day) {
        final Calendar calendar = Calendar.getInstance(locale);
        final DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.MEDIUM, locale);

        calendar.set(year, month, day);
        SimpleDateFormat format = new SimpleDateFormat("dd MMMM yyyy");
        String dateString = format.format(calendar.getTime());
        dateButton = findViewById(R.id.buttonTanggal);
        dateButton.setText(dateString);

    }
}