package com.kodilla.TicTacToe;

import javafx.application.Application;
import javafx.application.Platform;
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

        Button buttonCircle=new Button("Circle");

        buttonCircle.setOnAction((ActionEvent)-> {

            shapeOfPlayer = "Circle";
            shapeOfComputer = "Square";
            stage.close();

        });
        Button buttonSquare = new Button("Square");

        buttonSquare.setOnAction((ActionEvent) ->{
            shapeOfPlayer = "Square";
            shapeOfComputer = "Circle";
            stage.close();
        });

        GridPane gridPane = new GridPane();
        gridPane.add(text,0,0,1,1);
        gridPane.add(buttonCircle,0,1,1,1);
        gridPane.add(buttonSquare,1,1,1,1);
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        Scene scene = new Scene(gridPane, 400,300);

        stage.setScene(scene);
        stage.showAndWait();

    }

    public void gameRunner(){
        board();


        //To do
    }

    public void board(){
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

        for (Button button:buttons) {
            grid.add(buttons.get(buttons.indexOf(button)), 0, 0, 1, 1);
            grid.add(buttons.get(1), 1, 0, 1, 1);
            grid.add(buttons.get(2), 2, 0, 1, 1);
            grid.add(buttons.get(3), 0, 1, 1, 1);
            grid.add(buttons.get(4), 1, 1, 1, 1);
            grid.add(buttons.get(5), 2, 1, 1, 1);
            grid.add(buttons.get(6), 0, 2, 1, 1);
            grid.add(buttons.get(7), 1, 2, 1, 1);
            grid.add(buttons.get(8), 2, 2, 1, 1);

        }



        grid.setAlignment(Pos.CENTER);

        //creating scene
        Scene scene = new Scene(grid, 600,600);

        //display of stage
        stage.setTitle("Tic Tac Toe");
        stage.setScene(scene);
        stage.show();
    }
}
