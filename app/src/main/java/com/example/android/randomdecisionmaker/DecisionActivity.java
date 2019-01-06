package com.example.android.randomdecisionmaker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

// Second page displays the decision chosen
public class DecisionActivity extends AppCompatActivity {

    // Need to create a version here that putExtra will put data into
    private static final String DECISION = "decision";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.decision_layout);
        showDecision();
    }

    public void showDecision() {

        // Get the view where decision will be displayed
        TextView decDisp = (TextView) findViewById(R.id.decision);

        // Get the final decision from the intent extras
        String decision = getIntent().getExtras().getString(DECISION);

        // Display the final decision
        decDisp.setText(decision);
    }

    // Will return to first screen to allow user to make a new decision
    public void newDecision(View view) {
        // Create new intent
        Intent mainPageIntent = new Intent(this, MainActivity.class);

        // start next window
        startActivity(mainPageIntent);
    }

}