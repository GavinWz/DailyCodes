import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.lang.Math;

public class ThreadCooperation{
    private static Account account = new Account();

    public static class DepositTask implements Runnable{
        @Override
        public void run() {
            try {
                while(true){
                    account.deposit(((int)Math.random() * 10) + 1);
                    Thread.sleep(1000);
                }
            }
            catch(InterruptedException ex){
                ex.printStackTrace();
            }
        }
    }

    public static class WithdrawTask implements Runnable{
        @Override
        public void run() {
            account.withdraw(((int)Math.random() * 10) + 1);
        }
    }

    public static class Account{
        private static Lock lock = new ReentrantLock();
        private static Condition newDeposit = lock.newCondition();
        
        private int balance = 0;
        
        public int getBalance(){
            return balance;
        }

        public void withdraw(final int amount){
            lock.lock();
            try{
                while(balance < amount){
                    System.out.println("\t\t\tWait for a deposit.");
                    newDeposit.await();
                }

                balance -= amount;
                System.out.println("\t\t\tWithdraw " + amount + "\t\t" + getBalance());
            }catch(final InterruptedException ex){
                ex.printStackTrace();
            }
            finally{
                lock.unlock();
            }
        }

        public void deposit(final int amount){
            lock.lock();
            try {
                balance += amount;
                System.out.println("Desposit " + amount + "\t\t\t\t\t" + getBalance());
                newDeposit.signalAll();
            }
            finally{
                lock.unlock();
            }
        }

    }



}