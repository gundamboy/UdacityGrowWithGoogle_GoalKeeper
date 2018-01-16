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

    private static final String KEY_TEAM_A_NAME = "team_a_name";
    private static final String KEY_TEAM_B_NAME = "team_b_name";
    private static final String KEY_TEAM_A_GOALS = "team_a_goals";
    private static final String KEY_TEAM_B_GOALS = "team_b_goals";
    private static final String KEY_TEAM_A_PENALTIES = "team_a_penalties";
    private static final String KEY_TEAM_B_PENALTIES = "team_b_penalties";

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
        String team_a_goals = savedInstanceState.getString(KEY_TEAM_A_GOALS);
        String team_a_penalties = savedInstanceState.getString(KEY_TEAM_A_PENALTIES);
        String team_b_goals = savedInstanceState.getString(KEY_TEAM_B_GOALS);
        String team_b_penalties = savedInstanceState.getString(KEY_TEAM_B_PENALTIES);
        String team_a_name = savedInstanceState.getString(KEY_TEAM_A_NAME);
        String team_b_name = savedInstanceState.getString(KEY_TEAM_B_NAME);

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
        outState.putString(KEY_TEAM_A_GOALS, team_a_score_to_save);
        outState.putString(KEY_TEAM_A_PENALTIES, team_a_penalties_to_save);
        outState.putString(KEY_TEAM_B_GOALS, team_b_score_to_save);
        outState.putString(KEY_TEAM_B_PENALTIES, team_b_penalties_to_save);
        outState.putString(KEY_TEAM_A_NAME, team_a);
        outState.putString(KEY_TEAM_B_NAME, team_b);
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
        displayForTeamA("Goals " + scoreTeamA);
        displayForTeamB("Goals " + scoreTeamA);
        displayPenaltyTeamA("Penalties " + penaltyTeamA);
        displayPenaltyTeamB("Penalties " + penaltyTeamB);
    }

    /**
     * Increase the score for Team A by 1 point.
     */
    public void addOneForTeamA(View v) {
        scoreTeamA = scoreTeamA + 1;
        displayForTeamA("Goals " + scoreTeamA);
    }

    /**
     * Increase the penalties for Team A by 1 point.
     */
    public void addPenaltyTeamA(View v) {
        penaltyTeamA = penaltyTeamA + 1;
        displayPenaltyTeamA("Penalties " + penaltyTeamA);
    }

    /**
     * Displays the given score for Team A.
     * @param score
     */
    public void displayForTeamA(String score) {
        scoreView.setText(score);
    }

    /**
     * Displays the given penalties for Team A.
     */
    public void displayPenaltyTeamA(String penalty) {
        penaltyView.setText(penalty);
    }

    /**
     * Increase the score for Team B by 1 point.
     */
    public void addOneForTeamB(View v) {
        scoreTeamB = scoreTeamB + 1;
        displayForTeamB("Goals " + scoreTeamB);
    }

    /**
     * Increase the penalties for Team B by 1 point.
     */
    public void addPenaltyTeamB(View v) {
        penaltyTeamB = penaltyTeamB + 1;
        displayPenaltyTeamB("Penalties " + penaltyTeamB);
    }

    /**
     * Displays the given score for Team B.
     */
    public void displayForTeamB(String score) {
        scoreView_team_b.setText(score);
    }

    /**
     * Displays the given penalties for Team B.
     */
    public void displayPenaltyTeamB(String penalty) {
        penaltyView_team_b.setText(penalty);
    }
}
