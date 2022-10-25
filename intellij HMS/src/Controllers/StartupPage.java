package Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


/**
 * It will show all the available
 * options related to the management process
 * of the hospital
 * */


public class StartupPage implements Initializable {

    @FXML
    private ImageView truckImage;
    @FXML
    private Button addButton;
    @FXML
    private Button setting;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    // moving to the next scene
    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
        Parent newOrEditEntryPage = FXMLLoader.load(getClass().getResource("../View/Patient/newOrEdit.fxml"));
        addButton.getScene().setRoot(newOrEditEntryPage);
    }

    // moving to the next scene
    @FXML
    private void doctorOptions(ActionEvent event) throws IOException {
        Parent newOrEditEntryPage = FXMLLoader.load(getClass().getResource("../View/Doctor/newOrEditDoc.fxml"));
        addButton.getScene().setRoot(newOrEditEntryPage);
    }

    // moving to the next scene
    @FXML
    private void addRoom() throws IOException {
        Parent newOrEditEntryPage = FXMLLoader.load(getClass().getResource("../View/Room/rooms.fxml"));
        addButton.getScene().setRoot(newOrEditEntryPage);
    }

    @FXML
    private void settingPage(ActionEvent event) throws IOException {
        Parent newOrEditEntryPage = FXMLLoader.load(getClass().getResource("../View/UserAuthentication/loginSetting.fxml"));
        setting.getScene().setRoot(newOrEditEntryPage);
    }

    @FXML
    private void bills(ActionEvent event) throws IOException {
        Parent newOrEditEntryPage = FXMLLoader.load(getClass().getResource("../View/Bill/billOptions.fxml"));
        setting.getScene().setRoot(newOrEditEntryPage);
    }


}
