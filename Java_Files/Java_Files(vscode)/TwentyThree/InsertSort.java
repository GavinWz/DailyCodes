public class InsertSort{
    public static void main(String[] args){
        int[] list = {1,5,8,4,1,2,3,6,8,1,9};
        insertSort(list);
        for(int temp : list)
            System.out.println(temp);
    }

    public static void insertSort(int [] list){
        for(int i = 1; i < list.length; i++){
            int current = list[i];
            int j;
            for(j = i; j >= 0 && list[j-1] > current; j--){
                list[j] = list[j-1];
            }
            list[j] = current;
        }
    }
}