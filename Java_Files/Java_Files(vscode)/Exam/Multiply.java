public class Multiply{
    public static void main(String[] args){
        int[][] n1 = {{1,2,3},{4,5,6},{7,8,9},{7,8,9}};
        int[][] n2 = {{5,4,3,2,1},{8,7,6,5,4},{11,10,9,8,7}};
        int[][] answer = multiply(n1, n2);
        for(int i = 0; i < n1.length; i++){
            for(int j = 0; j < n2[0].length; j++)
                System.out.print(answer[i][j] + "\t");
            System.out.println();
        }
    }

    static int[][] multiply(int[][] n1, int [][] n2){
        int[][] answer = new int[n1.length][n2[0].length];
        if(n1[0].length != n2.length)
            return null;
        for(int i = 0; i < n1.length; i++){
            for(int j = 0; j < n2[0].length; j++){
                int temp = 0;
                for(int k = 0; k < n2.length; k++){
                    temp += n1[i][k] * n2[k][j]; 
                }
                answer[i][j] = temp;
            }
        }
        return answer;
    }
}