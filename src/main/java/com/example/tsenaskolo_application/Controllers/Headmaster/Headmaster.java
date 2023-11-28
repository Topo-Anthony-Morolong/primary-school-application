package com.example.tsenaskolo_application.Controllers.Headmaster;

import com.example.tsenaskolo_application.Models.Model;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;

import java.net.URL;
import java.util.ResourceBundle;

public class Headmaster implements Initializable{
    public BorderPane headmaster_background;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Model.getInstance().getViewFactory().getHeadmasterSelectedMenuItem().addListener((observableValue, oldVal, newVal) -> {
            switch (newVal){
                case TEACHERS ->  headmaster_background.setCenter(Model.getInstance().getViewFactory().get_teacherList());
                default ->headmaster_background.setCenter(Model.getInstance().getViewFactory().show_Dashboard());

            }

        });

    }
}
