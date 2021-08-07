package Controllers.Room;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import Controllers.Database.Queries;
import Models.Room;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class AllRooms implements Initializable {

    // Button from the options scene
    @FXML
    private TableView<Room> allRoomsTable;

    Queries database = new Queries();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        TableColumn<Room, String> column1 = new TableColumn<>("Room No");
        column1.setCellValueFactory(new PropertyValueFactory<>("roomNo"));

        TableColumn<Room, String> column2 = new TableColumn<>("Beds");
        column2.setCellValueFactory(new PropertyValueFactory<>("beds"));

        TableColumn<Room, String> column3 = new TableColumn<>("Status");
        column3.setCellValueFactory(new PropertyValueFactory<>("status"));

        TableColumn<Room, String> column4 = new TableColumn<>("Charge");
        column4.setCellValueFactory(new PropertyValueFactory<>("charge"));

        allRoomsTable.getColumns().addAll(column1, column2, column3, column4);
        addData();

    }

    @FXML
    private void backToOptions(ActionEvent event) throws IOException {
        Parent patientEntry = FXMLLoader.load(getClass().getResource("../../View/startupPage.fxml"));
        allRoomsTable.getScene().setRoot(patientEntry);
    }


    public void addData() {
        try {
            ResultSet data = database.getAllRooms();

            while (data.next()) {
                Room room = new Room();
                room.setRoomNo(data.getString("roomNo"));
                room.setBeds(data.getString("beds"));
                room.setStatus(data.getString("status"));
                room.setCharge(data.getString("charge"));
                room.toString();
                allRoomsTable.getItems().addAll(room);
            }

            data.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
