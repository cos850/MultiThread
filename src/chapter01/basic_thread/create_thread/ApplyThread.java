package chapter01.basic_thread.create_thread;

public class ApplyThread {
    public static void main(String[] args) throws Exception {

        Thread thread = new Thread(()->{
            System.out.println("Thread name : " + Thread.currentThread().getName());
            System.out.println("Thread priority : " + Thread.currentThread().getPriority());


            throw new RuntimeException("RunTimeException!!!!!!!!");
        });

        /**
         * 스레드 응용하기
         */
        // 01. Thread 이름 변경, 스레드 수가 많은 프로그램을 만들 경우, 스레드 이름은 디버깅에 꼭 필요하다.
        thread.setName("HyeRiThread");
        // 02. Thread 에 동적 우선순위 부여하기 (동적 우선순위 : static priority + bonus)
        thread.setPriority(Thread.MAX_PRIORITY); // 값은 1-10 까지 값을 줄 수 있음


        /**
         * 스레드 예외처리
         */
        // 1. 예외처리 핸들러를 생성해 모든 스레드의 오류를 전역적으로 관리하기
        Thread.UncaughtExceptionHandler exceptionHandler = new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println("Thread Exception Handler->check Exception[" + t.getName() + " : " + e.getMessage()+"]");
            }
        };
        thread.setUncaughtExceptionHandler(exceptionHandler);

        thread.start();
    }
}
