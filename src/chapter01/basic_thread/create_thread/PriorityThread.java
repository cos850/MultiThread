package chapter01.basic_thread.create_thread;

public class PriorityThread extends Thread {

    public PriorityThread(String name){
        this.setName(name);
    }

    @Override
    public void run() {
        System.out.println(this.getName() + " is Start.");
        long sum = 0;
        for(int i=1; i<Integer.MAX_VALUE; i++){
            sum += i;
        }
        System.out.println(this.getName() + " is Done. ["+sum+"]");
    }
}
