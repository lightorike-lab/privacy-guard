
package com.privacyguard.app;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.provider.Settings;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout page = new LinearLayout(this);
        page.setOrientation(LinearLayout.VERTICAL);
        page.setPadding(28, 40, 28, 24);
        page.setGravity(Gravity.CENTER_HORIZONTAL);
        page.setBackgroundColor(Color.rgb(20, 28, 45));

        TextView title = new TextView(this);
        title.setText("PRIVACY GUARD");
        title.setTextSize(28);
        title.setTypeface(null, Typeface.BOLD);
        title.setTextColor(Color.WHITE);
        title.setGravity(Gravity.CENTER);
        page.addView(title, new LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT, 100));

        TextView subtitle = new TextView(this);
        subtitle.setText("Your privacy. Your control.");
        subtitle.setTextSize(17);
        subtitle.setTextColor(Color.LTGRAY);
        subtitle.setGravity(Gravity.CENTER);
        page.addView(subtitle);

        addButton(page, "App settings",
            Settings.ACTION_APPLICATION_SETTINGS);
        addButton(page, "Privacy settings",
            Settings.ACTION_PRIVACY_SETTINGS);
        addButton(page, "Security settings",
            Settings.ACTION_SECURITY_SETTINGS);
        addButton(page, "Battery settings",
            Settings.ACTION_BATTERY_SAVER_SETTINGS);

        TextView note = new TextView(this);
        note.setText("\nYou remain in control of your device.");
        note.setTextColor(Color.LTGRAY);
        note.setGravity(Gravity.CENTER);
        page.addView(note);

        setContentView(page);
    }

    private void addButton(LinearLayout page, String label,
                           String action) {
        Button button = new Button(this);
        button.setText(label);

        LinearLayout.LayoutParams params =
            new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        params.setMargins(0, 10, 0, 4);
        page.addView(button, params);

        button.setOnClickListener(v -> {
            try {
                startActivity(new Intent(action));
            } catch (Exception e) {
                Toast.makeText(this,
                    "Setting unavailable on this device",
                    Toast.LENGTH_SHORT).show();
            }
        });
    }
}
