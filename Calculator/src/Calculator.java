//import java.awt.event.ActionEvent;
//
//public void actionPerformed(ActionEvent e) {
//    String buttonClick = e.getActionCommand();
//    if (buttonClick.matches("[0-9]")) {
//        // at first if the button is equals to 0, calculator screen will only display the value 0
//        if (isClickedOperator || isClickedEqual || calculatorScreen.getText().equals("0")) {
//            calculatorScreen.setText(buttonClick);
//        } else {
//            // else if the button is not equal to 0, the screen will display buttons that are clicked
//            calculatorScreen.setText(calculatorScreen.getText() + buttonClick);
//        }
//
//        isClickedOperator = false;
//
//        // if the button is clicked that equals to "="
//    } else if (buttonClick.equals("=")) {
//        // make num two get the text from calculator screen using the getText method
//        numTwo = (Double.parseDouble(calculatorScreen.getText()));
//
//        double result = 0;
//        switch (mathOperator) {
//            case '+':
//                result = numOne + numTwo;
//                break;
//            case '-':
//                result = numOne - numTwo;
//                break;
//            case 'X':
//                result = numOne * numTwo;
//                break;
//            case '/':
//                result = numOne / numTwo;
//                break;
//
//        }
//        // display the result
//        calculatorScreen.setText(Double.toString(result));
//
//        isClickedOperator = true;
//    }
//    // if the button clicked is equals to the word "CLEAR"
//    else if (buttonClick.equals("CLEAR")) {
//        // screen will display back to 0
//        calculatorScreen.setText("0");
//        // if the button clicked is equals to the word "DELETE"
//    } else if (buttonClick.equals("DELETE")) {
//        // get the screen text length and store it to the variable textLength
//        int textLength = calculatorScreen.getText().length();
//        // if the textLength is equals to 1, calculator screen will display 0
//        if (textLength == 1) {
//            calculatorScreen.setText("0");
//        } else {
//            // get text from the screen and store it to the variable screenText
//            String screenText = calculatorScreen.getText();
//            // clear the screen
//            calculatorScreen.setText("");
//            // loop the length of the screen text minus 1, and display the remaining text to the screen
//            for (int i = 0; i < screenText.length() - 1; i++) {
//                calculatorScreen.setText(calculatorScreen.getText() + screenText.charAt(i));
//            }
//        }
//        // if button clicked is equals to "."
//    } else if (buttonClick.equals(".")) {
//        // if calculator screen does not have ".", the screen will display what we got from it plus the new value from a button
//        if (!calculatorScreen.getText().contains(".")) {
//            calculatorScreen.setText(calculatorScreen.getText() + buttonClick);
//        }
//        // if button clicked is equals to "negative button"
//    } else if (buttonClick.equals("(-)")) {
//        // get the number from the text and store it to negativeNumber variable
//        double negativeNumber = Double.parseDouble(calculatorScreen.getText());
//        // negativeNumber multiply it by -1
//        negativeNumber *= -1;
//        // display the result to the screen
//        calculatorScreen.setText(String.valueOf(negativeNumber));
//    } else {
//        // if operator is not true, get the value from the screen, store it to numOne
//        if (!isClickedOperator) {
//            numOne = (Double.parseDouble(calculatorScreen.getText()));
//        }
//        // get the first String of screen text and store it to math operator
//        mathOperator = buttonClick.charAt(0);
//        // isClickedOperator set back to true
//        isClickedOperator = true;
//    }