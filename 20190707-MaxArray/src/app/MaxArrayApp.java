package app;


import java.util.*;

public class MaxArrayApp {
    public static final int ARRAY_SIZE = 20;
    public static final int TOP_VALUE = 10;
    static Random rnd = new Random();
    
    public static void main(String[] args) {
        ArrayList<Integer> array = new ArrayList<>();
        int maxVal = 0;
        int maxCount = 0;
        
        for ( int i = 0; i < ARRAY_SIZE; ++i ) array.add(rnd.nextInt(TOP_VALUE));
//        array.
        
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for ( int i = 0; i < array.size(); ++i ) {
            if ( ! map.containsKey(array.get(i)) ) map.put(array.get(i), new TreeSet<Integer>());
            (map.get(array.get(i))).add(i);
        }
        
        System.out.println("Array:");
//        for ( int i : array ) System.out.print(i + " ");
        System.out.println(array);
        
        System.out.println("\nValue\tIndexes");
        for ( int i : map.keySet() ) {
            System.out.print(i + ":\t");
            for ( int j : map.get(i) ) {
                System.out.print(j + " ");
            	if (map.get(i).size() > maxVal) {
            		maxVal = map.get(i).size();
            		maxCount = i;
            	}
            }
            System.out.println();
        }
        
        System.out.print("maxVal = " + maxVal);
        System.out.println(", maxCount = " + maxCount);
    }
}
