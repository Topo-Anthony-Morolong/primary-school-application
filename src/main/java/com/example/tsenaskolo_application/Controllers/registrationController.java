package com.example.tsenaskolo_application.Controllers;

import com.example.tsenaskolo_application.Models.Model;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import com.example.tsenaskolo_application.schoolUtilities.*;

import static java.lang.System.out;

public class registrationController implements Initializable {
    public RadioButton parent_rButton;

    public TextField registration_Username;
    public TextField registration_Password;
    public TextField confirm_Password;

    public Button register_Button;
    public Button login_Button;
    public TextField firstnameText_Field;
    public TextField lastName_textField;
    public TextField age_TextField;
    public TextField genderText_Field;
    public TextField id_TextField;
    public TextField email_TextField;
    public TextField postal_TextField;
    public TextField physical_TextField;
    public TextField phoneNum_TextField;
    public Label error_label;
    public Label error_empty;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        login_Button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Model.getInstance().getViewFactory().switchScene(event,"/Fxml/Login.fxml");
            }
        });
        addListener();

    }
    public void addListener(){
        register_Button.setOnAction(event -> emptyFields());
    }


    public void register(){
        Connection dbConn = schoolDatabase.getConnection();


        parent_rButton.setSelected(true);

        String fName =  firstnameText_Field.getText();
        String lName =  lastName_textField.getText();
        int age  = Integer.parseInt( age_TextField.getText());
        String gender =  genderText_Field.getText();
        String idNumber =  id_TextField.getText();
        String email =  email_TextField.getText();
        String postal =  postal_TextField.getText();
        String physical =  physical_TextField.getText();
        String phone =  phoneNum_TextField.getText();


        String username =  registration_Username.getText();
        String password = registration_Password.getText();
        String toggleName = parent_rButton.getText();


        String insertFields = "INSERT INTO `users`(`First_name`, `Last_name`, `Age`, `Gender`, `Id_number`, " +
                "`Email_address`, `Postal_address`, `Physical_address`, `Phone_number`, `TypeOf_user`, " +
                "`User_name`, `user_Password`)";
        String insertValues = "VALUES('"+fName+"','"+lName+"','"+age+"','"+gender+"','"+idNumber+"','"+email+"','"+postal+"','"+physical+"','"+phone+"','"+toggleName+"','"+username+"','"+password+"')";
        String registerUser = insertFields + insertValues ;

        try {
            Statement state = dbConn.createStatement();
            state.executeUpdate(registerUser);
            out.println("User registration successful...!!");

        }catch (SQLException io  ){
            io.printStackTrace();
            io.getCause();
            out.println("User registration failed...!!");
        }catch ( NumberFormatException a){
            a.printStackTrace();
            a.getCause();
            error_empty.setText("Please enter numbers only for age ..!");
        }
        finally {
            try {
                dbConn.close();
                out.println("Connection closing successful...!!");

            }catch (SQLException io){
                io.printStackTrace();
                io.getCause();
                out.println("User registration failed...!!");
            }
        }



    }
   public void Confirm_Password(){
        String pass = registration_Password.getText();
        String confirm = confirm_Password.getText();
        if(pass.equals(confirm)){

            register();
            error_label.setText("Registration successful");
            out.println("User Registered Successfully...!");

        }else {
            error_label.setText("Password does nor match.!");
            out.println("failed to register user..!");
        }

   }
   public void emptyFields(){
       String fName =  firstnameText_Field.getText();
       String lName =  lastName_textField.getText();

       String gender =  genderText_Field.getText();
       String idNumber =  id_TextField.getText();
       String email =  email_TextField.getText();
       String postal =  postal_TextField.getText();
       String physical =  physical_TextField.getText();
       String phone =  phoneNum_TextField.getText();
       if(fName.isEmpty() || lName.isEmpty()|| gender.isEmpty()||idNumber.isEmpty() || email.isEmpty() || postal.isEmpty()|| physical.isEmpty() || phone.isEmpty()){
           error_empty.setText("Please fill in all the Information..!");

       }else {Confirm_Password();
       clearFields();}
   }
   public void clearFields(){
        firstnameText_Field.setText(null);
        lastName_textField.setText(null);
        genderText_Field.setText(null);
        age_TextField.setText(null);
        id_TextField.setText(null);
        email_TextField.setText(null);
        postal_TextField.setText(null);
        physical_TextField.setText(null);
        phoneNum_TextField.setText(null);
        registration_Username.setText(null);
        registration_Password.setText(null);
        confirm_Password.setText(null);
   }

}
