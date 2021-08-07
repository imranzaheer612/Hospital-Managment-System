package Controllers.Patient;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import Controllers.Database.Queries;
import Models.Patient;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class AllDischargedPatients implements Initializable {

    // Button from the options scene
    @FXML
    private TableView<Patient> allOldPatTable;

    Queries database = new Queries();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        TableColumn<Patient, String> column1 = new TableColumn<>("ID");
        column1.setCellValueFactory(new PropertyValueFactory<>("patId"));

        TableColumn<Patient, String> column2 = new TableColumn<>("Name");
        column2.setCellValueFactory(new PropertyValueFactory<>("patName"));

        TableColumn<Patient, String> column3 = new TableColumn<>("Room N0");
        column3.setCellValueFactory(new PropertyValueFactory<>("roomNo"));

        TableColumn<Patient, String> column4 = new TableColumn<>("Contact");
        column4.setCellValueFactory(new PropertyValueFactory<>("contact"));

        TableColumn<Patient, String> column5 = new TableColumn<>("Address");
        column5.setCellValueFactory(new PropertyValueFactory<>("address"));

        TableColumn<Patient, String> column6 = new TableColumn<>("Admit Date");
        column6.setCellValueFactory(new PropertyValueFactory<>("admit"));

        TableColumn<Patient, String> column7 = new TableColumn<>("Discharge Date");
        column7.setCellValueFactory(new PropertyValueFactory<>("discharge"));

        TableColumn<Patient, String> column8 = new TableColumn<>("Disease");
        column8.setCellValueFactory(new PropertyValueFactory<>("disease"));

        TableColumn<Patient, String> column9 = new TableColumn<>("Prescription");
        column9.setCellValueFactory(new PropertyValueFactory<>("prescription"));

        TableColumn<Patient, String> column10 = new TableColumn<>("Doctor");
        column10.setCellValueFactory(new PropertyValueFactory<>("docName"));



        allOldPatTable.getColumns().addAll(column1, column2, column3, column4, column5, column6, column7, column8, column9, column10);
        addData();

    }

    @FXML
    private void backToOptions(ActionEvent event) throws IOException {
        Parent patientEntry = FXMLLoader.load(getClass().getResource("../../View/Patient/newOrEdit.fxml"));
        allOldPatTable.getScene().setRoot(patientEntry);
    }


    public void addData() {

        try {
            ResultSet data =  database.getOldPatientsView();

            while (data.next()) {
                Patient patient = new Patient();
                patient.setPatId(data.getString("id"));
                patient.setPatName(data.getString("name"));
                patient.setRoomNo(data.getString("roomNo"));
                patient.setContact(data.getString("contact"));
                patient.setAddress(data.getString("address"));
                patient.setAdmit(data.getString("admit"));
                patient.setDischarge(data.getString("discharge"));
                patient.setDisease(data.getString("disease"));
                patient.setPrescription(data.getString("prescription"));
                patient.setDocName(data.getString("doctor"));

                patient.toString();
                allOldPatTable.getItems().addAll(patient);
            }

            data.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}

