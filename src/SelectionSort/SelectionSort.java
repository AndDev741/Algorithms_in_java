package SelectionSort;

public class SelectionSort {
    public static void main(String[] args){
        int[] numbersList = {233, 2, 15, 355, 33};
        int[] orderedList = selectionSort(numbersList);
        for(int i = 0; i < orderedList.length; i++){
            System.out.println(orderedList[i]);
        }
    }

    public static int[] selectionSort(int[] list){
        for(int i = 0; i < list.length; i++){
            int minIndex = i;

            for(int j = i + 1; j < list.length; j++){
                if(list[j] < list[minIndex]){
                    minIndex = j;
                    System.out.println("New minIndex: " + j);
                }
            }

            int temp = list[i];
            list[i] = list[minIndex];
            list[minIndex] = temp;
        }

        return list;
    }

}
