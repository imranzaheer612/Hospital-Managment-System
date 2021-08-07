package Controllers.Patient;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class AssignRoom implements Initializable {

    // Button from the options scene
    @FXML
    private Button confirmRoomEntry;
    @FXML
    private DatePicker roomEntry;

    // This comboBox will show the Rooms Available
    @FXML
    private ComboBox<String> roomsAvailable;

    /*
    * This Method will be used in initializing some variables
    *  */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // room Entry will show today' date
        roomEntry.setValue(LocalDate.now());
    }

    // Going Back to the previous page
    @FXML
    private void backToOptions(ActionEvent event) throws IOException {
        Parent optionsPage = FXMLLoader.load(getClass().getResource("../../View/Patient/options.fxml"));
        confirmRoomEntry.getScene().setRoot(optionsPage);
    }


}
