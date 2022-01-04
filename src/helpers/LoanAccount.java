package helpers;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

public class LoanAccount {
    public SimpleStringProperty accountNumber = new SimpleStringProperty();
    public SimpleStringProperty firstname = new SimpleStringProperty();
    public SimpleStringProperty lastname = new SimpleStringProperty();
    public SimpleStringProperty address = new SimpleStringProperty();
    public SimpleStringProperty phone = new SimpleStringProperty();
    public ObjectProperty regDate = new SimpleObjectProperty();
    //public ObjectProperty photo = new SimpleObjectProperty();

    public String getAccountNumber() {
        return accountNumber.get();
    }

    public SimpleStringProperty accountNumberProperty() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber.set(accountNumber);
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

    public String getAddress() {
        return address.get();
    }

    public SimpleStringProperty addressProperty() {
        return address;
    }

    public void setAddress(String address) {
        this.address.set(address);
    }

    public String getPhone() {
        return phone.get();
    }

    public SimpleStringProperty phoneProperty() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone.set(phone);
    }

    public Object getRegDate() {
        return regDate.get();
    }

    public ObjectProperty regDateProperty() {
        return regDate;
    }

    public void setRegDate(Object regDate) {
        this.regDate.set(regDate);
    }

}
