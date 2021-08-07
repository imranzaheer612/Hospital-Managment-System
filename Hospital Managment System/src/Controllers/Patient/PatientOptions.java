package Controllers.Patient;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PatientOptions implements Initializable {

    // Button from the options scene
    @FXML
    private Button addPatient;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    private void addPatient(ActionEvent event) throws IOException {
        Parent patientEntry = FXMLLoader.load(getClass().getResource("../../View/Patient/options.fxml"));
        addPatient.getScene().setRoot(patientEntry);
    }

    @FXML
    private void dischargePatient(ActionEvent event) throws IOException {
        Parent patientEntry = FXMLLoader.load(getClass().getResource("../../View/Patient/dischargePat.fxml"));
        addPatient.getScene().setRoot(patientEntry);
    }

    @FXML
    private void showCurrPatients(ActionEvent event) throws IOException {
        Parent patientEntry = FXMLLoader.load(getClass().getResource("../../View/Patient/showAllPat.fxml"));
        addPatient.getScene().setRoot(patientEntry);
    }

    @FXML
    private void showOldPatients(ActionEvent event) throws IOException {
        Parent patientEntry = FXMLLoader.load(getClass().getResource("../../View/Patient/oldPatients.fxml"));
        addPatient.getScene().setRoot(patientEntry);
    }

    @FXML
    private void backToMenu(ActionEvent event) throws IOException {
        Parent startPage = FXMLLoader.load(getClass().getResource("../../View/startupPage.fxml"));
        addPatient.getScene().setRoot(startPage);
    }


}
