package chapter01.basic_thread.create_thread;

public class ApplyThread {
    public static void main(String[] args) {

        Thread thread = new Thread(()->{
            System.out.println("Thread name : " + Thread.currentThread().getName());
            System.out.println("Thread priority : " + Thread.currentThread().getPriority());


            throw new RuntimeException("RunTimeException!!!!!!!!");
        });

        /**
         * 스레드 응용하기
         */
        // Thread 이름 변경, 스레드 수가 많은 프로그램을 만들 경우, 스레드 이름은 디버깅에 꼭 필요하다.
        thread.setName("HyeRiThread");

        // Thread 에 동적 우선순위 부여하기 (동적 우선순위 : static priority + bonus)
        // 코어 수 보다 많은 스레드를 생성할 때 큰 영향을 미친다 (코어보다 적으면 병렬실행 가능성이 있음)
        thread.setPriority(Thread.MAX_PRIORITY); // 값은 1-10 까지 값을 줄 수 있음



        /**
         * 스레드 예외처리
         */
        // 예외처리 핸들러를 생성하여 스레드에 설정한다.
        Thread.UncaughtExceptionHandler exceptionHandler = (t, e) -> {
                System.out.println("Thread Exception Handler->check Exception[" + t.getName() + " : " + e.getMessage()+"]");
        };
        thread.setUncaughtExceptionHandler(exceptionHandler);

        // 해당 스레드를 실행하다가 오류가 날 경우 핸들러가 중간에 가로챈다.
        thread.start();
    }
}
