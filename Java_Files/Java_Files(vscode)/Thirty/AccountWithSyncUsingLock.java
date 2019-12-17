import java.util.concurrent.*;
import java.util.concurrent.locks.*;

public class AccountWithSyncUsingLock{
    private static Account account = new Account();

    public static void main(String[] args){
        ExecutorService executor = Executors.newCachedThreadPool();

        for(int i = 0; i < 100; i++){
            executor.execute(new AddPennyTask());
            // System.out.println(account.getBalance());
        }
        executor.shutdown();
        while(!executor.isTerminated()){}
        System.out.println("Balance = " + account.getBalance());        
    }

    public static class AddPennyTask implements Runnable{
        @Override
        public void run() {
            account.deposit(1);
        }
    }

    public static class Account {
        private static Lock lock = new ReentrantLock();
        private int balance  = 0;
        public int getBalance(){
            return balance;
        }

        public void deposit(int amount) {
            lock.lock();
            try {
                int newBalance = balance + amount;
                Thread.sleep(5);
                balance = newBalance; 
            }
            catch(InterruptedException ex){}
            finally{
                lock.unlock();
            }
        }
    }
}