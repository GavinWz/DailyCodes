public class MyTest{
    public static void main(String[] args){
        print test = new print('z');
        Thread runTest = new Thread(test);
        runTest.start();
    }

    static class print1 implements Runnable{
        int n;
        print1(int num){
            n = num;
        }
        @Override
        public void run() {
            for(int i = 0; i < n; i++){
                System.out.println(i);
            }
        }
    }
    

    static class print implements Runnable{
        char ch;
        print(char c){
            ch = c;
        }
        @Override
        public void run() {
            Thread thread1 = new Thread(new print1(5));
            thread1.start();
            try{
                for(int i = 0; i < 100; i++){
                    System.out.println(i);
                    if(i == 50)
                        thread1.join();
                    
                }
            }catch(InterruptedException ex){
                System.out.println("error");
            }
        }
    }

}