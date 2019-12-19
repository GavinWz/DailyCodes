import java.util.concurrent.RecursiveAction;
import java.util.concurrent.ForkJoinPool;
public class ParallelMergeSort{
    public static void main(String[] args){
        final int SIZE = 7000000;
        int[] list1 = new int[SIZE];
        int[] list2 = new int[SIZE];
        for(int i = 0; i < list1.length; i++)
            list1[i] = list2[i] = (int)(Math.random() * 10000000);
        long startTime = System.currentTimeMillis();
        parallelMergeSort(list1);
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
        for(int i : list1){
            System.out.println(i);
        }
    }

    public static void parallelMergeSort(int[] list) {
        RecursiveAction mainTask = new SortTask(list);
        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(mainTask);
    }

    private static class SortTask extends RecursiveAction {
        private final int THRESHOLD = 500;
        private int[] list;

        SortTask(int[] list) {
            this.list = list;
        }

        @Override
        protected void compute() {
            if (list.length < THRESHOLD)
                java.util.Arrays.sort(list);
            else {
                int[] firstHalf = new int[list.length / 2];
                System.arraycopy(list, 0, firstHalf, 0, list.length / 2);
                int[] secondHalf = new int[list.length - list.length / 2];
                System.arraycopy(list, list.length / 2, secondHalf, 0, list.length - list.length / 2);
                invokeAll(new SortTask(firstHalf), new SortTask(secondHalf));
                merge(firstHalf, secondHalf, list);

            }
        }

        public static void merge(int[] list1, int[] list2, int[] list) {
            int i = 0, j = 0, index = 0;
            while(i < list1.length && j < list2.length){
                if(list1[i] > list2[j]){
                    list[index] = list2[j];
                    j++;
                }
                else{
                    list[index] = list1[i];
                    i++;   
                }
                index++;
            }
            if(list1.length == i){
                for( ; j < list2.length; j++, index++){
                    list[index] = list2[j];
                }
            }
            else{
                for( ; i < list1.length; i++, index++){
                    list[index] = list1[i];
                }
            }
        }
        
        
    }
}