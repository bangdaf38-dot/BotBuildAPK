package com.example.halo_kanha;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widgetionate;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        // Hide status bar and set window to full screen
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULL_SCREEN,
                WindowManager.LayoutParams.FLAG_FULL_SCREEN);
        
        // Create main container with black background
        FrameLayout rootLayout = new FrameLayout(this);
        rootLayout.setBackground(getDrawable(android.R.color.black));
        
        // Create linear layout for vertical arrangement
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        linearLayout.setGravity(16); // Center horizontally and vertically
        
        // Create TextView for "HALO KANHA"
        TextViewTextView = new TextView(this);
        TextView.setText("HALO KANHA");
        TextView.setTextColor(0xFFFF0000); // Red color
        TextView.setTextAppearance(this, android.R.style.TextAppearance_Large);
        TextView.setPadding(20, 20, 20, 20);
        
        // Create Button for "TUTUP"
        Button TutupButton = new Button(this);
        TutupButton.setText("TUTUP");
        TutupButton.setTextColor(0xFFFFFFFF); // White text
        TutupButton.setBackground(getDrawable(android.R.color.holo_red_dark));
        TutupButton.setPadding(20, 20, 20, 20);
        
        // Add views to linear layout
        linearLayout.addView(TextView);
        linearLayout.addView(TutupButton);
        
        // Add linear layout to root container
        rootLayout.addView(linearis);
        
        // Set content view
        setContentView(rootLayout);
        
        // Close app when button is clicked
        TutupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}