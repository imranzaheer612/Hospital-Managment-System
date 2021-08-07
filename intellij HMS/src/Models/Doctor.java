package Models;

public class Doctor {

    private String docId = null;
    private String docName = null;
    private String charge = null;
    private String specialization = null;
    private String age = null;
    private String address = null;
    private String contact = null;

    public Doctor () {}

    public Doctor(String docId, String docName, String charge, String specialization, String age, String address, String contact) {
        this.docId = docId;
        this.docName = docName;
        this.charge = charge;
        this.specialization = specialization;
        this.age = age;
        this.address = address;
        this.contact = contact;
    }

    public String getDocId() {
        return docId;
    }

    public void setDocId(String docId) {
        this.docId = docId;
    }

    public String getDocName() {
        return docName;
    }

    public void setDocName(String docName) {
        this.docName = docName;
    }

    public String getCharge() {
        return charge;
    }

    public void setCharge(String charge) {
        this.charge = charge;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    @Override
    public String toString() {
        return "DoctorModel{" +
                "docId='" + docId + '\'' +
                ", docName='" + docName + '\'' +
                ", charge='" + charge + '\'' +
                ", specialization='" + specialization + '\'' +
                ", age='" + age + '\'' +
                ", address='" + address + '\'' +
                ", contact='" + contact + '\'' +
                '}';
    }
}
