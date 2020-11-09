package Ex1_2_Circle;

public class Circle {
    public static void main(String[] args) {
        CircleContructor.Circle c1 = new CircleContructor.Circle();
        System.out.println("The radius is: "+ c1.getRadius());
        System.out.printf("The area is: %.2f%n", c1.getArea());
        System.out.printf("The circumference is: %.2f%n",c1.getCircumference());
        System.out.println(c1.toString());
    }
}
