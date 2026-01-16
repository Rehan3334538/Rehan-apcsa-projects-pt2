package warmup;

public class Main {

    public static void main(String[] args) {
        public class CountingSundays {
    public static void main(String[] args) {
        int[] daysInMonth = {31,28,31,30,31,30,31,31,30,31,30,31};
        int dayOfWeek = 1;
        int sundayCount = 0;

        for (int year = 1900; year <= 2000; year++) {
            for (int month = 0; month < 12; month++) {
                if (year >= 1901 && dayOfWeek % 7 == 0) {
                    sundayCount++;
                }

                int daysThisMonth = daysInMonth[month];
                if (month == 1 && ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0))) {
                    daysThisMonth = 29;
                }

                dayOfWeek += daysThisMonth;
            }
        }

        System.out.println(sundayCount);
    }
}


    }
}
