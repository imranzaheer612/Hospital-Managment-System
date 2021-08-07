package Controllers.Patient;

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

public class AssignDoctor implements Initializable {

    // Button from the options scene
    @FXML
    private Button back;
    @FXML
    private Button assignAnother;
    @FXML
    private Button confirmAssign;
    @FXML
    private TextField enterPatId;
    @FXML
    private TextField enterDocId;

    private final Queries database = new Queries();
    private final Alert error = new Alert(Alert.AlertType.ERROR);
    private final Alert failed = new Alert(Alert.AlertType.ERROR);
    private final Alert info = new Alert(Alert.AlertType.INFORMATION);



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        error.setContentText("Please fill all the entries in correct format.");
        failed.setContentText("Failed to save the data.");
        info.setContentText("Doctor assigned successfully.");
    }

    // handler moving back to the options page
    @FXML
    private void backToOptions() throws IOException {
        Parent optionsScene = FXMLLoader.load(getClass().getResource("../../View/Patient/options.fxml"));
        back.getScene().setRoot(optionsScene);
    }

    public boolean isEmpty() {
        return enterDocId.getText().isBlank() ||
                enterPatId.getText().isBlank();
    }


    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }

    public boolean bothIdExists() throws SQLException {
        boolean patientExists = database.patientExists(Integer.parseInt(enterPatId.getText()));
        boolean doctorExists = database.doctorExists(Integer.parseInt(enterDocId.getText()));
        if (!patientExists) {
            error.setContentText("Patient Id does not exists!");
            error.showAndWait();
        }
        else if (!doctorExists){
            error.setContentText("Doctor Id does not exists!");
            error.showAndWait();
        }
        return  patientExists && doctorExists;
    }


    @FXML
    private void confirmData() {

        // Error Blank
        if (isEmpty() || !isNumeric(enterDocId.getText()) || !isNumeric(enterPatId.getText())) {
            error.showAndWait();
        }
        // if no error then save Entry
        else {
            try {
                if (bothIdExists()) {
                    database.assignDoctor(enterPatId.getText(), enterDocId.getText());
                    info.showAndWait();
                    back.fire();
                }
            }
            catch (SQLException throwables) {
                throwables.printStackTrace();
                failed.showAndWait();
            }

        }
    }
}