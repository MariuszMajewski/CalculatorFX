package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Controller {
    private double wynik;
    private double digitA;
    private double digitB;
    private boolean isContinued = false;
    private boolean isScreenContinued = true;
    private boolean isMinus = false;
    private String operation;
    private StringBuilder tempScreenView = new StringBuilder();

    public static double AddOperation(double a, double b) {
        return a + b;
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
    Button buttonMinus;

    @FXML
    Button buttonMultiply;

    @FXML
    Button buttonDivide;

    @FXML
    Button buttonPM;

    @FXML
    Button buttonDot;

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
        if (!isScreenContinued) {
            tempScreenView.delete(0, tempScreenView.length());
            isScreenContinued=true;
        }
        if (event.getSource().equals(digit0)){
            tempScreenView.append("0");
        }
        if (event.getSource().equals(digit1))
            tempScreenView.append("1");
        if (event.getSource().equals(digit2))
            tempScreenView.append("2");
        if (event.getSource().equals(digit3))
            tempScreenView.append("3");
        if (event.getSource().equals(digit4))
            tempScreenView.append("4");
        if (event.getSource().equals(digit5))
            tempScreenView.append("5");
        if (event.getSource().equals(digit6))
            tempScreenView.append("6");
        if (event.getSource().equals(digit7))
            tempScreenView.append("7");
        if (event.getSource().equals(digit8))
            tempScreenView.append("8");
        if (event.getSource().equals(digit9))
            tempScreenView.append("9");
        if (event.getSource().equals(buttonDot))
            tempScreenView.append(".");
        if (event.getSource().equals(buttonPM)) {

            if (isMinus) {
                double tempNumber = Double.parseDouble(tempScreenView.toString());
                tempScreenView.delete(0, tempScreenView.length());
                tempScreenView.append(Math.abs(tempNumber));
                isMinus = false;
            } else {
                StringBuilder temp = new StringBuilder(tempScreenView);
                tempScreenView.delete(0, tempScreenView.length());
                tempScreenView.append("-" + temp);
                isMinus = true;
            }
        }
        screen.setText(tempScreenView.toString());
    }


    @FXML
    void OnActionAdd(ActionEvent event) {
        if (!isContinued) {
            System.out.println("test Add 1    wynik: "+wynik+"  digitA: "+digitA+"   digitB: "+digitB+"   tempScreenView: "+tempScreenView);
            smallScreen.setText(smallScreen.getText() + " " + screen.getText() + " +");
            digitA = Double.parseDouble(tempScreenView.toString());;
            isContinued = true;
            isScreenContinued=false;
            operation = "+";
            System.out.println("test Add 1   wynik: "+wynik+" digitA: "+digitA+"   digitB: "+digitB+"   tempScreenView: "+tempScreenView);
        } else {
            System.out.println("test Add 2    wynik: "+wynik+"  digitA: "+digitA+"   digitB: "+digitB+"   tempScreenView: "+tempScreenView);
            digitB = Double.parseDouble(tempScreenView.toString());
            digitA = wynik = digitA + digitB;
            tempScreenView.delete(0, tempScreenView.length());
            smallScreen.setText(smallScreen.getText() + " " + screen.getText() + " +");
            screen.setText(String.valueOf(wynik));
            System.out.println("test Add 2    wynik: "+wynik+"  digitA: "+digitA+"   digitB: "+digitB+"   tempScreenView: "+tempScreenView);
        }

    }

    @FXML
    void onActionDivide(ActionEvent event) {

    }

    @FXML
    void onActionMultiply(ActionEvent event) {

    }

    @FXML
    void onActionMinus(ActionEvent event) {
        if (!isContinued) {
            System.out.println("test Minus 1    wynik: "+wynik+"  digitA: "+digitA+"   digitB: "+digitB+"   tempScreenView: "+tempScreenView);
            smallScreen.setText(smallScreen.getText() + " " + screen.getText() + " -");
            digitA = Double.parseDouble(tempScreenView.toString());;
            isContinued = true;
            isScreenContinued=false;
            operation = "-";
            System.out.println("test Minus 1   wynik: "+wynik+" digitA: "+digitA+"   digitB: "+digitB+"   tempScreenView: "+tempScreenView);
        } else {
            System.out.println("test Minus 2    wynik: "+wynik+"  digitA: "+digitA+"   digitB: "+digitB+"   tempScreenView: "+tempScreenView);
            digitB = Double.parseDouble(tempScreenView.toString());
            digitA = wynik = digitA - digitB;
            tempScreenView.delete(0, tempScreenView.length());
            smallScreen.setText(smallScreen.getText() + " " + screen.getText() + " -");
            screen.setText(String.valueOf(wynik));
            System.out.println("test Minus 2    wynik: "+wynik+"  digitA: "+digitA+"   digitB: "+digitB+"   tempScreenView: "+tempScreenView);
        }
    }


    void setScreen(String screenText) {


    }

    @FXML
    void onActionC(ActionEvent event) {
        digitA = 0;
        digitB = 0;
        screen.setText("");
        smallScreen.setText("");
        tempScreenView.delete(0, tempScreenView.length());
        isContinued = false;
        isScreenContinued=false;
        operation = "";
    }

    @FXML
    void onActionCE(ActionEvent event) {
        screen.setText("");
        tempScreenView.delete(0, tempScreenView.length());
    }

    @FXML
    void onActionBack(ActionEvent event) {
        tempScreenView.delete(tempScreenView.length() - 1, tempScreenView.length());
        screen.setText(tempScreenView.toString());

    }

    @FXML
    void onActionSum(ActionEvent event) {
        System.out.println("test Sum 0   wynik: "+wynik+" digitA: "+digitA+"   digitB: "+digitB+"   tempScreenView: "+tempScreenView);
        smallScreen.setText("");
        tempScreenView.delete(0, tempScreenView.length());
        if (operation.equals("+")) {
            digitB = Double.parseDouble(screen.getText());
            wynik = digitA + digitB;
            System.out.println("Operacja +");
        }else if (operation.equals("-")) {
            digitB = Double.parseDouble(screen.getText());
            wynik = digitA - digitB;
            System.out.println("Operacja -");
        }
        operation = "";
        digitA=0;
        digitB=0;
        isContinued = false;
        isScreenContinued=false;
        System.out.println("test Sum 1    wynik: "+wynik+"   digitA: "+digitA+"   digitB: "+digitB+"  tempScreenView: "+tempScreenView);
        screen.setText(String.valueOf(wynik));
        tempScreenView.append(String.valueOf(wynik));
    }
}
