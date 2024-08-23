package RecursionAlgorithms;

import java.util.ArrayList;

public class BiggestItem {

    public static void main(String[] args){
        ArrayList<Integer> arr = new ArrayList<Integer>();
        arr.add(2);
        arr.add(1);
        int biggestItem = biggestItem(arr);
        System.out.println(biggestItem);
    }

    public static int biggestItem(ArrayList<Integer> arr){
        if(arr.isEmpty()){
            return 0;
        }else {
            int item = arr.removeLast();
            if(item > biggestItem(arr)){
                return item;
            }else {
                return 0;
            }
        }


    }
}
