package com.array;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

public class canAttendMeetings {
    public boolean canAttendMeetings(int[][] intervals) {
        if(intervals == null)
            return false;
        SortedSet<int[]> sortedSet = new TreeSet<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] interval1, int[] interval2) {
                return interval1[0] - interval2[0] >=0 ? 1 : -1; // Compare based on start times
            }
        });
        for (int[] interval : intervals) {
            sortedSet.add(interval);
        }
        ArrayList<int[]> ll = new ArrayList<>(sortedSet);
        for (int i =1; i<ll.size(); i++) {
            if(ll.get(i)[0] < ll.get(i-1)[1])
                return false;
        }
        return true;
    }

    public static void main(String[] args) {

        int[][] intervals = {{0,30},{50,100},{35,40}};
        canAttendMeetings ca = new canAttendMeetings();
        System.out.println(ca.canAttendMeetings(intervals));
        System.out.println(ca.canAttendMeetings(new int[][]{{0,30},{5,10},{15,20},{1,5}}));
    }
}
