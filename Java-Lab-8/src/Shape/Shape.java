package Shape;

public class Shape {
    String color;
    boolean filled;

    public Shape(){
        color ="red";
        filled = true;
    }
    public Shape(String color, boolean filled){
        this.color = color;
        this.filled = filled;
    }
    public void setColor(String color) {this.color = color;}
    public String getColor() {return color;}
    public boolean isFilled(){return this.filled = filled;}
    public void setFilled(boolean filled) {this.filled = filled;}

    @Override
    public String toString() {
        return  "A shape with "+"color of" + color  + "and filled" + filled;
    }
}
