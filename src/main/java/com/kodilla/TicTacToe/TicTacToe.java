package com.kodilla.TicTacToe;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.scene.text.Text;

import javafx.event.ActionEvent;


import javax.swing.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static javafx.application.Platform.exit;

public class TicTacToe extends Application {

    private Image imageback = new Image("file:src/main/resources/background.jpg");
    private String shapeOfPlayer="";
    private String shapeOfComputer="";
    private Button[][] board = new Button[3][3];
    private List<Button> buttons = new ArrayList<>();

    private GridPane mainGrid = new GridPane();
    int roundCount=1;


    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage){

        //Instruction for player
        instruction();
        //Player decides what shape will he/she play
        shapeDecision();
        //Actual game
        gameRunner();

    }

    public void instruction(){
        Text text = new Text();
        text.setText("Welcome to Tic Tac toe game! \n Here are some rules:\n"+
                "1. Chose 'X' or 'O'\n"+
                "2. Player plays against computer\n"+
                "3. If  3 'X' or 3 'O' appears in row, column or diagonal game ends.\n" +
                "4. Using keys 1-9 please chose place to insert previously chosen shape");

        Button confirm = new Button("Proceed");


        Stage stage = new Stage();
        confirm.setOnAction((ActionEvent event) -> {
            stage.close();
        });

        GridPane gridPane = new GridPane();

        gridPane.add(text,0,0,1,1);
        gridPane.add(confirm,0,3,2,1);
        gridPane.setVgap(10);

        Scene scene = new Scene(gridPane, 400,300);
        stage.setScene(scene);
        stage.showAndWait();
    }
    public void shapeDecision(){

        Stage stage = new Stage();
        Text text = new Text();
        text.setText("Please chose your shape:");

        Button buttonO=new Button("O");

        buttonO.setOnAction((ActionEvent)-> {

            shapeOfPlayer = "O";
            shapeOfComputer = "X";
            stage.close();

        });
        Button buttonX = new Button("X");

        buttonX.setOnAction((ActionEvent) ->{
            shapeOfPlayer = "X";
            shapeOfComputer = "O";
            stage.close();
        });

        GridPane gridPane = new GridPane();
        gridPane.add(text,0,0,1,1);
        gridPane.add(buttonO,0,1,1,1);
        gridPane.add(buttonX,1,1,1,1);
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        Scene scene = new Scene(gridPane, 400,300);

        stage.setScene(scene);
        stage.showAndWait();

    }

    public void gameRunner(){
        boardFill();


            Stage stage = board();
        Scene scene = new Scene(mainGrid, 600, 600);

        //display of stage
        stage.setTitle("Tic Tac Toe");
        stage.setScene(scene);
            stage.show();
    }

    public void checkVerticaly(){
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
            String winner = "Player";
            endGame(winner);
        }else if(computerCounter0==3 || computerCounter1==3 || computerCounter2==3){
            String winner = "Computer";
            endGame(winner);
        }
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
            endGame(winner);
        }else if(computerCounter0==3 || computerCounter1==3 || computerCounter2==3){
            String winner = "Computer";
            endGame(winner);
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
            endGame(winner);
        }else if(computerCounter0==3 || computerCounter1==3){
            String winner = "Computer";
            endGame(winner);
        }
    }
    public void boardFill() {
        Random random = new Random();

        for(int column=0; column<=2;column++){
            for(int row=0;row<=2;row++){
                Button button = new Button(" ");
                mainGrid.add(button,column,row);
                board[column][row]= button;
                button.setOnAction((ActionEvent)->{

                        if (button.getText().equals(" ")) {
                            button.setText(shapeOfPlayer);
                            int computerMove = random.nextInt(9);
                            //Button tempButton = mainGrid.getChildren().get(computerMove).getAccessibleText();
                            boolean possibleMove=false;
                            int counter=0;
                            while(!possibleMove) {
                                int computerColumn = random.nextInt(3);
                                int computerRow = random.nextInt(3);
                                for (Node node : mainGrid.getChildren()) {
                                    Button buttonCheck = (Button) node;
                                    if (mainGrid.getColumnIndex(node) == computerColumn && mainGrid.getRowIndex(node) == computerRow) {
                                        if (buttonCheck.getText().equals(" ")) {
                                            buttonCheck.setText(shapeOfComputer);
                                            board[computerColumn][computerRow]=buttonCheck;
                                            possibleMove=true;
                                        }else if(counter==8){
                                            break;
                                        }
                                    }
                                }
                            }
                            checkVerticaly();
                            checkHorizontaly();
                            checkDiagonal();
                        }
                    });
            }
        }
    }

    public Stage board() {
            Stage stage = new Stage();


            //setting background image
            BackgroundSize backgroundSize = new BackgroundSize(50, 50, true, true, true, false);
            BackgroundImage backgroundImage = new BackgroundImage(imageback, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
            Background background = new Background(backgroundImage);
        mainGrid.setAlignment(Pos.CENTER);

            //creating grid
        mainGrid.setPadding(new Insets(0, 0, 0, 0));
        mainGrid.setHgap(100);
        mainGrid.setVgap(100);
        mainGrid.setBackground(background);

            return stage;

    }

    public void endGame(String winner) {
        Stage stage = new Stage();
        Text text = new Text();
        text.setText(winner + " wins game!");

        Button endButton = new Button("Proceed");



        endButton.setOnAction((ActionEvent event) -> {
            exit();
        });

        GridPane gridPane = new GridPane();

        gridPane.add(text,0,0,1,1);
        gridPane.add(endButton,0,3,2,1);
        gridPane.setVgap(10);

        Scene scene = new Scene(gridPane, 400,300);
        stage.setScene(scene);
        stage.show();
    }

}
