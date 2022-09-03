package chapter01.basic_thread.example1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ExampleTest {
    public static final int MAX_PASSWORD = 9999;
    public static final int TIMEOUT_SEC = 5;

     public static void main(String[] arg){
        Vault vault = new Vault(new Random().nextInt(MAX_PASSWORD));

         List<Thread> threads = new ArrayList<>();
         threads.add(new AscendingHacker(vault));
         threads.add(new DescendingHacker(vault));
         threads.add(new Police(TIMEOUT_SEC));

         threads.forEach(Thread::start);
     }

     private static class Vault {
         private final int password;

         public Vault(int password) {
             this.password = password;
         }

         public boolean isCorrectPassword(int guess){
             try {
                 Thread.sleep(1);
             } catch (InterruptedException e) {}
            return this.password == guess ;
         }
     }

     private static abstract class AbstractHackerThread extends Thread {
         protected Vault vault;

         public AbstractHackerThread(Vault vault){
             this.vault = vault;
             this.setName(this.getClass().getSimpleName());
             this.setPriority(Thread.MAX_PRIORITY);
         }

         @Override
         public synchronized void start() {
             System.out.println(this.getName() +" is start.");
             super.start();
         }

         public void openVault(int guess){
              System.out.println(this.getName() + " guessed the password [" + guess +"]");
              System.exit(0);
         }
     }

     private static class AscendingHacker extends AbstractHackerThread {
         public AscendingHacker(Vault vault){
             super(vault);
         }

         @Override
         public void run() {
             for(int guess = 0; guess < MAX_PASSWORD; guess++){
                if(this.vault.isCorrectPassword(guess)) this.openVault(guess);
             }
         }
     }

    private static class DescendingHacker extends AbstractHackerThread {
        public DescendingHacker(Vault vault){
            super(vault);
        }

        @Override
        public void run() {
            for(int guess = MAX_PASSWORD; guess >= 0; guess--){
                if(this.vault.isCorrectPassword(guess)) this.openVault(guess);
            }
        }
    }


    private static class Police extends Thread {
         private final int timeout;
         public Police(int timeout) {
            this.setName(this.getClass().getSimpleName());
            this.timeout = timeout;
        }

        @Override
        public void run() {
            for(int sec = 0; sec < timeout; sec++){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {}
                System.out.println(timeout-sec);
            }
            System.out.println("time over. Police win!!");
            System.exit(0);
        }
    }

}
