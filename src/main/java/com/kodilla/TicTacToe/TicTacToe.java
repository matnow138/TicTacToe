package com.kodilla.TicTacToe;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.awt.*;

public class TicTacToe extends Application {

    private Image imageback = new Image("file:src/main/resources/background.jpg");

    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage){
        BackgroundSize backgroundSize = new BackgroundSize(50,50,true,true,true,false);
        BackgroundImage backgroundImage = new BackgroundImage(imageback, BackgroundRepeat.REPEAT,BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,backgroundSize);
        Background background = new Background(backgroundImage);

        GridPane grid = new GridPane();

        grid.setBackground(background);
        Scene scene = new Scene(grid, 600,600);
        primaryStage.setTitle("Tic Tac Toe");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
