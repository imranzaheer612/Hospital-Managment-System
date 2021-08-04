package sample.DoctorControllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class NewOrEditDocController implements Initializable {

    // Button from the options scene
    @FXML
    private Button addDoc;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    private void addDocEntry(ActionEvent event) throws IOException {
        Parent patientEntry = FXMLLoader.load(getClass().getResource("../../fxfiles/DoctorFxml/options.fxml"));
        addDoc.getScene().setRoot(patientEntry);
    }

    @FXML
    private void deleteDoc(ActionEvent event) throws IOException {
        Parent patientEntry = FXMLLoader.load(getClass().getResource("../../fxfiles/DoctorFxml/deleteDoctor.fxml"));
        addDoc.getScene().setRoot(patientEntry);
    }

    @FXML
    private void backToMenu(ActionEvent event) throws IOException {
        Parent backPage = FXMLLoader.load(getClass().getResource("../../fxfiles/Others/startupPage.fxml"));
        addDoc.getScene().setRoot(backPage);
    }


}
