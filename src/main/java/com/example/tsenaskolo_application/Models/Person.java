package com.example.tsenaskolo_application.Models;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public abstract class Person {
    private final StringProperty first_name;
    private final StringProperty last_name;
    private final IntegerProperty age;
    private final StringProperty gender;
    private final StringProperty Id_number;
    private final StringProperty email_Address;
    private final StringProperty postal_Address;
    private final StringProperty physical_Address;
    private final StringProperty phone_number;

    public Person(String first_name,String last_name,int age,
                  String gender, String Id_number,String email_Address,
                  String postal_Address,String physical_Address,String phone_number){

        this.first_name = new SimpleStringProperty(this,"First name",first_name);
        this.last_name = new SimpleStringProperty(this,"First name",last_name);
        this.age = new SimpleIntegerProperty(this,"First name",age);
        this.gender = new SimpleStringProperty(this,"First name",gender);
        this.Id_number = new SimpleStringProperty(this,"First name",Id_number);
        this.email_Address = new SimpleStringProperty(this,"First name",email_Address);
        this.postal_Address= new SimpleStringProperty(this,"First name",postal_Address);
        this.physical_Address = new SimpleStringProperty(this,"First name",physical_Address);
        this.phone_number= new SimpleStringProperty(this,"First name",phone_number);

    }
   /**public Person(String first_name, String last_name, int age,
                  String gender, String email_Address, String postal_Address,
                  String physical_Address, String phone_number, StringProperty last_name1){
        this.last_name = last_name1;
    }
    */

    public StringProperty first_nameProperty() {
        return first_name;
    }

    public StringProperty last_nameProperty() {
        return last_name;
    }

    public IntegerProperty ageProperty() {
        return age;
    }

    public StringProperty genderProperty() {
        return gender;
    }

    public StringProperty id_numberProperty() {
        return Id_number;
    }
    public StringProperty email_AddressProperty(){
        return email_Address;
    }

    public StringProperty postal_AddressProperty() {
        return postal_Address;
    }

    public StringProperty physical_AddressProperty() {
        return physical_Address;
    }

    public StringProperty phone_numberProperty() {
        return phone_number;
    }
}
