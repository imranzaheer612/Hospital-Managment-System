package Controllers.Room;

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

public class AddRoom implements Initializable {

    // Button from the options scene
    @FXML
    private Button back;
    @FXML
    private Button save;
    @FXML
    private TextField roomNo;
    @FXML
    private TextField charges;
    @FXML
    private Spinner<Integer> beds;
    @FXML
    private RadioButton filled;
    @FXML
    private RadioButton unfilled;


    ToggleGroup toggle = new ToggleGroup();
    Queries database = new Queries();
    Alert error = new Alert(Alert.AlertType.ERROR);
    Alert failed = new Alert(Alert.AlertType.ERROR);
    Alert info = new Alert(Alert.AlertType.INFORMATION);

    String roomId;
    String totBeds;
    String status;
    String charge;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 100, 3);
        beds.setValueFactory(valueFactory);

        filled.setToggleGroup(toggle);
        unfilled.setToggleGroup(toggle);
        toggle.selectToggle(unfilled);

        roomNo.setText(String.valueOf(database.getNewRoomNo()));


        error.setContentText("Please fill all the entries in correct format.");
        failed.setContentText("Failed to save the data.");
        info.setContentText("Room data saved successfully.");
    }

    @FXML
    private void backToOptions() throws IOException {
        Parent patientEntry = FXMLLoader.load(getClass().getResource("../../View/startupPage.fxml"));
        back.getScene().setRoot(patientEntry);
    }

    public boolean isEmpty() {
        return roomNo.getText().isBlank() ||
                charges.getText().isBlank();
    }


    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    @FXML
    private void confirmData() {

        // Error Blank
        if (isEmpty()) {
            error.showAndWait();
        }
        // if no error then save Entry
        else {
            initializeValues();
            try {
                database.insertRoom(roomId, totBeds, status, charge);
                info.showAndWait();
                back.fire();
            }
            catch (SQLException throwables) {
                throwables.printStackTrace();
                failed.showAndWait();
            }
        }
    }

    public void initializeValues() {
        roomId = roomNo.getText();
        charge = charges.getText();
        totBeds = String.valueOf(beds.getValue());
        if (toggle.getSelectedToggle() == unfilled){
            status = "0";
        }
        else {
            status = "1";
        }
    }

}

