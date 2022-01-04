package controllers;

import helpers.DatabaseConnection;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.Statement;

public class NewAccountController {

    @FXML private TextField accountNumberField;
    @FXML private TextField firstnameField;
    @FXML private TextField lastnameField;
    @FXML private TextArea addressTextArea;
    @FXML private TextField phoneNumberField;
    @FXML private DatePicker datePickerField;
    @FXML private ImageView imageView;
    @FXML private Button browseImageButton, closeButton;
    @FXML private Label messageLabel;


    public void browseImageAction(ActionEvent event){
        openImage();
    }

    public void openImage(){
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter ext1 = new FileChooser.ExtensionFilter("JPG files(*.jpg)","*.JPG");
        FileChooser.ExtensionFilter ext2 = new FileChooser.ExtensionFilter("PNG files(*.png)","*.PNG");
        fileChooser.getExtensionFilters().addAll(ext1,ext2);
        File file = fileChooser.showOpenDialog(browseImageButton.getScene().getWindow());
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            Image image = new Image(fileInputStream);
            imageView.setImage(image);
        } catch (IOException ex) {
            ex.printStackTrace();
            ex.getCause();
        }
    }

    public void regSubmitButtonAction(ActionEvent event){
        if (accountNumberField.getText().isBlank() || firstnameField.getText().isBlank() || lastnameField.getText().isBlank()
                || addressTextArea.getText().isBlank() || phoneNumberField.getText().isBlank() || datePickerField.getValue().equals(null)
                || imageView.getImage().equals(null)){
            messageLabel.setText("Please Fill all the Fields!");
        }
        createAccount();
    }

    public void createAccount(){
        DatabaseConnection dbConnect = new DatabaseConnection();
        Connection connect = dbConnect.getConnection();

        String accountNumber = accountNumberField.getText();
        String firstname = firstnameField.getText();
        String lastname = lastnameField.getText();
        String address = addressTextArea.getText();
        String phone = phoneNumberField.getText();
        Date date = Date.valueOf(datePickerField.getValue());
        Image passport = imageView.getImage();

        String insertFields = "INSERT INTO loan_account(acc_no,firstname,lastname,address,phone_no,registered_date,passport) VALUES ('";
        String insertValues = accountNumber + "','" + firstname + "','" + lastname + "','" + address + "','" + phone + "','" + date + "','" + passport + "')";
        String insertToAccount = insertFields + insertValues;
        try{
            Statement statement = connect.createStatement();
            statement.executeUpdate(insertToAccount);
            messageLabel.setText("Account Created Successfully!");
        }catch (Exception ex){
            ex.printStackTrace();
            ex.getCause();
        }
    }

    public void closeButtonAction(ActionEvent event){
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
        Platform.exit();
    }
}
