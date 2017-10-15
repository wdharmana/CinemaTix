package com.android.cinematix;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

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

        // Declare intent here
        Intent intent = getIntent();

        String classCinematix = intent.getStringExtra("classCinematix");
        tvClass.setText(classCinematix);

        String movieCinematix = intent.getStringExtra("filmCinematix");
        tvMovie.setText(movieCinematix);

        int rate = 0;
        tvRate.setText(String.valueOf(rate));

        final String additional = intent.getStringExtra("additionalCinematix");
        int priceAdditional = getPriceBasedOnAdditional(additional);
        tvAdditional.setText(String.valueOf(priceAdditional));

        String jumlah = intent.getStringExtra("jumlahCinematix");
        tvJumlah.setText(jumlah);

        // Sub total
        int priceClass = getPriceBasedOnClass(classCinematix);

        int subTotalMovie = priceClass * Integer.valueOf(jumlah);
        tvSubTotalTicket.setText(String.valueOf(subTotalMovie));

        int subTotalAddtional = priceAdditional * Integer.valueOf(jumlah);
        tvSubTotalAddtional.setText(String.valueOf(subTotalAddtional));

        // Total
        int total = subTotalMovie + subTotalAddtional;
        tvTotal.setText(String.valueOf(total));

        btnShare = (Button) findViewById(R.id.btn_share);
        btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sendText = "Memesan " + tvJumlah.getText().toString() + " tiket " +
                        tvMovie.getText().toString() + ". Kelas " + tvClass.getText().toString() +
                        ", include popcorn dan soda : " + additional + ".\n" +
                        "Total Harga : " + tvTotal.getText().toString();
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, sendText);
                sendIntent.setType("text/plain");
                startActivity(Intent.createChooser(sendIntent, "Bagikan ke "));
            }
        });
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


    public int getSubTotalAdditional(int additionalPrice, int pcs) {
        return additionalPrice * pcs;
    }

}
