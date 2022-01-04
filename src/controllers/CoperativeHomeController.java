package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class CoperativeHomeController {

    @FXML
    AnchorPane coperativeAnchorPane;

    public void addUser(){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../resources/register_user.fxml"));
            Parent newUser = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("New User");
            stage.setResizable(true);
            stage.setScene(new Scene(newUser));
            stage.show();
        }catch (Exception ex){
            ex.printStackTrace();
            ex.getCause();
        }
    }

    public void addAccount(){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../resources/new_account.fxml"));
            Parent newAccount = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("New Account");
            stage.setResizable(true);
            stage.setScene(new Scene(newAccount));
            stage.show();
        }catch (Exception ex){
            ex.printStackTrace();
            ex.getCause();
        }
    }

    public void allAccountsAction(){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../resources/view_accounts.fxml"));
            Parent viewAllAcc = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("All Account");
            stage.setResizable(true);
            stage.setScene(new Scene(viewAllAcc));
            stage.show();
        }catch (Exception ex){
            ex.printStackTrace();
            ex.getCause();
        }
    }

    public void allUsersAction(){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../resources/view_users.fxml"));
            Parent viewAllUsers = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("All Users");
            stage.setResizable(true);
            stage.setScene(new Scene(viewAllUsers));
            stage.show();
        }catch (Exception ex){
            ex.printStackTrace();
            ex.getCause();
        }

    }

    public void depositMenuAction(){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../resources/deposit.fxml"));
            Parent deposit = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Deposit Money");
            stage.setResizable(true);
            stage.setScene(new Scene(deposit));
            stage.show();
        }catch (Exception ex){
            ex.printStackTrace();
            ex.getCause();
        }
    }

}
