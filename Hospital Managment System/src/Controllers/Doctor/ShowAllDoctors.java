package Controllers.Doctor;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import Controllers.Database.Queries;
import Models.Doctor;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ShowAllDoctors implements Initializable {

    @FXML
    private TableView<Doctor> allDocTable;

    Queries database = new Queries();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        TableColumn<Doctor, String> column1 = new TableColumn<>("ID");
        column1.setCellValueFactory(new PropertyValueFactory<>("docId"));

        TableColumn<Doctor, String> column2 = new TableColumn<>("Name");
        column2.setCellValueFactory(new PropertyValueFactory<>("docName"));

        TableColumn<Doctor, String> column3 = new TableColumn<>("Charge");
        column3.setCellValueFactory(new PropertyValueFactory<>("charge"));

        TableColumn<Doctor, String> column4 = new TableColumn<>("Specialization");
        column4.setCellValueFactory(new PropertyValueFactory<>("specialization"));

        TableColumn<Doctor, String> column5 = new TableColumn<>("Age");
        column5.setCellValueFactory(new PropertyValueFactory<>("age"));

        TableColumn<Doctor, String> column6 = new TableColumn<>("Address");
        column6.setCellValueFactory(new PropertyValueFactory<>("address"));

        TableColumn<Doctor, String> column7 = new TableColumn<>("Contact");
        column7.setCellValueFactory(new PropertyValueFactory<>("contact"));

        allDocTable.getColumns().addAll(column1, column2, column3, column4, column5, column6, column7);
        addData();

    }


    @FXML
    private void backToOptions(ActionEvent event) throws IOException {
        Parent patientEntry = FXMLLoader.load(getClass().getResource("../../View/Doctor/options.fxml"));
        allDocTable.getScene().setRoot(patientEntry);
    }


    public void addData() {
        try {
            ResultSet data =  database.getDoctors();

            while (data.next()) {
                Doctor doctor = new Doctor();
                doctor.setDocId(data.getString("doc_id"));
                doctor.setDocName(data.getString("doc_name"));
                doctor.setCharge(data.getString("charge"));
                doctor.setSpecialization(data.getString("specialization"));
                doctor.setAge(data.getString("age"));
                doctor.setAddress(data.getString("address"));
                doctor.setContact(data.getString("contact"));

                doctor.toString();
                allDocTable.getItems().addAll(doctor);
            }

            data.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


}
