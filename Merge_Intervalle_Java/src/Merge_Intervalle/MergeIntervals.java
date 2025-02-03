package Merge_Intervalle;
import java.util.*;
public class MergeIntervals {
	public static List<int[]> merge(int[][] intervals) {
        if (intervals.length == 0) return new ArrayList<>();
        
        // Trier les intervalles par heure de début
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        
        List<int[]> merged = new ArrayList<>();
        int[] currentInterval = intervals[0];
        merged.add(currentInterval);
        
        for (int[] interval : intervals) {
            int currentEnd = currentInterval[1];
            int nextStart = interval[0];
            int nextEnd = interval[1];
            
            if (nextStart <= currentEnd) { // Fusionner les intervalles
                currentInterval[1] = Math.max(currentEnd, nextEnd);
            } else { // Ajouter un nouvel intervalle
                currentInterval = interval;
                merged.add(currentInterval);
            }
        }
        
        return merged;
    }
    
    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        List<int[]> mergedIntervals = merge(intervals);
        
        System.out.println("Intervalles fusionnes :");
        for (int[] interval : mergedIntervals) {
            System.out.println(Arrays.toString(interval));
        }
    }

}
