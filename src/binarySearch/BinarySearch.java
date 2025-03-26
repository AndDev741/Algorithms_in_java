package binarySearch;

public class BinarySearch {
    public static void main(String[] args) {
        int[] list = { 2, 5, 8, 12, 16, 23, 38, 56, 72, 91};

        System.out.println(binarySearchAlgorithm(list, 23));
    }

    public static int binarySearchAlgorithm(int[] list, int target){
        int left = 0;
        int rigth = list.length - 1;
        int step = 0;
        
        while(left <= rigth){
            step++;
            System.out.println("STEP: " + step);
            int middle = (left + rigth) / 2;

            if(list[middle] == target){
                return middle;
            }

            if(list[middle] < target){
                left = middle + 1;
            }

            if(list[middle] > target){
                rigth = middle - 1;
            }
            System.out.println(middle);
        }
        return -1;

    }
}