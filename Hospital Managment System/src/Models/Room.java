package Models;

public class Room {

    private String roomNo = null;
    private String beds = null;
    private String status = null;
    private String charge = null;

    public Room() {}

    public Room(String roomNo, String beds, String status, String charges) {
        this.roomNo = roomNo;
        this.beds = beds;
        this.status = status;
        this.charge = charges;
    }

    public String getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
    }

    public String getBeds() {
        return beds;
    }

    public void setBeds(String beds) {
        this.beds = beds;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCharge() {
        return charge;
    }

    public void setCharge(String charge) {
        this.charge = charge;
    }

    @Override
    public String toString() {
        return "RoomModel{" +
                "roomNo='" + roomNo + '\'' +
                ", beds='" + beds + '\'' +
                ", status='" + status + '\'' +
                ", charge='" + charge + '\'' +
                '}';
    }
}
