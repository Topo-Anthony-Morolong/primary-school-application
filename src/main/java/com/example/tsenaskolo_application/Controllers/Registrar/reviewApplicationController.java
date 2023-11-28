package com.example.tsenaskolo_application.Controllers.Registrar;
/*
* Author @Topo Anthony Morolong
* the class attempts to give the registrar control to manipulate content on the graphical  User Interface
*
* */

import com.example.tsenaskolo_application.Models.Model;
import com.example.tsenaskolo_application.schoolUtilities.schoolDatabase;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import static java.lang.System.out;

public class reviewApplicationController implements Initializable {
    public ListView<String> reviewApplications_Listview;
    public TextField nameText_Field;
    public TextField surname_TextF;
    public TextField birth_cert_NumberTextF;
    public TextField Age_TextField;
    public TextField Gender_TextField;
    public TextField readWriting_TextField;
    public TextField communication_TextField;

    public Button accept_button;
    public Button reject_Button;
    public TextField student_name_TextField;
    public TextField Student_Last_name_TextField;
    public TextField BirthCertificate_TextField;
    public TextField Student_Age_TextField;
    public TextField gender_TextField;
    public TextField grade_level_TextField;
    public TextField Class_TextField;
    public Button enrol_Button;
    public Button Drop_Button;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    addListener();
    }
    public void addListener(){
        selectedApplicant();
        populateListView();
        accept_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                onAccept(event);
            }
        });
        enrol_Button.setOnAction(event -> onEnrol());
        reject_Button.setOnAction(event -> onReject());
    }

    //accepting the application
    public void onAccept(ActionEvent event){
        /*
        *
        * Stage stage ;
        Scene scene;
        Parent root;*/
        String name = nameText_Field.getText();
        String last_name=surname_TextF.getText() ;
        String birth_CertificateNumber = birth_cert_NumberTextF.getText();
        String Age = Age_TextField.getText();
        String Gender = Gender_TextField.getText();
      /*  try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Registrar/enrolStudent.fxml"));
            root = loader.load();
            enrolStudentController enrolStudent = new enrolStudentController();
            enrolStudent.setStudent(name,last_name,birth_CertificateNumber,Age,Gender);

                stage =(Stage) ((Node)event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();

    out.println("Parsing student to Enrol form successful..!");
        }catch (IOException a){
            a.printStackTrace();
            a.getCause();
            out.println("Failed to parse Student to the next scene");
        }*/
        //working on the enrol section
        student_name_TextField.setText(name);
        Student_Last_name_TextField.setText(last_name);
        BirthCertificate_TextField.setText(birth_CertificateNumber);
        Student_Age_TextField.setText(Age);
        gender_TextField.setText(Gender);
        String applicationStatus = "ACCEPTED";
        String birthDocument =BirthCertificate_TextField.getText();

        //Updating the application Status
        String status = "UPDATE `newstudentapplication` SET `application_status`='"+applicationStatus+"' WHERE `birthCertificate_No`='"+birthDocument+"';";
        Connection statusUpdate = schoolDatabase.getConnection();
        try{
            Statement renewStatus = statusUpdate.createStatement();
            renewStatus.executeUpdate(status);
            out.println("Application Status updated..!");
        }catch (SQLException update){
            update.printStackTrace();
            update.getCause();
            out.println("Application Status update failed..!");
        }finally {
            try {
                statusUpdate.close();
                out.println("Connection Closed..!");
            }catch (SQLException stUpdate){
                stUpdate.printStackTrace();
                stUpdate.getCause();
                out.println("failed to close connection..!");
            }
        }
        clearReviewedField();


    }
    public void onReject(){
        //Updating the application Status
        String birthDocument =BirthCertificate_TextField.getText();
        String applicationStatus = "REJECTED";
        String status = "UPDATE `newstudentapplication` SET `application_status`='"+applicationStatus+"' WHERE `birthCertificate_No`='"+birthDocument+"';";
        Connection statusUpdate = schoolDatabase.getConnection();
        try{
            Statement renewStatus = statusUpdate.createStatement();
            renewStatus.executeUpdate(status);
            out.println("Application Status updated..!");
        }catch (SQLException update){
            update.printStackTrace();
            update.getCause();
            out.println("Application Status update failed..!");
        }finally {
            try {
                statusUpdate.close();
                out.println("Connection Closed..!");
            }catch (SQLException stUpdate){
                stUpdate.printStackTrace();
                stUpdate.getCause();
                out.println("failed to close connection..!");
            }
        }
    }
    //Student into the database;
    public void onEnrol(){
      String studName =  student_name_TextField.getText();
       String StudLast = Student_Last_name_TextField.getText();
       String certificate_No = BirthCertificate_TextField.getText();
       String studAge = Student_Age_TextField.getText();
        String gender = gender_TextField.getText();
        String gradeLevel = grade_level_TextField.getText();
        String classLetter = Class_TextField.getText();

        String InsertFields="INSERT INTO `students`(`First_name`, `Last_name`, `student_Id`, `Age`, `Gender`, `Grade level`, `class`) ";
        String InertValues ="VALUES ('"+studName+"','"+StudLast+"','"+certificate_No+"','"+studAge+"','"+gender+"','"+gradeLevel+"','"+classLetter+"')";
        String enrolStudent = InsertFields +InertValues;
        Connection enterStud = schoolDatabase.getConnection();
        try {
            Statement newStud = enterStud.createStatement();
            newStud.executeUpdate(enrolStudent);
            out.println("Successful enrolment..!");

        }catch (SQLException stud){
            stud.printStackTrace();
            stud.getCause();
            out.println("enrolment failed..!");
        }finally {
            try {
                enterStud.close();
                out.println("Connection closed..!");
            }catch (SQLException close){
                close.printStackTrace();
                close.getCause();
                out.print("Failed to close connection..!");
            }
            clearStudFields();

        }
    }

    //selecting an item from the listView
    public void selectedApplicant(){
        //get selected menu item
         reviewApplications_Listview.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
             @Override
             public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {

                 //get selected menu item
                 String applicant = reviewApplications_Listview.getSelectionModel().getSelectedItem();
                 out.println(applicant);

                 //store in an array
                  String[] potentialStudent = applicant.split(" ");

                 //store in an array
                 for(int pStud = 0 ; pStud < potentialStudent.length; pStud++ )out.println(potentialStudent[pStud]);//pStud is short for potential Student

                 //retrieve from an array
                 nameText_Field.setText(potentialStudent[0]);
                 surname_TextF.setText(potentialStudent[1]);
                 birth_cert_NumberTextF.setText(potentialStudent[2]);
                 Age_TextField.setText(potentialStudent[3]);
                 Gender_TextField.setText(potentialStudent[4]);
                 readWriting_TextField.setText(potentialStudent[5]);
                 communication_TextField.setText(potentialStudent[6]);


             }
         });

    }


    //this method populates the list view... for applications
    public void populateListView(){
        Connection populateConn = schoolDatabase.getConnection();

        String ListviewItems = "SELECT `applicant_name`, `applicant_lastname`, `birthCertificate_No`, `Age`, " +
                                "`gender`, `readWrite`, `communication` FROM newstudentapplication";
        try {
            Statement listViewState = populateConn.createStatement();
            ResultSet viewItem = listViewState.executeQuery(ListviewItems);
            while (viewItem.next()){
                String fName = viewItem.getString("applicant_name");
                String lName = viewItem.getString("applicant_lastname");
                String birthCertificate = viewItem.getString("birthCertificate_No");
                String age = viewItem.getString("Age");
                String gender = viewItem.getString("gender");
                String readWrite = viewItem.getString("readWrite");
                String communication = viewItem.getString("communication");

                String Applicant_Details= fName+ " " +lName+ " " +birthCertificate+ " " +age+ " " +gender+ " " +readWrite+ "" +communication;

                reviewApplications_Listview.getItems().add(Applicant_Details);
            }
        }catch(Exception listItem){
            listItem.printStackTrace();
            listItem.getCause();
            out.println("Failed to populate application review list view..!");
        }finally {
            try {
                populateConn.close();
                out.println("populating applications list view successful..!");
            }catch (Exception connectionCloser){
                connectionCloser.printStackTrace();
                connectionCloser.getCause();
                out.println("Failed to close Connection..!");
            }
        }
    }

    public void clearStudFields(){
        student_name_TextField.setText(null);
        Student_Last_name_TextField.setText(null);
        BirthCertificate_TextField.setText(null);
          Student_Age_TextField.setText(null);
          gender_TextField.setText(null);
          grade_level_TextField.setText(null);
          Class_TextField.setText(null);

    }
    public void clearReviewedField(){
        nameText_Field.setText(null);
         surname_TextF.setText(null);
         birth_cert_NumberTextF.setText(null);
         Age_TextField.setText(null);
         Gender_TextField.setText(null);
        readWriting_TextField.setText(null);
        communication_TextField.setText(null);

    }


}
