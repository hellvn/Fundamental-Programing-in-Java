public class snippet5_14_NumberPyramid {
    public static void main(String[] args) {
        outer:
        for (int i=1; i<5; i++){
            for (int j = 1; j<5; j++){
                if (j>i){
                    System.out.println();
                    continue outer;
                }
                System.out.printf(" %d ", j);
            }
            System.out.println("\nThis is the outer loop.");
        }
        System.out.println("Good bye");
    }
}
