package com.example.tsenaskolo_application.Controllers.Headmaster;

import com.example.tsenaskolo_application.Models.Model;
import com.example.tsenaskolo_application.Views.headmasterMenu_Options;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class headmasterMenuController implements Initializable {
    public Label name_Label;
    public Button dashboard_Button;
    public Button teacher_list_Button;
    public Button logout_Button;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addListeners();
    }
    public void addListeners(){
        dashboard_Button.setOnAction(event -> onDashboard());
        teacher_list_Button.setOnAction(event -> onTeacherList());
        logout_Button.setOnAction(event -> onLogout());
    }

    public void onDashboard(){
        Model.getInstance().getViewFactory().getHeadmasterSelectedMenuItem().set(headmasterMenu_Options.DASHBOARD);
    }
    public void onTeacherList(){
        Model.getInstance().getViewFactory().getHeadmasterSelectedMenuItem().set(headmasterMenu_Options.TEACHERS);
    }
    public void onLogout(){
        Stage stage = (Stage) name_Label.getScene().getWindow();
        Model.getInstance().getViewFactory().closeStage(stage);
        Model.getInstance().getViewFactory().showLogin_Window();
    }
}
