package com.example.tsenaskolo_application.Controllers.Registrar;

import com.example.tsenaskolo_application.Models.Model;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;

import java.net.URL;
import java.util.ResourceBundle;

public class Registrar implements Initializable {

    public BorderPane registrar_background;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Model.getInstance().getViewFactory().getRegistrarSelectedMenuItem().addListener((observableValue, oldVal,newVal ) ->{
            switch (newVal){
                case APPLICATIONS -> registrar_background.setCenter(Model.getInstance().getViewFactory().getReviewApplications());
                case CLASSES -> registrar_background.setCenter(Model.getInstance().getViewFactory().getViewClasses());
                default -> registrar_background.setCenter(Model.getInstance().getViewFactory().getRegistrarDashboard());

            }
        });

    }
}
