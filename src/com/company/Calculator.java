package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener {
    //variables
    JFrame frame;
    JTextField textField;
    JButton[] numbersButton = new JButton[10];
    JButton[] functionButtons = new JButton[9];
    JButton addButton, subButton, mulButton, divButton;
    JButton decButton, negButton, equButton, clrButton, delButton;
    JPanel panel;

    Font myFont = new Font("Serif", Font.BOLD,20);
    double num1 = 0.00, num2 = 0.00, result = 0.00;
    char operator;

    Calculator(){
        //window of calculator
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 550);
        frame.setLayout(null);

        //Output of calculator
        textField = new JTextField();
        textField.setBounds(50,25, 300, 50);
        textField.setFont(myFont);
        textField.setEditable(false);

        //Functions Buttons
        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        negButton = new JButton("(-)");
        equButton = new JButton("=");
        delButton = new JButton("Delete");
        clrButton = new JButton("Clear");

        //adding functionButtons to array of function buttons
        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = decButton;
        functionButtons[5] = negButton;
        functionButtons[6] = equButton;
        functionButtons[7] = delButton;
        functionButtons[8] = clrButton;

        //settings of each function button
        for (JButton functionButton : functionButtons) {
            functionButton.addActionListener(this);
            functionButton.setFont(myFont);
            functionButton.setFocusable(false);
        }
        // adding numbers buttons and config of each number button
        for(int i = 0; i<numbersButton.length; i++){
            numbersButton[i] = new JButton(String.valueOf(i));
            numbersButton[i].addActionListener(this);
            numbersButton[i].setFont(myFont);
            numbersButton[i].setFocusable(false);
        }

        //end frame buttons
        delButton.setBounds(50, 430, 100, 50);
        clrButton.setBounds(150, 430, 100, 50);
        negButton.setBounds(250, 430, 100, 50);

        //Panel where we have numbers and operations
        panel = new JPanel();
        panel.setBounds(50, 100, 300, 300);
        panel.setLayout(new GridLayout(4, 4, 10, 10));

        //Design and order of panel
        panel.add(numbersButton[1]);
        panel.add(numbersButton[2]);
        panel.add(numbersButton[3]);
        panel.add(addButton);
        panel.add(numbersButton[4]);
        panel.add(numbersButton[5]);
        panel.add(numbersButton[6]);
        panel.add(subButton);
        panel.add(numbersButton[7]);
        panel.add(numbersButton[8]);
        panel.add(numbersButton[9]);
        panel.add(mulButton);
        panel.add(decButton);
        panel.add(numbersButton[0]);
        panel.add(equButton);
        panel.add(divButton);


        //Adding elements to frame and setting Visibility to true
        frame.add(panel);
        frame.add(delButton);
        frame.add(clrButton);
        frame.add(negButton);
        frame.add(textField);
        frame.setVisible(true);

}
    public static void main(String[] args){
        //Creates our calculator;
        System.out.println("Loading...");
        Calculator calculator = new Calculator();
        System.out.println("Working!");

    }

    @Override
    //Logic of the software
    public void actionPerformed(ActionEvent e) {

        //numbers
        for(int i = 0; i<numbersButton.length; i++){
            if(e.getSource() == numbersButton[i]){
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }
        //Special Buttons Logic
        if(e.getSource() == decButton){
            textField.setText(textField.getText().concat("."));
        }
        if(e.getSource() == negButton){
            double temp = (Double.parseDouble(textField.getText()));
            temp *=-1;
            textField.setText(String.valueOf(temp));
        }
        if(e.getSource() == clrButton){
            textField.setText("");
        }
        if(e.getSource() == delButton){
            String aux = textField.getText();
            textField.setText("");
            for(int i = 0; i<aux.length()-1; i++){
                textField.setText(textField.getText()+ aux.charAt(i));
            }
        }
        //Operations Logic Buttons
        if(e.getSource() == addButton){
           num1 = Double.parseDouble(textField.getText());
           operator = '+';
           textField.setText("");
        }
        if(e.getSource() == subButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText("");
        }
        if(e.getSource() == mulButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '*';
            textField.setText("");
        }
        if(e.getSource() == divButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText("");
        }

        //Logic of equal Buttons and getting result
        if(e.getSource() == equButton){
            num2 = Double.parseDouble(textField.getText());

            switch (operator){
                case '+' -> result =  num1+num2;
                case '-' -> result =  num1-num2;
                case '*' -> result =  num1*num2;
                case '/' -> result =  num1/num2;
            }
            textField.setText(String.valueOf(result));
        }
    }
}
