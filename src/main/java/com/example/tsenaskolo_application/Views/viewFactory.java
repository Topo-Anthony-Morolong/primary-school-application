package com.example.tsenaskolo_application.Views;

import com.example.tsenaskolo_application.Controllers.Headmaster.Headmaster;
import com.example.tsenaskolo_application.Controllers.Parent.parentController;
import com.example.tsenaskolo_application.Controllers.Registrar.Registrar;
import com.example.tsenaskolo_application.Controllers.Registrar.grade1_viewController;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

import static java.lang.System.in;
import static java.lang.System.out;

public class viewFactory {

    private system_Users login_UserType;

    //parent data and views
        private final ObjectProperty<parentMenu_Options> parentSelectedMenuItem;
        private AnchorPane dashboard_View;
        private AnchorPane apply_View;
        private AnchorPane applications_View;
        private AnchorPane students_View;
        private AnchorPane requestTransfer_View;


    //headmaster data
    private final ObjectProperty<headmasterMenu_Options> headmasterSelectedMenuItem;
    private AnchorPane hmDashboard_View;
    private AnchorPane teachersList_View;

    //Registrar data
    private final ObjectProperty<registrarMenuItem> registrarSelectedMenuItem;
    private AnchorPane registrarDashboard;
    private AnchorPane reviewApplications;
    private AnchorPane viewClasses;
    private AnchorPane viewGrade1;
    //Teacher data

    public viewFactory(){

        this.login_UserType = system_Users.PARENT;
        this.parentSelectedMenuItem = new SimpleObjectProperty<>();
        this.headmasterSelectedMenuItem = new SimpleObjectProperty<>();
        this.registrarSelectedMenuItem = new SimpleObjectProperty<>();

    }
    //getter method for getting the login user type
    public system_Users getLogin_UserType(){return login_UserType;}

    //setter method for login user type
    public void setLogin_UserType(system_Users login_UserType){
    this.login_UserType = login_UserType;
    }

    /*
    * The section bellow is for headmaster views
     */
    public ObjectProperty<headmasterMenu_Options> getHeadmasterSelectedMenuItem(){
        return headmasterSelectedMenuItem;
    }

    // the method shows headmasters window
    public void showHeadmaster_Window(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Headmaster/Headmaster.fxml"));
        Headmaster hmController = new Headmaster();
        loader.setController(hmController);
        createStage(loader);
    }
    // gets the dashboard window
    public AnchorPane show_Dashboard(){
        if(hmDashboard_View == null){
            try {
                hmDashboard_View = new FXMLLoader(getClass().getResource("/Fxml/Headmaster/headmasterDashboard.fxml")).load();
                out.println("Headmaster dashboard successfully loaded..!");
            }catch (Exception hmView){
                hmView.printStackTrace();
                hmView.getCause();
                out.println("Loading headmaster dashboard failed..!");
            }
        }
        return hmDashboard_View;
    }
    // gets the teacher list window
    public AnchorPane get_teacherList(){
        if(teachersList_View == null){
            try {
                teachersList_View = new FXMLLoader(getClass().getResource("/Fxml/Headmaster/teacherList_View.fxml")).load();
                out.println("teachers list view successfully loaded..!");
            }catch (Exception tL_View){
                tL_View.printStackTrace();
                tL_View.getCause();
                out.println("Failed to load teachers list view..!");
            }
        }
        return teachersList_View;
    }


    /*
    * the following section is for parent views
    * */

    //this method gets parent selected menu item
    public ObjectProperty<parentMenu_Options> getParentSelectedMenuItem(){return parentSelectedMenuItem;}

    //this method shows the parent window
    public void showParent_Window(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Parent/Parent.fxml"));
        parentController prController = new parentController();
        loader.setController(prController);
        createStage(loader);
    }

    //this method shows the parent dashboard
    public AnchorPane getDashboard(){
        if(dashboard_View == null){
            try{
                dashboard_View = new FXMLLoader(getClass().getResource("/Fxml/Parent/parentDashboard.fxml")).load();
                out.println(" parent dashboard successfully loaded..!!");
            }catch (Exception dV){
                dV.printStackTrace();
                dV.getCause();
                out.println("failed to load parent dashboard..!!");
            }
        }
        return dashboard_View;
    }
    //this method shows the view to apply
    public AnchorPane getApply_View(){
        if(apply_View == null){
            try{
                apply_View = new FXMLLoader(getClass().getResource("/Fxml/Parent/applyView.fxml")).load();
                out.println("Apply view successfully loaded..!");
            }catch(Exception aV){
                aV.printStackTrace();
                aV.getCause();
                out.println("failed to load the apply view..!");
            }
        }
        return apply_View;
    }
    //gets the applications view
    public AnchorPane getApplications_View(){
        if(applications_View == null) {
            try {
                applications_View = new FXMLLoader(getClass().getResource("/Fxml/Parent/applicationsView.fxml")).load();
                out.println("parent applications view successfully loaded..!");
            } catch (Exception aV) {
                aV.printStackTrace();
                aV.getCause();
                out.println("failed to load parent applications view..!");
            }
        }
        return applications_View;
    }
    //gets the students view
    public AnchorPane getStudents_View(){
            if(students_View == null){
                try{
                    students_View = new FXMLLoader(getClass().getResource("/Fxml/Parent/studentsView.fxml")).load();
                    out.println("Students view successfully loaded..!");
                }catch(Exception aV){
                    aV.printStackTrace();
                    aV.getCause();
                    out.println("failed to load students view..!");
                }
        }
            return students_View;
        }
    //gets the request for transfer view
    public AnchorPane getRequestTransfer_View(){
        if(requestTransfer_View == null){
            try{
            requestTransfer_View = new FXMLLoader(getClass().getResource("/Fxml/Parent/requestForTransfer_View.fxml")).load();
            out.println("Request for transfer view successfully loaded..!");
            }catch(Exception rTView){
                rTView.printStackTrace();
                rTView.getCause();
                out.println("Failed to load  request for transfer view..!");
            }
        }
        return requestTransfer_View;
    }

    /*
    * section below is for the registrar's views
    **/

    //method gets the registrar's selected menu item
    public ObjectProperty<registrarMenuItem> getRegistrarSelectedMenuItem(){return registrarSelectedMenuItem;}

    //method to displays the registrars window
    public void showRegistrar_Window(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Registrar/Registrar.fxml"));
        Registrar registrarController = new Registrar();
        loader.setController(registrarController);
        createStage(loader);
    }
    //method to display Registrar's dashboard
    public AnchorPane getRegistrarDashboard(){
        if (registrarDashboard == null){
            try {
                registrarDashboard = new FXMLLoader(getClass().getResource("/Fxml/Registrar/registrarDashboard.fxml")).load();
                out.println("Registrar dashboard loaded..!");
        }catch (Exception rD){
                rD.printStackTrace();
                rD.getCause();
                out.println("Failed to load registrar dashboard..!");
            }
        }
        return  registrarDashboard;
    }
    //method gets the review applications window
    public AnchorPane getReviewApplications(){
        if (reviewApplications == null){
            try{
                reviewApplications = new FXMLLoader(getClass().getResource("/Fxml/Registrar/reviewApplication.fxml")).load();
                out.println("Review applications window loaded..!");
            }catch (Exception rAp){
                rAp.printStackTrace();
                rAp.getCause();
                out.println("Failed to load review applications window..!");
            }
        }
        return reviewApplications;
    }
    //method to facilitate viewing of classes
    public AnchorPane getViewClasses(){
        if (viewClasses == null){
            try{
                viewClasses = new FXMLLoader(getClass().getResource("/Fxml/Registrar/viewClasses.fxml")).load();
                out.println("view classes window successfully loaded..!");
            }catch (Exception vClass){
                vClass.printStackTrace();
                vClass.getCause();
                out.println("Failed to load view classes window..!");
            }
        }
        return viewClasses;
    }
    //method for getting class view scene
    public void  getViewGrade1(){

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Registrar/grade1_classA.fxml"));
        grade1_viewController grade1_ = new grade1_viewController() ;
        loader.setController(grade1_);
        createStage(loader);
       /* if(viewGrade1== null){
            try{
                viewGrade1 = new FXMLLoader(getClass().getResource("/Fxml/Registrar/grade1_classA.fxml")).load();
            }catch (Exception eS){
                eS.printStackTrace();
                eS.getCause();
                out.println("Failed to load enrol Student Scene");
            }*/
        }



    /* All the methods bellow are accessible to all controllers
     *this method creates a stage to display any window
     */

    //this method displays the login Window
       public void showLogin_Window(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Login.fxml"));
        createStage(loader);
        out.println("Login window has been successfully displayed..!");
    }


    //displays the registration window
    public void showRegistration_Window(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Registration.fxml"));
        createStage(loader);
        out.println("Login Window successfully displayed..!");
    }

    public void createStage(FXMLLoader loader){

        Scene scene = null;
        try {
            scene = new Scene(loader.load());
            out.println("Stage successfully created..!!");
        }catch (IOException s){
            s.printStackTrace();
            s.getCause();
            out.println("Failed to create the stage..!!");
        }

        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("TSENA SKOLO APP");
        stage.show();
    }

    /*
    * this method closes a stage
    * */
    public void closeStage(Stage stage){
        stage.close();
    }

    /*
    * this method allow switching of scenes
    * */
    public void switchScene(ActionEvent sw, String fxmlFile){
        Parent root = null;
        try{
            root = FXMLLoader.load(viewFactory.class.getResource(fxmlFile));
            out.println("Switching of Scenes successful..!");
        }catch (IOException stS){
            stS.printStackTrace();
            stS.getCause();
            out.println("Switching of Scenes failed..!");
        }
        Stage stage = (Stage) ((Node)sw.getSource()).getScene().getWindow();
        stage.setTitle("TSENA SKOLO APP");
        stage.setScene(new Scene(root, 600, 400));
        stage.show();
    }
}
