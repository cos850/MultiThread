package chapter01.basic_thread.inheritance;

public class InheritanceThreadTest {
    public static void main(String[] args){
        Thread thread = new InheritanceThread();

        thread.start();
    }

}
