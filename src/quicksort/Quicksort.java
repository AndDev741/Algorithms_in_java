package quicksort;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Quicksort {
    public static void main(String[] args){
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(5);
        arr.add(25);
        arr.add(2);
        arr.add(8);
        arr.add(7);
        arr.add(1);
        List<Integer> ordenedResult = quicksort(arr);
        System.out.println(ordenedResult);
    }

    public static List quicksort(List<Integer> arr){
        if(arr.size() < 2){
            return arr;
        }
        //recursive case
        Integer pivot = arr.getFirst();
        //All the numbers less than the pivot
        List<Integer> lessThanPivot = new ArrayList<>();
        //All the numbers bigger than the pivot
        List<Integer> biggerThanPivot = new ArrayList<>();

        for(int i = 1; i < arr.size(); i++){
            if(arr.get(i) <= pivot){
                lessThanPivot.add(arr.get(i));
            } else {
                biggerThanPivot.add(arr.get(i));
            }
        }

        return (List) Stream.of(quicksort(lessThanPivot).stream(),
                Stream.of(pivot),
                quicksort(biggerThanPivot).stream())
                .flatMap(s -> s).collect(Collectors.toList());
    }
}
