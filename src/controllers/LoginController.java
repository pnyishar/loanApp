package controllers;

import helpers.DatabaseConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    @FXML private Button cancelButton;
    @FXML private Button loginButton;
    @FXML private Label loginMessageLabel;
    @FXML private TextField userNameTextField;
    @FXML private PasswordField passwordLoginField;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){

    }

    public void loginButtonAction(ActionEvent event){
        if(!userNameTextField.getText().isBlank() && !passwordLoginField.getText().isBlank()){
            validateLogin();
        }
        else {
            loginMessageLabel.setText("Please enter username and password");
        }
        Stage stage = (Stage) loginButton.getScene().getWindow();
        stage.close();
    }

    public void cancelButtonAction(ActionEvent event){
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    public void validateLogin(){
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connection = connectNow.getConnection();
        String sql = "SELECT * FROM users WHERE username=? AND password =?";

        String username = userNameTextField.getText();
        String password = passwordLoginField.getText();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet rs = preparedStatement.executeQuery();
            if(rs.next()){
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../resources/home.fxml"));
                Parent homeRoot = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.setTitle("Home Select");
                stage.setResizable(true);
                stage.setScene(new Scene(homeRoot));
                stage.show();
            }
            else {
                errorInfoBox("Enter Correct Username and Password", "Failed", null);
            }

        }catch (Exception ex){
            ex.printStackTrace();
            ex.getCause();
        }
        
    }

    public static void errorInfoBox(String infoMessage, String titleBar, String headerMessage)
    {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(titleBar);
        alert.setHeaderText(headerMessage);
        alert.setContentText(infoMessage);
        alert.showAndWait();
    }
}
