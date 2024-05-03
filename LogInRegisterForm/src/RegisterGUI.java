import db.FormJDBC;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RegisterGUI extends Form {
    RegisterGUI() {
        // set the title
        super("Register");
        // add register components
        addRegisterComponents();
    }

    public void addRegisterComponents() {
        // sign up label
        JLabel signUpLabel = new JLabel("Sign Up");
        signUpLabel.setFont(new Font("Arial", Font.BOLD, 35));
        signUpLabel.setBounds(150, 20, 130, 100);
        signUpLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(signUpLabel);

        // logIn panel
        JPanel logInPanel = new JPanel();
        logInPanel.setBounds(30, 125, 375, 250);
        logInPanel.setBackground(new Color(0xe5e7eb));
        logInPanel.setLayout(null);
        add(logInPanel);

        // username label
        JLabel userNameLabel = new JLabel("Username:");
        userNameLabel.setFont(new Font("Arial", Font.PLAIN, 13));
        userNameLabel.setBounds(35, -10, 100, 50);
        logInPanel.add(userNameLabel);

        // username textfield
        JTextField userNameTextField = new JTextField();
        userNameTextField.setFont(new Font("Arial", Font.PLAIN, 15));
        userNameTextField.setBounds(35, 30, 300, 40);
        logInPanel.add(userNameTextField);

        // password label
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setFont(new Font("Arial", Font.PLAIN, 13));
        passwordLabel.setBounds(35, 70, 100, 50);
        logInPanel.add(passwordLabel);

        // password textfield
        JPasswordField passwordTextField = new JPasswordField();
        passwordTextField.setFont(new Font("Arial", Font.PLAIN, 15));
        passwordTextField.setBounds(35, 110, 300, 40);
        logInPanel.add(passwordTextField);

        // confirm password label
        JLabel confirmPasswordLabel = new JLabel("Confirm Password:");
        confirmPasswordLabel.setFont(new Font("Arial", Font.PLAIN, 13));
        confirmPasswordLabel.setBounds(35, 155, 130, 50);
        logInPanel.add(confirmPasswordLabel);

        // confirm password textfield
        JPasswordField confirmPasswordField = new JPasswordField();
        confirmPasswordField.setFont(new Font("Arial", Font.PLAIN, 15));
        confirmPasswordField.setBounds(35, 190, 300, 40);
        logInPanel.add(confirmPasswordField);


        // sign up button
        JButton signUpButton = new JButton("Sign Up");
        signUpButton.setFont(new Font("Arial", Font.BOLD, 15));
        signUpButton.setForeground(Color.white);
        signUpButton.setBounds(145, 390, 150, 50);
        signUpButton.setBackground(new Color(59, 130, 246));
        signUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // get the username
                String userName = userNameTextField.getText();

                // get the password
                String password = new String(passwordTextField.getPassword());

                // get confirm password
                String confirmPassword = new String(confirmPasswordField.getPassword());

                // validate user inputs
                if (userInputs(userName, password, confirmPassword)) {
                    // check if user exists. if not, create an account
                    if (FormJDBC.register(userName, password)) {
                        // dispose this RegisterGUI class
                        RegisterGUI.this.dispose();
                        // launch LogInGUI class
                        LogInGUI logInGUI = new LogInGUI();
                        logInGUI.setVisible(true);
                        // create a message dialog for the outcome
                        JOptionPane.showMessageDialog(logInGUI, "Account Creation Successfully");
                    } else {
                        JOptionPane.showMessageDialog(RegisterGUI.this, "Username already exists");
                    }
                } else {
                    JOptionPane.showMessageDialog(RegisterGUI.this,
                            "- Username must be at least 6 characters, \n " +
                                    "- Passwords must have at least 8 characters, \n " +
                                    "- Passwords must have at least 1 uppercase letter \n" +
                                    "- Passwords must have at least 1 special character ($, &, %, !, @, ?, *) \n" +
                                    "& Password and Confirm Password must be match");
                }
                userNameTextField.setText("");
                passwordTextField.setText("");
                confirmPasswordField.setText("");
            }
        });
        add(signUpButton);

        // have an account label
        JLabel haveAnAccountLabel = new JLabel("Already have an account?");
        haveAnAccountLabel.setFont(new Font("Arial", Font.PLAIN, 13));
        haveAnAccountLabel.setBounds(147, 420, 150, 100);
        add(haveAnAccountLabel);

        // logIn account label
        JLabel logInAccountLabel = new JLabel("Login");
        logInAccountLabel.setFont(new Font("Arial", Font.PLAIN, 13));
        logInAccountLabel.setBounds(205, 450, 150, 100);
        logInAccountLabel.setForeground(new Color(45, 133, 243));
        logInAccountLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // dispose RegisterGUI
                RegisterGUI.this.dispose();

                // launch LogInGUI
                new LogInGUI().setVisible(true);
            }
        });
        add(logInAccountLabel);
    }

    // check if user inputs matches the given conditions
    private boolean userInputs(String userName, String password, String confirmPassword) {
        // username, password and confirm password should not be empty
        if (userName.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) return false;

        //  username must be more than 6 characters length
        if (userName.length() < 6) return false;

        // password must should contain at least 8 characters
        if (password.length() < 8) return false;

        // password must have 1 uppercase letter
        if (!password.matches(".*[A-Z].*")) return false;

        // password must have 1 number
        if (!password.matches(".*[0-9].*")) return false;

        // password must have 1 special characters include $, &, %, !, @, ?
        if (!password.matches(".*[$&%!@?*].*")) return false;

        // password and confirm password must be match
        return password.equals(confirmPassword);
//        return password.equals(confirmPassword);
    }
}
