import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {



        Parent root =
                FXMLLoader.load(getClass().getResource("./View/UserAuthentication/loginPage.fxml"));
        // Parent root = FXMLLoader.load(getClass().getResource("./View/startupPage.fxml"));
        primaryStage.setTitle("Hospital");
        primaryStage.setScene(new Scene(root));
        primaryStage.setHeight(700);
        primaryStage.setWidth(1000);
        primaryStage.show();
    }



    public static void main(String[] args) {
        launch(args);
    }
}
