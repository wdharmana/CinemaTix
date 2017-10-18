package com.android.cinematix;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

// TODO (5.A) buat class MainActivity agar bisa mengimplementasikan OnItemSelectedListener
public class MainActivity extends AppCompatActivity {

    // TODO (5) buat variabel komponen UI untuk:
    // EditText (etJumlah), RadioButton (rbAdditional),
    // RadioGroup (rgAdditional), Spinner (spFilm) dan Button (btnBook);
    private Spinner spClass;


    private List<String> classCinematix;
    private List<String> filmCinematix;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Spinner Element
        spClass = (Spinner) findViewById(R.id.sp_class);
        // TODO (6) LANJUTKAN INISIALISASI VALUE UNTUK Spinner (spFilm) mengikuti contoh di atas


        // TODO (7) LANJUTKAN INISIALISASI VALUE UNTUK RadioButton (rbAdditional)


        // TODO (8) LANJUTKAN INISIALISASI VALUE UNTUK RadioGRoup (rgAdditional)


        // TODO (9) LANJUTKAN INISIALISASI VALUE UNTUK EditText (etJumlah)


        // TODO (10) LANJUTKAN INISIALISASI VALUE UNTUK Button (btnBook)


        // Spinner Click Listener
        spClass.setOnItemSelectedListener(this);
        // TODO (11) TAMBAHKAN spFilm dalam click listener

        // List data untuk daftar kelas
        classCinematix = new ArrayList<String>();
        classCinematix.add("Ekonomi");
        classCinematix.add("Regular");
        classCinematix.add("Eksekutif");

        //List data untuk daftar film
        filmCinematix = new ArrayList<String>();
        filmCinematix.add("Emoji");
        filmCinematix.add("Star Wars: The last Jedi");
        filmCinematix.add("Rumah Pengabdi Setan?");
        filmCinematix.add("Interstellar");
        filmCinematix.add("Blade Runner 2049");
        filmCinematix.add("Thor: Ragnarok");
        filmCinematix.add("Pokemon: I Choose You");
        filmCinematix.add("Happy Death Day");
        filmCinematix.add("IT!");
        filmCinematix.add("Guardians Of Galaxy. Volume 2");


        // Creating adapter for Spinner
        ArrayAdapter<String> classCinematixAdapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, classCinematix);
        // TODO (12) BUATKAN ADAPTER UNTUK filmCinematixAdapter sesuai dengan format classCinematixAdapter


        // Setup Adapter in dropdown view
        classCinematixAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        // TODO (13) SETUP ADAPTER UNTUK filmCinematixAdapter dalam dropdown view sesuai dengan format classCinematixAdapter

        btnBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                boolean valid = true;

                if (etJumlah.getText().length() < 1) {
                    // TODO (14.A) setError pada etJumlah dengan pernyataan "Wajib diisi!"
                    valid = false;
                } else if (Integer.parseInt(etJumlah.getText().toString()) < 1) {
                    // TODO (14.B) setError pada etJumlah dengan pernyataan "Minimal 1 tiket!"
                    valid = false;
                }

                if (valid) {

                    // Buatlah sebuah object Intent dengan sumbernya adalah MainActivity dan tujuannya adalah ResultActivity

                    intent.putExtra("classCinematix", spClass.getSelectedItem().toString());
                    // TODO (15.A) masukkan spFilm ke dalam intent dengan konstanta "filmCinematix"
                    // dengan mengikuti format di intent.putExtra sebelumnya

                    int selectedId = rgAdditional.getCheckedRadioButtonId();
                    rbAdditional = (RadioButton) findViewById(selectedId);
                    intent.putExtra("additionalCinematix", rbAdditional.getText().toString());

                    intent.putExtra("jumlahCinematix", etJumlah.getText().toString());

                    // TODO (15) masukkan method startActivity() dengan parameter intent untuk navigasi ke UI/Activity berikutnya

                }
            }
        });

    }

}
