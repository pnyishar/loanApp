package controllers;

import helpers.DatabaseConnection;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ResourceBundle;

public class RegisterUserController implements Initializable {

    @FXML private Label regMessageLabel;
    @FXML private Label confirmPasswordLabel;
    @FXML private TextField firstnameField;
    @FXML private TextField lastnameField;
    @FXML private TextField emailField;
    @FXML private TextField usernameField;
    @FXML private ChoiceBox<String> choseUserType;
    @FXML private Button closeButton;
    @FXML private Button regSubmitButton;
    @FXML private PasswordField setPasswordField;
    @FXML private PasswordField confirmPasswordField;


    @Override
    public void initialize(URL url, ResourceBundle rb){
        choseUserType.getItems().addAll("Admin", "User");
        choseUserType.setValue("Admin");
    }
    public void closeButtonAction(ActionEvent event){
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
        Platform.exit();
    }

    public void regSubmitButtonAction(ActionEvent event){
        if(setPasswordField.getText().equals(confirmPasswordField.getText())){
            registerUser();
            confirmPasswordLabel.setText("");
        }
        else {
            confirmPasswordLabel.setText("Password does not match");
        }
    }

    public void registerUser(){
        DatabaseConnection dbConnect = new DatabaseConnection();
        Connection connect = dbConnect.getConnection();

        String firstname = firstnameField.getText();
        String lastname = lastnameField.getText();
        String email = emailField.getText();
        String username = usernameField.getText();
        String password = setPasswordField.getText();
        String usertype = choseUserType.getValue();

        String insertFields = "INSERT INTO users(first_name,last_name,email,username,password,user_type) VALUES ('";
        String insertValues = firstname + "','" + lastname + "','" + email + "','" + username + "','" + password + "','" + usertype + "')";
        String insertToRegister = insertFields + insertValues;

        try{
            Statement statement = connect.createStatement();
            statement.executeUpdate(insertToRegister);
            regMessageLabel.setText("User has been registered successfully");
        }catch (Exception ex){
            ex.printStackTrace();
            ex.getCause();
        }

    }
}
