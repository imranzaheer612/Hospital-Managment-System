package sample.TableModels;

public class PatientModel {

    private String patId = null;
    private String patName = null;
    private String roomNo = null;
    private String contact = null;
    private String address = null;
    private String admit = null;
    private String disease = null;
    private String prescription = null;
    private String docName = null;

    public PatientModel(String patId, String patName, String roomNo, String contact, String address, String admit, String disease, String prescription, String docName) {
        this.patId = patId;
        this.patName = patName;
        this.roomNo = roomNo;
        this.contact = contact;
        this.address = address;
        this.admit = admit;
        this.disease = disease;
        this.prescription = prescription;
        this.docName = docName;
    }

    public String getPatId() {
        return patId;
    }

    public void setPatId(String patId) {
        this.patId = patId;
    }

    public String getPatName() {
        return patName;
    }

    public void setPatName(String patName) {
        this.patName = patName;
    }

    public String getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAdmit() {
        return admit;
    }

    public void setAdmit(String admit) {
        this.admit = admit;
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    public String getPrescription() {
        return prescription;
    }

    public void setPrescription(String prescription) {
        this.prescription = prescription;
    }

    public String getDocName() {
        return docName;
    }

    public void setDocName(String docName) {
        this.docName = docName;
    }

    @Override
    public String toString() {
        return "PatientModel{" +
                "patId='" + patId + '\'' +
                ", patName='" + patName + '\'' +
                ", roomNo='" + roomNo + '\'' +
                ", contact='" + contact + '\'' +
                ", address='" + address + '\'' +
                ", admit='" + admit + '\'' +
                ", disease='" + disease + '\'' +
                ", prescription='" + prescription + '\'' +
                ", docName='" + docName + '\'' +
                '}';
    }
}