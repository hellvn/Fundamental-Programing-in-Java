public class TestStudent {

    public static void main(String[] args) {
        aClass c1 = new aClass("C101","Java","active");
        System.out.println(c1);

        Student s1 = new Student("S1001","John Cage", 25.5, c1);
        System.out.println(s1);

        
    }
}
