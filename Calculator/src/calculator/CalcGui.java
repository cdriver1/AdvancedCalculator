package calculator;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.ComponentOrientation;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author Charles
 */
public class CalcGui extends JPanel {

    private JPanel answerPnl = new JPanel();
    private JTextArea calcTA = new JTextArea();
    private JPanel btnPnl = new JPanel();
    private String equation = " ";
    private String visibleEQ = " ";
    private String answer = "No Calculation Done";
    private String[] btnLabels = {"C", "(", ")", "DEL", "sin", "cos", "tan",
        "÷", "7", "8", "9", "*", "4", "5", "6", "-", "1",
        "2", "3", "+", "0", ".", "ans", "="};
    private JButton[] buttons = new JButton[btnLabels.length];

    public CalcGui() {
        setUp();
        setLayout(new GridLayout(2, 1));
    }

    private void setUp() {
        calcTA.setVisible(true);
        calcTA.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);

        answerPnl.setLayout(new GridLayout());
        answerPnl.add(calcTA);
        this.add(answerPnl);
        btnPnl.setLayout(new GridLayout(6, 4));

        for (int i = 0; i < 8; i++) {
            buttons[i] = new JButton(btnLabels[i]);
            buttons[i].addActionListener(new OpButtonListener(i));
            btnPnl.add(buttons[i]);
        }
        for (int i = 8; i < 11; i++) {
            buttons[i] = new JButton(btnLabels[i]);
            buttons[i].addActionListener(new NumButtonListener(i));
            btnPnl.add(buttons[i]);
        }
        buttons[11] = new JButton(btnLabels[11]);
        buttons[11].addActionListener(new OpButtonListener(11));
        btnPnl.add(buttons[11]);
        for (int i = 12; i < 15; i++) {
            buttons[i] = new JButton(btnLabels[i]);
            buttons[i].addActionListener(new NumButtonListener(i));
            btnPnl.add(buttons[i]);
        }
        buttons[15] = new JButton(btnLabels[15]);
        buttons[15].addActionListener(new OpButtonListener(15));
        btnPnl.add(buttons[15]);
        for (int i = 16; i < 19; i++) {
            buttons[i] = new JButton(btnLabels[i]);
            buttons[i].addActionListener(new NumButtonListener(i));
            btnPnl.add(buttons[i]);
        }
        buttons[19] = new JButton(btnLabels[19]);
        buttons[19].addActionListener(new OpButtonListener(19));
        buttons[20] = new JButton(btnLabels[20]);
        buttons[20].addActionListener(new NumButtonListener(20));
        buttons[21] = new JButton(btnLabels[21]);
        buttons[21].addActionListener(new OpButtonListener(21));
        buttons[22] = new JButton(btnLabels[22]);
        buttons[22].addActionListener(new OpButtonListener(22));
        buttons[23] = new JButton(btnLabels[23]);
        buttons[23].addActionListener(new OpButtonListener(23));
        for (int i = 19; i < 24; i++) {
            btnPnl.add(buttons[i]);
        }
        this.add(btnPnl);
    }

    private class NumButtonListener implements ActionListener {

        private int btnNumber;

        public NumButtonListener(int btnNumber) {
            this.btnNumber = btnNumber;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            switch (btnNumber) {
                case 8://7 button
                    equation = equation + "7";
                    visibleEQ = visibleEQ + "7";
                    calcTA.setText(visibleEQ);
                    break;
                case 9://8 button
                    equation = equation + "8";
                    visibleEQ = visibleEQ + "8";
                    calcTA.setText(visibleEQ);
                    break;
                case 10://9 button
                    equation = equation + "9";
                    visibleEQ = visibleEQ + "9";
                    calcTA.setText(visibleEQ);
                    break;
                case 12://4 button
                    equation = equation + "4";
                    visibleEQ = visibleEQ + "4";
                    calcTA.setText(visibleEQ);
                    break;
                case 13://5 button
                    equation = equation + "5";
                    visibleEQ = visibleEQ + "5";
                    calcTA.setText(visibleEQ);
                    break;
                case 14://6 button
                    equation = equation + "6";
                    visibleEQ = visibleEQ + "6";
                    calcTA.setText(visibleEQ);
                    break;
                case 16://1 button
                    equation = equation + "1";
                    visibleEQ = visibleEQ + "1";
                    calcTA.setText(visibleEQ);
                    break;
                case 17://2 button
                    equation = equation + "2";
                    visibleEQ = visibleEQ + "2";
                    calcTA.setText(visibleEQ);
                    break;
                case 18://3 button
                    equation = equation + "3";
                    visibleEQ = visibleEQ + "3";
                    calcTA.setText(visibleEQ);
                    break;
                case 20://0 button
                    equation = equation + "0";
                    visibleEQ = visibleEQ + "0";
                    calcTA.setText(visibleEQ);
                    break;
            }
        }
    }

    private class OpButtonListener implements ActionListener {

        private int btnNumber;

        public OpButtonListener(int btnNumber) {
            this.btnNumber = btnNumber;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            //All calculation done in equals button or closed paran code.
            switch (btnNumber) {
                case 0://C button
                    equation = " ";
                    visibleEQ = " ";
                    calcTA.setText(visibleEQ);
                    break;
                case 1:// ( button
                    equation = equation + "( ";
                    visibleEQ = visibleEQ + "(";
                    calcTA.setText(visibleEQ);
                    break;
                case 2:// ) button
                    equation = closingParan(equation);
                    visibleEQ = visibleEQ + ")";
                    calcTA.setText(visibleEQ);
                    break;
                case 3:// Delete button
                    deleteBtn();
                    calcTA.setText(visibleEQ);
                    break;
                case 4:// Sine button
                    equation = equation + "sin( ";
                    visibleEQ = visibleEQ + "sin(";
                    calcTA.setText(visibleEQ);
                    break;
                case 5://Cosine button
                    equation = equation + "cos( ";
                    visibleEQ = visibleEQ + "cos(";
                    calcTA.setText(visibleEQ);
                    break;
                case 6://Tangent button
                    equation = equation + "tan( ";
                    visibleEQ = visibleEQ + "tan(";
                    calcTA.setText(visibleEQ);
                    break;
                case 7://Division button
                    if (Character.isDigit(equation.charAt(equation.length() - 1))) {
                        equation = equation + " / ";
                        visibleEQ = visibleEQ + "/";
                    }
                    calcTA.setText(visibleEQ);
                    break;
                case 11://Multiplication button
                    if (Character.isDigit(equation.charAt(equation.length() - 1))) {
                        equation = equation + " * ";
                        visibleEQ = visibleEQ + "*";
                    }
                    calcTA.setText(visibleEQ);
                    break;
                case 15://Subtract button
                    if (Character.isDigit(equation.charAt(equation.length() - 1))) {
                        equation = equation + " - ";
                        visibleEQ = visibleEQ + "-";
                    }
                    calcTA.setText(visibleEQ);
                    break;
                case 19://Add button
                    if (Character.isDigit(equation.charAt(equation.length() - 1))) {
                        equation = equation + " + ";
                        visibleEQ = visibleEQ + "+";
                    }
                    calcTA.setText(visibleEQ);
                    break;
                case 21://Decimal button
                    equation = equation + ".";
                    visibleEQ = visibleEQ + ".";
                    calcTA.setText(visibleEQ);
                    break;
                case 22://Answer button                    
                    calcTA.setText(answer);
                    break;
                case 23://Equals button 
                    System.out.println(equation);
                    equation = equation + " ";
                    double ans = Double.parseDouble(evaluate(equation));
                    answer = "" + (double) Math.round(ans * 10000) / 10000;
                    equation = answer;
                    calcTA.setText(answer);
                    equation = " ";
                    visibleEQ = " ";
                    break;

            }
        }

        public String closingParan(String eq) {
            String paranEquation = eq.substring(eq.lastIndexOf("(") + 2);
            // runs evaluate for whatever is within the parenthesis
            String paranRes = evaluate(paranEquation);
            double resNum = Double.parseDouble(paranRes);

            if ((eq.contains("sin"))) {
                // use Math class for sin function on paranRes
                resNum = Math.sin(resNum);
                paranRes = Double.toString(resNum);
                if (eq.lastIndexOf("sin") > 0) {
                    if (Character.isDigit(eq.charAt(eq.lastIndexOf("sin") - 1))) {
                        return eq.substring(0, eq.indexOf("sin")) + " * " + paranRes;
                    }
                }
                return eq.substring(0, eq.indexOf("sin")) + paranRes;
            } else if ((eq.contains("cos"))) {
                // use Math class for cos function on paranRes
                resNum = Math.cos(resNum);
                paranRes = Double.toString(resNum);
                if (eq.lastIndexOf("cos") > 0) {
                    if (Character.isDigit(eq.charAt(eq.lastIndexOf("cos") - 1))) {
                        return eq.substring(0, eq.indexOf("cos")) + " * " + paranRes;
                    }
                }
                return eq.substring(0, eq.indexOf("cos")) + paranRes;
            } else if ((eq.contains("tan"))) {
                // use Math class for tan function on paranRes
                resNum = Math.tan(resNum);
                paranRes = Double.toString(resNum);
                if (eq.lastIndexOf("tan") > 0) {
                    if (Character.isDigit(eq.charAt(eq.lastIndexOf("tan") - 1))) {
                        return eq.substring(0, eq.indexOf("tan")) + " * " + paranRes;
                    }
                }
                return eq.substring(0, eq.indexOf("tan")) + paranRes;
            } else {
                // adds the result from the parans to equation for the final equation
                if (eq.lastIndexOf("(") > 0) {
                    if (Character.isDigit(eq.charAt(eq.lastIndexOf("(") - 1))) {
                        System.out.println(" yes ");
                        String temp = eq.substring(0, eq.indexOf("(")) + " * " + paranRes;
                        return temp;
                    }
                }
                return eq.substring(0, eq.lastIndexOf("(")) + paranRes;
            }
        }

        public void deleteBtn() {
            if (equation.length() > 1) {
                if (equation.endsWith(" ")) {
                    // removes sin, cos or tan from equation and the screen
                    if (equation.charAt(equation.length() - 3) == 'n' || equation.charAt(equation.length() - 3) == 's') {
                        visibleEQ = visibleEQ.substring(0, visibleEQ.length() - 4);
                        equation = equation.substring(0, equation.length() - 5);
                    } else {// removes operator from equation and the screen
                        visibleEQ = visibleEQ.substring(0, visibleEQ.length() - 1);
                        equation = equation.substring(0, equation.length() - 3);
                    }
                } else { //removes the last number from equation and the screen
                    equation = equation.substring(0, equation.length() - 1);
                    visibleEQ = visibleEQ.substring(0, visibleEQ.length() - 1);
                }
            }
        }

        public String evaluate(String equation) {
            String[] eqArray = equation.split(" ");
            int indOfM = equation.length(), indOfD = equation.length(),
                    indOfP = equation.length(), indOfS = equation.length();
            if (equation.contains("*")) {
                indOfM = equation.indexOf("*");
            }
            if (equation.contains("/")) {
                indOfD = equation.indexOf("/");
            }
            if (equation.contains("+")) {
                indOfP = equation.indexOf("+");
            }
            if (equation.contains("-")) {
                indOfS = equation.indexOf("-");
            }

            if (indOfM < equation.length() & indOfM < indOfD) {
                System.out.println("*");
                return multiply(eqArray, equation);
            } else if (indOfD < equation.length() & indOfD < indOfM) {
                System.out.println("/");
                return divide(eqArray, equation);
            } else if (equation.contains("+") & indOfP < indOfS) {
                return addition(eqArray, equation);
            } else if (equation.contains("-") & indOfS < indOfP) {
                return subtraction(eqArray, equation);
            }

            return equation;
        }

        public String multiply(String[] eqArray, String equation) {
            for (int i = 0; i < eqArray.length; i++) {
                if ("*".equals(eqArray[i])) {
                    double num1 = Double.parseDouble(eqArray[i - 1]);
                    double num2 = Double.parseDouble(eqArray[i + 1]);
                    double result = num1 * num2;
                    String tempEq = eqArray[i - 1] + " " + eqArray[i] + " " + eqArray[i + 1];
                    return evaluate(equation.replace(tempEq, Double.toString(result)));
                }
            }
            return equation;
        }

        public String divide(String[] eqArray, String equation) {
            for (int i = 0; i < eqArray.length; i++) {
                if ("/".equals(eqArray[i])) {
                    double num1 = Double.parseDouble(eqArray[i - 1]);
                    double num2 = Double.parseDouble(eqArray[i + 1]);
                    double result = num1 / num2;
                    String tempEq = eqArray[i - 1] + " " + eqArray[i] + " " + eqArray[i + 1];
                    //System.out.println(tempEq);
                    return evaluate(equation.replace(tempEq, Double.toString(result)));
                }
            }
            return equation;
        }

        public String addition(String[] eqArray, String equation) {
            for (int i = 0; i < eqArray.length; i++) {
                if ("+".equals(eqArray[i])) {
                    double num1 = Double.parseDouble(eqArray[i - 1]);
                    System.out.println(eqArray[i + 1]);
                    double num2 = Double.parseDouble(eqArray[i + 1]);
                    double result = num1 + num2;
                    String tempEq = eqArray[i - 1] + " " + eqArray[i] + " " + eqArray[i + 1];
                    //System.out.println(tempEq);
                    return evaluate(equation.replace(tempEq, Double.toString(result)));
                }
            }
            return equation;
        }

        public String subtraction(String[] eqArray, String equation) {
            for (int i = 0; i < eqArray.length; i++) {
                if ("-".equals(eqArray[i])) {
                    double num1 = Double.parseDouble(eqArray[i - 1]);
                    double num2 = Double.parseDouble(eqArray[i + 1]);
                    double result = num1 - num2;
                    String tempEq = eqArray[i - 1] + " " + eqArray[i] + " " + eqArray[i + 1];
                    //System.out.println(tempEq);
                    return evaluate(equation.replace(tempEq, Double.toString(result)));
                }
            }
            return equation;
        }
    }
}
