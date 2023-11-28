package com.example.tsenaskolo_application;

import com.example.tsenaskolo_application.Models.Model;
import javafx.application.Application;
import javafx.stage.Stage;

public class schoolApp extends Application {

    @Override
    public void start(Stage stage)  {
        Model.getInstance().getViewFactory().showLogin_Window();

    }
}
