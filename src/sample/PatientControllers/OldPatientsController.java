package sample.PatientControllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.Database;
import sample.TableModels.OldPatientModel;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.ResourceBundle;

public class OldPatientsController implements Initializable {

    // Button from the options scene
    @FXML
    private TableView<OldPatientModel> allOldPatTable;

    Database database = new Database();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        TableColumn<OldPatientModel, String> column1 = new TableColumn<>("ID");
        column1.setCellValueFactory(new PropertyValueFactory<>("patId"));

        TableColumn<OldPatientModel, String> column2 = new TableColumn<>("Name");
        column2.setCellValueFactory(new PropertyValueFactory<>("patName"));

        TableColumn<OldPatientModel, String> column3 = new TableColumn<>("Room N0");
        column3.setCellValueFactory(new PropertyValueFactory<>("roomNo"));

        TableColumn<OldPatientModel, String> column4 = new TableColumn<>("Contact");
        column4.setCellValueFactory(new PropertyValueFactory<>("contact"));

        TableColumn<OldPatientModel, String> column5 = new TableColumn<>("Address");
        column5.setCellValueFactory(new PropertyValueFactory<>("address"));

        TableColumn<OldPatientModel, String> column6 = new TableColumn<>("Admit Date");
        column6.setCellValueFactory(new PropertyValueFactory<>("admit"));

        TableColumn<OldPatientModel, String> column7 = new TableColumn<>("Discharge Date");
        column7.setCellValueFactory(new PropertyValueFactory<>("discharge"));

        TableColumn<OldPatientModel, String> column8 = new TableColumn<>("Disease");
        column8.setCellValueFactory(new PropertyValueFactory<>("disease"));

        TableColumn<OldPatientModel, String> column9 = new TableColumn<>("Prescription");
        column9.setCellValueFactory(new PropertyValueFactory<>("prescription"));

        TableColumn<OldPatientModel, String> column10 = new TableColumn<>("Doctor");
        column10.setCellValueFactory(new PropertyValueFactory<>("docName"));



        allOldPatTable.getColumns().addAll(column1, column2, column3, column4, column5, column6, column7, column8, column9, column10);
        addData();

    }

    @FXML
    private void backToOptions(ActionEvent event) throws IOException {
        Parent patientEntry = FXMLLoader.load(getClass().getResource("../../fxfiles/PatientFxml/newOrEdit.fxml"));
        allOldPatTable.getScene().setRoot(patientEntry);
    }


    public void addData() {
        String patient[] = new String[10];
        try {
            ResultSet data =  database.getOldPatientsView();

            while (data.next()) {
                patient[0] = data.getString("id");
                patient[1] = data.getString("name");
                patient[2] = data.getString("roomNo");
                patient[3] = data.getString("contact");
                patient[4] = data.getString("address");
                patient[5] = data.getString("admit");
                patient[6] = data.getString("discharge");
                patient[7] = data.getString("disease");
                patient[8] = data.getString("prescription");
                patient[9] = data.getString("doctor");
                System.out.println(Arrays.toString(patient));
                allOldPatTable.getItems().addAll(new OldPatientModel(patient[0], patient[1], patient[2], patient[3], patient[4], patient[5], patient[6], patient[7], patient[8], patient[9]));
            }

            data.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}

