package Ex_2_1_Libraly;

public class testAuthor {
    public static void main(String[] args) {
        Author vuonghm = new Author("Hoang Minh Vuong", "vuongpt93@gmail.com", 'M');
        System.out.println(vuonghm);
        vuonghm.setEmail("vuonghmth2003009@fpt.edu.vn");
        System.out.println("name is: "+vuonghm.getName());
        System.out.println("email is: "+vuonghm.getEmail());
        System.out.println("gender is: "+vuonghm.getGender());
    }
}
