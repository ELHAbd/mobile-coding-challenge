package com.ingecys.had.project_mobile_coding_chalenge.method;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Method {



    public static String getYesterdayDateString() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(yesterday());
    }


    public static Date yesterday() {
        final Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -1);
        return cal.getTime();
    }

    public static String abbreviateNumber(String number) {


        Long num = Long.parseLong(number);

      //  String convertedString = new DecimalFormat("#.##").format(num);





        String convertedString =  NumberFormat.getInstance().format(num);

        DecimalFormat decimalFormat =  new DecimalFormat("#.#");

        Double temp = (double) num / 1000000;

        if (temp > 0) {



            return roundToNDigits(temp,1) + "M";
        }

        temp = (double)num / 1000;
        if (temp > 0) {
            return roundToNDigits(temp,1) + "K";
        }

        return String.valueOf(num);
    }


    private static double roundToNDigits(double value, int nDigits) {
        return Math.round(value * (10 ^ nDigits)) / (double) (10 ^ nDigits);
    }

/*
    public static String getFormatNumber(int num ){
        NumberFormat formatter = NumberFormat.getInstance();
        String result = null;
        if (num % 1000000 == 0 && num != 0) {
            result = formatter.format(num / 1000000) + "M";
        } else if (num % 1000 == 0 && num != 0) {
            result = formatter.format(num / 1000) + "K";
        } else {
            result = formatter.format(num);
        }

        return result;


    }*/





    private static char[] c = new char[]{'k', 'm', 'b', 't'};

    /**
     * Recursive implementation, invokes itself for each factor of a thousand, increasing the class on each invokation.
     * @param n the number to format
     * @param iteration in fact this is the class from the array c
     * @return a String representing the number n formatted in a cool looking way.
     */
    public static String coolFormat(double n, int iteration) {
        double d = ((long) n / 100) / 10.0;
        boolean isRound = (d * 10) %10 == 0;//true if the decimal part is equal to 0 (then it's trimmed anyway)
        return (d < 1000? //this determines the class, i.e. 'k', 'm' etc
                ((d > 99.9 || isRound || (!isRound && d > 9.99)? //this decides whether to trim the decimals
                        (int) d * 10 / 10 : d + "" // (int) d * 10 / 10 drops the decimal
                ) + "" + c[iteration])
                : coolFormat(d, iteration+1));

    }





    private static final String[] magnitudes = new String[] {"", "K", "M"};

    public static String getFormatNumber(final Integer num) {
        if (num == null || num == 0)
            return "0";

        float res = num;
        int i = 0;
        for (; i < magnitudes.length; i++) {
            final float sm = res / 1000;
            if (sm < 1) break;

            res = sm;
        }


        // don't use fractions if we don't have to
        return ( (res % (int) res < 0.1) ?
                String.format("%d", (int)res) :
                String.format("%.1f", res)
        )
                + magnitudes[i];
    }




}
