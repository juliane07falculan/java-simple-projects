import constants.ConstantComponents;
import db.FormJDBC;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LogInGUI extends Form {

    LogInGUI() {
        // set the title
        super("Login");
        // add LogIn components
        addLogInComponents();
    }

    public void addLogInComponents() {
        // logIn label
        JLabel logInLabel = new JLabel("Log In");
        logInLabel.setFont(new Font("Arial", Font.BOLD, 35));
        logInLabel.setBounds(158, 20, 120, 100);
        logInLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(logInLabel);

       // logIn panel
        JPanel logInPanel = new JPanel();
        logInPanel.setBounds(30, 110, 375, 100);
        logInPanel.setBackground(new Color(0xe5e7eb));
        logInPanel.setLayout(null);
        add(logInPanel);

        // username label
        JLabel userNameLabel = new JLabel("Username:");
        userNameLabel.setFont(new Font("Arial", Font.PLAIN, 13));
        userNameLabel.setBounds(35, 5, 100, 50);
        logInPanel.add(userNameLabel);

        // username textfield
        JTextField userNameTextField = new JTextField();
        userNameTextField.setFont(new Font("Arial", Font.PLAIN, 15));
        userNameTextField.setBounds(35, 45, 300, 40);
        logInPanel.add(userNameTextField);

        // password panel
        JPanel passwordPanel = new JPanel();
        passwordPanel.setBounds(30, 210, 375, 100);
        passwordPanel.setBackground(new Color(0xe5e7eb));
        passwordPanel.setLayout(null);
        add(passwordPanel);

        // password label
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setFont(new Font("Arial", Font.PLAIN, 13));
        passwordLabel.setBounds(35, 5, 100, 50);
        passwordPanel.add(passwordLabel);

        // password textfield
        JPasswordField passwordTextField = new JPasswordField();
        passwordTextField.setFont(new Font("Arial", Font.PLAIN, 15));
        passwordTextField.setBounds(35, 45, 300, 40);
        passwordPanel.add(passwordTextField);

        // logIn button
        JButton logInButton = new JButton("Log In");
        logInButton.setFont(new Font("Arial", Font.BOLD, 15));
        logInButton.setForeground(Color.white);
        logInButton.setBounds(145, 340, 150, 50);
        logInButton.setBackground(new Color(59, 130, 246));
        logInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // get the username
                String userName = userNameTextField.getText();

                // get the password
                String password = new String(passwordTextField.getPassword());

                // validate Account
                if (FormJDBC.accountValidation(userName, password)) {
                    JOptionPane.showMessageDialog(LogInGUI.this, "LogIn Successful!\n Welcome, " + userName);
                } else {
                    JOptionPane.showMessageDialog(LogInGUI.this, "Incorrect username or password");
                }

                // clear text
                userNameTextField.setText("");
                passwordTextField.setText("");
            }
        });
        add(logInButton);

        // dont have account label
        JLabel dontHaveAccountLabel = new JLabel("Don't have an account?");
        dontHaveAccountLabel.setFont(new Font("Arial", Font.PLAIN, 13));
        dontHaveAccountLabel.setBounds(157, 390, 150, 100);
        add(dontHaveAccountLabel);

        // sign up label
        JLabel signUpLabel = new JLabel("Sign Up");
        signUpLabel.setFont(new Font("Arial", Font.PLAIN, 13));
        signUpLabel.setBounds(197, 410, 150, 100);
        signUpLabel.setForeground(new Color(45, 133, 243));
        signUpLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // dispose LogInGUI
                LogInGUI.this.dispose();

                // launch RegisterGUI
                new RegisterGUI().setVisible(true);
            }
        });
        add(signUpLabel);
    }
}
