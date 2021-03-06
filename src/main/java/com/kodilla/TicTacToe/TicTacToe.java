package com.kodilla.TicTacToe;

import javafx.application.Application;
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


import java.util.Random;

import static javafx.application.Platform.exit;

public class TicTacToe extends Application {

    private final Image imageback = new Image("file:src/main/resources/background.jpg");
    private String shapeOfPlayer="";
    private String shapeOfComputer="";
    private Button[][] board = new Button[3][3];


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
        Text instructions = new Text();
        instructions.setText("Welcome to Tic Tac toe game! \n Here are some rules:\n"+
                "1. Chose 'X' or 'O'\n"+
                "2. Player plays against computer\n"+
                "3. If  3 'X' or 3 'O' appears in row, column or diagonal game ends.\n" +
                "4. Using buttons please chose place to insert previously chosen shape");

        Button confirm = new Button("Proceed");


        Stage stage = new Stage();
        confirm.setOnAction((ActionEvent event) -> {
            stage.close();
        });

        GridPane gridPane = new GridPane();

        gridPane.add(instructions,0,0,1,1);
        gridPane.add(confirm,0,3,2,1);
        gridPane.setVgap(10);

        Scene scene = new Scene(gridPane, 400,300);
        stage.setScene(scene);
        stage.showAndWait();
    }
    public void shapeDecision(){

        Stage stage = new Stage();
        Text shapeChooseText = new Text();
        shapeChooseText.setText("Please chose your shape:");

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
        gridPane.add(shapeChooseText,0,0,1,1);
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
        actionsForButtons();
        Stage stage = board();
        Scene scene = new Scene(mainGrid, 600, 600);

        //display of stage
        stage.setTitle("Tic Tac Toe");
        stage.setScene(scene);
        stage.show();
    }


    public void boardFill() {

        for(int column=0; column<=2;column++){
            for(int row=0;row<=2;row++){
                Button button = new Button(" ");
                mainGrid.add(button,column,row);
                board[column][row]= button;
            }
        }
    }
    public void actionsForButtons(){

        for (Node node : mainGrid.getChildren()) {
            Button buttonAction = (Button) node;
            buttonAction.setOnAction((ActionEvent)->{
                //setting shape of player to button
                if (buttonAction.getText().equals(" ")) {
                    buttonAction.setText(shapeOfPlayer);
                    computerMove();

                    //Check winning conditions
                    Verification verification = new Verification(board, shapeOfPlayer, shapeOfComputer);
                    if(verification.playerWins()){
                        endGame("Player");
                        return;
                    }
                    if(verification.computerWins()){
                        endGame("Computer");
                    }
                }
            });

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
        Text gameWinner = new Text();
        if(winner.equals("Draw")){
            gameWinner.setText("Draw!");
        }else{
            gameWinner.setText(winner + " wins game!");
        }


        Button endButton = new Button("Proceed");



        endButton.setOnAction((ActionEvent event) -> {
            exit();
        });

        GridPane gridPane = new GridPane();

        gridPane.add(gameWinner,0,0,1,1);
        gridPane.add(endButton,0,3,2,1);
        gridPane.setVgap(10);

        Scene scene = new Scene(gridPane, 400,300);
        stage.setScene(scene);
        stage.show();
    }
    public void computerMove(){
        Random random = new Random();
        boolean possibleMove=false;
        int counter=0;
        //Generating random computer move
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
                    } else{

                        //Check for DRAW

                        Verification tieVerification = new Verification(board, shapeOfPlayer, shapeOfComputer);
                        if(tieVerification.isTie()){
                            possibleMove=true;
                            endGame("Draw");
                        }

                    }
                }
            }
        }
    }


}
