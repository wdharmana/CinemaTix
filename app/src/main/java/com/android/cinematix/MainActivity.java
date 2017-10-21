package com.android.cinematix;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Spinner spClass, spMovie;
    private EditText etJumlah;
    private RadioGroup rgAdditional;
    private RadioButton rbAdditional;
    private Button btnBook;

    private List<String> classCinematix, movieCinematix;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inisialisasi komponen berdasarkan id dari layout ke dalam variabel
        spClass = (Spinner) findViewById(R.id.sp_class);
        spMovie = (Spinner) findViewById(R.id.sp_movie);
        etJumlah = (EditText) findViewById(R.id.edt_jumlah);
        rgAdditional = (RadioGroup) findViewById(R.id.rg_additional);
        btnBook = (Button) findViewById(R.id.btn_book);

        // Berikan spinner beberapa data
        classCinematix = new ArrayList<String>();
        classCinematix.add("Ekonomi");
        classCinematix.add("Regular");
        classCinematix.add("Eksekutif");

        movieCinematix = new ArrayList<String>();
        movieCinematix.add("Emoji");
        movieCinematix.add("Star Wars: The last Jedi");
        movieCinematix.add("Rumah Pengabdi Setan?");
        movieCinematix.add("Interstellar");
        movieCinematix.add("Blade Runner 2049");
        movieCinematix.add("Thor: Ragnarok");
        movieCinematix.add("Pokemon: I Choose You");
        movieCinematix.add("Happy Death Day");
        movieCinematix.add("IT!");
        movieCinematix.add("Guardians Of Galaxy. Volume 2");

        // Buatlah adapter untuk spinner
        ArrayAdapter<String> classCinematixAdapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, classCinematix);
        ArrayAdapter<String> movieCinematixAdapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, movieCinematix);

        // Set adapter tadi ke dalam spinner
        spClass.setAdapter(classCinematixAdapter);
        spMovie.setAdapter(movieCinematixAdapter);

        // Deteksi kapan tombol "Pesan Tiket" di tekan
        btnBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                boolean valid = true;

                if (etJumlah.getText().length() < 1) {
                    etJumlah.setError("Wajib diisi!");
                    valid = false;
                } else if (Integer.parseInt(etJumlah.getText().toString()) < 1) {
                    etJumlah.setError("Minimal 1 tiket");
                    valid = false;
                }

                // Jika valid, lanjutkan ke ResultActivity
                if (valid) {
                    int selectedId = rgAdditional.getCheckedRadioButtonId();
                    rbAdditional = (RadioButton) findViewById(selectedId);

                    Intent intent = new Intent(MainActivity.this, ResultActivity.class);

                    // Set data untuk dikirimkan ke ResultActivity
                    intent.putExtra("classCinematix", spClass.getSelectedItem().toString());
                    intent.putExtra("movieCinematix", spMovie.getSelectedItem().toString());
                    intent.putExtra("additionalCinematix", rbAdditional.getText().toString());
                    intent.putExtra("jumlahCinematix", etJumlah.getText().toString());

                    // Pindah activity ke ResultActivity
                    startActivity(intent);
                }
            }
        });
    }
}
