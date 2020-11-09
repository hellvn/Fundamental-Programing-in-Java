class Circle{
    public double getPI(){
        return 3.14;
    }
}
public class PassByRef {
    public void calcArea(Circle objPi, double rad){
        double Area = objPi.getPI() * rad *rad;
        System.out.println("Area of the circle is: " + Area);
    }
    public static void main(String[] args) {
        PassByRef p1 = new PassByRef();
        p1.calcArea(new Circle(),2);
    }
}