package Ex1_3;

public class RectangleTest {
    public static void main(String[] args) {
        Rectangle r1 = new Rectangle(5.0f,7.0f);
        System.out.println("The Length is: "+ r1.getLength());
        System.out.println("The Width is: "+r1.getWidth());
        System.out.printf("The Area is: %.2f%n", r1.getArea());
        System.out.printf("The Perimeter is: %.2f%n", r1.getPerimeter());
        System.out.println(r1.toString());
    }
}
