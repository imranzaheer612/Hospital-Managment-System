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

public class OptionsController implements Initializable {

    // Button from the options scene
    @FXML
    private Button addDoc;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    private void addDoc(ActionEvent event) throws IOException {
        Parent docEntry = FXMLLoader.load(getClass().getResource("../../View/Doctor/newDocEntry.fxml"));
        addDoc.getScene().setRoot(docEntry);
    }
 @FXML
    private void docTable(ActionEvent event) throws IOException {
        Parent docEntry = FXMLLoader.load(getClass().getResource("../../View/Doctor/showAllDoc.fxml"));
        addDoc.getScene().setRoot(docEntry);
    }

    @FXML
    private void backToMenu(ActionEvent event) throws IOException {
        Parent startPage = FXMLLoader.load(getClass().getResource("../../View/Doctor/newOrEditDoc.fxml"));
        addDoc.getScene().setRoot(startPage);
    }

}
