package com.example.tsenaskolo_application.Controllers.Registrar;

import com.example.tsenaskolo_application.Models.Model;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class viewClassesController implements Initializable {
    public Button grade1_class_A;
    public Button grade1_class_B;
    public Button grade3_class_A;
    public Button grade3_class_B;
    public Button grade4_class_A;
    public Button grade4_class_B;
    public Button grade5_class_A;
    public Button grade5_class_B;
    public Button grade2_class_A;
    public Button grade2_class_B;
    public Button grade6_class_A;
    public Button grade6_class_B;
    public Button grade7_class_A;
    public Button grade7_class_B;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    AddListener();
    }
    public void AddListener(){
        grade1_class_A.setOnAction(event -> viewClassList());
    }
    public void viewClassList(){
        /*Stage stage = (Stage) grade1_class_A.getScene().getWindow();
        Model.getInstance().getViewFactory().closeStage(stage);*/
        Model.getInstance().getViewFactory().getViewGrade1();

    }
}
