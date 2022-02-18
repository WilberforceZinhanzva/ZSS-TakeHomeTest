package com.api.booksmanagement.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

public class Utilities {

    public static String generatedId(){
        Random r = new Random();
        StringBuilder s = new StringBuilder();
        for(int i=0; i<6; i++){
            char c = (char)(r.nextInt(26)+'a');
            s.append(c);
        }

        int upperBound = 999;
        int lowerBound = 100;
        int number = lowerBound+(int)(Math.random() * ((upperBound-lowerBound)+1));

        s.append(number);
        return s.toString().toUpperCase();
    }

    public static String roundToTwoDecimals(Double amount){
        BigDecimal bigDecimal = new BigDecimal(amount);
        return bigDecimal.setScale(2, RoundingMode.HALF_EVEN).toString();
    }
}
