package com.ds.array;

import java.util.Arrays;

public class InsertInterval {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] result = new int[][]{};
        int mergeInterval1=-1,mergeInterval2=-1, start =0;
        while (start < intervals.length){
            if(newInterval[0] <= intervals[start][1] && newInterval[0] >= intervals[start][0]) {
                mergeInterval1 = start;
                break;
            }
            start++;
        }
        if(mergeInterval1==-1)
        	return intervals;
        start =mergeInterval1;
        if(intervals[mergeInterval1][1] < newInterval[1] ) {
            intervals[mergeInterval1][0] = newInterval[0];
        }
        while (start<intervals.length) {
            if (newInterval[1] <= intervals[start][1] && newInterval[1] >= intervals[start][0]) {
                mergeInterval2 = start;
                break;
            }
            mergeInterval2 =start;
            start++;
        }
        if(mergeInterval2==-1)
        {
            // no change in size
            return intervals;
        }
        if(mergeInterval2> mergeInterval1) {
            if(newInterval[1] < intervals[mergeInterval2][1]) {
                intervals[mergeInterval1][1] = intervals[mergeInterval2][1];
            } else {
                intervals[mergeInterval1][1] = intervals[mergeInterval2][1];
            }
        }
        int newResult[][] = removeIntervals(intervals, mergeInterval1+1, mergeInterval2);
        return newResult;
    }

    public int[][] removeIntervals(int[][] intervals, int startIndex, int endIndex) {
        // Check boundaries
        if (startIndex < 0 || endIndex >= intervals.length || startIndex > endIndex) {
            throw new IllegalArgumentException("Invalid indices");
        }

        // Calculate new length after removal
        int newLength = intervals.length - (endIndex - startIndex + 1);
        int[][] updatedIntervals = new int[newLength][];

        // Copy the intervals before the start index
        for (int i = 0; i < startIndex; i++) {
            updatedIntervals[i] = intervals[i];
        }

        // Copy the intervals after the end index
        for (int i = endIndex + 1; i < intervals.length; i++) {
            updatedIntervals[i - (endIndex - startIndex + 1)] = intervals[i];
        }

        return updatedIntervals;
    }

    public static void main(String[] args) {
        int[][] intervals = {{1,3},{6,5},{6,7},{8,10},{12,16}};
        int[] newInterval = {4,8};
        InsertInterval ii = new InsertInterval();
        int[][] result = ii.insert(intervals,newInterval);
        System.out.println(Arrays.toString(result));

        for (int[] interval : result) {
            System.out.println("[" + interval[0] + "," + interval[1] + "]");
        }
    }
}
