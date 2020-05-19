package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;


public class MainActivity extends AppCompatActivity {
    // Field
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
        o = new Player("O");
        x = new Player("X");

        currPlayer = getPlayer();
        displayCurrentPlayer();
    }

    public void clickNewGame(View v) {
        for (Button button : buttonAry) {
            button.setText("");
        }
        initializeGame();
    }

    public void onClick(View v){
        for (Button button : buttonAry) {
            if (v == button && button.getText() == "") {
                button.setText(currPlayer.playerName);
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

    // Generate a number to represent a player
    private Player getPlayer()
    {
        Random rand = new Random();
        int num = rand.nextInt(2);
        if (num == 0) {
            return x;
        }
        else {
            return o;
        }
    }
}
