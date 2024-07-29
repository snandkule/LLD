public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Hello world!");
        Logger logger = Logger.getInstance();
        logger.log("Application started.");

        // Simulate multiple threads logging messages
        Thread thread1 = new Thread(() -> {
            Logger.getInstance().log("Thread 1 logging a message.");
        });
        Thread thread2 = new Thread(() -> {
            Logger.getInstance().log("Thread 2 logging a message.");
        });
        Thread thread3 = new Thread(() -> {
            Logger.getInstance().log("Thread 3 logging a message.");
        });
        Thread thread4 = new Thread(() -> {
            Logger.getInstance().log("Thread 4 logging a message.");
        });

        thread1.start();
        thread2.start();
        thread1.join();
        thread3.start();
        thread2.join();
        thread4.start();
    }
}