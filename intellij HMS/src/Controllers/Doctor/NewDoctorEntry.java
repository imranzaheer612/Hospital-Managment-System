package Controllers.Doctor;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import Controllers.Database.Queries;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class NewDoctorEntry implements Initializable {

    @FXML
    private Button saveDocEntry;
    @FXML
    private Button backDocEntry;
    @FXML
    private TextField name;
    @FXML
    private TextField charge;
    @FXML
    private TextField specialization;
    @FXML
    private TextField age;
    @FXML
    private TextField address;
    @FXML
    private TextField contact;

    Queries database = new Queries();
    Alert error = new Alert(Alert.AlertType.ERROR);
    Alert failed = new Alert(Alert.AlertType.ERROR);
    Alert info = new Alert(Alert.AlertType.INFORMATION);

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        error.setContentText("Please fill all the entries in correct format.");
        failed.setContentText("Failed to save the data.");
        info.setContentText("Doctor's data saved successfully.");
    }

    @FXML
    private void backToOptions() throws IOException {
        Parent backPage = FXMLLoader.load(getClass().getResource("../../View/Doctor/options.fxml"));
        saveDocEntry.getScene().setRoot(backPage);
    }

    public boolean isEmpty() {
        return name.getText().isBlank() ||
                specialization.getText().isBlank() ||
                charge.getText().isBlank() ||
                age.getText().isBlank() ||
                address.getText().isBlank() ||
                contact.getText().isBlank();
    }


    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }

    public String[] getDocArr() {
        String[] doctor = new String[7];
        doctor[0] = database.generateDoctorID();
        doctor[1] = name.getText();
        doctor[2] = charge.getText();
        doctor[3] = specialization.getText();
        doctor[4] = age.getText();
        doctor[5] = address.getText();
        doctor[6] = contact.getText();
        return doctor;
    }

    @FXML
    private void confirmData() {

        if (isEmpty() || !isNumeric(contact.getText()) || !isNumeric(age.getText()) || !isNumeric(charge.getText())) {
            error.showAndWait();
        }
        else {
            try {
                database.insertDoctor(getDocArr());
                info.showAndWait();
                backDocEntry.fire();
            }
            catch (SQLException throwables) {
                throwables.printStackTrace();
                failed.showAndWait();
            }
        }
    }


}
