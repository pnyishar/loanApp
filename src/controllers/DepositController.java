package controllers;

import helpers.DatabaseConnection;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;

public class DepositController {
    @FXML
    private TextField accNumberField;

    @FXML
    private TextField firstNameField;

    @FXML
    private TextField lastnameField;

    @FXML
    private TextField depositField;

    @FXML
    private Button depositSubmitButton;

    @FXML
    private Button depositCloseButton;

    @FXML
    private Label depositMessageLabel;

    @FXML
    private DatePicker dateField;

    private DatabaseConnection dbconnect = new DatabaseConnection();;
    private Connection connect = dbconnect.getConnection();;


    @FXML
    public void accNumberFieldAction(ActionEvent event) {
        if(!accNumberField.getText().isBlank()){
            populateUser();
        }
        else {
            errorInfoBox("Enter Account Number!", "Failed", null);
        }
    }

    @FXML
    public void depositCloseButtonAction(ActionEvent event) {
        Stage stage = (Stage) depositCloseButton.getScene().getWindow();
        stage.close();
        Platform.exit();
    }

    @FXML
    public void depositSubmitButtonAction(ActionEvent event) {
        String firstname = firstNameField.getText();
        String lastname = lastnameField.getText();
        if(!accNumberField.getText().isBlank() && !firstname.isBlank() && !lastname.isBlank() &&
            !depositField.getText().isBlank() && !dateField.getValue().equals(null)
        ){
            insertTransaction();

        }
        else {
            errorInfoBox("Ensure all fields are appropriately filled!", "Failed", null);
        }

    }

    public void insertTransaction(){

        String accno = accNumberField.getText();
        int deposit = Integer.parseInt(depositField.getText());
        Date transDate = Date.valueOf(dateField.getValue());

        int interest = (int) (0.02*deposit);

        String insertFields = "INSERT INTO transaction (tran_date,deposit,interest,acc_no) VALUES ('";
        String insertValues = transDate + "','" + deposit + "','" + interest + "','" + accno + "')";
        String insertToAccount = insertFields + insertValues;
        try{
            Statement statement = connect.createStatement();
            statement.executeUpdate(insertToAccount);
            depositMessageLabel.setText("Amount Deposited Successfully!");
        }catch (Exception ex){
            ex.printStackTrace();
            ex.getCause();
        }

    }


    public void populateUser(){
        String sql = "SELECT firstname, lastname FROM loan_account WHERE acc_no ="+ accNumberField.getText();
        try{
            ResultSet rs = connect.createStatement().executeQuery(sql);
            if (rs.next()){
                firstNameField.setText(rs.getString("firstname"));
                lastnameField.setText(rs.getString("lastname"));
            }
            else {
                errorInfoBox("Account Number not found!", "Failed", null);
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
