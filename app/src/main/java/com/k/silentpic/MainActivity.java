package com.example.kalkulator;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity {

    private EditText etAngka1;
    private EditText etAngka2;
    private TextView tvHasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setPadding(40, 40, 40, 40);

        etAngka1 = new EditText(this);
        etAngka1.setHint("Angka 1");
        etAngka1.setSingleLine();

        etAngka2 = new EditText(this);
        etAngka2.setHint("Angka 2");
        etAngka2.setSingleLine();

        Button btnTambah = new Button(this);
        btnTambah.setText("+");

        Button btnKurang = new Button(this);
        btnKurang.setText("-");

        Button btnKali = new Button(this);
        btnKali.setText("*");

        Button btnBagi = new Button(this);
        btnBagi.setText("/");

        tvHasil = new TextView(this);
        tvHasil.setText("Hasil: ");
        tvHasil.setTextSize(20);

        layout.addView(etAngka1);
        layout.addView(etAngka2);
        layout.addView(btnTambah);
        layout.addView(btnKurang);
        layout.addView(btnKali);
        layout.addView(btnBagi);
        layout.addView(tvHasil);

        setContentView(layout);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    double a = Double.parseDouble(etAngka1.getText().toString());
                    double b = Double.parseDouble(etAngka2.getText().toString());
                    double hasil = 0;

                    if (v == btnTambah) {
                        hasil = a + b;
                    } else if (v == btnKurang) {
                        hasil = a - b;
                    } else if (v == btnKali) {
                        hasil = a * b;
                    } else if (v == btnBagi) {
                        if (b == 0) {
                            tvHasil.setText("Error: Pembagian nol");
                            return;
                        }
                        hasil = a / b;
                    }

                    tvHasil.setText("Hasil: " + hasil);
                } catch (NumberFormatException e) {
                    tvHasil.setText("Masukkan angka valid");
                }
            }
        };

        btnTambah.setOnClickListener(listener);
        btnKurang.setOnClickListener(listener);
        btnKali.setOnClickListener(listener);
        btnBagi.setOnClickListener(listener);
    }
}