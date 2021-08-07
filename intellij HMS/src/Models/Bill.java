package Models;

public class Bill {

    private String patId = null;
    private String p_name = null;
    private String roomCharge = null;
    private String docCharge = null;
    private String days = null;
    private String otherCharges = null;
    private String totBill = null;


    public Bill() {}
    public Bill(String patId, String p_name, String roomCharge, String docCharge, String days, String otherCharges, String totBill) {
        this.patId = patId;
        this.p_name = p_name;
        this.roomCharge = roomCharge;
        this.docCharge = docCharge;
        this.days = days;
        this.otherCharges = otherCharges;
        this.totBill = totBill;
    }

    public String getPatId() {
        return patId;
    }

    public void setPatId(String patId) {
        this.patId = patId;
    }

    public String getP_name() {
        return p_name;
    }

    public void setP_name(String p_name) {
        this.p_name = p_name;
    }

    public String getRoomCharge() {
        return roomCharge;
    }

    public void setRoomCharge(String roomCharge) {
        this.roomCharge = roomCharge;
    }

    public String getDocCharge() {
        return docCharge;
    }

    public void setDocCharge(String docCharge) {
        this.docCharge = docCharge;
    }

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days;
    }

    public String getOtherCharges() {
        return otherCharges;
    }

    public void setOtherCharges(String otherCharges) {
        this.otherCharges = otherCharges;
    }

    public String getTotBill() {
        return totBill;
    }

    public void setTotBill(String totBill) {
        this.totBill = totBill;
    }

    @Override
    public String toString() {
        return "BillsModel{" +
                "patId='" + patId + '\'' +
                ", p_name='" + p_name + '\'' +
                ", roomCharge='" + roomCharge + '\'' +
                ", docCharge='" + docCharge + '\'' +
                ", days='" + days + '\'' +
                ", otherCharges='" + otherCharges + '\'' +
                ", totBill='" + totBill + '\'' +
                '}';
    }
}
