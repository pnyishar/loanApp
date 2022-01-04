package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class HomeController {

    @FXML private Button shareButton;
    @FXML private Button exitButton;
    @FXML private AnchorPane anchorPane;
    @FXML private HBox horizontalBox;
    @FXML private MenuBar menuBar;


    public void exitButtonAction(ActionEvent event){
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
    }

    public void shareButtonAction(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../resources/coperativeHome.fxml"));
            Parent shareRoot = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Cooperative Loan Home");
            stage.setResizable(true);
            //horizontalBox.prefWidthProperty().bind(anchorPane.widthProperty());
            //menuBar.prefWidthProperty().bind(horizontalBox.widthProperty());
            //menuBar.prefHeightProperty().bind(horizontalBox.heightProperty());
            stage.setScene(new Scene(shareRoot));
            stage.show();
        }catch (Exception ex){
            ex.printStackTrace();
            ex.getCause();
        }
        Stage stage = (Stage) shareButton.getScene().getWindow();
        stage.close();
    }

    public void dailyButtonAction(ActionEvent event) {
    }
}
