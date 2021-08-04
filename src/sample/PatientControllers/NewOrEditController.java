package sample.PatientControllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class NewOrEditController implements Initializable {

    // Button from the options scene
    @FXML
    private Button addPatient;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    private void addPatient(ActionEvent event) throws IOException {
        Parent patientEntry = FXMLLoader.load(getClass().getResource("../../fxfiles/PatientFxml/options.fxml"));
        addPatient.getScene().setRoot(patientEntry);
    }

    @FXML
    private void dischargePatient(ActionEvent event) throws IOException {
        Parent patientEntry = FXMLLoader.load(getClass().getResource("../../fxfiles/PatientFxml/dischargePat.fxml"));
        addPatient.getScene().setRoot(patientEntry);
    }

    @FXML
    private void showCurrPatients(ActionEvent event) throws IOException {
        Parent patientEntry = FXMLLoader.load(getClass().getResource("../../fxfiles/PatientFxml/showAllPat.fxml"));
        addPatient.getScene().setRoot(patientEntry);
    }

    @FXML
    private void showOldPatients(ActionEvent event) throws IOException {
        Parent patientEntry = FXMLLoader.load(getClass().getResource("../../fxfiles/PatientFxml/oldPatients.fxml"));
        addPatient.getScene().setRoot(patientEntry);
    }

    @FXML
    private void backToMenu(ActionEvent event) throws IOException {
        Parent startPage = FXMLLoader.load(getClass().getResource("../../fxfiles/Others/startupPage.fxml"));
        addPatient.getScene().setRoot(startPage);
    }


}
