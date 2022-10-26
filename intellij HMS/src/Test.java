import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import Controllers.Database.Queries;
/**
 * Testing the database
 */
public class Test {


    public static void main(String[] args) throws SQLException {

        // Testing the Database
        testingDB();
        presentDateTime();
    }


    public static String presentDateTime() {
        LocalDateTime localDate = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String date = localDate.format(format);;
        return date;
    }


    public static void testingDB() throws SQLException {
        Queries database = new Queries();

        // printing all Patients
        database.printAllPatient();

        System.out.println("Check if patient id 4 exists: ");

        /*
         * Check if a patient exists --> if yes return its attributes
         */
        if (database.patientExists(4)) {
            System.out.println("Exists");
            // returning attributes
            String[] patient = database.getPatient(4);
            System.out.println(Arrays.toString(patient));
        } else
            System.out.println("Not Exists!");
    }
}
