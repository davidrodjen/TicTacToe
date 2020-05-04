package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    // Make a field
    // For button Array
    private Button[] buttonAry;
    private Player x;
    private Player o;
    public Player currPlayer;
    private TextView playerTurn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Add method to onCreate
        initializeButtons();

        //Have to find the current player
        playerTurn = findViewById(R.id.playerTurn);

        //initialize the game
        initializeGame();
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

    private void initializeGame(){
        o = new Player("X");
        x = new Player("O");

        displayCurrentPlayer();
    }

    public void clickNewGame(View v) {
        for (int i = 0; i < buttonAry.length; i++) {
            buttonAry[i].setText("");
        }
    }

    public void onClick(View v){
        for (int i = 0; i < buttonAry.length; i++) {
            if (v == buttonAry[i] && buttonAry[i].getText() == "") {
                buttonAry[i].setText(currPlayer.playerName);
                alternatePlayer();
            }
        }
    }

    private void displayCurrentPlayer(){
        playerTurn.setText("Player: " + currPlayer.playerName + "'s Turn");
    }

    private void alternatePlayer() {
        if (currPlayer == x) {
            currPlayer = o;
        }
        else {
            currPlayer = x;
        }
        displayCurrentPlayer();
    }


}
