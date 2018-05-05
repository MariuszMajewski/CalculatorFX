package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Controller {
    private double wynik;
    private double digitA;
    private double digitB;
    //  private boolean isContinued = false;
    private boolean isScreenContinued = true;
    private boolean isMinus = false;
    // Operations
    // 0 - no operation
    // 1 - Add
//     2 - Minus
//    3 - Multiply
//    4 - Divide
    private int operation = 0;
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
            isScreenContinued = true;
        }
        if (event.getSource().equals(digit0)) {
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
    void onActionOperations(ActionEvent event) {
        System.out.println("test Operations 1:    operacja: " + operation + " wynik: " + wynik + " digitA: " + digitA + "   digitB: " + digitB + "   tempScreenView: " + tempScreenView);

        if (operation==0) {
            digitA = Double.parseDouble(tempScreenView.toString());
            isScreenContinued = false;
        }
        else {
            digitB = Double.parseDouble(tempScreenView.toString());
        }
            if(operation==1){
                digitA = wynik = onActionAdd(digitA,digitB);
            }else if(operation==2){
            digitA = wynik = onActionMinus(digitA,digitB);
            }else if(operation==3){
                digitA = wynik = onActionMultiply(digitA,digitB);
            }else if(operation==4){
                if(digitB!=0)
                    digitA = wynik = onActionDivide(digitA,digitB);
                else
                    System.out.println("Nie dziel przez zero");
            }

            if (event.getSource().equals(buttonAdd)) {
                operation = 1;
                smallScreen.setText(smallScreen.getText() + " " + screen.getText() + " +");
            } else if (event.getSource().equals(buttonMinus)) {
                operation = 2;
                smallScreen.setText(smallScreen.getText() + " " + screen.getText() + " -");
            }
            else if (event.getSource().equals(buttonMultiply)) {
                operation = 3;
                smallScreen.setText(smallScreen.getText() + " " + screen.getText() + " *");
            }
            else if (event.getSource().equals(buttonDivide)) {
                operation = 4;
                smallScreen.setText(smallScreen.getText() + " " + screen.getText() + " /");
            }


            tempScreenView.delete(0, tempScreenView.length());
            screen.setText(String.valueOf(digitA));

            System.out.println("test Operations 2:    operacja: " + operation + " wynik: " + wynik + " digitA: " + digitA + "   digitB: " + digitB + "   tempScreenView: " + tempScreenView);
    }
    @FXML
    void onActionSum(ActionEvent event) {

        if (operation==1) {
            digitB = Double.parseDouble(screen.getText());
            wynik = onActionAdd(digitA,digitB);
        } else if (operation==2) {
            digitB = Double.parseDouble(screen.getText());
            wynik = onActionMinus(digitA,digitB);
        } else if (operation==3) {
            digitB = Double.parseDouble(screen.getText());
            wynik = onActionMultiply(digitA,digitB);
        } else if (operation==4) {
            digitB = Double.parseDouble(screen.getText());
            if(digitB!=0)
            wynik = onActionDivide(digitA,digitB);
        }
        operation = 0;
        digitA = 0;
        digitB = 0;
        isScreenContinued = false;

        smallScreen.setText("");
        screen.setText(String.valueOf(wynik));
        tempScreenView.delete(0, tempScreenView.length());
        tempScreenView.append(String.valueOf(wynik));
    }


    double onActionAdd(double digitA, double digitB) {
         return digitA + digitB;
    }

    double onActionMinus(double digitA, double digitB) {
        return digitA - digitB;
    }
    double onActionMultiply(double digitA, double digitB) {
        return digitA * digitB;
    }
    double onActionDivide(double digitA, double digitB) {
        System.out.println("t "+(digitA / digitB)+(digitA % digitB));
        return (digitA / digitB)+(digitA % digitB);
    }


    @FXML
    void onActionC(ActionEvent event) {
        digitA = 0;
        digitB = 0;
        screen.setText("");
        smallScreen.setText("");
        tempScreenView.delete(0, tempScreenView.length());
        isScreenContinued = false;
        operation = 0;
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


}
