package RecursionAlgorithms;

import java.util.ArrayList;

public class RecursionSum {

    public static void main(String[] args){
        ArrayList<Integer> arr = new ArrayList<Integer>();
        arr.add(10);
        arr.add(5);
        arr.add(4);
        arr.add(1);
        arr.add(7);
        int sum = sum(arr);
        System.out.println(sum);
    }

    public static int sum (ArrayList<Integer> arr){
        if(arr.isEmpty()){
            return 0;
        }else {
            int last = arr.removeLast();
            return last + sum(arr);
        }
    }
}
