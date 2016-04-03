package com.example.android.redlinemobu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Bengt on 2016-04-03.
 */
public class GTNSettingsActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.gtn_settings_layout);

    }

    private void chooseSettings(int settings) {

        Intent setGTNSettings = new Intent(this, GTNActivity.class);

        if (settings == 1) {
            setGTNSettings.putExtra("minValue", 1);
            setGTNSettings.putExtra("maxValue", 10);
            setGTNSettings.putExtra("maxGuesses", 5);
        } else if (settings == 2) {
            setGTNSettings.putExtra("minValue", 1);
            setGTNSettings.putExtra("maxValue", 100);
            setGTNSettings.putExtra("maxGuesses", 7);
        } else {
            setGTNSettings.putExtra("minValue", 1);
            setGTNSettings.putExtra("maxValue", 1000);
            setGTNSettings.putExtra("maxGuesses", 10);
        }

        startActivity(setGTNSettings);

        finish();

    }

    public void chooseEasy(View view) {
        chooseSettings(1);
    }

    public void chooseMedium(View view) {
        chooseSettings(2);
    }

    public void chooseHard(View view) {
        chooseSettings(3);
    }

    // Go back to choose game

    public void quitGTNSettings(View view) {

        Intent chooseGameToPlay = new Intent(this, MainActivity.class);

        startActivity(chooseGameToPlay);

        finish();

    }
}
