package com.example.tsenaskolo_application.Models;

import javafx.beans.property.StringProperty;

public class Child extends Person{
       public final StringProperty BirthCertificateNO;
    public Child(String first_name, String last_name, String BirthCertificateNO, int age, String gender, String email_Address, String postal_Address, String physical_Address, String phone_number, StringProperty birthCertificateNO) {
        super(first_name, last_name, age, gender, email_Address, postal_Address, physical_Address, phone_number, last_name);

        this.BirthCertificateNO = birthCertificateNO;
    }
}
