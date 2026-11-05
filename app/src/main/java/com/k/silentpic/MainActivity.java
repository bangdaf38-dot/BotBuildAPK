<<<<<<< HEAD
package com.k.silentpic;

import android.app.Activity;
import android.os.Bundle;
=======
package com.example.simplecalc;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
>>>>>>> 119c5c02c5235e8411952e36327ae0265501614c
import android.widget.TextView;
import android.graphics.Color;
import android.view.Gravity;

public class MainActivity extends Activity {
<<<<<<< HEAD
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TextView tv = new TextView(this);
        tv.setText("HELLO WORLD!\nBuild berhasil.");
        tv.setTextColor(Color.WHITE);
        tv.setTextSize(30);
        tv.setGravity(Gravity.CENTER);
        tv.setBackgroundColor(Color.BLACK);
        setContentView(tv);
=======

    private TextView display;
    private double firstOperand = 0;
    private String operator = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setPadding(20, 20, 20, 20);

        // Display TextView
        display = new TextView(this);
        display.setText("0");
        display.setTextSize(24);
        display.setSingleLine();
        display.setGravity(android.view.Gravity.CENTER_HORIZONTAL);
        layout.addView(display);

        // Number buttons 0-9
        for (int i = 0; i < 10; i++) {
            final int digit = i;
            Button btn = new Button(this);
            btn.setText(String.valueOf(i));
            btn.setLayoutParams(new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT));
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String current = display.getText().toString();
                    if (current.equals("0") && digit == 0) {
                        // keep single 0
                    } else {
                        display.setText(current + digit);
                    }
                }
            });
            layout.addView(btn);
        }

        // 4 Matematika buttons: +, -, *, /
        String[] opLabels = {"+", "-", "*", "/"};
        for (String label : opLabels) {
            Button btn = new Button(this);
            btn.setText(label);
            btn.setLayoutParams(new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT));
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String text = display.getText().toString();
                    if (text.equals("0") && operator.isEmpty()) return;
                    firstOperand = Double.parseDouble(text);
                    operator = label;
                    display.setText("0");
                    Toast.makeText(MainActivity.this, "Operator: " + label, Toast.LENGTH_SHORT).show();
                }
            });
            layout.addView(btn);
        }

        // Equals button
        Button btnEq = new Button(this);
        btnEq.setText("=");
        btnEq.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));
        btnEq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (operator.isEmpty()) return;
                String secondText = display.getText().toString();
                double second = Double.parseDouble(secondText);
                double result = 0;
                switch (operator) {
                    case "+": result = firstOperand + second; break;
                    case "-": result = firstOperand - second; break;
                    case "*": result = firstOperand * second; break;
                    case "/": result = (second != 0) ? firstOperand / second : 0; break;
                    default: result = second;
                }
                display.setText(String.valueOf(result));
                operator = "";
            }
        });
        layout.addView(btnEq);

        setContentView(layout);
>>>>>>> 119c5c02c5235e8411952e36327ae0265501614c
    }
}
