package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.DragEvent;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    private double wynik;
    private double digitA;
    private double digitB;
    private boolean czKolejnaOperacja=false;

    private double tempScreen;
    private String operation;
    private StringBuilder tempScreenView = new StringBuilder();

    public static double AddOperation(double a, double b) {
        return a+b;
    }
    public Controller() {
    }

    public void initialize() {
    }

    @FXML
    Button digit0;

    @FXML
    Button digit1;

    @FXML
    Button digit2;

    @FXML
    Button digit3;

    @FXML
    Button digit4;

    @FXML
    Button digit5;

    @FXML
    Button digit6;

    @FXML
    Button digit7;

    @FXML
    Button digit8;

    @FXML
    Button digit9;

    @FXML
    Button buttonAdd;

    @FXML
    Button buttonC;

    @FXML
    Button buttonCE;

    @FXML
    Button buttonBack;

    @FXML
    Button buttonSum;

    @FXML
    Label screen;

    @FXML
    Label smallScreen;

    @FXML
    void OnActionDigit(ActionEvent event) {
        if (czKolejnaOperacja){
            tempScreenView.delete(0,tempScreenView.length());
        }
        if(event.getSource().equals(digit0))
            tempScreenView.append("0");
        if(event.getSource().equals(digit1))
            tempScreenView.append("1");
        if(event.getSource().equals(digit2))
            tempScreenView.append("2");
        if(event.getSource().equals(digit3))
            tempScreenView.append("3");
        if(event.getSource().equals(digit4))
            tempScreenView.append("4");
        if(event.getSource().equals(digit5))
            tempScreenView.append("5");
        if(event.getSource().equals(digit6))
            tempScreenView.append("6");
        if(event.getSource().equals(digit7))
            tempScreenView.append("7");
        if(event.getSource().equals(digit8))
            tempScreenView.append("8");
        if(event.getSource().equals(digit9))
            tempScreenView.append("9");
            screen.setText(tempScreenView.toString());
    }


    @FXML
    void OnActionAdd(ActionEvent event) {
        if(!czKolejnaOperacja) {
            setScreen(screen.getText()+" +");
            digitA = Double.parseDouble(screen.getText());
            System.out.println("test Add 1");
            czKolejnaOperacja=true;
            operation = "+";
        }else {
            digitB = Double.parseDouble(screen.getText());
            digitA = wynik = digitA+digitB;
            setScreen(screen.getText()+" +");
            screen.setText(String.valueOf(wynik));
//            czKolejnaOperacja=true;
            System.out.println("test Add 2");
        }

    }
    void setScreen(String screenText) {
        smallScreen.setText(smallScreen.getText()+" "+screenText);

    }

    @FXML
    void onActionC(ActionEvent event) {
        digitA = 0;
        digitB = 0;
        screen.setText("");
        smallScreen.setText("");
        tempScreenView.delete(0,tempScreenView.length());
    }
    @FXML
    void onActionCE(ActionEvent event) {
        screen.setText("");
        tempScreenView.delete(0,tempScreenView.length());
    }

    @FXML
    void onActionBack(ActionEvent event) {
        tempScreenView.delete(tempScreenView.length()-1,tempScreenView.length());
        screen.setText(tempScreenView.toString());
    }

    @FXML
    void onActionSum(ActionEvent event) {
        smallScreen.setText("");
        tempScreenView.delete(0,tempScreenView.length());
        if(operation.equals("+")){
            digitB = Double.parseDouble(screen.getText());
            digitA = wynik = digitA+digitB;
        }
        screen.setText(String.valueOf(wynik));
    }
}
