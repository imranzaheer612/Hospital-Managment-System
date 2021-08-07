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


public class Options implements Initializable {

    @FXML
    private Button addPatient;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    // Adding a new Patient to the Database
    @FXML
    private void patientEntryHandle(ActionEvent event) throws IOException {
        Parent patientEntry = FXMLLoader.load(getClass().getResource("../../View/Patient/patientEntry.fxml"));
        addPatient.getScene().setRoot(patientEntry);
    }

    // Page for adding a diagnosis of a patient
    @FXML
    private void diagnosisEntry(ActionEvent event) throws IOException {
        Parent diagnosisEntry = FXMLLoader.load(getClass().getResource("../../View/Patient/enterPatId.fxml"));
        addPatient.getScene().setRoot(diagnosisEntry);
    }

    // Assigning Doctors to the Patients

    @FXML
    private void assignDoctor(ActionEvent event) throws IOException {
        Parent assignPage = FXMLLoader.load(getClass().getResource("../../View/Patient/assignDoctor.fxml"));
        addPatient.getScene().setRoot(assignPage);
    }
    // Giving their rooms to the patients

    @FXML
    private void giveRoom(ActionEvent event) throws IOException {
        Parent roomEntryPage = FXMLLoader.load(getClass().getResource("../../View/Patient/giveRoom.fxml"));
        addPatient.getScene().setRoot(roomEntryPage);
    }

    // Giving their rooms to the patients

    @FXML
    private void patTable(ActionEvent event) throws IOException {
        Parent roomEntryPage = FXMLLoader.load(getClass().getResource("../../View/Patient/showAllPat.fxml"));
        addPatient.getScene().setRoot(roomEntryPage);
    }

    @FXML
    private void oldPatTable(ActionEvent event) throws IOException {
        Parent roomEntryPage = FXMLLoader.load(getClass().getResource("../../View/Patient/oldPatients.fxml"));
        addPatient.getScene().setRoot(roomEntryPage);
    }

    // Return back to the main screen
    @FXML
    private void backToMenu(ActionEvent event) throws IOException {
        Parent startPage = FXMLLoader.load(getClass().getResource("../../View/Patient/newOrEdit.fxml"));
        addPatient.getScene().setRoot(startPage);
    }

}
