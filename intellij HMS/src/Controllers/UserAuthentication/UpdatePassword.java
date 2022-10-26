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


public class UpdatePassword implements Initializable {

    @FXML
    private Button b_update;
    @FXML
    private TextField user;
    @FXML
    private PasswordField old ;
    @FXML
    private PasswordField newpass;
    @FXML
    private Button b_back;

    private final Queries database = new Queries();
    private final Alert error = new Alert(Alert.AlertType.ERROR);
    private final Alert failed = new Alert(Alert.AlertType.ERROR);
    private final Alert info = new Alert(Alert.AlertType.INFORMATION);

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        error.setContentText("Please fill all the entries in correct format.");
        failed.setContentText("Failed to save the data.");
        info.setContentText("Password Updated Successfully.");
    }
    public boolean isEmpty() {
        return user.getText().isBlank() ||
                old.getText().isBlank()||
                newpass.getText().isBlank();
    }

    public boolean bothIdExists() {
        try {
            boolean usernamePassCheck = database.usernamePassCheck(user.getText(),old.getText());
            if (!usernamePassCheck || newpass.getText().isBlank()) {
                error.setContentText("INVALID USERNAME AND PASSWORD!");
                error.showAndWait();
            }
            else {
                database.updatePassword(newpass.getText(),user.getText());
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
    private void updatePassword(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../../View/UserAuthentication/loginSetting.fxml"));
        Parent diagnosisEntry  = loader.load();

        if (bothIdExists()) {
            b_update.getScene().setRoot(diagnosisEntry);
        }
        else
            System.out.println("error here");
    }
    @FXML
    private void back(ActionEvent event) throws IOException {
        Parent startup = FXMLLoader.load(getClass().getResource("../../View/startupPage.fxml"));
        b_back.getScene().setRoot(startup);
    }

}