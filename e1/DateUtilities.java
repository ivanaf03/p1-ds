package e1;

public class DateUtilities {
    public static boolean isLeap(int year) {
        return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
    }

    public static int numberOfDays(int month, int year) {
        byte numDay;
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                numDay = 31;
                break;
            case 2:
                if (isLeap(year)) {
                    numDay = 29;
                } else {
                    numDay = 28;
                }
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                numDay = 30;
                break;
            default:
                throw new IllegalArgumentException("The month" + month + "is not valid");
        }

        return numDay;
    }

    public static String convertToISODate(String dateText) {
        String[] a = dateText.split(" ");
        String[] b = a[1].split(",");
        switch (a[0]) {
            case "January" -> a[0] = "01";
            case "February" -> a[0] = "02";
            case "March" -> a[0] = "03";
            case "April" -> a[0] = "04";
            case "May" -> a[0] = "05";
            case "June" -> a[0] = "06";
            case "July" -> a[0] = "07";
            case "August" -> a[0] = "08";
            case "September" -> a[0] = "09";
            case "October" -> a[0] = "10";
            case "November" -> a[0] = "11";
            case "December" -> a[0] = "12";
        }

        return a[2] + "-" + a[0] + "-" + b[0];
    }

    public static boolean checkISODate(String dateText) {
        String[] str = dateText.split("-");
        int n1 = Integer.parseInt(str[0]);
        int n2 = Integer.parseInt(str[1]);
        int n3 = Integer.parseInt(str[2]);
        if (str[0].length() > 0 && (str[1].length() == 2 || str[1].length() == 1) && (str[2].length() == 2 || str[2].length() == 1)) {
            if (n1 >= 0 && n2 > 0 && n2 < 13 && n3 > 0 && n3 < 32) {
                return n3 <= numberOfDays(n2, n1);
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}

