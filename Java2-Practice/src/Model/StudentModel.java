package Model;

public class StudentModel {
    private String StudentID;
    private String StudentName;
    private String Address;
    private String Phone;

    public StudentModel() {
        StudentID = "";
        StudentName = "";
        Address = "";
        Phone = "";
    }

    public StudentModel(String studentID, String studentName, String address, String phone) {
        StudentID = studentID;
        StudentName = studentName;
        Address = address;
        Phone = phone;
    }

    public String getStudentID() {
        return StudentID;
    }

    public void setStudentID(String studentID) {
        StudentID = studentID;
    }

    public String getStudentName() {
        return StudentName;
    }

    public void setStudentName(String studentName) {
        StudentName = studentName;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    @Override
    public String toString() {
        return String.format(StudentID +
                ", " + StudentName +
                ", " + Address+
                ", " + Phone);
    }
}
