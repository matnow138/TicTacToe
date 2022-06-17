package com.kodilla.TicTacToe;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
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
    private String[][] board = new String[3][3];
    private List<Button> buttons = new ArrayList<>();

    private GridPane mainGrid = new GridPane();


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
        boolean result=false;

            Stage stage = board();
        Scene scene = new Scene(mainGrid, 600, 600);

        //display of stage
        stage.setTitle("Tic Tac Toe");
        stage.setScene(scene);
            stage.showAndWait();
            stage = board();
        stage.setTitle("Tic Tac Toe");
        stage.setScene(scene);
            stage.showAndWait();
        stage = board();
        stage.showAndWait();
        stage = board();
        stage.showAndWait();





        //To do
    }
    public void boardFill() {

        buttons.add(new Button("1"));
        buttons.add(new Button("2"));
        buttons.add(new Button("3"));
        buttons.add(new Button("4"));
        buttons.add(new Button("5"));
        buttons.add(new Button("6"));
        buttons.add(new Button("7"));
        buttons.add(new Button("8"));
        buttons.add(new Button("9"));

        for (int column = 0; column <= 2; column++) {
            for (int row = 0; row <= 2; row++) {
                board[column][row] = buttons.get(column + row).getText();
            }
        }
        int column=0;
        int row=0;
        for(Button button:buttons){
            mainGrid.add(button,column,row);
            column++;
            if(column>2){
                column=0;
                row++;
            }

        }
        /*for (int column = 0; column <= 2; column++) {
            for (int row = 0; row <= 2; row++) {
                mainGrid.add(buttons.get(column+row),column,row,1,1);
            }
        }*/

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


        playerMove(stage);

        computerMove(stage);


          /*  int column = 0;
            int row = 0;
            Text text = new Text();
            for (Button button : buttons) {
                if (column <= 2) {
                    if (board[column][row].equals(shapeOfPlayer)) {
                        text.setText(shapeOfPlayer);
                        grid.getChildren().set(grid.getChildren().indexOf(button),text);
                       // grid.getChildren().remove(text);
                        //  grid.add(text, column, row, 1, 1);
                        column++;
                    } else if (board[column][row].equals(shapeOfComputer)) {
                        text.setText(shapeOfComputer);
                        grid.getChildren().set(grid.getChildren().indexOf(button),text);
                        //grid.getChildren().remove(text);
                        //grid.add(text, column, row, 1, 1);
                        column++;
                    } else {
                        grid.getChildren().set(grid.getChildren().indexOf(button),text);
                       // grid.getChildren().remove(button);
                        //grid.add(button, column, row, 1, 1);
                        column++;
                    }
                } else {
                    row++;
                    column = 0;
                    if (board[column][row].equals(shapeOfPlayer)) {
                        text.setText(shapeOfPlayer);

                        grid.getChildren().set(grid.getChildren().indexOf(button),text);
                       // grid.getChildren().remove(text);
                       // grid.add(text, column, row, 1, 1);
                    } else if (board[column][row].equals(shapeOfComputer)) {
                        text.setText(shapeOfComputer);
                        grid.getChildren().set(grid.getChildren().indexOf(button),text);
                       // grid.getChildren().remove(text);
                       // grid.add(text, column, row, 1, 1);
                    } else {
                        grid.getChildren().set(grid.getChildren().indexOf(button),text);
                       // grid.getChildren().remove(button);
                        //grid.add(button, column, row, 1, 1);
                    }
                    column++;
                }
            }*/
            //creating scene


            return stage;

    }

    public void playerMove(Stage stage){
        buttons.get(0).setOnAction((ActionEvent)->{
            board[0][0]=(shapeOfPlayer);
            Text text = new Text();
            text.setText(shapeOfPlayer);
            mainGrid.getChildren().remove(0);
            mainGrid.add(text,0,0);

            stage.close();
        });
        buttons.get(1).setOnAction((ActionEvent)->{
            board[1][0]=shapeOfPlayer;
            Text text = new Text();
            text.setText(shapeOfPlayer);
            mainGrid.getChildren().remove(1);
            mainGrid.add(text,1,0);

            stage.close();
        });
        buttons.get(2).setOnAction((ActionEvent)->{
            board[2][0]=shapeOfPlayer;
            Text text = new Text();
            text.setText(shapeOfPlayer);
            mainGrid.getChildren().remove(2);
            mainGrid.add(text,2,0);
            stage.close();
        });
        buttons.get(3).setOnAction((ActionEvent)->{
            board[0][1]=shapeOfPlayer;
            Text text = new Text();
            text.setText(shapeOfPlayer);
            mainGrid.getChildren().remove(3);
            mainGrid.add(text,0,1);
            stage.close();
        });
        buttons.get(4).setOnAction((ActionEvent)->{
            board[1][1]=shapeOfPlayer;
            Text text = new Text();
            text.setText(shapeOfPlayer);
            mainGrid.getChildren().remove(4);
            mainGrid.add(text,1,1);
            stage.close();
        });
        buttons.get(5).setOnAction((ActionEvent)->{
            board[2][1]=shapeOfPlayer;
            Text text = new Text();
            text.setText(shapeOfPlayer);
            mainGrid.getChildren().remove(5);
            mainGrid.add(text,2,1);
            stage.close();
        });
        buttons.get(6).setOnAction((ActionEvent)->{
            board[0][2]=shapeOfPlayer;
            Text text = new Text();
            text.setText(shapeOfPlayer);
            mainGrid.getChildren().remove(6);
            mainGrid.add(text,0,2);
            stage.close();
        });
        buttons.get(7).setOnAction((ActionEvent)->{
            board[1][2]=shapeOfPlayer;
            Text text = new Text();
            text.setText(shapeOfPlayer);
            mainGrid.getChildren().remove(7);
            mainGrid.add(text,1,2);
            stage.close();
        });
        buttons.get(8).setOnAction((ActionEvent)->{
            board[2][2]=shapeOfPlayer;
            Text text = new Text();
            text.setText(shapeOfPlayer);
            mainGrid.getChildren().remove(8);
            mainGrid.add(text,2,2);
            stage.close();
        });


    }
    public void computerMove(Stage stage){
        Random random = new Random();
        boolean possibleMove=false;
        int computerColumn;
        int computerRow;
        Text text = new Text();
        text.setText(shapeOfComputer);
        while(!possibleMove){
        //Generating random position of computer shape
            int computerMove = random.nextInt(8);


            switch(computerMove){
                case 0:
                    if(board[0][0].equals(shapeOfPlayer)){
                        break;
                    }else{
                        board[0][0]=shapeOfComputer;
                        mainGrid.getChildren().set(0,text);
                       // mainGrid.getChildren().remove(0);
                        //mainGrid.add(text,0,0,1,1);
                    }
                    possibleMove=true;
                    break;
                case 1:
                if(board[1][0].equals(shapeOfPlayer)){
                    break;
                }else{
                    board[1][0]=shapeOfComputer;
                    mainGrid.getChildren().set(1,text);
                    //mainGrid.getChildren().remove(1);
                    //mainGrid.add(text,1,0,1,1);
                }
                    possibleMove=true;
                break;
                case 2:
                    if(board[2][0].equals(shapeOfPlayer)){
                        break;
                    }else{
                        board[2][0]=shapeOfComputer;
                        mainGrid.getChildren().set(2,text);
                       // mainGrid.getChildren().remove(2);
                        //mainGrid.add(text,2,0,1,1);
                    }
                    possibleMove=true;
                    break;
                case 3:
                    if(board[0][1].equals(shapeOfPlayer)){
                        break;
                    }else{
                        board[0][1]=shapeOfComputer;
                        mainGrid.getChildren().set(3,text);
                       // mainGrid.getChildren().remove(3);
                        //mainGrid.add(text,0,1,1,1);
                    }
                    possibleMove=true;
                    break;
                case 4:
                    if(board[1][1].equals(shapeOfPlayer)){
                        break;
                    }else{
                        board[1][1]=shapeOfComputer;
                        mainGrid.getChildren().set(4,text);
                       // mainGrid.getChildren().remove(4);
                        //mainGrid.add(text,1,1,1,1);
                    }
                    possibleMove=true;
                    break;
                case 5:
                    if(board[2][1].equals(shapeOfPlayer)){
                        break;
                    }else{
                        board[2][1]=shapeOfComputer;
                        mainGrid.getChildren().set(5,text);
                        //mainGrid.getChildren().remove(5);
                        //mainGrid.add(text,2,1,1,1);
                    }
                    possibleMove=true;
                    break;
                case 6:
                    if(board[0][2].equals(shapeOfPlayer)){
                        break;
                    }else{
                        board[0][2]=shapeOfComputer;
                        mainGrid.getChildren().set(6,text);
                      // mainGrid.getChildren().remove(6);
                       // mainGrid.add(text,0,2,1,1);
                    }
                    possibleMove=true;
                    break;
                case 7:
                    if(board[1][2].equals(shapeOfPlayer)){
                        break;
                    }else{
                        board[1][2]=shapeOfComputer;
                        mainGrid.getChildren().set(7,text);
                       // mainGrid.getChildren().remove(7);
                        //mainGrid.add(text,1,2,1,1);
                    }
                    possibleMove=true;
                    break;
                case 8:
                if(board[2][2].equals(shapeOfPlayer)){
                    break;
                }else{
                    board[2][2]=shapeOfComputer;
                    mainGrid.getChildren().set(8,text);
                   // mainGrid.getChildren().remove(8);
                    //mainGrid.add(text,2,2,1,1);
                }
                possibleMove=true;
                break;
            }


        }
    }
}
