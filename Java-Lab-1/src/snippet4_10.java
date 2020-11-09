public class snippet4_10 {
    public static void main(String[] args) {
        String day = "Monday";
        String hour = "am";
        switch (day){
            case "Sunday":
                System.out.println("Sunday is a Holiday...");
                switch (hour){
                    case "am":
                        System.out.println("Good Morning");
                        break;
                    case "pm":
                        System.out.println("Good Evening");
                        break;
                }
                break;
            case "Monday":
                System.out.println("Monday is Working day");
                switch (hour){
                    case "am":
                        System.out.println("Good Morning");
                        break;
                    case "pm":
                        System.out.println("Good Evening");
                        break;
                }
                break;
            default:
                System.out.println("Invalid day");
        }
    }
}
