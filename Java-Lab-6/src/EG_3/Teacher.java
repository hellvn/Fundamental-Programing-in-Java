package EG_3;

public class Teacher extends Person{
    private int numCourse;
    private String[] courses;
    private static final int MAX_COURSES = 5;

    public Teacher(String name, String address) {
        super(name, address);
        numCourse = 0;
        courses = new String[MAX_COURSES];
    }

    @Override
    public String toString() {
        return "Teacher: " + super.toString();
    }

    public boolean addCourse(String course){
        for (int i = 0; i < numCourse; i++){
            if (courses[i].equals(course))
                return false;
        }
        courses[numCourse] = course;
        numCourse++;
        return true;
    }

    public boolean removeCourse(String course){
        boolean found = false;
        int courseIndex = -1;
        for (int i = 0; i < numCourse; i++){
            if (courses[i].equals(course)){
                courseIndex = i;
                found = true;
                break;
            }
        }
        if (found){
            for (int i = courseIndex; i < numCourse; i++){
                courses[i] = courses[i+1];
            }
            numCourse--;
            return true;
        }
        else return false;
    }
}
