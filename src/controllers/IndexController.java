package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class IndexController {

    @FXML private Button exitButton;
    @FXML private Button loginButton;


    public void exitButtonAction(ActionEvent event){
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
    }


    public void loginButtonAction(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../resources/login.fxml"));
            Parent loginRoot = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Login");
            stage.setResizable(true);
            stage.setScene(new Scene(loginRoot));
            stage.show();
        }catch (Exception ex){
            ex.printStackTrace();
            ex.getCause();
        }
        Stage stage = (Stage) loginButton.getScene().getWindow();
        stage.close();
    }
}
