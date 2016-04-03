package com.example.android.redlinemobu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

/**
 * Created by Bengt on 2016-04-02.
 */
public class RPSActivity extends Activity{

    Random rand = new Random();

    int win, tie, loss;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.rps_layout);

        win = 0;
        tie = 0;
        loss = 0;
    }

    /*****
     * 1 = rock
     * 2 = paper
     * 3 = scissor
     */


    private void generateResult(int userMove) {

        int computerMove = rand.nextInt(3) + 1;
        String resultText;
        TextView computerMoveView = (TextView) findViewById(R.id.computer_move_text_view);
        TextView resultView = (TextView) findViewById(R.id.rps_result_text_view);

        TextView winView = (TextView) findViewById(R.id.human_score_text_view);
        TextView tieView = (TextView) findViewById(R.id.tie_score_text_view);
        TextView lossView = (TextView) findViewById(R.id.computer_score_text_view);

        //Calculate resulte and inform user of result

        if (userMove == computerMove) {
            resultView.setText("Draw!");
            tie++;
        } else if ( (userMove == 1 && computerMove == 2) || (userMove == 2 && computerMove == 3 ) || (userMove == 3 && computerMove == 1 ) ){
            resultView.setText("You lose!");
            loss++;
        } else {
            resultView.setText("You win!");
            win++;
        }
        //Telling user what computer did!

        switch (computerMove) {
            case 1:
                computerMoveView.setText("Rock");
                break;
            case 2:
                computerMoveView.setText("Paper");
                break;
            case 3:
                computerMoveView.setText("Scissor");
                break;
            default:
                computerMoveView.setText("!");
                break;
        }

        // Updating score

        winView.setText(String.valueOf(win));
        tieView.setText(String.valueOf(tie));
        lossView.setText(String.valueOf(loss));
    }


    public void onChooseRock(View view) {
        generateResult(1);
    }

    public void onChoosePaper(View view) {
        generateResult(2);
    }

    public void onChooseScissor(View view) {
        generateResult(3);
    }

    public void onRPSQuitClick(View view) {

        Intent chooseGameToPlay = new Intent(this, MainActivity.class);

        startActivity(chooseGameToPlay);

        finish();

    }
}
