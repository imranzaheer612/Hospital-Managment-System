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
import sample.TableModels.RoomModel;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.ResourceBundle;

public class AllRoomsController implements Initializable {

    // Button from the options scene
    @FXML
    private TableView<RoomModel> allRoomsTable;

    Database database = new Database();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        TableColumn<RoomModel, String> column1 = new TableColumn<>("Room No");
        column1.setCellValueFactory(new PropertyValueFactory<>("roomNo"));

        TableColumn<RoomModel, String> column2 = new TableColumn<>("Beds");
        column2.setCellValueFactory(new PropertyValueFactory<>("beds"));

        TableColumn<RoomModel, String> column3 = new TableColumn<>("Status");
        column3.setCellValueFactory(new PropertyValueFactory<>("status"));

        TableColumn<RoomModel, String> column4 = new TableColumn<>("Charge");
        column4.setCellValueFactory(new PropertyValueFactory<>("charge"));

        allRoomsTable.getColumns().addAll(column1, column2, column3, column4);
        addData();

    }

    @FXML
    private void backToOptions(ActionEvent event) throws IOException {
        Parent patientEntry = FXMLLoader.load(getClass().getResource("../../fxfiles/Others/startupPage.fxml"));
        allRoomsTable.getScene().setRoot(patientEntry);
    }


    public void addData() {
        String room[] = new String[4];
        try {
            ResultSet data = database.getAllRooms();

            while (data.next()) {
                room[0] = data.getString("roomNo");
                room[1] = data.getString("beds");
                room[2] = data.getString("status");
                room[3] = data.getString("charge");
                System.out.println(Arrays.toString(room));
                allRoomsTable.getItems().addAll(new RoomModel(room[0], room[1], room[2], room[3]));
            }

            data.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
