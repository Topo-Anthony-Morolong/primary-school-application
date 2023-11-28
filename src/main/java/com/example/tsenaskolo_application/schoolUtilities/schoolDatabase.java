package com.example.tsenaskolo_application.schoolUtilities;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import static java.lang.System.out;

public class schoolDatabase {

    public static Connection databaseLink;

    public static Connection getConnection(){
        String URL =    "jdbc:mysql://localhost:3306/primaryschooljdbc";
        String user = "root";
        String password = "";

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            databaseLink = DriverManager.getConnection(URL,user,password);
            out.println("Connection successful.....!");

        }catch(SQLException | ClassNotFoundException db){
            db.printStackTrace();
            db.getCause();
            out.println("Connection failed.....!");
        }
        return databaseLink;
    }
    /* creation of tables
    * **/
    public static void setUsersTable(){
        try{
            Connection dbConn = schoolDatabase.getConnection();
            Statement state = dbConn.createStatement();
            String query1 = "create table users " +
                            "(first_name varchar(255)," +
                            "last_name varchar(255)," +
                            "Age int(3)," +
                            "Gender varchar(6)," +
                            "Id_Number number," +
                            "email_Address varchar(20)," +
                            "postal_Address varchar(50)," +
                            "physical_Address varchar(50)," +
                            "phone_Number varchar(15));";
            state.executeUpdate(query1);
            out.println("The table parent has been created");

        }
        catch (Exception a){
            a.printStackTrace();
            a.getCause();
            out.println("Creation of parent table failed...!!");
        }

    }

    public static void main(String[] args){

    }

}
