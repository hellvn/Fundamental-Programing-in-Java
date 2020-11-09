package Point;

public class Point3D extends Point2D{
    float z;
    public Point3D(float x,float y,float z){
        super(x, y);
        this.z = z;
    }
    Point3D(){
        z = 0.0f;
    }

    public float getZ() {return z;}
    public void setZ(float z) {this.z = z;}
    public void setXYZ(float x,float y,float z){

        this.z = z;
    }
}
