package sample.authenticate;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
import sample.Database;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.sql.SQLException;

/**
 * It will show all the available
 * options related to the management process
 * of the hospital
 * */


public class SettingPage implements Initializable {

    @FXML
    private Button change;
    @FXML
    private Button adduser;
    @FXML
    private Button logout;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    @FXML
    private void changePass(ActionEvent event) throws IOException {
        Parent startup = FXMLLoader.load(getClass().getResource("../../fxfiles/authenticate/updatePassword.fxml"));
        change.getScene().setRoot(startup);
    }
    @FXML
    private void addUser(ActionEvent event) throws IOException {
        Parent startup = FXMLLoader.load(getClass().getResource("../../fxfiles/authenticate/newUseradd.fxml"));
        adduser.getScene().setRoot(startup);
    }
    @FXML
    private void logOut(ActionEvent event) throws IOException {
        Parent startup = FXMLLoader.load(getClass().getResource("../../fxfiles/authenticate/authen.fxml"));
        logout.getScene().setRoot(startup);
    }
    @FXML
    private void back(ActionEvent event) throws IOException {
        Parent startup = FXMLLoader.load(getClass().getResource("../../fxfiles/Others/startupPage.fxml"));
        logout.getScene().setRoot(startup);
    }
}