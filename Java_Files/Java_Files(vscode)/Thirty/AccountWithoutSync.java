import java.util.concurrent.*;
public class AccountWithoutSync{
    private static Account account = new Account();
    public static void main(final String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
         for(int i = 0; i < 100; i++)
            executor.execute(new AddPenneyTask());
        executor.shutdown();
        while(!executor.isTerminated()){}
        
    }

    private static class Account{
        private int balance = 0;

        public int getBalance(){
            return balance;
        }

        public void deposit(int amount){
            int newBalance = balance + amount;
            /*若使用此句，则当所有线程同时访问同一个数据源时，会出现数据破坏的问题*/ 
            /*所以输出结果不可预测*/
            
            // balance += amount;
            try{
                Thread.sleep(5);
            }
            catch(InterruptedException exception){}
            balance = newBalance;
        }
    }
    private static class AddPenneyTask implements Runnable{
        @Override
        public void run(){
            synchronized(account){
                account.deposit(1);
            }
                
        }
    }
}