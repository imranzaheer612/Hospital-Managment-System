package Controllers.UserAuthentication;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
import Controllers.Database.Queries;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.sql.SQLException;

/**
 * It will show all the available
 * options related to the management process
 * of the hospital
 * */


public class AddNewUser implements Initializable {

    @FXML
    private Button addnew;
    @FXML
    private TextField user;
    @FXML
    private PasswordField pass ;
    @FXML
    private Button back;

    private final Queries database = new Queries();
    private final Alert error = new Alert(Alert.AlertType.ERROR);
    private final Alert failed = new Alert(Alert.AlertType.ERROR);
    private final Alert info = new Alert(Alert.AlertType.INFORMATION);

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        failed.setContentText("Failed to save the data.");
        info.setContentText("New User added successfully.");
    }
    public boolean isEmpty() {
        return user.getText().isBlank() ||
                pass.getText().isBlank();
    }


    public boolean confirmData() {
        try {
            boolean usernameCheck = database.usernameCheck(user.getText());

            if (isEmpty()) {
                error.setContentText("Please enter data in correct format!");
                error.showAndWait();
            }
            else if (usernameCheck) {
                error.setContentText("USER NAME ALREADY EXISTS!");
                error.showAndWait();
            }
            else{
                database.newUser(user.getText(),pass.getText());
                info.showAndWait();
                return true;
            }
        }catch (SQLException throwables) {
            throwables.printStackTrace();
            failed.showAndWait();
        }
        return false;
    }

    @FXML
    private void backLogin(ActionEvent event) throws IOException {
        Parent startup = FXMLLoader.load(getClass().getResource("../../View/startupPage.fxml"));
        back.getScene().setRoot(startup);
    }

}