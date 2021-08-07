package Controllers;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

//        Testing the Database
//        testingDB();
//        presentDateTime();


        Parent root = FXMLLoader.load(getClass().getResource("../View/UserAuthentication/loginPage.fxml"));
//        Parent root = FXMLLoader.load(getClass().getResource("../View/startupPage.fxml"));
        primaryStage.setTitle("Hospital");
        primaryStage.setScene(new Scene(root));
        primaryStage.setHeight(700);
        primaryStage.setWidth(1000);
        primaryStage.show();
    }








//    public String presentDateTime() {
//        LocalDateTime localDate = LocalDateTime.now();
//        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
//        String date = localDate.format(format);;
//        return date;
//    }


//    public static void testingDB() {
//        Database database = new Database();
//        // printing all Patients
//        database.printAllPatient();
//
//        System.out.println("Check if patient id 4 exists: ");
//
//        /*
//        * Check if a patient exists
//        * --> if yes return its attributes
//        * */
//        if(database.patientExists(4)) {
//            System.out.println("Exists");
//            // returning attributes
//            String[] patient = database.getPatient(4);
//            System.out.println(Arrays.toString(patient));
//        }
//        else
//            System.out.println("Not Exists!");
//    }

    public static void main(String[] args) {
        launch(args);
    }
}
