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
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DiagnosisEntry implements Initializable {

    @FXML
    private Button backButtonDiagnosis;
    @FXML
    private TextField disease;
    @FXML
    private TextField temperature ;
    @FXML
    private TextField bloodType;
    @FXML
    private TextField bloodPressure;
    @FXML
    private TextArea prescription;

    private String patID;
//    private  EnterPatIdController patIdController;
    private final Queries database = new Queries();

    private final Alert error = new Alert(Alert.AlertType.ERROR);
    private final Alert failed = new Alert(Alert.AlertType.ERROR);
    private final Alert info = new Alert(Alert.AlertType.INFORMATION);


    /**
     * Initializing some variables before genrating
     * the scene
     * */

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        error.setContentText("Please fill all the entries in correct format.");
        failed.setContentText("Failed to save the data.");
        info.setContentText("Patient data saved successfully.");
    }

    public void initPatID(String id) {
        patID = id;
    }

    /**
     * moving back to the previous scene on
     * hitting the back button
     * */

    @FXML
    private void backToOptions(ActionEvent event) throws IOException {
        Parent patientEntry = FXMLLoader.load(getClass().getResource("../../View/Patient/options.fxml"));
        backButtonDiagnosis.getScene().setRoot(patientEntry);
    }

    /**
     * Checking if all the text boxes are filled
     * if not
     * --> Show error alert
     * */

    public boolean isEmpty() {
        return disease.getText().isBlank() ||
            temperature.getText().isBlank() ||
            bloodType.getText().isBlank() ||
            bloodPressure.getText().isBlank() ||
            prescription.getText().isBlank();
    }

    /**
     * Saving all the entered attributes by the user in
     * a string array
     * */

    public String[] getDiagnosisArr() {
        String[] diagnosis = new String[7];
        diagnosis[0] = database.generateDiagnosisId();
        diagnosis[1] = patID;
        diagnosis[2] = disease.getText();
        diagnosis[3] = temperature.getText();
        diagnosis[4] = bloodType.getText();
        diagnosis[5] = bloodPressure.getText();
        diagnosis[6] = prescription.getText();
        return diagnosis;
    }

    @FXML
    private void confirmData() {

        // Error Blank
        if (isEmpty()) {
            error.showAndWait();
        }
        // if no error then save Entry
        else {
            try {
                database.insertDiagnosis(getDiagnosisArr());
                info.showAndWait();
                backButtonDiagnosis.fire();
            }
            catch (SQLException throwables) {
                throwables.printStackTrace();
                failed.showAndWait();
            }
        }
    }



}
