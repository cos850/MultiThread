package chapter01.basic_thread.create;

public class PriorityTest {
    public static void main(String[] args){
        int num = 16;
        for(int i=0; i<num; i++){
            Thread thread = new PriorityThread("no. " + i);
            if(i != num-1){
                thread.setPriority(Thread.MIN_PRIORITY);
            }else {
                thread.setPriority(Thread.MAX_PRIORITY);
            }
            thread.start();
        }
    }
}
