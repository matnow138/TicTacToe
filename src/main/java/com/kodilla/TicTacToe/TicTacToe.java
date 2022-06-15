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




import static javafx.application.Platform.exit;

public class TicTacToe extends Application {

    private Image imageback = new Image("file:src/main/resources/background.jpg");
    private String shapeOfPlayer="";
    private String shapeOfComputer="";
    private HBox hbox;
    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage){
        instruction();
        Button buttonCircle=new Button("Circle");
        buttonCircle.setOnAction(ActionEvent-> {

            shapeOfPlayer = "Circle";
            shapeOfComputer = "Square";
            System.out.println(shapeOfPlayer);
        });
        Button buttonSquare = new Button("Square");





        GridPane gridShapeDecision = new GridPane();
        gridShapeDecision.add(buttonCircle,0,0,1,1);
        gridShapeDecision.add(buttonSquare, 0,1,1,1);
        gridShapeDecision.setHgap(10);
        gridShapeDecision.setVgap(10);

        Scene sceneShapeDecision = new Scene(gridShapeDecision, 600,600);
        primaryStage.setTitle("Tic Tac Toe");
        primaryStage.setScene(sceneShapeDecision);
        primaryStage.show();




        buttonSquare.setOnAction(value -> {
            shapeOfPlayer = "Square";
            shapeOfComputer = "Circle";
        });


       /* BackgroundSize backgroundSize = new BackgroundSize(50,50,true,true,true,false);
        BackgroundImage backgroundImage = new BackgroundImage(imageback, BackgroundRepeat.REPEAT,BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,backgroundSize);
        Background background = new Background(backgroundImage);

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(1,1,20,20));
        grid.setHgap(5.5);
        grid.setVgap(3);
        grid.setBackground(background);
        Scene scene = new Scene(grid, 600,600);
        primaryStage.setTitle("Tic Tac Toe");
        primaryStage.setScene(scene);
        primaryStage.show();*/
    }

    public void instruction(){
        Text text = new Text();
        text.setText("Welcome to Tic Tac toe game! \n Here are some rules:\n "+
                "1. Chose 'X' or 'O'\n"+
                "2. Player plays against computer\n"+
                "3. If  3 'X' or 3 'O' appears in row, column or diagonal game ends.");

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
}
