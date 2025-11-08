//volatile and syncronized keyword


class SharedResource {

private boolean flag=false;
//private volatile boolean flag=false;
// instead of voilatile use synchronised keyword for both
//the getter and setter method it will behave same
    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

}

public class visibilityProblem {
    public static void main(String[] args) {

        SharedResource sharedResource=new SharedResource();

        //thread1
        new Thread(() -> {
            System.out.println("Thread 1 started");
            try {
            System.out.println("Thread 1 logic started");
            Thread.sleep(1000);
                System.out.println("Thread 1 logic completed");
            sharedResource. setFlag(true);
            System.out.println("Flag set to true by Thread 1");
                } catch (InterruptedException e) {
            e.printStackTrace();
         }
         }).start();

        //thread2
        new Thread(() -> {
            System.out.println("Thread 2 started");
            while (!sharedResource.isFlag()) {
// It will run until flag value is true
            }
            System.out.println("Thread 2 logic completed");
        }).start();





    }

}
