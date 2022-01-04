package controllers;

import helpers.DatabaseConnection;
import helpers.LoanAccount;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;

public class ViewAccountsController {

    @FXML private TableView tableView;
    @FXML private TableColumn accNoColumn;
    @FXML private TableColumn firstNameColumn;
    @FXML private TableColumn lastnameColumn;
    @FXML private TableColumn addressColumn;
    @FXML private TableColumn phonenumberColumn;
    @FXML private TableColumn dateColumn;
    @FXML private TableColumn passportColumn;
    @FXML private TableColumn actionColumn;
    @FXML private Button exitButton;

    private DatabaseConnection dbconnect;
    private Connection conn;


    @FXML
    void initialize(){
        assert tableView != null : "fx:id=\"tableView\" was not injected: check your FXML file 'view_accounts.fxml'.";
        accNoColumn.setCellValueFactory(new PropertyValueFactory<LoanAccount,String>("accountNumber"));
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<LoanAccount,String>("firstname"));
        lastnameColumn.setCellValueFactory(new PropertyValueFactory<LoanAccount,String>("lastname"));
        addressColumn.setCellValueFactory(new PropertyValueFactory<LoanAccount,String>("address"));
        phonenumberColumn.setCellValueFactory(new PropertyValueFactory<LoanAccount,String>("phone"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<Object, Date>("regDate"));
        //passportColumn.setCellValueFactory(new PropertyValueFactory<Object, ImageView>("photo"));

        dbconnect = new DatabaseConnection();
        try{
            conn = dbconnect.getConnection();
            buildData();
        }
        catch(Exception ce){
            ce.printStackTrace();
            ce.getCause();
        }
    }

    private ObservableList<LoanAccount> data;

    public void buildData(){
        data = FXCollections.observableArrayList();
        try{
            String sql = "Select * from loan_account Order By acc_no";
            ResultSet rs = conn.createStatement().executeQuery(sql);
            while(rs.next()){
                LoanAccount la = new LoanAccount();
                la.accountNumber.set(rs.getString("acc_no"));
                la.firstname.set(rs.getString("firstname"));
                la.lastname.set(rs.getString("lastname"));
                la.address.set(rs.getString("address"));
                la.phone.set(rs.getString("phone_no"));
                la.regDate.set(rs.getDate("registered_date"));

                /*InputStream in = rs.getBinaryStream("passport");
                Image image = new Image(in);
                ImageView mv = new ImageView();
                mv.setImage(image);
                mv.setFitWidth(70);
                mv.setFitHeight(80);
                la.photo.set(mv);*/
                data.add(la);
            }
            tableView.setItems(data);
        }
        catch(Exception e){
            e.printStackTrace();
            System.out.println("Error on Building Data");
        }
    }

    public void exitButtonAction(ActionEvent event){
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
        Platform.exit();
    }
}
