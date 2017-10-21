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

    private Spinner spClass;
    // TODO (5) Buatlah variabel private untuk komponen UI berikut :
    // Spinner spClass (spMovie), EditText (etJumlah),
    // RadioGroup (rgAdditional), RadioButton (rbAdditional), Button (btnBook)
    // [ikuti contoh di atas (spClass)]

    private List<String> classCinematix, movieCinematix;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inisialisasi komponen berdasarkan id dari layout ke dalam variabel
        spClass = (Spinner) findViewById(R.id.sp_class);
        // TODO (6) Lanjutkan inisialisasi value untuk "Spinner (spMovie)"
        // [ikuti contoh di atas (spClass)]

        // TODO (7) Lanjutkan inisialisasi value untuk "EditText (etJumlah)"

        // TODO (8) Lanjutkan inisialisasi value untuk "RadioGroup (rgAdditional)"

        // TODO (9) Lanjutkan inisialisasi value untuk "Button (btnBook)"

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
        // TODO (10) Lanjutkan membuat adapter untuk "movieCinematixAdapter"
        // [ikuti contoh di atas (classCinematixAdapter)]

        // Set adapter tadi ke dalam spinner
        spClass.setAdapter(classCinematixAdapter);
        // TODO (11) Lanjutkan men-setup "spMovie"
        // [ikuti contoh di atas (spClass)]

        // Deteksi kapan tombol "Pesan Tiket" di tekan
        btnBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                boolean valid = true;

                if (etJumlah.getText().length() < 1) {
                    // TODO (12.A) setError pada "etJumlah" dengan pernyataan "Wajib diisi!"
                    valid = false;
                } else if (Integer.parseInt(etJumlah.getText().toString()) < 1) {
                    // TODO (12.B) setError pada "etJumlah" dengan pernyataan "Minimal 1 tiket!"
                    valid = false;
                }

                // Jika valid, lanjutkan ke ResultActivity
                if (valid) {
                    int selectedId = rgAdditional.getCheckedRadioButtonId();
                    rbAdditional = (RadioButton) findViewById(selectedId);

                    // TODO (13.A) Buatlah object "Intent" dengan sumber "MainActivity", dan tujuannya ke "ResultActivity"

                    // Set data untuk dikirimkan ke ResultActivity
                    intent.putExtra("classCinematix", spClass.getSelectedItem().toString());
                    // TODO (13.B) Masukkan "spMovie" ke dalam "intent" dengan "putExtra" menggunakan konstanta "movieCinematix"
                    // [ikuti contoh di atas (spClass)]

                    intent.putExtra("additionalCinematix", rbAdditional.getText().toString());
                    // TODO (13.B) Masukkan "etJumlah" ke dalam "intent" dengan "putExtra" menggunakan konstanta "jumlahCinematix"
                    // [ikuti contoh di atas (rbAdditional)]

                    // Pindah activity ke ResultActivity
                    // TODO (13.C) Gunakan method "startActivity()" dengan parameter "intent"
                }
            }
        });
    }
}
