package com.example.android.redlinemobu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

/**
 * Created by Bengt on 2016-04-03.
 */
public class GTNActivity extends Activity {

    Random rand = new Random();

    int minValue, maxValue, maxGuesses, correctValue, nbrOfGuessesLeft, number;

    //TextView minView, guessView, maxView, infoView, nbrGuessesLeftView;

    boolean guessActive;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.gtn_layout);


        Intent getGTNSettingsValues = getIntent();


        minValue = getGTNSettingsValues.getExtras().getInt("minValue");
        maxValue = getGTNSettingsValues.getExtras().getInt("maxValue");
        maxGuesses = getGTNSettingsValues.getExtras().getInt("maxGuesses");

        /*
        minValue = 1;
        maxValue = 100;
        maxGuesses = 7;


        TextView nbrGuessesLeftView = (TextView) findViewById(R.id.number_of_guesses_left_text_view);
        TextView infoView = (TextView) findViewById(R.id.inform_user_text_view);
        TextView minView = (TextView) findViewById(R.id.lowest_value_text_view);
        TextView guessView = (TextView) findViewById(R.id.guess_text_view);
        TextView maxView = (TextView) findViewById(R.id.highest_value_text_view);
        */
        resetGame();
    }

    public void resetGame() {
        //generate a value

        TextView nbrGuessesLeftView = (TextView) findViewById(R.id.number_of_guesses_left_text_view);
        TextView infoView = (TextView) findViewById(R.id.inform_user_text_view);
        TextView minView = (TextView) findViewById(R.id.lowest_value_text_view);
        TextView guessView = (TextView) findViewById(R.id.guess_text_view);
        TextView maxView = (TextView) findViewById(R.id.highest_value_text_view);

        correctValue = rand.nextInt(maxValue-minValue) + minValue;
        nbrOfGuessesLeft = maxGuesses;

        nbrGuessesLeftView.setText("Number of guesses left: " + String.valueOf(nbrOfGuessesLeft));
        //set border value, one less then minmum and one more then max
        minView.setText(String.valueOf(minValue-1)+"<");
        guessView.setText(String.valueOf(minValue));
        maxView.setText("<" + String.valueOf(maxValue+1));
        infoView.setText("Guess a number!");
        number = minValue;
        guessActive = true;
    }




    public void guessTheNumber(View view) {
        TextView nbrGuessesLeftView = (TextView) findViewById(R.id.number_of_guesses_left_text_view);
        TextView infoView = (TextView) findViewById(R.id.inform_user_text_view);
        TextView minView = (TextView) findViewById(R.id.lowest_value_text_view);

        TextView maxView = (TextView) findViewById(R.id.highest_value_text_view);


        if (number > minValue && number < maxValue) {
            nbrOfGuessesLeft--;
            if (number == correctValue) {
                guessActive = false;
                infoView.setText("Correct, you did it with " + (maxGuesses-nbrOfGuessesLeft) + " tries!\nReset or quit!");
            } else if (number < correctValue){
                infoView.setText("Too low!");
                minView.setText(String.valueOf(number)+"<");


            } else {
                infoView.setText("Too high!");
                maxView.setText("<" + String.valueOf(number));


            }

            if (nbrOfGuessesLeft == 0) {
                guessActive=false;
                infoView.setText("You ran out of guesses, the correct value was " + correctValue + "!\nReset or quit!");
            }
            else {
                nbrGuessesLeftView.setText("Number of guesses left: " + String.valueOf(nbrOfGuessesLeft));
            }

        }else {
            infoView.setText("Guess is out of bound!");
        }


    }

    public void increase1(View view) {
        TextView guessView = (TextView) findViewById(R.id.guess_text_view);
        if (guessActive) {
            number++;
            guessView.setText(String.valueOf(number));
        }
    }

    public void decrease1(View view) {
        TextView guessView = (TextView) findViewById(R.id.guess_text_view);
        if (guessActive) {
            number--;
            guessView.setText(String.valueOf(number));
        }
    }

    public void increase10(View view) {
        TextView guessView = (TextView) findViewById(R.id.guess_text_view);
        if (guessActive) {
            number += 10;
            guessView.setText(String.valueOf(number));
        }
    }

    public void decrease10(View view) {
        TextView guessView = (TextView) findViewById(R.id.guess_text_view);
        if (guessActive) {
            number -= 10;
            guessView.setText(String.valueOf(number));
        }
    }

    public void increase50(View view) {
        TextView guessView = (TextView) findViewById(R.id.guess_text_view);
        if (guessActive) {
            number += 50;
            guessView.setText(String.valueOf(number));
        }
    }

    public void decrease50(View view) {
        TextView guessView = (TextView) findViewById(R.id.guess_text_view);
        if (guessActive) {
            number -= 50;
            guessView.setText(String.valueOf(number));
        }
    }

    public void quitGuessTheNumber(View view) {

        Intent gtnSettings = new Intent(this, GTNSettingsActivity.class);

        startActivity(gtnSettings);

        finish();

    }

    public void resetGuessTheNumber(View view) {
        resetGame();
    }
}
