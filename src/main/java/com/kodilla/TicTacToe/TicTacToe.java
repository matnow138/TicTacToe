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

import static javafx.application.Platform.exit;

public class TicTacToe extends Application {

    private Image imageback = new Image("file:src/main/resources/background.jpg");
    private String shapeOfPlayer="";
    private String shapeOfComputer="";
    private String[][] board = new String[3][3];
    private List<Button> buttons = new ArrayList<>();

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
        stage.showAndWait();
        stage = board();
        stage.show();


        //To do
    }
    public void boardFill(){
        buttons.add(new Button("1"));
        buttons.add(new Button("2"));
        buttons.add(new Button("3"));
        buttons.add(new Button("4"));
        buttons.add(new Button("5"));
        buttons.add(new Button("6"));
        buttons.add(new Button("7"));
        buttons.add(new Button("8"));
        buttons.add(new Button("9"));

        for(int column=0;column<=2;column++){
            for(int row=0;row<=2;row++){
               board[column][row]=buttons.get(column+row).getText();
            }
        }
    }
    public Stage board(){
        Stage stage = new Stage();
        GridPane grid = new GridPane();



        //setting background image
        BackgroundSize backgroundSize = new BackgroundSize(50,50,true,true,true,false);
        BackgroundImage backgroundImage = new BackgroundImage(imageback, BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,backgroundSize);
        Background background = new Background(backgroundImage);

        //creating grid
        grid.setPadding(new Insets(0,0,0,0));
        grid.setHgap(100);
        grid.setVgap(100);
        grid.setBackground(background);

        //mechanics for display buttons 1-9
        playerMove(stage);
        computerMove(stage);

        int column=0;
        int row=0;
        Text text = new Text();
        for (Button button:buttons) {
            if(column<=2) {
                if(board[column][row].equals(shapeOfPlayer)){
                    text.setText(shapeOfPlayer);
                    grid.add(text,column,row,1,1);
                    column++;
                } else if (board[column][row].equals(shapeOfComputer)) {
                    text.setText(shapeOfComputer);
                    grid.add(text,column,row,1,1);
                    column++;
                }else {
                    grid.add(button, column, row, 1, 1);
                    column++;
                                    }
            } else {
                row++;
                column = 0;
                if (board[column][row].equals(shapeOfPlayer)) {
                    text.setText(shapeOfPlayer);
                    grid.add(text, column, row, 1, 1);
                } else {
                    grid.add(button, column, row, 1, 1);
                }
                column++;
            }

        }
        grid.setAlignment(Pos.CENTER);

        //creating scene
        Scene scene = new Scene(grid, 600,600);

        //display of stage
        stage.setTitle("Tic Tac Toe");
        stage.setScene(scene);
        return stage;
    }

    public void playerMove(Stage stage){
        buttons.get(0).setOnAction((ActionEvent)->{
            board[0][0]=(shapeOfPlayer);
            stage.close();
        });
        buttons.get(1).setOnAction((ActionEvent)->{
            board[1][0]=shapeOfPlayer;
            stage.close();
        });
        buttons.get(2).setOnAction((ActionEvent)->{
            board[2][0]=shapeOfPlayer;
            stage.close();
        });
        buttons.get(3).setOnAction((ActionEvent)->{
            board[0][1]=shapeOfPlayer;
            stage.close();
        });
        buttons.get(4).setOnAction((ActionEvent)->{
            board[1][1]=shapeOfPlayer;
            stage.close();
        });
        buttons.get(5).setOnAction((ActionEvent)->{
            board[2][1]=shapeOfPlayer;
            stage.close();
        });
        buttons.get(6).setOnAction((ActionEvent)->{
            board[0][2]=shapeOfPlayer;
            stage.close();
        });
        buttons.get(7).setOnAction((ActionEvent)->{
            board[1][2]=shapeOfPlayer;
            stage.close();
        });
        buttons.get(8).setOnAction((ActionEvent)->{
            board[2][2]=shapeOfPlayer;
            stage.close();
        });


    }
    public void computerMove(Stage stage){
        //TODO 17.06
    }
}
