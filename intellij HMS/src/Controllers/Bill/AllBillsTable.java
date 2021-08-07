package Controllers.Bill;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import Controllers.Database.Queries;
import Models.Bill;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class AllBillsTable  implements Initializable {

    // Button from the options scene
    @FXML
    private TableView<Bill> allBillsTable;

    Queries database = new Queries();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        TableColumn<Bill, String> column1 = new TableColumn<>("Patient ID");
        column1.setCellValueFactory(new PropertyValueFactory<>("patId"));

        TableColumn<Bill, String> column2 = new TableColumn<>("Patient Name");
        column2.setCellValueFactory(new PropertyValueFactory<>("p_name"));

        TableColumn<Bill, String> column3 = new TableColumn<>("Room Charge");
        column3.setCellValueFactory(new PropertyValueFactory<>("roomCharge"));

        TableColumn<Bill, String> column4 = new TableColumn<>("Doctor Charge");
        column4.setCellValueFactory(new PropertyValueFactory<>("docCharge"));

        TableColumn<Bill, String> column5 = new TableColumn<>("Days Spent");
        column5.setCellValueFactory(new PropertyValueFactory<>("days"));

        TableColumn<Bill, String> column6 = new TableColumn<>("Other Charges");
        column6.setCellValueFactory(new PropertyValueFactory<>("otherCharges"));

        TableColumn<Bill, String> column7 = new TableColumn<>("Total Bill");
        column7.setCellValueFactory(new PropertyValueFactory<>("totBill"));

        allBillsTable.getColumns().addAll(column1, column2, column3, column4, column5, column6, column7);
        addData();

    }

    @FXML
    private void backToOptions(ActionEvent event) throws IOException {
        Parent patientEntry = FXMLLoader.load(getClass().getResource("../../View/startupPage.fxml"));
        allBillsTable.getScene().setRoot(patientEntry);
    }


    public void addData() {
        String room[] = new String[7];
        try {
            ResultSet data = database.getBills();

            while (data.next()) {
                Bill bill = new Bill();
                bill.setPatId(data.getString("patId"));
                bill.setP_name(data.getString("p_name"));
                bill.setRoomCharge(data.getString("roomCharge"));
                bill.setDocCharge(data.getString("docCharge"));
                bill.setDays(data.getString("days"));
                bill.setOtherCharges(data.getString("days"));
                bill.setTotBill(data.getString("totbill"));
                bill.toString();

                allBillsTable.getItems().addAll(bill);
            }

            data.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
