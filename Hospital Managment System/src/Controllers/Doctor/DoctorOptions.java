package Controllers.Doctor;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DoctorOptions implements Initializable {

    // Button from the options scene
    @FXML
    private Button addDoc;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    private void addDocEntry(ActionEvent event) throws IOException {
        Parent patientEntry = FXMLLoader.load(getClass().getResource("../../View/Doctor/options.fxml"));
        addDoc.getScene().setRoot(patientEntry);
    }

    @FXML
    private void deleteDoc(ActionEvent event) throws IOException {
        Parent patientEntry = FXMLLoader.load(getClass().getResource("../../View/Doctor/deleteDoctor.fxml"));
        addDoc.getScene().setRoot(patientEntry);
    }

    @FXML
    private void backToMenu(ActionEvent event) throws IOException {
        Parent backPage = FXMLLoader.load(getClass().getResource("../../View/startupPage.fxml"));
        addDoc.getScene().setRoot(backPage);
    }


}
