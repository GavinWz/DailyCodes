import java.lang.System;
public class MergeSort{
    public static void main(String[] args){
        int[] list = {4,1,8,9,5,1,2,3,4};
        mergeSort(list);
        for(int temp : list)
            System.out.println(temp);
    }

    public static void mergeSort(int[] list){
        if(list.length > 1){
            int[] firstHalf = new int[list.length / 2];
            System.arraycopy(list, 0, firstHalf, 0, list.length / 2);
            mergeSort(firstHalf);

            int[] secondHalf = new int[list.length - list.length / 2];
            System.arraycopy(list, list.length / 2, secondHalf, 0, list.length - list.length / 2);
            mergeSort(secondHalf);

            merge(firstHalf, secondHalf, list);
        }
    }

    public static void merge(int[] firstHalf, int[] secondHalf, int[] list){
        int first = 0;
        int second = 0;
        int current = 0;
        while(first < firstHalf.length && second < secondHalf.length){
            if(firstHalf[first] > secondHalf[second])
                list[current++] = secondHalf[second++];
            else
                list[current++] = firstHalf[first++];
        }
        while(first < firstHalf.length)
            list[current++] = firstHalf[first++];
        while(second < secondHalf.length)
            list[current++] = secondHalf[second++];
    }
}