public class aClass {
    private String classId, className, status;

    public aClass(String classId, String className, String status) {
        this.classId = classId;
        this.className = className;
        this.status = status;
    }

    public String getClassId() {
        return classId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return classId + "," + className + "," + status;
    }
}
