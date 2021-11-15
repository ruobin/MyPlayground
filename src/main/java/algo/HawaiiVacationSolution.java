package algo;

import java.util.HashMap;
import java.util.Map;

public class HawaiiVacationSolution {

    public int solution(int year, String beginningMonth, String endingMonth,  String dayOfWeek) {
        // write your code in Java SE 8

        boolean isLeapYear = year%4 == 0;
        int febDays;
        if (isLeapYear) {
            febDays = 29;
        } else {
            febDays = 28;
        }
        int monthDays[] = {31, febDays, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        Map monthIndex = new HashMap();
        monthIndex.put("January", 0);
        monthIndex.put("February", 1);
        monthIndex.put("March", 2);
        monthIndex.put("April", 3);
        monthIndex.put("May", 4);
        monthIndex.put("June", 5);
        monthIndex.put("July", 6);
        monthIndex.put("August", 7);
        monthIndex.put("September", 8);
        monthIndex.put("October", 9);
        monthIndex.put("November", 10);
        monthIndex.put("December", 11);

        Map dayOfWeekMap = new HashMap();
        dayOfWeekMap.put("Monday", 1);
        dayOfWeekMap.put("Tuesday", 2);
        dayOfWeekMap.put("Wednesday", 3);
        dayOfWeekMap.put("Thursday", 4);
        dayOfWeekMap.put("Friday", 5);
        dayOfWeekMap.put("Saturday", 6);
        dayOfWeekMap.put("Sunday", 7);

        int dayOfWeekOnJanFirst = (int) dayOfWeekMap.get(dayOfWeek); // for example, 5 for Friday
        int beginningMonthIndex = (int) monthIndex.get(beginningMonth); // for example, 6 for July
        int endingMonthIndex = (int) monthIndex.get(endingMonth); // for example, 8 for September

        int dayOfYear = 0;
        for (int i = 0; i < beginningMonthIndex; i++) {
            dayOfYear+=monthDays[i]; // for example, 181/7 = 25*7 + 6. 176 th day is Friday, 182 th day is Thursday
        }
        int dayOfYearOnEnding = 0;
        for (int i = 0; i < endingMonthIndex; i++) {
            dayOfYearOnEnding+=monthDays[i]; // for example, 273 for 30th, Sep
        }
        int totalVacationSpan = dayOfYearOnEnding - dayOfYear; // e.g. 92
        int dayOfWeekOnBeginning = (dayOfWeekOnJanFirst + (dayOfYear + 1)%7)%7; // e.g. 4 for Thursday
        int departureDelay = (8-dayOfWeekOnBeginning)%7;
        int departureDay = 1 + departureDelay;
        int remainVacationDays = totalVacationSpan - departureDay; // e.g. 92-5=87
        int count = (remainVacationDays + 1 - departureDay)/7;
        return count;
    }
}
