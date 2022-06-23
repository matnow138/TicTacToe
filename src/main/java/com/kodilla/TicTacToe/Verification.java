package com.kodilla.TicTacToe;

import javafx.scene.control.Button;

public class Verification {

    private Button[][] board;
    private String shapeOfPlayer;
    private String shapeOfComputer;

    public Verification(Button[][] board, String shapeOfPlayer, String shapeOfComputer) {
        this.board = board;
        this.shapeOfPlayer = shapeOfPlayer;
        this.shapeOfComputer = shapeOfComputer;
    }

    public boolean playerWins() {
        int playerCounterHorizontaly0 = 0;
        int playerCounterHorizontaly1 = 0;
        int playerCounterHorizontaly2 = 0;
        int playerCounterVerticaly0 = 0;
        int playerCounterVerticaly1 = 0;
        int playerCounterVerticaly2 = 0;
        int playerCounterDiagonal0 = 0;
        int playerCounterDiagonal1 = 0;

        for (int i = 0; i <= 2; i++) {
            if (board[0][i].getText().equals(shapeOfPlayer)) {
                playerCounterHorizontaly0 += 1;
            }
            if (board[1][i].getText().equals(shapeOfPlayer)) {
                playerCounterHorizontaly1 += 1;
            }
            if (board[2][i].getText().equals(shapeOfPlayer)) {
                playerCounterHorizontaly2 += 1;
            }
            if (board[i][0].getText().equals(shapeOfPlayer)) {
                playerCounterVerticaly0 += 1;
            }
            if (board[i][1].getText().equals(shapeOfPlayer)) {
                playerCounterVerticaly1 += 1;
            }
            if (board[i][2].getText().equals(shapeOfPlayer)) {
                playerCounterVerticaly2 += 1;
            }
            if (board[i][i].getText().equals(shapeOfPlayer)) {
                playerCounterDiagonal0 += 1;
            }
            if (board[i][2 - i].getText().equals(shapeOfPlayer)) {
                playerCounterDiagonal1 += 1;
            }
        }

        if (playerCounterHorizontaly0 == 3 || playerCounterHorizontaly1 == 3 || playerCounterHorizontaly2 == 3 || playerCounterVerticaly0==3 || playerCounterVerticaly1==3 || playerCounterVerticaly2==3 || playerCounterDiagonal0 == 3 || playerCounterDiagonal1 == 3) {
            return true;
        }

        return false;
    }

    public boolean computerWins(){
        int computerCounterHorizontaly0=0;
        int computerCounterHorizontaly1=0;
        int computerCounterHorizontaly2=0;
        int computerCounterVerticaly0=0;
        int computerCounterVerticaly1=0;
        int computerCounterVerticaly2=0;
        int computerCounterDiagonal0=0;
        int computerCounterDiagonal1=0;
        for(int i=0;i<=2;i++){
            if(board[0][i].getText().equals(shapeOfComputer)){
                computerCounterHorizontaly0+=1;
            }
            if(board[1][i].getText().equals(shapeOfComputer)){
                computerCounterHorizontaly1+=1;
            }
            if(board[2][i].getText().equals(shapeOfComputer)){
                computerCounterHorizontaly2+=1;
            }
            if(board[i][0].getText().equals(shapeOfComputer)){
                computerCounterVerticaly0+=1;
            }
            if(board[i][1].getText().equals(shapeOfComputer)){
                computerCounterVerticaly1+=1;
            }
            if(board[i][2].getText().equals(shapeOfComputer)){
                computerCounterVerticaly2+=1;
            }
            if (board[i][i].getText().equals(shapeOfComputer)) {
                computerCounterDiagonal0 += 1;
            }
            if (board[i][2 - i].getText().equals(shapeOfComputer)) {
                computerCounterDiagonal1 += 1;
            }
        }

        if(computerCounterHorizontaly0==3 || computerCounterHorizontaly1 == 3 || computerCounterHorizontaly2 == 3 || computerCounterVerticaly0 ==3 ||computerCounterVerticaly1==3 || computerCounterVerticaly2==3 || computerCounterDiagonal0 ==3 || computerCounterDiagonal1 ==3){
            return true;
        }
        return false;
    }

    public boolean isTie(){
        int counter=0;
        for(int i = 0;i<=2;i++){
            for(int j=0;j<=2;j++){
                if(!board[i][j].getText().equals(" ")){
                    counter+=1;
                }
            }
        }
        System.out.println(counter);
        if(counter==9){
            return true;
        }
        return false;
    }
    /*
    public boolean checkVerticaly(){
        int playerCounter0=0;
        int computerCounter0=0;
        for(int i =0;i<=2;i++){
            if(board[0][i].getText().equals(shapeOfPlayer)){
                playerCounter0 +=1;
            }else if(board[0][i].getText().equals(shapeOfComputer)){
                computerCounter0+=1;
            }
        }
        int playerCounter1=0;
        int computerCounter1=0;
        for(int i =0;i<=2;i++){
            if(board[1][i].getText().equals(shapeOfPlayer)){
                playerCounter1 +=1;
            }else if(board[1][i].getText().equals(shapeOfComputer)){
                computerCounter1+=1;
            }
        }
        int playerCounter2=0;
        int computerCounter2=0;
        for(int i =0;i<=2;i++){
            if(board[2][i].getText().equals(shapeOfPlayer)){
                playerCounter2 +=1;
            }
            else if(board[0][i].getText().equals(shapeOfComputer)){
                computerCounter2+=1;
            }
        }
        if(playerCounter0==3 || playerCounter1==3 || playerCounter2==3){
            return "Player";
        }else if(computerCounter0==3 || computerCounter1==3 || computerCounter2==3){
            return "Computer";
        }
        return null;
    }
    public void checkHorizontaly(){
        int playerCounter0=0;
        int computerCounter0=0;
        for(int i =0;i<=2;i++){
            if(board[i][0].getText().equals(shapeOfPlayer)){
                playerCounter0 +=1;
            }else if(board[i][0].getText().equals(shapeOfComputer)){
                computerCounter0+=1;
            }
        }
        int playerCounter1=0;
        int computerCounter1=0;
        for(int i =0;i<=2;i++){
            if(board[i][1].getText().equals(shapeOfPlayer)){
                playerCounter1 +=1;
            }else if(board[i][1].getText().equals(shapeOfComputer)){
                computerCounter1+=1;
            }
        }
        int playerCounter2=0;
        int computerCounter2=0;
        for(int i =0;i<=2;i++){
            if(board[i][2].getText().equals(shapeOfPlayer)){
                playerCounter2 +=1;
            }
            else if(board[i][2].getText().equals(shapeOfComputer)){
                computerCounter2+=1;
            }
        }
        if(playerCounter0==3 || playerCounter1==3 || playerCounter2==3){
            String winner = "Player";
           // endGame(winner);
        }else if(computerCounter0==3 || computerCounter1==3 || computerCounter2==3){
            String winner = "Computer";
            //endGame(winner);
        }
    }

    public void checkDiagonal(){
        int playerCounter0=0;
        int computerCounter0=0;
        for(int i =0;i<=2;i++){
            if(board[i][i].getText().equals(shapeOfPlayer)){
                playerCounter0 +=1;
            }else if(board[i][i].getText().equals(shapeOfComputer)){
                computerCounter0+=1;
            }
        }
        int playerCounter1=0;
        int computerCounter1=0;
        for(int i =0;i<=2;i++){
            if(board[i][2-i].getText().equals(shapeOfPlayer)){
                playerCounter1 +=1;
            }else if(board[i][2-i].getText().equals(shapeOfComputer)){
                computerCounter1+=1;
            }
        }

        if(playerCounter0==3 || playerCounter1==3){
            String winner = "Player";
            //endGame(winner);
        }else if(computerCounter0==3 || computerCounter1==3){
            String winner = "Computer";
           // endGame(winner);
        }
    }*/
}
