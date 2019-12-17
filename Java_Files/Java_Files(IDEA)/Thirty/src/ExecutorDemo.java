    import java.util.concurrent.*;
    public class ExecutorDemo {
        public static void main(String[] args) {
            ExecutorService executor = Executors.newFixedThreadPool(3);
            executor.execute(new PrintChar('a', 100));
            executor.execute(new PrintChar('b', 100));
            executor.execute(new PrintChar('c', 100));
        }
    }
    class PrintChar implements Runnable{
        private char ch;
        private int time;
        public PrintChar(char c, int t){
            ch = c;
            time = t;
        }
        @Override
        public void run(){
            for(int i = 0; i < time; i++)
                System.out.print(ch + ' ');
            System.out.println();
        }
    }
