package com.arumbala.soln.problems;

/**
 * Longest Sleep Time
 *
 * Daniel has M meetings in a week (Mon 00:00 - Sun 24:00).
 * Find the longest time slot with no meetings.
 *
 * Input: List of string "Ddd hh:mm-hh:mm"
 * Output: Mins in the longest sleep time
 *
 */
public class LongestSleepTime {

    private static int getDay(String day){
        return switch(day){
            case "Mon" -> 0;
            case "Tue" -> 1;
            case "Wed" -> 2;
            case "Thu" -> 3;
            case "Fri" -> 4;
            case "Sat" -> 5;
            case "Sun" -> 6;
            default -> throw new IllegalStateException("Unexpected value: " + day);
        };
    }

    private static int toMin(String time) {
        String[] part = time.split(":");
        return Integer.parseInt(part[0]) * 60 + Integer.parseInt(part[1]);
    }

    public static int getLongStreakInMins(String[] schedule) {

        /**
         *
         * Note::
         * int[] weekMins = new int[(7 * 24 * 60) + 1];
         * Meeting ends at Sun 24:00
         * int e = 6 * 1440 + toMin("24:00");
         * = 8640   + 1440
         * = 10,080  ← this index is accessed!
         *  So + 1 is required
         */
        int[] weekBusyMins = new int[(7 * 24 * 60) + 1];
        for(String sched : schedule){
            //"Sun 10:00-20:00"
            String[] parts = sched.split(" ");
            String day =  parts[0];

            //10:00-20:00"
            String[] times = parts[1].split("-");
            int base = getDay(day) * 24  * 60;
            int startMin = base + toMin(times[0]);
            int endMin =  base + toMin(times[1]);

            //Mark the busy minutes for the start_min and end_min
            for(int i = startMin; i < endMin; i++){
                weekBusyMins[i] = 1;
            }
        }

        // Find the longest free streak
        int maxFree = 0;
        int currentFree = 0;
        for(int i :  weekBusyMins){
            if(i == 0){
                currentFree++;
                maxFree = Math.max(currentFree, maxFree);
            }else{
                currentFree = 0;
            }
        }
        return maxFree;
    }

    public static void main(String[] args) {
        String[] schedule = {
                "Sun 10:00-20:00",
                "Fri 05:00-10:00",
                "Fri 16:30-23:50",
                "Sat 10:00-24:00",
                "Sun 01:00-04:00",
                "Sat 02:00-06:00",
                "Tue 03:30-18:15",
                "Tue 19:00-20:00",
                "Wed 04:25-15:14",
                "Wed 15:14-22:40",
                "Thu 00:00-23:59",
                "Mon 05:00-13:00",
                "Mon 15:00-21:00"
        };

        System.out.println(getLongStreakInMins(schedule)); // Expected: 505
    }
}