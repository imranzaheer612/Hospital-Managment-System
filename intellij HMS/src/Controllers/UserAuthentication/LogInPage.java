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


public class LogInPage implements Initializable {

    @FXML
    private Button submit;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password ;

    private final Queries database = new Queries();
    private final Alert error = new Alert(Alert.AlertType.ERROR);
    private final Alert failed = new Alert(Alert.AlertType.ERROR);
    private final Alert info = new Alert(Alert.AlertType.INFORMATION);

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        error.setContentText("Please fill all the entries in correct format.");
        failed.setContentText("Database error!.");
        info.setContentText("Doctor assigned successfully.");
    }

    public boolean isEmpty() {
        return username.getText().isBlank() ||
                password.getText().isBlank();
    }

    public boolean confirmData() {
       try {
           boolean usernamePassCheck = database.usernamePassCheck(username.getText(),password.getText());
           if (!usernamePassCheck || isEmpty()) {
               error.setContentText("INVALID USERNAME AND PASSWORD!");
               error.showAndWait();
           }
           return usernamePassCheck;
       }
       catch (SQLException throwables) {
           throwables.printStackTrace();
           failed.showAndWait();
       }
       return false;
    }
    @FXML
    private void startup(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../../View/startupPage.fxml"));
        Parent diagnosisEntry  = loader.load();

        if (confirmData()) {
            submit.getScene().setRoot(diagnosisEntry);
        }

    }
}