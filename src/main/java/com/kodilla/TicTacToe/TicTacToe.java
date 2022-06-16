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
    private char shapeOfPlayer;
    private char shapeOfComputer;
    private char[][] board = new char[2][2];
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

        Button buttonO=new Button("Circle");

        buttonO.setOnAction((ActionEvent)-> {

            shapeOfPlayer = 'O';
            shapeOfComputer = 'X';
            stage.close();

        });
        Button buttonX = new Button("X");

        buttonX.setOnAction((ActionEvent) ->{
            shapeOfPlayer = 'X';
            shapeOfComputer = 'O';
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
        Stage stage = board();
        stage.show();
        playerMove(stage);


        //To do
    }

    public Stage board(){
        Stage stage = new Stage();
        GridPane grid = new GridPane();

        buttons.add(new Button("1"));
        buttons.add(new Button("2"));
        buttons.add(new Button("3"));
        buttons.add(new Button("4"));
        buttons.add(new Button("5"));
        buttons.add(new Button("6"));
        buttons.add(new Button("7"));
        buttons.add(new Button("8"));
        buttons.add(new Button("9"));

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
        int column=0;
        int row=0;
        for (Button button:buttons) {

            if(column<2) {
                if(board[column][row]==shapeOfPlayer || board[column][row]==shapeOfComputer) {
                    grid.add(button, column, row, 1, 1);
                    column++;
                }
            } else if (column>=2) {
                grid.add(button, column, row, 1, 1);
                row++;
                column=0;
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
            board[0][0]=shapeOfPlayer;
        });
        buttons.get(0).setOnAction((ActionEvent)->{
            board[1][0]=shapeOfPlayer;
        });
        buttons.get(0).setOnAction((ActionEvent)->{
            board[2][0]=shapeOfPlayer;
        });
        buttons.get(0).setOnAction((ActionEvent)->{
            board[0][1]=shapeOfPlayer;
        });
        buttons.get(0).setOnAction((ActionEvent)->{
            board[1][1]=shapeOfPlayer;
        });
        buttons.get(0).setOnAction((ActionEvent)->{
            board[2][1]=shapeOfPlayer;
        });
        buttons.get(0).setOnAction((ActionEvent)->{
            board[0][2]=shapeOfPlayer;
        });
        buttons.get(0).setOnAction((ActionEvent)->{
            board[1][2]=shapeOfPlayer;
        });
        buttons.get(0).setOnAction((ActionEvent)->{
            board[2][2]=shapeOfPlayer;
        });


    }
}
