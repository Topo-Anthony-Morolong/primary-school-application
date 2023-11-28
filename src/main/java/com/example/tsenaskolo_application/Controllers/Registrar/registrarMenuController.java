package com.example.tsenaskolo_application.Controllers.Registrar;

import com.example.tsenaskolo_application.Models.Model;
import com.example.tsenaskolo_application.Views.registrarMenuItem;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class registrarMenuController implements Initializable {
    public Label name_Label;
    public Button dashboard_Button;
    public Button reviewApplications_Button;
    public Button login_Button;
    public Button viewClasses_Button;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    AddListeners();
    }
    public void AddListeners(){
        dashboard_Button.setOnAction(event -> onRegistrarDashboard());
        reviewApplications_Button.setOnAction(event -> onReviewApplications());
        viewClasses_Button.setOnAction(event -> onViewClasses());
        login_Button.setOnAction(event -> onLogout());
    }
    public void onRegistrarDashboard(){
        Model.getInstance().getViewFactory().getRegistrarSelectedMenuItem().set(registrarMenuItem.DASHBOARD);
    }
    public void onReviewApplications(){
        Model.getInstance().getViewFactory().getRegistrarSelectedMenuItem().set(registrarMenuItem.APPLICATIONS);
    }
    public void onViewClasses(){
        Model.getInstance().getViewFactory().getRegistrarSelectedMenuItem().set(registrarMenuItem.CLASSES);
    }
    public void onLogout(){
        Stage stage = (Stage) name_Label.getScene().getWindow();
        Model.getInstance().getViewFactory().closeStage(stage);
        Model.getInstance().getViewFactory().showLogin_Window();
    }
}
