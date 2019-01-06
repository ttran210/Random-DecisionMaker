package com.example.android.randomdecisionmaker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

// Add decision options and chooses an option to display on the next page
public class MainActivity extends AppCompatActivity {

    private static final String DECISION = "decision";
    private ArrayList<String> optionsList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // Adds the option to the list of all options
    public void addOption(View view) {
        // Gets the textbox
        TextView optionStrTextView = (TextView) findViewById(R.id.option_field);

        // Gets the string from the text box and adds it to the list
        String op = optionStrTextView.getText().toString();
        optionsList.add(op);

        // Clear the text box
        optionStrTextView.setText("");

    }

    // Go to next page of app with decision
    public void decide(View view) {
        // Get the decision

        // Generate random number
        Random random = new Random();
        int randInt = 0;

        if (optionsList.size() > 0) {
            // Gets a random number bn 0 (included) and the size of the list (excluded)
            randInt = random.nextInt(optionsList.size());
        }

        // Get the item in options list at this index
        String decision = optionsList.get(randInt);

        // Clears the list so that future random decisions start with a new list
        optionsList.clear();

        // Create the intent for the next page
        Intent decisionIntent = new Intent(this, DecisionActivity.class);

        // Send the decision to the extras for the next activity
        decisionIntent.putExtra(DECISION, decision);
        // start next window
        startActivity(decisionIntent);
    }

}
