import java.util.Arrays;
import java.util.Comparator;

class Interval {
    int start;
    int end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

public class Overlap {
    public static int maxOverlapIntervals(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }

        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval.start));

        int maxOverlap = 1;
        int currentOverlap = 1;
        int currentIndex = 0;

        while (currentIndex < intervals.length - 1) {
            if (intervals[currentIndex].end >= intervals[currentIndex + 1].start) {
                currentOverlap++;
            } else {
                maxOverlap = Math.max(maxOverlap, currentOverlap);
                currentOverlap = 1;
            }
            currentIndex++;
        }

        return Math.max(maxOverlap, currentOverlap);
    }

    public static void main(String[] args) {
        Interval[] intervals = {new Interval(1, 2), new Interval(3, 4), new Interval(5, 6)};
        int maxOverlap = maxOverlapIntervals(intervals);
        System.out.println("Maximum overlapping intervals: " + maxOverlap);
    }
}
