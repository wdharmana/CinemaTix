package com.android.cinematix;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //TODO (2) buat variabel komponen UI

    private List<String> classCinematix;
    private List<String> filmCinematix;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //TODO (3) inisialisasikan value dari tiap variabel widget UI menggunakan findViewById

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


        //TODO (4) buat adapter untuk masing-masing spinner menggunakan ArrayAdapter

        //TODO (5) setup masing-masing spinner dengan adapter yang sudah dibuat

        //TODO (6) buat action saat tombol pesan di klik
        //TODO (7) kirim semua data inputan ke UI / Activity berikutnya menggunakan Intent
        //TODO (8) lakukan validasi inputan, dimana jumlah tiket harus diisi minimal 1 tiket
        //TODO (9) navigasi ke UI / Activity berikutnya menggunakan method startActivity()

    }
}
