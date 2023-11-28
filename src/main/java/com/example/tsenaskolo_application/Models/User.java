package com.example.tsenaskolo_application.Models;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class User extends Person{

    private final StringProperty typeOf_User;
    private final StringProperty user_name;
    private final StringProperty password;
    public User(String first_name, String last_name, int age,
                String gender, String Id_number, String email_Address,
                String postal_Address, String physical_Address, String phone_number,
                String typeOf_User, String user_name, String password) {
        super(first_name, last_name, age, gender, Id_number, email_Address, postal_Address, physical_Address, phone_number);
        this.typeOf_User = new SimpleStringProperty(this,"Type Of User",typeOf_User);
        this.user_name = new SimpleStringProperty(this,"User Name",user_name);
        this.password = new SimpleStringProperty(this,"Password",password);

    }
    public StringProperty typeOf_UserProperty() {
        return typeOf_User;
    }

    public StringProperty user_nameProperty() {
        return user_name;
    }

    public StringProperty passwordProperty() {
        return password;
    }
}
