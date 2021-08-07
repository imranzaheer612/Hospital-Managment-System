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

public class GenerateBill implements Initializable {

    @FXML
    private TextField patid;
    @FXML
    private TextField name;
    @FXML
    private TextField roomCharge;
    @FXML
    private TextField docCharge;
    @FXML
    private TextField daysSpend;
    @FXML
    private TextField otherCharges;
    @FXML
    private TextField totBill;
    @FXML
    private Button calculate;
    @FXML
    public Button back;
    @FXML
    public Button save;

    Queries database = new Queries();
    Alert error = new Alert(Alert.AlertType.ERROR);
    Alert failed = new Alert(Alert.AlertType.ERROR);
    Alert info = new Alert(Alert.AlertType.INFORMATION);

    String patientId;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            System.out.println("pat id entered: " + patientId);

            String[] bill = database.getBillDetails(patientId);
            patid.setText(bill[0]);
            name.setText(bill[1]);
            roomCharge.setText(bill[2]);
            docCharge.setText(bill[3]);
            daysSpend.setText(bill[4]);
            totBill.setText(bill[6]);
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        error.setContentText("Please fill all the entries in correct format.");
        failed.setContentText("Failed to save the data.");
        info.setContentText("Patient data saved successfully.");
    }

    @FXML
    private void backToOptions(ActionEvent event) throws IOException {
        Parent patientEntry = FXMLLoader.load(getClass().getResource("../../View/startupPage.fxml"));
        back.getScene().setRoot(patientEntry);
    }

    public void initData (String id) {
        patientId = id;
    }

    public boolean isEmpty() {
        return patid.getText().isBlank() ||
                name.getText().isBlank() ||
                totBill.getText() == null;
    }


    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }

    @FXML
    private void confirmData() {

        // Error Blank
        if (isEmpty()) {
            error.showAndWait();
        }
        // Error Format
        else if (!isNumeric(otherCharges.getText())) {
            error.showAndWait();
        }
        // if no error then save Entry
        else {
            try {
                database.insertBill(patientId,String.valueOf(calculateBill()));
                info.showAndWait();
                back.fire();
            }
            catch (SQLException throwables) {
                throwables.printStackTrace();
                failed.showAndWait();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public boolean areNumeric() {
        return isNumeric(roomCharge.getText()) &&
                isNumeric(daysSpend.getText()) &&
                isNumeric(otherCharges.getText()) &&
                isNumeric(docCharge.getText());
    }

    @FXML
    public double calculateBill() throws Exception{

        if (areNumeric()) {
            int days = Integer.parseInt(daysSpend.getText());
            double roomChrge = Double.parseDouble(roomCharge.getText());
            double doctorCharge = Double.parseDouble(docCharge.getText());
            double others = Double.parseDouble(otherCharges.getText());
            double total = (roomChrge*days)+others+doctorCharge;
            totBill.setText(String.valueOf(total));
            return total;
        }
        else {
            error.showAndWait();
            return 0;
        }
    }

}
