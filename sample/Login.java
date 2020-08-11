package sample;

import app.Person;
import dataBase.DataBasesConnections;
import dataBase.EmployeeDBConnection;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import javax.print.attribute.standard.NumberUp;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.EventListener;
import java.util.ResourceBundle;

public class Login extends Application implements Initializable {

    public TextField txtPassword;
    public TextField txtUser;
    public Button btnLogin;
    static private String user ;
    static private String password;

    public static String getUser() {
        return user;
    }

    public static String getPassword() {
        return password;
    }

    String query = "SELECT * from person";
    @FXML
    ComboBox<String> comboBox ;


    ObservableList<String> departmentsList = FXCollections.observableArrayList("Admin","Sales");

    Stage stage = new Stage();
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Please Login");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();
        primaryStage.setResizable(false);
        stage = primaryStage;
    }

    public static void main(String[] args) {
         launch(args);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
            comboBox.setItems(departmentsList);
    }

    String departmentAsString = "";

    public void onClickButton(MouseEvent event) {
        departmentAsString = comboBox.getValue();
        user  = txtUser.getText();
        password  = txtPassword.getText();
        try {
            if(( departmentAsString.equals("Admin")) && (txtUser.getText().equals(""))){
                JOptionPane.showMessageDialog(null,"User field can't be empty","User",
                        JOptionPane.ERROR_MESSAGE);
            }else if(departmentAsString.equals("Admin") && (txtPassword.getText().equals(""))){
                JOptionPane.showMessageDialog(null,"Password field can't be empty","Password",
                        JOptionPane.ERROR_MESSAGE);
            }else if((departmentAsString.equals("Admin")) && ((txtUser.getText() != "") && (txtPassword.getText() != ""))) {
                try {
                    DataBasesConnections.connectToPersonTable(query);
                }catch (NullPointerException ignored){
                    txtUser.clear();
                    txtPassword.clear();
                }
            }

            if(departmentAsString.equals("Sales")){
                JOptionPane.showMessageDialog(null,"Department sales not existing");
            }
        } catch (Exception ignored){
            JOptionPane.showMessageDialog(null,"Select department first");
        }
    }
}




