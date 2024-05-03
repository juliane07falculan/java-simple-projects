import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorGUI extends JFrame implements ActionListener {
    // stores screen values
    double numOne, numTwo;

    // check if what operator button is clicked
    char mathOperator;

    // check if operator or equal button is true or false
    boolean isClickedOperator, isClickedEqual;

    // calculator main buttons
    JButton[] calculatorMainButtons;

    // bottom buttons includes (-) negative, clear and delete button
    JButton[] calculatorBottomButtons;

    // calculator screen that we will use later to get the text from
    JTextField calculatorScreen;

    CalculatorGUI() {
        // set title of the UI
        super("Calculator");

        // it will automatically close the frame after exit
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 350 pixels wide and 480 pixels tall
        setSize(350, 480);

        // it will disable to resize the frame
        setResizable(false);

        // allows us to place our components manually
        setLayout(null);

        // once ui open, it will place in the center of the screen
        setLocationRelativeTo(null);

        // add the components of calculator
        addComponents();
    }

    public void addComponents() {
        // the screen of our calculator
        addCalculatorScreen();

//        // the buttons of the calculator
        addButtonsCalculator();
    }

    public void addCalculatorScreen() {
        calculatorScreen = new JTextField("0");
        calculatorScreen.setBounds(15, 30, 305, 50);
        calculatorScreen.setFont(new Font("Arial", Font.BOLD, 35));
        calculatorScreen.setHorizontalAlignment(SwingConstants.RIGHT);
        calculatorScreen.setBorder(BorderFactory.createEmptyBorder());
        calculatorScreen.setEditable(false);
        calculatorScreen.setCaretColor(getBackground());
        add(calculatorScreen);
    }

    public void addButtonsCalculator() {
        // panel for the container of buttons
        JPanel mainButtonsPanel = new JPanel();
        mainButtonsPanel.setBounds(15, 100, 305, 270);
        mainButtonsPanel.setLayout(new GridLayout(4, 4, 3, 3));
        add(mainButtonsPanel);

        // calculator main buttons
        calculatorMainButtons = new JButton[16];
        for (int i = 0; i < calculatorMainButtons.length; i++) {
            calculatorMainButtons[i] = new JButton(getMainLabel(i));
            calculatorMainButtons[i].setBackground(Color.white);
            calculatorMainButtons[i].setFont(new Font("Arial", Font.BOLD, 17));
            calculatorMainButtons[i].setFocusable(false);
            calculatorMainButtons[i].addActionListener(this);
            mainButtonsPanel.add(calculatorMainButtons[i]);
        }

        // panel of bottom buttons
        JPanel bottomButtonsPanel = new JPanel();
        bottomButtonsPanel.setBounds(15, 373, 305, 50);
        bottomButtonsPanel.setLayout(new GridLayout(1, 3, 3, 3));
        add(bottomButtonsPanel);

        // calculator bottom buttons
        calculatorBottomButtons = new JButton[3];
        for (int i = 0; i < calculatorBottomButtons.length; i++) {
            calculatorBottomButtons[i] = new JButton(getBottomLabel(i));
            calculatorBottomButtons[i].setBackground(Color.white);
            calculatorBottomButtons[i].setFont(new Font("Arial", Font.BOLD, 16));
            calculatorBottomButtons[i].setFocusable(false);
            calculatorBottomButtons[i].addActionListener(this);
            bottomButtonsPanel.add(calculatorBottomButtons[i]);
        }
    }

    public String getMainLabel(int indexButton) {
        switch (indexButton) {
            case 0:
                return "7";
            case 1:
                return "8";
            case 2:
                return "9";
            case 3:
                return "/";
            case 4:
                return "4";
            case 5:
                return "5";
            case 6:
                return "6";
            case 7:
                return "x";
            case 8:
                return "1";
            case 9:
                return "2";
            case 10:
                return "3";
            case 11:
                return "-";
            case 12:
                return ".";
            case 13:
                return "0";
            case 14:
                return "+";
            case 15:
                return "=";
        }
        return "";
    }

    public String getBottomLabel(int indexButton) {
        switch (indexButton) {
            case 0:
                return "(-)";
            case 1:
                return "CLEAR";
            case 2:
                return "DELETE";
        }
        return "";
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // surround with try catch block to handle some error that might stop the normal flow of the program
        // ignore that exception
       try {
           // we get the string of our buttons using getActionCommand and store it to buttonClick variable
           String buttonClick = e.getActionCommand();
           if (buttonClick.matches("[0-9]")) {
               // if the textfield/screen has only 0 on it, display 0
               if (calculatorScreen.getText().equals("0")) {
                   calculatorScreen.setText(buttonClick);
               } else {
                   // if the screen has the value >0, we append the new number to the current number
                   calculatorScreen.setText(calculatorScreen.getText() + buttonClick);
               }
           } else if (buttonClick.equals("+") || buttonClick.equals("-") || buttonClick.equals("x") || buttonClick.equals("/")) {
               // get the value/s from the screen and store it to the variable numOne, serves as a first number
               numOne = Double.parseDouble(calculatorScreen.getText());
               // get the first character of the button clicked and store it to the variable mathOperator
               mathOperator = buttonClick.charAt(0);
               // clear the screen to prevent it from appending the latest number to the current number
               calculatorScreen.setText("");
           } else if (buttonClick.equals("=")) {
               // get the text/number from the screen and store it to variable numTwo, serves as a second number
               numTwo = Double.parseDouble(calculatorScreen.getText());
               // compare if mathOperator's character is matches to our cases
               double result = 0;
               switch (mathOperator) {
                   case '+':
                       result = numOne + numTwo;
                       break;
                   case '-':
                       result = numOne - numTwo;
                       break;
                   case 'x':
                       result = numOne * numTwo;
                       break;
                   case '/':
                       result = numOne / numTwo;
                       break;
               }
               // display the result but make sure to make it a string since it is a double variable
               calculatorScreen.setText(Double.toString(result));
           } else if (buttonClick.equals(".")) {
               // if the numbers on the screen has not ".", place one.
               if (!calculatorScreen.getText().contains(".")) {
                   calculatorScreen.setText(calculatorScreen.getText() + buttonClick);
               }
           } else if (buttonClick.equals("(-)")) {
               // get the value from the screen and store it to the variable negative number
               double negativeNumber = Double.parseDouble(calculatorScreen.getText());
               // multiply by -1
               negativeNumber *= -1;
               // since negativeNumber variable is a double and setText requires string, make sure to change it to String
               calculatorScreen.setText(Double.toString(negativeNumber));
           } else if (buttonClick.equals("DELETE")) {
               // get the value from the screen and store it to the variable deleteCharacter
               String deleteCharacter = calculatorScreen.getText();
               // clear textfield to prevent it from appending to latest text/number
               calculatorScreen.setText("");
               // create a loop to get the length of the string and remove 1 from it
               for (int i = 0; i < deleteCharacter.length() - 1; i ++) {
                   // since our text field is cleared, no numbers can append to the latest
                   calculatorScreen.setText(calculatorScreen.getText() + deleteCharacter.charAt(i));
               }
               // if screen has only 1 number and clicked the delete button, it will display 0 instead of a blank space
               if (calculatorScreen.getText().length() == 1) {
                   calculatorScreen.setText("0");
               }
           } else if (buttonClick.equals("CLEAR")) {
               // display 0 to the screen, that serves as the default display
               calculatorScreen.setText("0");
           }
       } catch (Exception exception) {
           // set to blank if there are any exceptions
           System.out.println("");
       }
    }
}