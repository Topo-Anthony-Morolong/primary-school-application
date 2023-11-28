package com.example.tsenaskolo_application.Controllers.Registrar;

import com.example.tsenaskolo_application.Models.Model;
import com.example.tsenaskolo_application.schoolUtilities.schoolDatabase;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

import static java.lang.System.out;

public class grade1_viewController implements Initializable {
    public ListView<String> class_listView;
    public Button close_button;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        AddListener();
    }

    public void AddListener(){
        populate_Class();
        close_button.setOnAction(event -> onClose());
    }
    public void populate_Class(){
        Connection populateConn = schoolDatabase.getConnection();

        String ListviewItems = "SELECT `First_name`, `Last_name`, `student_Id`, `Age`, `Gender`, `Grade level`, `class`  FROM `students` ;";
        try {
            Statement listViewState = populateConn.createStatement();
            ResultSet viewItem = listViewState.executeQuery(ListviewItems);
            while (viewItem.next()){
                String stud_Name = viewItem.getString("First_name");
                String stud_lName = viewItem.getString("Last_name");
                String stud_id = viewItem.getString("student_Id");
                String age = viewItem.getString("Age");
                String gender = viewItem.getString("Gender");
                String grade = viewItem.getString("Grade level");
                String classId = viewItem.getString("class");

                String student_Details= stud_Name+ " " +stud_lName+ " " +stud_id+ " " +age+ " " +gender+ " " +grade+ "" +classId;

                class_listView.getItems().add(student_Details);
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
    public void onClose(){
        Model.getInstance().getViewFactory().getReviewApplications();
        Stage stage = (Stage) class_listView.getScene().getWindow();
        Model.getInstance().getViewFactory().closeStage(stage);
    }
}
