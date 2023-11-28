package com.example.tsenaskolo_application.Controllers.Parent;

import com.example.tsenaskolo_application.Models.Model;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;

import java.net.URL;
import java.util.ResourceBundle;

public class parentController implements Initializable {

    public BorderPane Parent_background;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        Model.getInstance().getViewFactory().getParentSelectedMenuItem().addListener((observableValue, oldVal, newVal) ->{
            switch (newVal){
                case APPLY-> Parent_background.setCenter(Model.getInstance().getViewFactory().getApply_View());
                case APPLICATIONS -> Parent_background.setCenter(Model.getInstance().getViewFactory().getApplications_View());
                case STUDENTS -> Parent_background.setCenter(Model.getInstance().getViewFactory().getStudents_View());
                case TRANSFER -> Parent_background.setCenter(Model.getInstance().getViewFactory().getRequestTransfer_View());
                    default -> Parent_background.setCenter(Model.getInstance().getViewFactory().getDashboard());

            }
        } );
    }
}
