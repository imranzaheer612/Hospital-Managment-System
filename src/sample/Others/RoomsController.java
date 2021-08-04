package sample.Others;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class RoomsController implements Initializable {

    @FXML
    private Button back;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }


    @FXML
    private void addRoom(ActionEvent event) throws IOException {
        Parent roomEntryPage = FXMLLoader.load(getClass().getResource("../../fxfiles/Others/addRoom.fxml"));
        back.getScene().setRoot(roomEntryPage);
    }

    @FXML
    private void allRooms(ActionEvent event) throws IOException {
        Parent roomsTabel = FXMLLoader.load(getClass().getResource("../../fxfiles/Others/allRooms.fxml"));
        back.getScene().setRoot(roomsTabel);
    }

    // Return back to the main screen
    @FXML
    private void backToMenu(ActionEvent event) throws IOException {
        Parent startPage = FXMLLoader.load(getClass().getResource("../../fxfiles/Others/startupPage.fxml"));
        back.getScene().setRoot(startPage);
    }

}