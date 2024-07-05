package SelectionSort;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class SelectionSort {
    public static void main(String[] args){
        ArrayList<Integer> array = new ArrayList<Integer>();
        array.add(233);
        array.add(2);
        array.add(15);
        array.add(355);
        array.add(33);
        System.out.println(selectionSort(array));
    }

    public static ArrayList<Integer> selectionSort(ArrayList<Integer> array){
        ArrayList<Integer> newArray = new ArrayList<Integer>(array.size());
        int size_of_array = array.size();
        for(int i = 0; i < size_of_array; i++){
            int index = findBiggestNumber(array);
            newArray.add(array.remove(index));
        }
        return newArray;
    }

    public static int findBiggestNumber(ArrayList<Integer> array){
        int biggest = array.get(0);
        int biggestIndex = 0;

        for(int i = 0; i < array.size(); i++){
            if(array.get(i) > biggest){
                biggest = array.get(i);
                biggestIndex = i;
            }
        }
        return biggestIndex;
    }


}
