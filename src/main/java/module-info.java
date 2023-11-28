module com.example.tsenaskolo_application {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    requires java.sql;
    requires mysql.connector.j;

    opens com.example.tsenaskolo_application to javafx.fxml;
    exports com.example.tsenaskolo_application;
    exports com.example.tsenaskolo_application.Controllers;
    exports com.example.tsenaskolo_application.Controllers.Headmaster;
    exports com.example.tsenaskolo_application.Controllers.Parent;
    exports com.example.tsenaskolo_application.Controllers.Registrar;
    exports com.example.tsenaskolo_application.Controllers.Teacher;
    exports com.example.tsenaskolo_application.Models;
    exports com.example.tsenaskolo_application.Views;
}