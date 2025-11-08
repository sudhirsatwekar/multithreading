import java.util.concurrent.atomic.AtomicInteger;

class SharedCounter {
    //1.
    // private  int count;
    //threads will return less than actual value
    //public void increment(){count++;}
    //public int getCount() {return count;}

//2.
//It is Not lock based means it is laveraging hardware support
private AtomicInteger count=new AtomicInteger(0);
public void increment(){count.incrementAndGet();}
public int getCount() {return count.get();}


//3.
//(synchronized keyword)it is lock based ,will put lock on other thread until this updates
//incremented value in main memory
//public synchronized void increment(){count++;}
    //public void increment(){count++;}
    //public int getCount() {return count;}


}
public class RaceCondition {

    public static void main(String[] args) {
        SharedCounter sharedCounter = new SharedCounter();

        // Thread 1
        new Thread(() -> {
            System.out.println("Thread 1 Started");
            for (int i = 0; i < 50000; i++) { // Fixed wrong condition (1 < 50000)
                sharedCounter.increment();
            }
            System.out.println("Thread 1 Completed");
        }).start();

        // Thread 2
        new Thread(() -> {
            System.out.println("Thread 2 Started");
            for (int i = 0; i < 50000; i++) {
                sharedCounter.increment();
            }
            System.out.println("Thread 2 Completed");
        }).start();


        try{
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Final Counter Value: " + sharedCounter.getCount());
    }
}