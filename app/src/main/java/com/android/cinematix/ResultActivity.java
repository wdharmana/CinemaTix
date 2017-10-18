package com.android.cinematix;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.Locale;

public class ResultActivity extends AppCompatActivity {

    private TextView tvClass, tvMovie, tvRate, tvAdditional, tvJumlah;
    private TextView tvSubTotalTicket, tvSubTotalAddtional, tvTotal;
    private Button btnShare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        tvClass = (TextView) findViewById(R.id.tv_class);
        tvMovie = (TextView) findViewById(R.id.tv_movie);
        tvRate = (TextView) findViewById(R.id.tv_rate);
        tvAdditional = (TextView) findViewById(R.id.tv_additional);
        tvJumlah = (TextView) findViewById(R.id.tv_jumlah);

        tvSubTotalTicket = (TextView) findViewById(R.id.tv_ticket_subtotal);
        tvSubTotalAddtional = (TextView) findViewById(R.id.tv_additional_subtotal);
        tvTotal = (TextView) findViewById(R.id.tv_total);

        btnShare = (Button) findViewById(R.id.btn_share);

        //TODO (10) Inisialiasi Intent yang dikirim dari UI / Activity sebelumnya menggunakan getIntent()

        //TODO (11) ambil value dari Intent tersebut, dan aplikasikan ke dalam UI

        //TODO (12) dapatkan harga kelas dan harga additional snack menggunakan fungsi getPriceBasedOnClass() dan getPriceBasedOnAdditional()

        //TODO (13) hitung total harga tiket, harga additional(popcorn & soda), dan total keseluruhan, formating bisa menggunakan method convertMoney()

        //TODO (14) tampilkan hasil perhitungan harga ke UI

        //TODO (15) buat action saat tombol "BAGIKAN KE TEMAN" di klik

        //TODO (16) pada action tombol, buat sebuah String yang menjelaskan detail tiket yang dipesan

        //TODO (17) gunakan Intent dengan ACTION_SEND untuk melakukan share String yang sudah dibuat
    }

    public int getPriceBasedOnClass(String classCinema) {
        int price = 0;
        switch (classCinema) {
            case "Ekonomi":
                price = 20000;
                break;
            case "Regular":
                price = 30000;
                break;
            case "Eksekutif":
                price = 50000;
                break;
            default:
                price = 0;
                break;
        }
        return price;
    }

    public int getPriceBasedOnAdditional(String additional) {
        int price = 0;
        switch (additional) {
            case "Ya":
                price = 20000;
                break;
            case "Tidak":
            default:
                price = 0;
                break;
        }
        return price;
    }

    public String convertMoney(int money) {
        return NumberFormat.getNumberInstance(Locale.GERMANY).format(money);
    }


}
