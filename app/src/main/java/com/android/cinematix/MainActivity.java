package com.android.cinematix;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Button btnBook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Spinner Element
        Spinner spClass = (Spinner) findViewById(R.id.sp_class);
        Spinner spFilm = (Spinner) findViewById(R.id.sp_movie);
        Spinner spAdditional = (Spinner) findViewById(R.id.sp_additional);

        // Spinner click listener
        spClass.setOnItemSelectedListener(this);
        spFilm.setOnItemSelectedListener(this);
        spAdditional.setOnItemSelectedListener(this);

        // Spinner Dropdown elements
        List<String> classCinematix = new ArrayList<String>();
        classCinematix.add("Ekonomi");
        classCinematix.add("Regular");
        classCinematix.add("Eksekutif");

        List<String> filmCinematix = new ArrayList<String>();
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

        List<String> additionalCinematix = new ArrayList<String>();
        additionalCinematix.add("Ya");
        additionalCinematix.add("Tidak");


        // Creating adapter for spinner
        ArrayAdapter<String> classCinematixAdapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, classCinematix);
        ArrayAdapter<String> filmCinematixAdapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, filmCinematix);
        ArrayAdapter<String> additionalCinematixAdapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, additionalCinematix);


        // Drop down layout style - list view with radio button
        classCinematixAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        filmCinematixAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        additionalCinematixAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);

        // Attaching data adapter to spinner
        spClass.setAdapter(classCinematixAdapter);
        spFilm.setAdapter(filmCinematixAdapter);
        spAdditional.setAdapter(additionalCinematixAdapter);

        btnBook = (Button) findViewById(R.id.btn_book);
        btnBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
