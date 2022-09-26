import java.util.Calendar;

public class Date implements Comparable<Date> {
    public static final int[] LONG_MONTHS = new int [] {1, 3, 5, 7, 8, 10, 12};
    public static final int[] SHORT_MONTHS = new int [] {4, 6, 9, 11};
    public static final int FEB = 2;
    public static final int LONG_MONTH_DAYS = 31;
    public static final int SHORT_MONTH_DAYS = 30;
    public static final int FEB_DAYS_NONLEAP = 28;
    public static final int FEB_DAYS_LEAP = 29;
    public static final int QUADRENNIAL = 4;
    public static final int CENTENNIAL = 100;
    public static final int QUARTERCENTENNIAL = 400;

    private int year;
    //months are indexed from 0 to 11
    private int month;
    private int day;
    public Date() {
        Calendar today = Calendar.getInstance();
        this.year = today.get(Calendar.YEAR);
        this.month = today.get(Calendar.MONTH);
        this.day = today.get(Calendar.DAY_OF_MONTH);
    }

    public Date(String date) {
        String [] dates = date.split("/");

        this.month = Integer.parseInt(dates[1]);
        this.day = Integer.parseInt(dates[0]);
        this.year = Integer.parseInt(dates[2]);
    }

    @Override
    public int compareTo(Date date) {
        if (date == this)
            return 0;

        if(date.year > this.year)
            return -1;
        else if(date.year < this.year)
            return 1;
        else{
            if (date.month > this.month)
                return -1;
            else if (date.month < this.month)
                return 1;
            else{
                if(date.day > this.day)
                    return -1;
                else if (date.day < this.day)
                    return 1;
                else
                    return 0;
            }
        }
    }
    public boolean isValid() {
        if (this.month == FEB){
            if(isLeapYear(this.year))
                if (this.day > FEB_DAYS_LEAP)
                    return false;
            else
                if (this.day > FEB_DAYS_NONLEAP)
                    return false;

            return true;
        }

        for (int counter = 0 ; counter < LONG_MONTHS.length; counter ++){
            if (this.month == LONG_MONTHS[counter]){
                if(this.day > LONG_MONTH_DAYS){
                    return false;
                }
                return true;
            }
        }
        for (int counter = 0 ; counter < SHORT_MONTHS.length; counter ++){
            if (this.month == SHORT_MONTHS[counter]){
                if(this.day > SHORT_MONTH_DAYS){
                    return false;
                }
                return true;
            }
        }
        return false;
    }

    public boolean isLeapYear(int year){
        if (year % QUADRENNIAL == 0)
            if(year % CENTENNIAL == 0)
                if(year % QUARTERCENTENNIAL == 0)
                    return true;
                else
                    return false;
            else
                return true;
        else
            return false;
    }
}