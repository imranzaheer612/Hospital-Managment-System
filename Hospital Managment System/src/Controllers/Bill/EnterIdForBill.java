package Controllers.Bill;

import javafx.event.ActionEvent;
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

public class EnterIdForBill implements Initializable {

    @FXML
    private Button back;
    @FXML
    private Button confirmID;
    @FXML
    public TextField enterPatId;

    Queries database = new Queries();
    Alert error = new Alert(Alert.AlertType.ERROR);
    Alert failed = new Alert(Alert.AlertType.ERROR);

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        error.setContentText("Please fill all the entries in correct format.");
        failed.setContentText("Failed to find id.");
    }

    // Going to the previous Page
    @FXML
    private void backToOptions(ActionEvent event) throws IOException {
        Parent patientEntry = FXMLLoader.load(getClass().getResource("../../View/startupPage.fxml"));
        back.getScene().setRoot(patientEntry);
    }

    // if ID is correct move to the Next Page
    @FXML
    private void nextScene(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../../View/Bill/getbill.fxml"));

        // passing patient id to be used in the next scene
        GenerateBill controller =  new GenerateBill();
        controller.initData(enterPatId.getText());

        loader.setController(controller);
        Parent billEntry  = loader.load();

        if (confirmId(enterPatId.getText())) {
            confirmID.getScene().setRoot(billEntry);
        }
        else
            System.out.println("error here");
    }

    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }

    public boolean idExists(String id) {
        try {
            if(database.patientExists(Integer.parseInt(id))) {
                return true;
            }
            else {
                failed.showAndWait();
                return false;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            failed.showAndWait();
        }
        return false;
    }

    public boolean confirmId(String id) {
        if (!isNumeric(id)) {
            error.showAndWait();
        }
        return idExists(id);
    }

    public String getEnterPatId() {
        return enterPatId.getText();
    }

}
