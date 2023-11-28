package com.example.tsenaskolo_application.Controllers.Registrar;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class enrolStudentController implements Initializable {
    public TextField student_NameTextField;
    public TextField student_last_name;
    public TextField Birth_certificateNo_TextF;
    public TextField Student_AgeTextField;
    public TextField student_GenderTextField;
    public TextField gradeLevel_TextField;
    public TextField class_textField;
    public Button enrol_Button;
    public Button cancel_Button;
    public Button close_Button;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    public void setStudent(String name,String last_name,String birthCertificate_No,String Age,String Gender){
        student_NameTextField.setText(name);
        student_last_name.setText(last_name);
        Birth_certificateNo_TextF.setText(birthCertificate_No);
        Student_AgeTextField.setText(Age);
        student_GenderTextField.setText(Gender);


    }
}
