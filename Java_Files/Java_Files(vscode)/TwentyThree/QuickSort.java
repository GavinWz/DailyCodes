public class QuickSort{
    public static void main(String[] args){
        int[] list = {1,4,1,2,6,9,8,5,1,21,3,6,8,7,4,5};
        quickSort(list, 0, list.length-1);
        for(int temp : list)
        System.out.println(temp);
    }

    public static void quickSort(int[] list, int first, int last){
        if(first < last){
            int index = quickPass(list, first, last);
            quickSort(list, first, index-1);
            quickPass(list, index+1, last);
        }
    }

    public static int quickPass(int[] list, int first, int last){
        int low = first + 1;
        int high = last;
        int value = list[first];
        while(low < high){
            while(low <= high && list[low] <= value)
                low++;
            while(low <= high && list[high] > value)
                high--;
            if(high > low){
                int temp = list[high];
                list[high] = list[low];
                list[low] = temp;
            }
        }
        while(high > first && list[high] >= value)
            high--;
        if(value > list[high]){
            list[first] = list[high];
            list[high] = value;
            return high;
        }
        else
            return first;
    }
}