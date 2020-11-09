public class snippet5_12 {
    public static void main(String[] args) {
        int cnt, square, cube;
        for (cnt = 1; cnt<300; cnt++){
            if (cnt%3 == 0){
                continue;
            }
            square = cnt*cnt;
            cube = cnt*cnt*cnt;
            System.out.printf("\nSquare of %d is %d and cube is %d", cnt, square, cube);
        }
    }
}
