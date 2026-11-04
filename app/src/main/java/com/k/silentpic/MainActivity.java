package com.example.contohaplikasi;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    private EditText inputNama;
    private Button tombolSapa;
    private TextView teksHasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputNama = findViewById(R.id.inputNama);
        tombolSapa = findViewById(R.id.tombolSapa);
        teksHasil = findViewById(R.id.teksHasil);

        tombolSapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nama = inputNama.getText().toString().trim();

                if (nama.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Silakan isi nama terlebih dahulu!", Toast.LENGTH_SHORT).show();
                    return;
                }

                String sapaan = "Halo, " + nama + "! Selamat menggunakan aplikasi ini.";
                teksHasil.setText(sapaan);
                Toast.makeText(MainActivity.this, sapaan, Toast.LENGTH_LONG).show();
            }
        });
    }
}