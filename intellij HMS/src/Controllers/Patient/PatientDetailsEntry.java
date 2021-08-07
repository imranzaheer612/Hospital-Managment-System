package Controllers.Patient;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
import Controllers.Database.Queries;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.ResourceBundle;

public class PatientDetailsEntry implements Initializable {

    // Button from the options scene
    @FXML
    private Button backButtonEntry;
    @FXML
    private Button save;
    @FXML
    private TextField firstName;
    @FXML
    private TextField lastName;
    @FXML
    private TextField gender;
    @FXML
    private TextField weight;
    @FXML
    private TextField address;
    @FXML
    private TextField contactNo;
    @FXML
    private DatePicker birthDate;
    @FXML
    private DatePicker diseaseDate;
    @FXML
    private ComboBox<String> roomsSelector;

    Queries database = new Queries();
    Alert error = new Alert(Alert.AlertType.ERROR);
    Alert failed = new Alert(Alert.AlertType.ERROR);
    Alert info = new Alert(Alert.AlertType.INFORMATION);


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        try {
            ResultSet allRooms = database.getUnfilledRooms();
            while (allRooms.next()) {
                roomsSelector.getItems().add(allRooms.getString("roomNO"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


        error.setContentText("Please fill all the entries in correct format.");
        failed.setContentText("Failed to save the data.");

    }

    @FXML
    private void backToOptions(ActionEvent event) throws IOException {
        Parent patientEntry = FXMLLoader.load(getClass().getResource("../../View/Patient/options.fxml"));
        backButtonEntry.getScene().setRoot(patientEntry);
    }

    public boolean isEmpty() {
        System.out.println("Contact No: " + contactNo.getText());
        return firstName.getText().isBlank() ||
                lastName.getText().isBlank() ||
                weight.getText().isBlank() ||
                gender.getText().isBlank() ||
                address.getText().isBlank() ||
                contactNo.getText().isBlank() ||
                birthDate.getValue() == null ||
                diseaseDate.getValue() == null;
    }


    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }

    public String[] getPatientArr() {
        String[] patient = new String[8];
        patient[0] = database.generatePatientID();
        patient[1] = firstName.getText() + " " + lastName.getText();
        patient[2] = birthDate.getValue().toString();
        patient[3] = gender.getText();
        patient[4] = weight.getText();
        patient[5] = address.getText();
        patient[6] = contactNo.getText();
        patient[7] = roomsSelector.getValue();
        return patient;
    }

    @FXML
    private void confirmData() {

        // Error Blank
        if (isEmpty()) {
            error.showAndWait();
        }
        // Error Format
        else if (!isNumeric(contactNo.getText()) || !isNumeric(weight.getText())) {
            error.showAndWait();
        }
        // if no error then save Entry
        else {
            try {
                database.insertPatient(getPatientArr(), getDiseaseDate());
                info.setContentText("Date is saved successfully. Patient Id : " + getPatientArr()[0] );
                info.showAndWait();
                backButtonEntry.fire();
            }
            catch (SQLException throwables) {
                throwables.printStackTrace();
                failed.showAndWait();
            }
        }
    }

    public Date getDiseaseDate() {
        System.out.println(Date.valueOf(diseaseDate.getValue()));
        return Date.valueOf(diseaseDate.getValue());
    }


}
