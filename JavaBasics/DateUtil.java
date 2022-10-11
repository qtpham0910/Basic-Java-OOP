public class DateUtil {

    public static void main(String[] args) {

        DateUtil aDateUtil = new DateUtil();
        System.out.println(isLeapYear(1900));  // false
        System.out.println(isLeapYear(2000));  // true
        System.out.println(isLeapYear(2011));  // false
        System.out.println(isLeapYear(2012));  // true

        System.out.println(isValidDate(2012, 2, 29));  // true
        System.out.println(isValidDate(2011, 2, 29));  // false
        System.out.println(isValidDate(2099, 12, 31)); // true
        System.out.println(isValidDate(2099, 12, 32)); // false

        System.out.println(getDayOfWeek(1982, 4, 24));  // 6:Sat
        System.out.println(getDayOfWeek(2000, 1, 1));   // 6:Sat
        System.out.println(getDayOfWeek(2054, 6, 19));  // 5:Fri
        System.out.println(getDayOfWeek(2012, 2, 17));  // 5:Fri

        System.out.println(printDate(2012, 2, 14)); // Tuesday 14 Feb 2012

//        System.out.println(aDateUtil.toString(2022,10,9));
    }

    // Month's name – for printing
    public static String[] strMonths
            = {"Jan", "Feb", "Mar", "Apr", "May", "Jun",
            "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
    public static String[] strDays
            = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
    // Number of days in each month (for non-leap years)
    public static int[] daysInMonths
            = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    // Returns true if the given year is a leap year
    public static boolean isLeapYear(int year) {
        return (year > 0) && (year % 4 == 0 && (year % 100 != 0 || (year % 400 == 0)));
        //    return (year > 0) && ((year % 4 == 0) ? ((year % 100 == 0) ? ((year % 400 == 0) ? true : false) : true) : false);
    }


    // Return true if the given year, month, day is a valid date
    // year: 1-9999
    // month: 1(Jan)-12(Dec)
    // day: 1-28|29|30|31. The last day depends on year and month
    public static boolean isValidDate(int year, int month, int day) {

        if (year < 1 || year > 9999)
            return false;

        if (month < 1 || month > 12)
            return false;

        int monthDays = daysInMonths[month - 1] + (month == 2 && isLeapYear(year) ? 1 : 0);
        return 1 <= day && day <= monthDays;
    }

    // Return the day of the week, 0:Sun, 1:Mon, ..., 6:Sat
    public static int getDayOfWeek(int year, int month, int day) {
        if(!isValidDate(year, month, day)) return -1;

        int dayOfTheWeek = 0;

        int[] entryCentury = {6, 4, 2, 0};
        int firstTwoYearDigit = entryCentury[(year/100) % 4 ];
        int lastTwoYearDigit = year % 100;
        int modLastTwoYearDigit = lastTwoYearDigit / 4;

        int[] nonLeapYearNumber = {0, 3, 3, 6, 1, 4, 6, 2, 5, 0, 3, 5};
        int[] leapYearNumber = {6, 2, 3, 6, 1, 4, 6, 2, 5, 0, 3, 5};

        int mothNum = isLeapYear(year) ? leapYearNumber[month - 1] : nonLeapYearNumber[month - 1];

        dayOfTheWeek += (firstTwoYearDigit + lastTwoYearDigit + modLastTwoYearDigit + mothNum + day) % 7;
        return dayOfTheWeek;
    }

    // Return String "xxxday d mmm yyyy" (e.g., Wednesday 29 Feb 2012)
    public static String printDate(int year, int month, int day) {
        if(!isValidDate(year, month, day)) return "Not a valid day";

        int dayOfTheWeek = getDayOfWeek(year, month, day);
        return strDays[dayOfTheWeek] + " " + day + " " + strMonths[month - 1] + " " + year;
    }

}
