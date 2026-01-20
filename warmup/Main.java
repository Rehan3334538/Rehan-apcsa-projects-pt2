package warmup;

public class Main {

    public static void main(String[] args) {

        
        int[] daysInMonth = {
                31, 28, 31, 30, 31, 30,
                31, 31, 30, 31, 30, 31
        };

        
        int dayOfWeek = 0;

        int sundayCount = 0;

        for (int year = 1900; year <= 2000; year++) {

            for (int month = 0; month < 12; month++) {

    
                if (year >= 1901) {
                    if (dayOfWeek == 6) {
                        sundayCount++;
                    }
                }

                int days = daysInMonth[month];

                // February leap year adjustment
                if (month == 1 && isLeapYear(year)) {
                    days++;
                }

                // Move dayOfWeek to next month
                dayOfWeek = (dayOfWeek + days) % 7;
            }
        }

        System.out.println(sundayCount);
    }

    public static boolean isLeapYear(int year) {
        if (year % 400 == 0) return true;
        if (year % 100 == 0) return false;
        return year % 4 == 0;
    }
}

