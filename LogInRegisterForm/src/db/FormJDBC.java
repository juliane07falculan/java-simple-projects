package db;

import constants.ConstantComponents;

import java.sql.*;

public class FormJDBC {

    // account registration
    public static boolean register(String userName, String password) {
        try {
            // check if the user exists
            if (!checkUser(userName)) {
                // create a connection to the database
                Connection connection = DriverManager.getConnection(ConstantComponents.DB_URL,
                        ConstantComponents.DB_USERNAME, ConstantComponents.DB_PASSWORD);
                // create a query
                PreparedStatement insertUser = connection.prepareStatement("INSERT INTO " +
                        ConstantComponents.DB_TABLENAME + "(username, password)" + "VALUES(?, ?)");

                // set parameters to value
                insertUser.setString(1, userName);
                insertUser.setString(2, password);

                // update db with new user
                insertUser.executeUpdate();
                System.out.println("User Insert Successfully");
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("User Insert Failed");
        return false;
    }

    // check if user is existing
    public static boolean checkUser(String userName) {
        try {
            // create a connection to mysql
            Connection connection = DriverManager.getConnection(ConstantComponents.DB_URL,
                    ConstantComponents.DB_USERNAME,
                    ConstantComponents.DB_PASSWORD);

            // create a query
            PreparedStatement checkUserExists = connection.prepareStatement("SELECT * FROM "
                    + ConstantComponents.DB_TABLENAME + " WHERE USERNAME = ?");

            // set parameter values for type and position
            // basically, change the "?" to the String username
            checkUserExists.setString(1, userName);

            // get the result of the query and store it to the result set object then execute
            ResultSet resultSet = checkUserExists.executeQuery();

            // check if the result set is empty meaning no rows containing username.
            if (resultSet.isBeforeFirst()) {
                System.out.println("Existing Account");
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Not yet registered");
        return false;
    }

    // username and password validation
    public static boolean accountValidation(String userName, String password) {
        try {
            // connect to the database
            Connection connection = DriverManager.getConnection(ConstantComponents.DB_URL,
                    ConstantComponents.DB_USERNAME,
                    ConstantComponents.DB_PASSWORD);

            // create query
            PreparedStatement accountValidation = connection.prepareStatement("SELECT * FROM "
                    + ConstantComponents.DB_TABLENAME + " WHERE USERNAME = ? AND PASSWORD = ?");

            // set parameters and positions
            accountValidation.setString(1, userName);
            accountValidation.setString(2, password);

            // get the result of the query and store it to Result set object
            ResultSet resultSet = accountValidation.executeQuery();

            // check if the result set is empty meaning no rows containing username.
            // false meaning, no rows
            if (!resultSet.isBeforeFirst()) {
                return false;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }
}



