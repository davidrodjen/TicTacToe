package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    // Make a field
    // For button Array
    private Button[] buttonAry;
    private Player x;
    private Player o;
    public Player currPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Add method to onCreate
        initializeButtons();

    }


    // Method creates an array of buttons
    private void initializeButtons(){

        buttonAry = new Button[]
        {
            findViewById(R.id.button),
            findViewById(R.id.button2),
            findViewById(R.id.button3),
            findViewById(R.id.button4),
            findViewById(R.id.button5),
            findViewById(R.id.button6),
            findViewById(R.id.button7),
            findViewById(R.id.button8),
            findViewById(R.id.button9)
        };
    }

    private void intializeGame(){
        o = new Player("X");
        x = new Player("O");

        currPlayer = getPlayer();

        displayCurrentPlayer();
    }
}
