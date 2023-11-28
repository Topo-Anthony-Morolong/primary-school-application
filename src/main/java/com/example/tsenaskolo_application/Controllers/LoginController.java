package com.example.tsenaskolo_application.Controllers;

import com.example.tsenaskolo_application.Models.Model;
import com.example.tsenaskolo_application.Views.system_Users;
import com.example.tsenaskolo_application.schoolUtilities.schoolDatabase;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

import static java.lang.System.out;

public class LoginController implements Initializable {
    public ChoiceBox<system_Users> select_UserType;
    public TextField username;
    public TextField password;
    public Button login_Button;
    public Button register_Button;
    public Label error_label;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        /*
        * this button switches Windows from login to registration
        * */
        register_Button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Model.getInstance().getViewFactory().switchScene(event, "/Fxml/Registration.fxml");
            }

        });
        /*
         *  This section operates on the select_UserType ChoiceBox
         * */
        select_UserType.setItems(FXCollections.observableArrayList(system_Users.HEADMASTER,system_Users.PARENT,system_Users.REGISTRAR,system_Users.TEACHER));
        select_UserType.setValue(Model.getInstance().getViewFactory().getLogin_UserType());
        select_UserType.valueProperty().addListener(observable -> Model.getInstance().getViewFactory().setLogin_UserType(select_UserType.getValue()));
        login_Button.setOnAction(event -> validateLogin());

    }

    //this method is for logging in when clicking the login button
    public void onLogin(){
        Stage stage = (Stage) username.getScene().getWindow();
        Model.getInstance().getViewFactory().closeStage(stage);

        if( Model.getInstance().getViewFactory().getLogin_UserType().equals(system_Users.PARENT)){

            Model.getInstance().getViewFactory().showParent_Window();

        } else if (Model.getInstance().getViewFactory().getLogin_UserType() == system_Users.HEADMASTER){

            Model.getInstance().getViewFactory().showHeadmaster_Window();

        }else if (Model.getInstance().getViewFactory().getLogin_UserType() == system_Users.REGISTRAR){

            Model.getInstance().getViewFactory().showRegistrar_Window();

        }//{Model.getInstance().getViewFactory().showTeacher_Window();}

    }
    public void validateLogin(){
        String userName = username.getText();
        String pass = password.getText();
        String usertype = String.valueOf( Model.getInstance().getViewFactory().getLogin_UserType());


        Connection validationConn = schoolDatabase.getConnection();
        String validate = "SELECT COUNT(1) FROM users WHERE User_name = '"+userName+"' and user_Password = '"+pass+"' and TypeOf_user='"+usertype+"';";

        try {
            Statement state = validationConn.createStatement();
            ResultSet result = state.executeQuery(validate);

                while(result.next()) {
                    if(result.getInt(1)==1){
                        onLogin();
                        out.println("successful login..!");
                        out.println( Model.getInstance().getViewFactory().getLogin_UserType());


                    }else if (result.getInt(1)==0){
                        out.println("User does not exist..! ");
                        error_label.setText("enter the right credentials..!");
                        out.println( Model.getInstance().getViewFactory().getLogin_UserType());
                    }
                }
        }catch (Exception log){
            log.printStackTrace();
            log.getCause();
            error_label.setText("enter the right credentials..!");
            out.println("Failed to login..!");
        }

    }
    public void checkEmptyField(){}


}
