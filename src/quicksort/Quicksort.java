package quicksort;

import java.util.ArrayList;
import java.util.Random;

public class Quicksort {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(5);
        arr.add(25);
        arr.add(2);
        arr.add(-1);
        arr.add(7);
        arr.add(0);
        arr.add(25);
        arr.add(1);

        Long startTime = System.nanoTime();

        ArrayList<Integer> ordenedResult = quicksort(arr);

        Long endTime = System.nanoTime();
        Long durationInNanoseconds = endTime - startTime;
        double durationInMilliseconds = durationInNanoseconds / 1_000_000.0;

        System.out.println("Execution in milisseconds: " + durationInMilliseconds);
        System.out.println(ordenedResult);
    }

    public static ArrayList<Integer> quicksort(ArrayList<Integer> arr) {
        if (arr.size() < 2) {
            return arr;
        }
        // recursive case
        Random random = new Random();
        Integer pivotIndex = random.nextInt(arr.size());
        Integer pivot = arr.get(pivotIndex);

        // All the numbers less than the pivot
        ArrayList<Integer> lessThanPivot = new ArrayList<>();
        // All the numbers bigger than the pivot
        ArrayList<Integer> biggerThanPivot = new ArrayList<>();

        for (int i = 0; i < arr.size(); i++) {
            if(i == pivotIndex) continue;
            if (arr.get(i) <= pivot) {
                lessThanPivot.add(arr.get(i));
            } else {
                biggerThanPivot.add(arr.get(i));
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        result.addAll(quicksort(lessThanPivot));
        result.add(pivot);
        result.addAll(quicksort(biggerThanPivot));

        return result;
    }
}
