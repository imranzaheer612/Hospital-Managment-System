package sample.Others;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.Database;
import sample.TableModels.BillsModel;
import sample.TableModels.RoomModel;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.ResourceBundle;

public class AllBillsTable  implements Initializable {

    // Button from the options scene
    @FXML
    private TableView<BillsModel> allBillsTable;

    Database database = new Database();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        TableColumn<BillsModel, String> column1 = new TableColumn<>("Patient ID");
        column1.setCellValueFactory(new PropertyValueFactory<>("patId"));

        TableColumn<BillsModel, String> column2 = new TableColumn<>("Patient Name");
        column2.setCellValueFactory(new PropertyValueFactory<>("p_name"));

        TableColumn<BillsModel, String> column3 = new TableColumn<>("Room Charge");
        column3.setCellValueFactory(new PropertyValueFactory<>("roomCharge"));

        TableColumn<BillsModel, String> column4 = new TableColumn<>("Doctor Charge");
        column4.setCellValueFactory(new PropertyValueFactory<>("docCharge"));

        TableColumn<BillsModel, String> column5 = new TableColumn<>("Days Spent");
        column5.setCellValueFactory(new PropertyValueFactory<>("days"));

        TableColumn<BillsModel, String> column6 = new TableColumn<>("Other Charges");
        column6.setCellValueFactory(new PropertyValueFactory<>("otherCharges"));

        TableColumn<BillsModel, String> column7 = new TableColumn<>("Total Bill");
        column7.setCellValueFactory(new PropertyValueFactory<>("totBill"));

        allBillsTable.getColumns().addAll(column1, column2, column3, column4, column5, column6, column7);
        addData();

    }

    @FXML
    private void backToOptions(ActionEvent event) throws IOException {
        Parent patientEntry = FXMLLoader.load(getClass().getResource("../../fxfiles/Others/startupPage.fxml"));
        allBillsTable.getScene().setRoot(patientEntry);
    }


    public void addData() {
        String room[] = new String[7];
        try {
            ResultSet data = database.getBills();

            while (data.next()) {
                room[0] = data.getString("patId");
                room[1] = data.getString("p_name");
                room[2] = data.getString("roomCharge");
                room[3] = data.getString("docCharge");
                room[4] = data.getString("days");
                room[5] = data.getString("otherCharges");
                room[6] = data.getString("totbill");

                System.out.println(Arrays.toString(room));
                allBillsTable.getItems().addAll(new BillsModel(room[0], room[1], room[2], room[3], room[4], room[5], room[6]));
            }

            data.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
