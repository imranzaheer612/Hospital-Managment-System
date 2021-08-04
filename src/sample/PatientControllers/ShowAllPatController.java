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
import sample.TableModels.PatientModel;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.ResourceBundle;

public class ShowAllPatController implements Initializable {

    // Button from the options scene
    @FXML
    private TableView<PatientModel> allPatTable;

    Database database = new Database();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        TableColumn<PatientModel, String> column1 = new TableColumn<>("ID");
        column1.setCellValueFactory(new PropertyValueFactory<>("patId"));

        TableColumn<PatientModel, String> column2 = new TableColumn<>("Name");
        column2.setCellValueFactory(new PropertyValueFactory<>("patName"));

        TableColumn<PatientModel, String> column3 = new TableColumn<>("Room N0");
        column3.setCellValueFactory(new PropertyValueFactory<>("roomNo"));

        TableColumn<PatientModel, String> column4 = new TableColumn<>("Contact");
        column4.setCellValueFactory(new PropertyValueFactory<>("contact"));

        TableColumn<PatientModel, String> column5 = new TableColumn<>("Address");
        column5.setCellValueFactory(new PropertyValueFactory<>("address"));

        TableColumn<PatientModel, String> column6 = new TableColumn<>("Admit Date");
        column6.setCellValueFactory(new PropertyValueFactory<>("admit"));

        TableColumn<PatientModel, String> column7 = new TableColumn<>("Disease");
        column7.setCellValueFactory(new PropertyValueFactory<>("disease"));

        TableColumn<PatientModel, String> column8 = new TableColumn<>("Prescription");
        column8.setCellValueFactory(new PropertyValueFactory<>("prescription"));

        TableColumn<PatientModel, String> column9 = new TableColumn<>("Doctor");
        column9.setCellValueFactory(new PropertyValueFactory<>("docName"));



        allPatTable.getColumns().addAll(column1, column2, column3, column4, column5, column6, column7, column8, column9);
        addData();

    }

    @FXML
    private void backToOptions(ActionEvent event) throws IOException {
        Parent patientEntry = FXMLLoader.load(getClass().getResource("../../fxfiles/PatientFxml/newOrEdit.fxml"));
        allPatTable.getScene().setRoot(patientEntry);
    }


    public void addData() {
        String patient[] = new String[9];
        try {
            ResultSet data =  database.getPatientsView();

            while (data.next()) {
                patient[0] = data.getString("id");
                patient[1] = data.getString("name");
                patient[2] = data.getString("roomNo");
                patient[3] = data.getString("contact");
                patient[4] = data.getString("address");
                patient[5] = data.getString("admit");
                patient[6] = data.getString("disease");
                patient[7] = data.getString("prescription");
                patient[8] = data.getString("doctor");
                System.out.println(Arrays.toString(patient));
                allPatTable.getItems().addAll(new PatientModel(patient[0], patient[1], patient[2], patient[3], patient[4], patient[5], patient[6], patient[7], patient[8]));
            }

            data.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


}