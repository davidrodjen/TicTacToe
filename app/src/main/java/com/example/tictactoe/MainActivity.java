package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity {
    // Field
    // For button Array
    private Button[][] buttonAry;
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

        buttonAry = new Button[][]
        {
             {findViewById(R.id.button), findViewById(R.id.button2), findViewById(R.id.button3)},
             {findViewById(R.id.button4),findViewById(R.id.button5),findViewById(R.id.button6)},
             {findViewById(R.id.button7),findViewById(R.id.button8),findViewById(R.id.button9)}
        };
    }

    // Initializes the game with the correct variable structures
    private void initializeGame(){
        o = new Player("O");
        x = new Player("X");

        currPlayer = x;
        displayCurrentPlayer();
    }

    // On clicking new game button, it will clear all text, and set the buttons to be enabled
    public void clickNewGame(View v) {
        for (Button[] buttons : buttonAry) {
            for (int cols = 0; cols < buttonAry[0].length; cols++) {
                buttons[cols].setText("");
                buttons[cols].setEnabled(true);
            }
        }
        initializeGame();
    }

    // Main onclick event, loops to set the text to the appropriate player
    // Cycles for win with each turn to check for a win instantly
    public void onClick(View v){
        for (Button[] buttons : buttonAry) {
            for (int cols = 0; cols < buttonAry[0].length; cols++) {
                if (v == buttons[cols] && buttons[cols].getText() == "") {
                    buttons[cols].setText(currPlayer.playerName);
                }
            }
        }
        // Win message string variables
        String xWin = "Player X Wins!";
        String oWin = "Player O Wins!";
        // I didn't like how Tie Game looked, so I spaced it manually
        String tie = "    Tie Game!";

        //Had to create a separate method, internal if statements would not allow setText
        if(isWinner("X")){
            playerTurn.setText(xWin);
            gameOver();
        }
        else if (isWinner("O")){
            playerTurn.setText(oWin);
            gameOver();
        }
        else if (tieGame()){
            playerTurn.setText(tie);
            gameOver();
        }
        else {
            //if not a success, change player and continue
            alternatePlayer();
        }
    }

    // Passes Player object into checks for wins
    private boolean isWinner(String player){
        if(checkHorizontalWin(player)){
            return true;
        }
        if(checkVerticalWin(player)){
            return true;
        }
        return checkDiagonalWin(player);
    }

    // Checks for horizontal matches based on Array index, arranged as if in a grid.
    private boolean checkHorizontalWin(String player){
        return buttonAry[0][0].getText() == player && buttonAry[0][1].getText() == player && buttonAry[0][2].getText() == player ||
                buttonAry[1][0].getText() == player && buttonAry[1][1].getText() == player && buttonAry[1][2].getText() == player ||
                buttonAry[2][0].getText() == player && buttonAry[2][1].getText() == player && buttonAry[2][2].getText() == player;
    }

    // Checks for vertical matches based on Array index, arranged as if in a grid.
    private boolean checkVerticalWin(String player){
        return buttonAry[0][0].getText() == player && buttonAry[1][0].getText() == player && buttonAry[2][0].getText() == player ||
                buttonAry[0][1].getText() == player && buttonAry[1][1].getText() == player && buttonAry[2][1].getText() == player ||
                buttonAry[0][2].getText() == player && buttonAry[1][2].getText() == player && buttonAry[2][2].getText() == player;
    }

    // Checks for diagonal wins
    private boolean checkDiagonalWin(String player){
        return buttonAry[0][0].getText() == player && buttonAry[1][1].getText() == player && buttonAry[2][2].getText() == player ||
                buttonAry[0][2].getText() == player && buttonAry[1][1].getText() == player && buttonAry[2][0].getText() == player;
    }

    // Checks for ties
    private boolean tieGame() {
        for (int rows = 0; rows < buttonAry.length; rows++){
            for (int cols = 0; cols < buttonAry[0].length; cols++) {
                if (buttonAry[rows][cols].getText() == ""){
                    return false;
                }
            }
        }
        return true;
    }

    private void gameOver() {
        for (int rows = 0; rows < buttonAry.length; rows++){
            for (int cols = 0; cols < buttonAry[0].length; cols++) {
                buttonAry[rows][cols].setEnabled(false);
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
