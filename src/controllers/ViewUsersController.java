package controllers;

import helpers.DatabaseConnection;
import helpers.Users;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.ResultSet;

public class ViewUsersController {
    @FXML
    private TableView tableView;

    @FXML
    private TableColumn<Users, String> firstnameColumn;

    @FXML
    private TableColumn<Users, String> lastnameColumn;

    @FXML
    private TableColumn<Users, String> emailColumn;

    @FXML
    private TableColumn<Users, String> usernameColumn;

    @FXML
    private TableColumn<Users, String> passwordColumn;

    @FXML
    private TableColumn<Users, String> usertypeColumn;

    @FXML
    private TableColumn<Users, String> actionColumn;

    @FXML
    private Button exitButton;

    private DatabaseConnection dbconnect;
    private Connection conn;


    @FXML
    public void initialize(){
        assert tableView != null : "fx:id=\"tableView\" was not injected: check your FXML file 'view_users.fxml'.";
        firstnameColumn.setCellValueFactory(new PropertyValueFactory<Users,String>("firstname"));
        lastnameColumn.setCellValueFactory(new PropertyValueFactory<Users,String>("lastname"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<Users,String>("email"));
        usernameColumn.setCellValueFactory(new PropertyValueFactory<Users,String>("username"));
        passwordColumn.setCellValueFactory(new PropertyValueFactory<Users,String>("password"));
        usertypeColumn.setCellValueFactory(new PropertyValueFactory<Users,String>("usertype"));
        actionColumn.setCellValueFactory(new PropertyValueFactory<>("update"));
        actionColumn.setCellValueFactory(new PropertyValueFactory<>("delete"));

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

    private ObservableList<Users> userdata;

    public void buildData(){
        userdata = FXCollections.observableArrayList();
        try{
            String sql = "Select * from users Order By username";
            ResultSet rs = conn.createStatement().executeQuery(sql);
            while(rs.next()){
                Users users = new Users();
                users.firstname.set(rs.getString("first_name"));
                users.lastname.set(rs.getString("last_name"));
                users.email.set(rs.getString("email"));
                users.username.set(rs.getString("username"));
                users.password.set(rs.getString("password"));
                users.usertype.set(rs.getString("user_type"));

                userdata.add(users);
            }
            tableView.setItems(userdata);
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
