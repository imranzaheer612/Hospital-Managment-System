package Controllers.Database;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class Queries {

    java.sql.Connection connection = Connection.connector();
    Statement stmt = null;

    public void printAllPatient() {

        // this array will store the patient attributes
        String[] patient = new String[7];
        // writing query
        String sql = "SELECT * FROM patient";
        // Result set actually contains the the resultant set (rows) of the query
        ResultSet rs;

        try {
            stmt = connection.createStatement();
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                patient[0] = rs.getString("patid");
                patient[1] = rs.getString("p_name");
                patient[2] = rs.getString("dateofbirth");
                patient[3] = rs.getString("gender");
                patient[4] = rs.getString("weight");
                patient[5] = rs.getString("address");
                patient[6] = rs.getString("contact");

                System.out.println(Arrays.toString(patient));
            }
            rs.close();
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    /**
     * Returning true if the Patient exists in the
     * Database
     * * */


    public boolean patientExists(int id) throws SQLException {
        boolean exists = false;
        String query = "SELECT patid FROM patient WHERE patId = " + id + "";
        ResultSet rs;

        stmt = connection.createStatement();
        rs = stmt.executeQuery(query);

        if (rs.next()) {
                exists = true;
        }

        return  exists;
    }

    public boolean doctorExists(int id) throws SQLException {
        boolean exists = false;
        String query = "SELECT doc_id FROM doctor WHERE doc_id = " + id + "";
        ResultSet rs;

        stmt = connection.createStatement();
        rs = stmt.executeQuery(query);

        if (rs.next()) {
                exists = true;
        }

        return  exists;
    }



    public void doctorDelete(String id) throws SQLException {
        String query = "DELETE FROM doctor WHERE doc_id = " + id + "";
        PreparedStatement stmt = connection.prepareStatement(query);
        stmt.executeUpdate();
    }

    /**
     * Returning all the attributes of the specific patient
     * */

    public String[] getPatient(int id) {

        String[] patient = new String[7];
        String query = "SELECT * FROM patient WHERE patid = " + id + "";
        ResultSet rs;

        try {
            stmt = connection.createStatement();
            rs = stmt.executeQuery(query);

            if (rs.next()) {
                patient[0] = rs.getString("patid");
                patient[1] = rs.getString("p_name");
                patient[2] = rs.getString("dateofbirth");
                patient[3] = rs.getString("gender");
                patient[4] = rs.getString("weight");
                patient[5] = rs.getString("address");
                patient[6] = rs.getString("contact");
                return patient;
            }
            else
                System.out.println("No data found!");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return  patient;
    }

    public String presentDateTime() {
        LocalDateTime localDate = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
        String date = localDate.format(format);;
        return date;
    }

    public String getEntryId() throws SQLException {
        String query = "select max(entryId) + 1 as id from daterecord";
        PreparedStatement stmt = connection.prepareStatement(query);
        ResultSet rs = stmt.executeQuery();
        String id = "";
        if (rs.next()) {
            id = rs.getString("id");
        }
        return id;
    }

    public void insertDate(String patId, java.sql.Date dateOfDisease) throws SQLException {
        String query = "INSERT INTO daterecord VALUES (?, ?, ?, ?, ?)";

        PreparedStatement stmt = connection.prepareStatement(query);
        stmt.setString(1, getEntryId());
        stmt.setString(2, patId);
        stmt.setString(3, presentDateTime());
        stmt.setNull(4, Types.DATE);
        stmt.setDate(5, dateOfDisease);
        stmt.executeUpdate();
    }

    public void insertPatient(String[] patient, Date dateOfDisease) throws SQLException {
        String query = "INSERT INTO patient VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement stmt = connection.prepareStatement(query);

        stmt.setString(1, patient[0]);
        stmt.setString(2, patient[1]);
        stmt.setString(3, patient[2]);
        stmt.setString(4, patient[3]);
        stmt.setString(5, patient[4]);
        stmt.setString(6, patient[5]);
        stmt.setString(7, patient[6]);
        stmt.setString(8, patient[7]);
        stmt.executeUpdate();

        insertDate(patient[0], dateOfDisease);
        updateRoom(patient[7]);

    }
    public void insertDoctor(String[] doctor) throws SQLException {
        String query = "INSERT INTO doctor VALUES (?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement stmt = connection.prepareStatement(query);

        stmt.setString(1, doctor[0]);
        stmt.setString(2, doctor[1]);
        stmt.setString(3, doctor[2]);
        stmt.setString(4, doctor[3]);
        stmt.setString(5, doctor[4]);
        stmt.setString(6, doctor[5]);
        stmt.setString(7, doctor[6]);
        stmt.executeUpdate();
    }

    public void assignDoctor(String patient, String doctor) throws SQLException {
        String query = "INSERT INTO doc_assign VALUES (?, ?)";

        PreparedStatement stmt = connection.prepareStatement(query);
        stmt.setString(1, patient);
        stmt.setString(2, doctor);
        stmt.executeUpdate();
    }

    /**
     * Generating an Patient id for the Patient
     * table
     * --> max(PatientId) + 1
     * */

    public String generatePatientID () {
        int id = 0;
        String query = "select max(patId) as maxId from patient";

        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            if(rs.next()) {
                id = Integer.parseInt(rs.getString("maxId")) ;
                id++;
            }
            stmt.close();
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return String.valueOf(id);
    }

    /**
     * Generating an Dcotor id for help in indexing the doctor's
     * table
     * --> max(doctorId) + 1
     * */

    public String generateDoctorID () {
        int id = 0;
        String query = "select max(doc_id) as maxId from doctor";

        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            if(rs.next()) {
                id = Integer.parseInt(rs.getString("maxId")) ;
                id++;
            }
            stmt.close();
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return String.valueOf(id);
    }

    /**
     * Generating an diagnosis id for the diagnosis
     * table
     * --> max(diagnosisId) + 1
     * */

    public String generateDiagnosisId () {
        int id = 0;
        String query = "select max(dia_id) as maxId from diagnosis";

        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            if(rs.next()) {
                id = Integer.parseInt(rs.getString("maxId")) ;
                id++;
            }

        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return String.valueOf(id);
    }

    /**
     * Generating a room no for the new Room
     * default max(RoomNO) + 1 will be given to the
     * user
     * */

    public int getNewRoomNo () {
        int roomNo = 0;
        String query = "select max(roomNo) as maxRoom from room";

        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            if(rs.next()) {
                roomNo = Integer.parseInt(rs.getString("maxRoom")) ;
            }

        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return ++roomNo;
    }

    /**
     * Inserting the diagnosis of the patient to
     * the diagnosis table in the database
     * --> Passing the string array containing all the attributes
     * of the diagnosis table
     * */

    public void insertDiagnosis(String[] diagnosis) throws SQLException {
        String query = "INSERT INTO diagnosis VALUES (?, ?, ?, ?, ?, ?, ?)";


        PreparedStatement stmt = connection.prepareStatement(query);

        stmt.setString(1, diagnosis[0]);
        stmt.setString(2, diagnosis[1]);
        stmt.setString(3, diagnosis[2]);
        stmt.setString(4, diagnosis[3]);
        stmt.setString(5, diagnosis[4]);
        stmt.setString(6, diagnosis[5]);
        stmt.setString(7, diagnosis[6]);
        stmt.executeUpdate();

    }

    public ResultSet getAllRooms() throws SQLException {
        String query = "select * from room";

        PreparedStatement stmt = connection.prepareStatement(query);
        ResultSet rooms = stmt.executeQuery();
        return rooms;
    }

    /**
     * Inserting a new room to the Database
     *
     * */

    public void insertRoom(String roomNo, String beds, String status, String charges) throws SQLException {
        String query = "INSERT INTO room VALUES (?, ?, ?, ?)";

        PreparedStatement stmt = connection.prepareStatement(query);
        stmt.setString(1, roomNo);
        stmt.setString(2, beds);
        stmt.setString(3, status);
        stmt.setString(4, charges);
        stmt.executeUpdate();
    }

    /**
     * --> getting tot patients in room
     * --> getting tot beds in room
     * --> if patients == beds ==> status = 1
     * */

    public void updateRoom(String roomNo) throws SQLException {

       // Finding all patients in room

        String query = "select count(*) as pats from patient inner join room on (patient.roomNo = room.roomNO)";

       PreparedStatement stmt = connection.prepareStatement(query);
       ResultSet rs = stmt.executeQuery();
       int patientsInRoom = 0;

       if(rs.next()) {
           patientsInRoom = Integer.parseInt(rs.getString("pats"));
       }

       //Finding toto beds of room

       int beds = 0;
       String query2 = "select beds from room where roomNo = ?";
       stmt = connection.prepareStatement(query2);
       stmt.setString(1, roomNo);

       rs = null;
       rs = stmt.executeQuery();

       if (rs.next()) {
           beds = Integer.parseInt(rs.getString("beds"));
       }

       // If patient reaches tot beds set status to 1

        if(patientsInRoom >= beds) {
            String query3 = "update room set status = 1 where roomNo = ?";
            stmt = connection.prepareStatement(query3);
            stmt.setString(1, roomNo);
            stmt.executeUpdate();
        }
    }

    public ResultSet getUnfilledRooms() throws SQLException {

        String sql = "SELECT roomNO FROM room where status = 0";
        ResultSet rooms;

        stmt = connection.createStatement();
        rooms = stmt.executeQuery(sql);
        return rooms;
    }


    public ResultSet getPatientsView() throws SQLException {
        String sql = "select * from currentpatient";
        ResultSet rs;
        PreparedStatement stmt = connection.prepareStatement(sql);
        rs = stmt.executeQuery();
        return rs;
    }
    public ResultSet getOldPatientsView() throws SQLException {
        String sql = "select * from oldpatient";
        ResultSet rs;
        PreparedStatement stmt = connection.prepareStatement(sql);
        rs = stmt.executeQuery();
        return rs;
    }

    public ResultSet getDoctors() throws SQLException {
        String sql = "select * from doctor";
        ResultSet rs;
        PreparedStatement stmt = connection.prepareStatement(sql);
        rs = stmt.executeQuery();
        return rs;
    }

    public ResultSet getBills() throws SQLException {
        String sql = "select * from patientbill";
        ResultSet rs;
        PreparedStatement stmt = connection.prepareStatement(sql);
        rs = stmt.executeQuery();
        return rs;
    }

    /* username password check*/
    public boolean usernamePassCheck(String user, String pass) throws SQLException {
        boolean exists = false;
        String query = "SELECT username, password FROM athentication WHERE username = ? and password = ?";
        PreparedStatement stmt = connection.prepareStatement(query);

        stmt.setString(1, user);
        stmt.setString(2, pass);
        ResultSet rs;
        rs = stmt.executeQuery();

        if (rs.next()) {
            exists = true;
        }
        return  exists;
    }

    public boolean usernameCheck(String user) throws SQLException {
        boolean exists = false;
        String query = "SELECT username FROM athentication WHERE username = ?";
        PreparedStatement stmt = connection.prepareStatement(query);

        stmt.setString(1, user);
        ResultSet rs;
        rs = stmt.executeQuery();

        if (rs.next()) {
            exists = true;
        }
        return  exists;
    }


    public boolean passwordCheck(String id) throws SQLException {
        boolean exists = false;
        String query = "SELECT password FROM athentication WHERE password = '"+ id +"'";
        ResultSet rs;

        stmt = connection.createStatement();
        rs = stmt.executeQuery(query);

        if (rs.next()) {
            exists = true;
        }

        return  exists;
    }
    public void updatePassword(String pass, String user) throws SQLException {
        String query = "UPDATE `hospital`.`athentication` SET `password` = ? WHERE (`username` = ?);";

        PreparedStatement stmt = connection.prepareStatement(query);
        stmt.setString(1, pass);
        stmt.setString(2, user);
        stmt.executeUpdate();
    }

    public void newUser(String user, String pass) throws SQLException {
        String query = "INSERT INTO `hospital`.`athentication` (`username`, `password`) VALUES (?, ?);";

        PreparedStatement stmt = connection.prepareStatement(query);
        stmt.setString(1, user);
        stmt.setString(2, pass);
        stmt.executeUpdate();
    }

    public String generateBillId() {
        int id = 0;
        String query = "select max(bill_id) as maxId from bill";

        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            if(rs.next()) {
                id = Integer.parseInt(rs.getString("maxId")) ;
                id++;
            }

        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return String.valueOf(id);
    }

    public void insertBill(String patid, String totBill) throws SQLException {
        String query = "INSERT INTO bill VALUES (?, ?, ?);";

        PreparedStatement stmt = connection.prepareStatement(query);
        stmt.setString(1, patid);
        stmt.setString(2, generateBillId());
        stmt.setString(3, totBill);
        stmt.executeUpdate();
    }

    public String[] getBillDetails(String patId) throws SQLException {
        String bill[] = new String[7];
        String query = "select * from patientbill where patId = ?";

        PreparedStatement stmt = connection.prepareStatement(query);
        stmt.setString(1, patId);
        ResultSet rs = stmt.executeQuery();
        if(rs.next()) {
            bill[0] = rs.getString("patId");
            bill[1] = rs.getString("p_name");
            bill[2] = rs.getString("roomCharge");
            bill[3] = rs.getString("docCharge");
            bill[4] = rs.getString("days");
            bill[5] = rs.getString("otherCharges");
            bill[6] = rs.getString("totbill");
        }
        return bill;
    }


    public void dischargePatient(String id) throws SQLException {
        String sql = "update daterecord set discharge = CAST(? as datetime) where patId = ?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        System.out.println(presentDateTime() + "   " + id);
        stmt.setString(1, presentDateTime());
        stmt.setString(2, id);
        stmt.executeUpdate();
    }

}
