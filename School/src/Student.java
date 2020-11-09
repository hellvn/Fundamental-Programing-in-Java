public class Student {
    private String rollNo, name;
    private double GPA;
    private aClass aClass;

    public Student(String rollNo, String name, double GPA, aClass aClass) {
        this.rollNo = rollNo;
        this.name = name;
        this.GPA = GPA;
        this.aClass = aClass;
    }

    public String getRollNo() {
        return rollNo;
    }

    public String getName() {
        return name;
    }

    public double getGPA() {
        return GPA;
    }

    public aClass getaClass() {
        return aClass;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGPA(double GPA) {
        this.GPA = GPA;
    }

    public void setaClass(aClass aClass) {
        this.aClass = aClass;
    }

    @Override
    public String toString() {
        return "Student [ rollNo='" + rollNo + '\'' + ", name='" + name + '\'' + ", GPA=" + GPA + ", Class=" + aClass + ']';
    }
}
