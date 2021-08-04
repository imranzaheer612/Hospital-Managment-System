package sample.DoctorControllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.Database;
import sample.TableModels.DoctorModel;
import sample.TableModels.PatientModel;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.ResourceBundle;

public class ShowAllDocController implements Initializable {

    @FXML
    private TableView<DoctorModel> allDocTable;

    Database database = new Database();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        TableColumn<DoctorModel, String> column1 = new TableColumn<>("ID");
        column1.setCellValueFactory(new PropertyValueFactory<>("docId"));

        TableColumn<DoctorModel, String> column2 = new TableColumn<>("Name");
        column2.setCellValueFactory(new PropertyValueFactory<>("docName"));

        TableColumn<DoctorModel, String> column3 = new TableColumn<>("Charge");
        column3.setCellValueFactory(new PropertyValueFactory<>("charge"));

        TableColumn<DoctorModel, String> column4 = new TableColumn<>("Specialization");
        column4.setCellValueFactory(new PropertyValueFactory<>("specialization"));

        TableColumn<DoctorModel, String> column5 = new TableColumn<>("Age");
        column5.setCellValueFactory(new PropertyValueFactory<>("age"));

        TableColumn<DoctorModel, String> column6 = new TableColumn<>("Address");
        column6.setCellValueFactory(new PropertyValueFactory<>("address"));

        TableColumn<DoctorModel, String> column7 = new TableColumn<>("Contact");
        column7.setCellValueFactory(new PropertyValueFactory<>("contact"));

        allDocTable.getColumns().addAll(column1, column2, column3, column4, column5, column6, column7);
        addData();

    }


    @FXML
    private void backToOptions(ActionEvent event) throws IOException {
        Parent patientEntry = FXMLLoader.load(getClass().getResource("../../fxfiles/DoctorFxml/options.fxml"));
        allDocTable.getScene().setRoot(patientEntry);
    }


    public void addData() {
        String doctor[] = new String[7];
        try {
            ResultSet data =  database.getDoctors();

            while (data.next()) {
                doctor[0] = data.getString("doc_id");
                doctor[1] = data.getString("doc_name");
                doctor[2] = data.getString("charge");
                doctor[3] = data.getString("specialization");
                doctor[4] = data.getString("age");
                doctor[5] = data.getString("address");
                doctor[6] = data.getString("contact");
                System.out.println(Arrays.toString(doctor));
                allDocTable.getItems().addAll(new DoctorModel(doctor[0], doctor[1], doctor[2], doctor[3], doctor[4], doctor[5], doctor[6]));
            }

            data.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


}
