public class Multiply {
    public static void main(String[] args){
        int[][] list1 = {{1,2,3},{4,5,6},{7,8,9},{7,8,9}};
        int[][] list2 = {{5,4,3,2,1},{8,7,6,5,4},{11,10,9,8,7}};
        int[][] answer = multiply(list1, list2);
        if(answer != null){
            for(int i = 0; i < list1.length; i++){
                for(int j = 0; j < list2[0].length; j++)
                    System.out.print(answer[i][j] + "\t");
                System.out.println();
            }
        }
    }

    public static int[][] multiply(int[][] list1, int[][] list2){
        if(list1[0].length != list2.length){
            System.out.println("Can't be caculated.");
            return null;
        }
        int[][] answer = new int[list1.length][list2[0].length];
        
        for(int i = 0; i < list1.length; i++){
            for(int j = 0; j < list2[0].length; j++){
                answer[i][j] = 0;
                for(int k = 0; k < list1[0].length; k++){
                    answer[i][j] += list1[i][k] * list2[k][j];
                }
            }
        }
        return answer;
    }
}