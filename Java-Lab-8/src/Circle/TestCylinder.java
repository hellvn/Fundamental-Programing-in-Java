package Circle;

public class TestCylinder {
    public static void main (String[] args) {

        Cylinder c1 = new Cylinder();
        System.out.println("Cylinder1:"
                + " radius=" + c1.getRadius() +"\n"
                + " height=" + c1.getHeight() + "\n"
                + " base area=" + c1.getArea() + "\n"
                + " volume=" + c1.getVolume());

        Cylinder c2 = new Cylinder(10.0);
        System.out.println("Cylinder2:"+ "\n"
                + " radius=" + c2.getRadius() + "\n"
                + " height=" + c2.getHeight() + "\n"
                + " base area=" + c2.getArea() + "\n"
                + " volume=" + c2.getVolume());

        Cylinder c3 = new Cylinder(2.0, 10.0);
        System.out.println("Cylinder3:"
                + " radius=" + c3.getRadius() + "\n"
                + " height=" + c3.getHeight() + "\n"
                + " base area=" + c3.getArea() + "\n"
                + " volume=" + c3.getVolume());
    }
}
