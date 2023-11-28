package com.example.tsenaskolo_application.Controllers.Parent;

//import com.example.tsenaskolo_application.Models.Model;
import com.example.tsenaskolo_application.Views.applicationType;
import com.example.tsenaskolo_application.schoolUtilities.schoolDatabase;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.sql.Connection;
import java.sql.Statement;
import java.util.Date;
import java.util.ResourceBundle;

import static java.lang.System.out;

public class applyViewController implements Initializable {
    public TextField firstname_textField;
    public TextField surname_TextField;
    public TextField Birth_certifNo_textField;
    public TextField age_textField;
    public TextField gender_TextField;
    public ChoiceBox<applicationType> applicationType_choiceBox;
   
    public Button submit_Button;
    public RadioButton readWrite_Excellent;
    public RadioButton readWrite_Average;
    public RadioButton readWrite_Poor;
    public RadioButton communication_Excellent;
    public RadioButton communication_Average;
    public RadioButton communication_Poor;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addListener();

    }
    public void addListener(){
        submit_Button.setOnAction(event -> grade1Apply());
    }


        //add data to newstudentapplication table
        public void grade1Apply(){
            Connection applyConn = schoolDatabase.getConnection();

            //variables to match table fields
        Date today = new Date();
        java.sql.Date creationDate = new java.sql.Date(today.getTime());
        String name = firstname_textField.getText();
        String lastname = surname_TextField.getText();
         String birthCrNum = Birth_certifNo_textField.getText();
        int age = Integer.parseInt(age_textField.getText());
        String gender = gender_TextField.getText();
        String status = "PENDING";

        //Variables for radio buttons and getting text from the radio buttons
            // read write buttons
            ToggleGroup Read_write = new ToggleGroup();
            readWrite_Excellent.setToggleGroup(Read_write);
            readWrite_Average.setToggleGroup(Read_write);
            readWrite_Poor.setToggleGroup(Read_write);
            //getting text from the button
            String readWrite_rButtons = ((RadioButton)Read_write.getSelectedToggle()).getText();

            //Communication button
            ToggleGroup communication = new ToggleGroup();
            communication_Excellent.setToggleGroup(communication);
            communication_Average.setToggleGroup(communication);
            communication_Poor.setToggleGroup(communication);
            //getting text from the button
            String communication_rButtons = ((RadioButton) communication.getSelectedToggle()).getText();



        //variables for sql insert statement
        String InsertFields ="INSERT INTO `newstudentapplication`(`applicant_name`, `applicant_lastname`, `birthCertificate_No`, `Age`," +
                                                                    " `gender`, `dateCreated`, `application_status`, `readWrite`, `communication`)";
        String InsertValues ="VALUES ('"+name+"','"+lastname+"','"+birthCrNum+"','"+age+"'"+
                                    ",'"+gender+"','"+creationDate+"','"+status+"','"+readWrite_rButtons+"','"+communication_rButtons+"')";
        String addApplicant = InsertFields + InsertValues;
        try{
            Statement addToG1 = applyConn.createStatement();
            addToG1.executeUpdate(addApplicant);
            //variable AddToG1 short for add to grade 1 applications table(`newstudentapplication`)
            out.println("Applicant successfully Added..!");
        }
        catch(Exception g1App){
            g1App.printStackTrace();
            g1App.getCause();
            out.println("Applicant addition Failed..!");
        }finally {
            try {
                applyConn.close();
                out.println("Connection Closed..!");
            }catch (Exception applyCloser){
                applyCloser.printStackTrace();
                out.println("Connection closing Failed..!");
            }
        }

    }
    //method to set
    public void setApplication_Type(){
        /*if(applicationType_choiceBox.equals(applicationType.NEWStudent)){
            Model.getInstance().getViewFactory().getClass().getResource()
        }*/
    }


}
