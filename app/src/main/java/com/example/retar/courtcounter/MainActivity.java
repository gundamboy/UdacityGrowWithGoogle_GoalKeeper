package com.example.retar.courtcounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int scoreTeamA = 0;
    int scoreTeamB = 0;
    int penaltyTeamA = 0;
    int penaltyTeamB = 0;
    TextView scoreView;
    TextView penaltyView;
    TextView scoreView_team_b;
    TextView penaltyView_team_b;
    Spinner team_a_name_spinner;
    Spinner team_b_name_spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scoreView = (TextView) findViewById(R.id.team_a_score);
        penaltyView = (TextView) findViewById(R.id.team_a_penalties);
        scoreView_team_b = (TextView) findViewById(R.id.team_b_score);
        penaltyView_team_b = (TextView) findViewById(R.id.team_b_penalties);
        team_a_name_spinner = (Spinner) findViewById(R.id.team_a_name);
        team_b_name_spinner = (Spinner) findViewById(R.id.team_b_name);

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        String team_a_goals = savedInstanceState.getString("team_a_goals");
        String team_a_penalties = savedInstanceState.getString("team_a_penalties");
        String team_b_goals = savedInstanceState.getString("team_b_goals");
        String team_b_penalties = savedInstanceState.getString("team_b_penalties");
        String team_a_name = savedInstanceState.getString("team_a_name");
        String team_b_name = savedInstanceState.getString("team_b_name");

        if (savedInstanceState != null) {
            scoreView.setText(team_a_goals);
            penaltyView.setText(team_a_penalties);
            scoreView_team_b.setText(team_b_goals);
            penaltyView_team_b.setText(team_b_penalties);
            team_a_name_spinner.setSelection(getIndex(team_a_name_spinner, team_a_name));
            team_b_name_spinner.setSelection(getIndex(team_b_name_spinner, team_b_name));
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        String team_a_score_to_save = scoreView.getText().toString();
        String team_a_penalties_to_save = penaltyView.getText().toString();
        String team_b_score_to_save = scoreView_team_b.getText().toString();
        String team_b_penalties_to_save = penaltyView_team_b.getText().toString();
        String team_a = team_a_name_spinner.getSelectedItem().toString();
        String team_b = team_b_name_spinner.getSelectedItem().toString();
        outState.putString("team_a_goals", team_a_score_to_save);
        outState.putString("team_a_penalties", team_a_penalties_to_save);
        outState.putString("team_b_goals", team_b_score_to_save);
        outState.putString("team_b_penalties", team_b_penalties_to_save);
        outState.putString("team_a_name", team_a);
        outState.putString("team_b_name", team_b);
    }

    /**
     * Get the spinner position for a value
     */
    private int getIndex(Spinner spinner, String myString)
    {
        int index = 0;

        for (int i=0;i<spinner.getCount();i++){
            if (spinner.getItemAtPosition(i).toString().equalsIgnoreCase(myString)){
                index = i;
                break;
            }
        }
        return index;
    }

    /**
     * Reset the game
     */
    public void resetScore(View v) {
        scoreTeamA = 0;
        scoreTeamB = 0;
        penaltyTeamA = 0;
        penaltyTeamB = 0;
        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamA);
        displayPenaltyTeamA(penaltyTeamA);
        displayPenaltyTeamB(penaltyTeamB);
    }

    /**
     * Increase the score for Team A by 1 point.
     */
    public void addOneForTeamA(View v) {
        scoreTeamA = scoreTeamA + 1;
        displayForTeamA(scoreTeamA);
    }

    /**
     * Increase the penalties for Team A by 1 point.
     */
    public void addPenaltyTeamA(View v) {
        penaltyTeamA = penaltyTeamA + 1;
        displayPenaltyTeamA(penaltyTeamA);
    }

    /**
     * Displays the given score for Team A.
     */
    public void displayForTeamA(int score) {
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays the given penalties for Team A.
     */
    public void displayPenaltyTeamA(int penalty) {
        penaltyView.setText(String.valueOf(penalty));
    }

    /**
     * Increase the score for Team B by 1 point.
     */
    public void addOneForTeamB(View v) {
        scoreTeamB = scoreTeamB + 1;
        displayForTeamB(scoreTeamB);
    }

    /**
     * Increase the penalties for Team B by 1 point.
     */
    public void addPenaltyTeamB(View v) {
        penaltyTeamB = penaltyTeamB + 1;
        displayPenaltyTeamB(penaltyTeamB);
    }

    /**
     * Displays the given score for Team B.
     */
    public void displayForTeamB(int score) {

        scoreView_team_b.setText(String.valueOf(score));
    }

    /**
     * Displays the given penalties for Team B.
     */
    public void displayPenaltyTeamB(int penalty) {

        penaltyView_team_b.setText(String.valueOf(penalty));
    }
}
