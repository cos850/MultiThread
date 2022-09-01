package chapter01.basic_thread.create;

public class CreateThread {

    public static void main(String[] args) throws InterruptedException {
        /**
         * Thread 객체 자체는 기본적으로 비어 있기 때문에 Runnable 인터페이스를 상속받은 객체를 전달해야 한다.
         * 운영체제가 스케줄링 하자 마자 새 스레드에서 시작한다.
         */
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                // 여기서 해당 thread.start() 시 작업할 코드를 작성한다
            }
        });

        /**
         * 위의 코드를 람다로 줄이면 아래와 같이 구성이 가능하다
         */
        Thread secondThread = new Thread(()->{
            // 여기서 해당 thread.start() 시 작업할 코드를 작성한다
        });

        /**
         * 위의 Thread 코드를 실행하고 시작하려면 thread.start() 메소드를 호출해줘야 한다.
         * 그러면 JVM이 새 스레드를 생성해 운영체제에 전달한다.
         */
        thread.start();
        secondThread.start();


        /**
         * 스레드 클래스의 유용한 기능들
         */
        // 현재 스레드의 스레드 객체 정보 가져오기
        Thread currentThread = Thread.currentThread();
        // 스레드 객체 안에는 Id, Name 등 다양한 정보를 확인할 수 있다
        System.out.println("현재 실행 중인 스레드 정보 : " + currentThread.getName());
        // 현재 스레드를 원하는 밀리초만큼 멈추기
        // * 해당 메소드는 반복되는 명령이 아닌, 단순히 운영체제에게 스케줄링 하지 말라는 지시만 보낸다
        // 따라서 현재 스레드는 인수로 전달한 시간동안 cpu를 사용하지 않는 것이다
        System.out.println("스레드 1초 휴식");
        Thread.sleep(1000);
        System.out.println("스레드 1초 휴식 끝");

        /**
         * 스레드 비동기적 실헹
         * 스레드는 운영체제의 스케줄링에 의해 비동기적으로 실행된다.
         * 때문에 아래의 코드는 main 스레드에서 작성한 프린트문 before, after 스레드가 두 개 찍히고
         * 그 후 스케줄링되어 비동기적으로 실행된 checkStartingOfThread 가 실행되어 프린트문을 남긴다.
         */
        Thread checkThread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("새로운 스레드를 시작하였음 : " + Thread.currentThread().getName());
            }
        });
        checkThread.setName("checkThread");

        System.out.println("새로운 스레드를 시작하기 전 : " + Thread.currentThread().getName());
        checkThread.start();
        System.out.println("새로운 스레드를 시작한 후 : "  + Thread.currentThread().getName());
    }
}
