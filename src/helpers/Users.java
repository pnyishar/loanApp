package helpers;

import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.Button;

public class Users {
    public SimpleStringProperty firstname = new SimpleStringProperty();
    public SimpleStringProperty lastname = new SimpleStringProperty();
    public SimpleStringProperty email = new SimpleStringProperty();
    public SimpleStringProperty username = new SimpleStringProperty();
    public SimpleStringProperty password = new SimpleStringProperty();
    public SimpleStringProperty usertype = new SimpleStringProperty();

    public Button update, delete;

    public Button getUpdate() {
        return update;
    }

    public void setUpdate(Button update) {
        this.update = update;
    }

    public Button getDelete() {
        return delete;
    }

    public void setDelete(Button delete) {
        this.delete = delete;
    }

    public String getFirstname() {
        return firstname.get();
    }

    public SimpleStringProperty firstnameProperty() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname.set(firstname);
    }

    public String getLastname() {
        return lastname.get();
    }

    public SimpleStringProperty lastnameProperty() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname.set(lastname);
    }

    public String getEmail() {
        return email.get();
    }

    public SimpleStringProperty emailProperty() {
        return email;
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

    public String getUsername() {
        return username.get();
    }

    public SimpleStringProperty usernameProperty() {
        return username;
    }

    public void setUsername(String username) {
        this.username.set(username);
    }

    public String getPassword() {
        return password.get();
    }

    public SimpleStringProperty passwordProperty() {
        return password;
    }

    public void setPassword(String password) {
        this.password.set(password);
    }

    public String getUsertype() {
        return usertype.get();
    }

    public SimpleStringProperty usertypeProperty() {
        return usertype;
    }

    public void setUsertype(String usertype) {
        this.usertype.set(usertype);
    }
}
