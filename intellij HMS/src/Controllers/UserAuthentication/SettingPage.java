package Controllers.UserAuthentication;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

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
        Parent startup = FXMLLoader.load(getClass().getResource("../../View/UserAuthentication/updatePassword.fxml"));
        change.getScene().setRoot(startup);
    }
    @FXML
    private void addUser(ActionEvent event) throws IOException {
        Parent startup = FXMLLoader.load(getClass().getResource("../../View/UserAuthentication/addNewUser.fxml"));
        adduser.getScene().setRoot(startup);
    }
    @FXML
    private void logOut(ActionEvent event) throws IOException {
        Parent startup = FXMLLoader.load(getClass().getResource("../../View/UserAuthentication/loginPage.fxml"));
        logout.getScene().setRoot(startup);
    }
    @FXML
    private void back(ActionEvent event) throws IOException {
        Parent startup = FXMLLoader.load(getClass().getResource("../../View/startupPage.fxml"));
        logout.getScene().setRoot(startup);
    }
}