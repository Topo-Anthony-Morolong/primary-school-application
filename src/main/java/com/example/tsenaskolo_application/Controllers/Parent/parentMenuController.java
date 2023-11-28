package com.example.tsenaskolo_application.Controllers.Parent;

import com.example.tsenaskolo_application.Models.Model;
import com.example.tsenaskolo_application.Views.parentMenu_Options;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class parentMenuController implements Initializable {

    public Button dashboard_Button;
    public Button apply_Button;
    public Button applications_Button;
    public Button Students_Button;
    public Button reqTransfer_Button;

    public Button logout_Button;
    public Label name_Label;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addListeners();
    }

    //method adds event listeners to th buttons
    public void addListeners(){
        dashboard_Button.setOnAction(event -> onDashboard());
        apply_Button.setOnAction(event -> onApply());
        applications_Button.setOnAction(event -> onApplications());
        Students_Button.setOnAction(event -> onStudents());
        reqTransfer_Button.setOnAction(event -> onRequestTransfer());
        logout_Button.setOnAction(event -> onLogout());

    }
    //handles Dashboard button
    public void onDashboard(){
        Model.getInstance().getViewFactory().getParentSelectedMenuItem().set(parentMenu_Options.DASHBOARD);
    }
    //handles apply button
    public void onApply(){
        Model.getInstance().getViewFactory().getParentSelectedMenuItem().set(parentMenu_Options.APPLY);
    }
    //handles application button
    public void onApplications(){
        Model.getInstance().getViewFactory().getParentSelectedMenuItem().set(parentMenu_Options.APPLICATIONS);
    }
    //handles students button
    public void onStudents(){
        Model.getInstance().getViewFactory().getParentSelectedMenuItem().set(parentMenu_Options.STUDENTS);
    }
    //handles request transfer button
    public void onRequestTransfer(){
        Model.getInstance().getViewFactory().getParentSelectedMenuItem().set(parentMenu_Options.TRANSFER);
    }

    public void onLogout(){
        Stage stage = (Stage) name_Label.getScene().getWindow();
        Model.getInstance().getViewFactory().closeStage(stage);
        Model.getInstance().getViewFactory().showLogin_Window();
    }


}
