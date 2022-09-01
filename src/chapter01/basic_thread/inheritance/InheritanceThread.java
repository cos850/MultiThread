package chapter01.basic_thread.inheritance;

public class InheritanceThread extends Thread{
    @Override
    public void run() {
        this.setName("InheritanceThread");
        System.out.println(this.getName() + " is extneds Thread");
    }

}
