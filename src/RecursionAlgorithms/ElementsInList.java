package RecursionAlgorithms;

import java.util.ArrayList;

public class ElementsInList {

    public static void main(String[] args){
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(2);
        arr.add(2);
        arr.add(2);
        arr.add(2);
        arr.add(2);
        int elementsInList = elementsInList(arr);
        System.out.println(elementsInList);
    }

    public static int elementsInList(ArrayList<Integer> arr){
        if(arr.isEmpty()){
            return 0;
        }else{
            int item = arr.removeLast();
            return 1 + elementsInList(arr);
        }
    }
}
