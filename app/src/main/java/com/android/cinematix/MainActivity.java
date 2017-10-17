package com.android.cinematix;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button btnBook;
    private RadioGroup rgAdditional;
    private RadioButton rbAdditional;
    private EditText etJumlah;
    private Spinner spClass,spFilm;

    private List<String> classCinematix;
    private List<String> filmCinematix;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Spinner Element
        spClass = (Spinner) findViewById(R.id.sp_class);
        spFilm = (Spinner) findViewById(R.id.sp_movie);

        // Radio element
        rgAdditional = (RadioGroup) findViewById(R.id.rg_additional);

        // EditText Element
        etJumlah = (EditText) findViewById(R.id.edt_jumlah);

        // Spinner Dropdown elements
        classCinematix = new ArrayList<String>();
        classCinematix.add("Ekonomi");
        classCinematix.add("Regular");
        classCinematix.add("Eksekutif");

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


        // Creating adapter for spinner
        ArrayAdapter<String> classCinematixAdapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, classCinematix);
        ArrayAdapter<String> filmCinematixAdapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, filmCinematix);


        // Attaching data adapter to spinner
        spClass.setAdapter(classCinematixAdapter);
        spFilm.setAdapter(filmCinematixAdapter);

        btnBook = (Button) findViewById(R.id.btn_book);
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

                if (valid) {

                    Intent intent = new Intent(MainActivity.this, ResultActivity.class);

                    intent.putExtra("classCinematix", spClass.getSelectedItem().toString());
                    intent.putExtra("filmCinematix", spFilm.getSelectedItem().toString());

                    int selectedId = rgAdditional.getCheckedRadioButtonId();
                    rbAdditional = (RadioButton) findViewById(selectedId);
                    intent.putExtra("additionalCinematix", rbAdditional.getText().toString());

                    intent.putExtra("jumlahCinematix", etJumlah.getText().toString());

                    startActivity(intent);

                }
            }
        });

    }
}
