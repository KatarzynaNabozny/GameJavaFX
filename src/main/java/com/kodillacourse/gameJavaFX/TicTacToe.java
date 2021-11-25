package com.kodillacourse.gameJavaFX;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.*;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import static javafx.scene.paint.Color.DIMGREY;


public class TicTacToe extends Application {

    private Text textForUser;
    private boolean endOfRound;
    private boolean comMovement;
    private boolean userMovement;

    public boolean isEndOfRound() {
        return endOfRound;
    }

    public void setEndOfRound(boolean endOfRound) {
        this.endOfRound = endOfRound;
    }

    public Text getTextForUser() {
        return textForUser;
    }

    public void setTextForUser(Text textForUser) {
        this.textForUser = textForUser;
    }

    public boolean isComMovement() {
        return comMovement;
    }

    public void setComMovement(boolean comMovement) {
        this.comMovement = comMovement;
    }

    public boolean isUserMovement() {
        return userMovement;
    }

    public void setUserMovement(boolean userMovement) {
        this.userMovement = userMovement;
    }

    public static void main(String[] args) {
        launch(args);

    }

    @Override
    public void start(Stage primaryStage)  {
        setUserMovement(true);
        Group root = new Group();
        Scene scene = new Scene(root,300,400, DIMGREY);

        textForUser = new Text("Click the Button");
        textForUser.setFont(Font.font("verdana", FontWeight.EXTRA_BOLD, FontPosture.ITALIC, 15));
        textForUser.setX(75);
        textForUser.setY(355);
        textForUser.setTextAlignment(TextAlignment.CENTER);

        Button resetB = new Button("Reset");
        resetB.setStyle("-fx-background-color:yellow");
        resetB.setFont(Font.font("arial",FontWeight.EXTRA_BOLD,15));
        resetB.setMinSize(100,10);

        List<Button> buttonList = new ArrayList<>();
        Button button1 = new Button("");
        Button button2 = new Button("");
        Button button3 = new Button("");
        Button button4 = new Button("");
        Button button5 = new Button("");
        Button button6 = new Button("");
        Button button7 = new Button("");
        Button button8 = new Button("");
        Button button9 = new Button("");
        button1.setMinSize(100, 100);
        button2.setMinSize(100, 100);
        button3.setMinSize(100, 100);
        button4.setMinSize(100, 100);
        button5.setMinSize(100, 100);
        button6.setMinSize(100, 100);
        button7.setMinSize(100, 100);
        button8.setMinSize(100, 100);
        button9.setMinSize(100, 100);

        buttonList.add(button1);
        buttonList.add(button2);
        buttonList.add(button3);
        buttonList.add(button4);
        buttonList.add(button5);
        buttonList.add(button6);
        buttonList.add(button7);
        buttonList.add(button8);
        buttonList.add(button9);

        buttonList.forEach(button -> {
            button.setFont(Font.font("arial",FontWeight.EXTRA_BOLD,30));
            button.setStyle("-fx-background-color:white;-fx-border-color:red" );
        });

        button1.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                userMovement(button1, buttonList);
                compMovement(buttonList);
            }
        });
        button2.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                userMovement(button2, buttonList);
                compMovement(buttonList);
            }
        });
        button3.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                userMovement(button3, buttonList);
                compMovement(buttonList);
            }
        });
        button4.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                userMovement(button4, buttonList);
                compMovement(buttonList);
            }
        });
        button5.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                userMovement(button5, buttonList);
                compMovement(buttonList);
            }
        });
        button6.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                userMovement(button6, buttonList);
                compMovement(buttonList);
            }
        });
        button7.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                userMovement(button7, buttonList);
                compMovement(buttonList);
            }
        });
        button8.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                userMovement(button8, buttonList);
                compMovement(buttonList);
            }
        });
        button9.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                userMovement(button9, buttonList);
                compMovement(buttonList);
            }
        });
        resetB.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                reset(buttonList);
                textForUser.setText("Click the Button");
            }
        });

        GridPane gridPane = new GridPane();

        gridPane.add(button1, 0, 0, 1, 1);
        gridPane.add(button2, 1, 0, 1, 1);
        gridPane.add(button3, 2, 0, 1, 1);

        gridPane.add(button4, 0, 1, 1, 1);
        gridPane.add(button5, 1, 1, 1, 1);
        gridPane.add(button6, 2, 1, 1, 1);

        gridPane.add(button7, 0, 2, 1, 1);
        gridPane.add(button8, 1, 2, 1, 1);
        gridPane.add(button9, 2, 2, 1, 1);
        gridPane.add(resetB,1,3,1,1);
       root.getChildren().addAll(gridPane,textForUser);
        primaryStage.setTitle("TicTacToe");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    private void userMovement(Button button, List<Button> buttonList) {
        if (!isEndOfRound() && isUserMovement()) {
            if("".equals(button.getText())) {
                button.setText("X");
                button.setStyle("-fx-background-color:blue;-fx-border-color:red" );
                //button.setStyle("-fx-border-color:red");

                setUserMovement(false);
                checkIfThereIsAWinner(buttonList);
                checkEndOfMovement(buttonList);
                setComMovement(true);
            }
        } else {
            buttonList.forEach(b -> b.setDisable(true));
        }
    }

    private void checkEndOfMovement(List<Button> buttonList) {
        if (!buttonList.stream().anyMatch(button -> button.getText().equals("")) &&
                !isEndOfRound()
        ) {
            textForUser.setText("Dead-heat try again");
        }
    }

    public void checkIfThereIsAWinner(List<Button> buttonList) {
        for (int a = 0; a < 8; a++) {
            String line = switch (a) {
                case 0 -> buttonList.get(0).getText() + buttonList.get(1).getText() + buttonList.get(2).getText();
                case 1 -> buttonList.get(3).getText() + buttonList.get(4).getText() + buttonList.get(5).getText();
                case 2 -> buttonList.get(6).getText() + buttonList.get(7).getText() + buttonList.get(8).getText();
                case 3 -> buttonList.get(0).getText() + buttonList.get(3).getText() + buttonList.get(6).getText();
                case 4 -> buttonList.get(1).getText() + buttonList.get(4).getText() + buttonList.get(7).getText();
                case 5 -> buttonList.get(2).getText() + buttonList.get(5).getText() + buttonList.get(8).getText();
                case 6 -> buttonList.get(0).getText() + buttonList.get(4).getText() + buttonList.get(8).getText();
                case 7 -> buttonList.get(2).getText() + buttonList.get(4).getText() + buttonList.get(6).getText();
                default -> null;
            };

            if (line.equals("XXX")) {
                textForUser.setText("You won");
                setEndOfRound(true);
                winnerLine(a, "-fx-background-color:green;-fx-border-color:red", buttonList);
                return;
            } else if (line.equals("OOO")) {
                textForUser.setText("Computer won");
                setEndOfRound(true);
                winnerLine(a, "-fx-background-color:yellow;-fx-border-color:red", buttonList);
                return;
            }

        }
    }

    private void winnerLine(int a, String s, List<Button> buttonList) {

        switch (a) {
            case 0:
                buttonList.get(0).setStyle(s);
                buttonList.get(1).setStyle(s);
                buttonList.get(2).setStyle(s);
                break;
            case 1:
                buttonList.get(3).setStyle(s);
                buttonList.get(4).setStyle(s);
                buttonList.get(5).setStyle(s);
                break;
            case 2:
                buttonList.get(6).setStyle(s);
                buttonList.get(7).setStyle(s);
                buttonList.get(8).setStyle(s);
                break;
            case 3:
                buttonList.get(0).setStyle(s);
                buttonList.get(3).setStyle(s);
                buttonList.get(6).setStyle(s);
                break;
            case 4:
                buttonList.get(1).setStyle(s);
                buttonList.get(4).setStyle(s);
                buttonList.get(7).setStyle(s);
                break;
            case 5:
                buttonList.get(2).setStyle(s);
                buttonList.get(5).setStyle(s);
                buttonList.get(8).setStyle(s);
                break;
            case 6:
                buttonList.get(0).setStyle(s);
                buttonList.get(4).setStyle(s);
                buttonList.get(8).setStyle(s);
                break;
            case 7:
                buttonList.get(2).setStyle(s);
                buttonList.get(4).setStyle(s);
                buttonList.get(6).setStyle(s);
                break;
            default:
        }
    }

    public void compMovement(List<Button> buttonList) {
        if (!isEndOfRound() && isComMovement()) {
            Random random = new Random();

            List<Button> emptyButtons = buttonList.stream()
                    .filter(button -> "".equals(button.getText())).collect(Collectors.toList());

            int randomIndex = random.nextInt(emptyButtons.size());
            emptyButtons.get(randomIndex).setText("O");

            setComMovement(false);
            checkIfThereIsAWinner(buttonList);
            checkEndOfMovement(buttonList);
            setUserMovement(true);
        }
    }

    public void reset(List<Button> buttonList) {
        buttonList.stream()
                .forEach(button -> {
                    button.setText("");
                    button.setDisable(false);
                    button.setStyle("-fx-background-color:white;-fx-border-color:red" );
                });
        setEndOfRound(false);
        setUserMovement(true);
        setComMovement(false);
    }

}


