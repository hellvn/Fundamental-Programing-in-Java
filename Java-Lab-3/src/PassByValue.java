public class PassByValue {
    public void setVal(int num1){
        num1 = num1 +20;
    }
    public static void main(String[] args) {
        int num1 = 100;
        PassByValue obj = new PassByValue();

        obj.setVal(num1);
        System.out.println("Value after invoking setVal is " + num1);
    }
}
