package FlightTicket;

public class Date {
    private int day;
    private int month;
    private  int year;

    public Date(int day, int month, int year){
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        if (day>0 || day<30){
            this.day = day;
        }
        else {
            this.day = 00;
        }
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        if (month>0 || month<12){
            this.month = month;
        }
        else {
            this.month = 00;
        }
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        if (year>0){
            this.year = year;
        }
        else {
            this.year = 0000;
        }
    }

    @Override
    public String toString() {
        return "Departure Date: "+ day + "/" + month + "/" + year;
    }
}
