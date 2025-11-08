import java.util.function.Supplier;

public class ThreadExample {
    public static <myanoclass> void main(String[] args) {

        Thread t1 = new myThread();
        t1.start();


        //use lambda and functional interface
        Thread t2 = new Thread(() -> {

            System.out.println("t2 running......");
        });
        t2.start();

//anonymous inner class
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("r1 running....");
            }
        };

        Thread t3=new Thread(r1,"r1 runnable thread..");
          t3.start();


          //lambda code for above

        Runnable r2=()->{
            System.out.println("r2 running....");
            try {
                Thread.sleep(5000);
            }catch(InterruptedException e){
                throw new RuntimeException(e);
            }

//            System.out.println(Thread.currentThread().getName());
//            System.out.println(Thread.currentThread().getState());
           System.out.println("r2 completed");

        };

        Thread t4=new Thread(r2,"r2 runnable");
        t4.start();



        System.out.println("main thread");


     Myanoclass m1=new Myanoclass(){
         @Override
         public void show(){
             System.out.println("myanoclass called...");
         }

     };
        m1.show();

//        Myanoclass m2=()->{
//            System.out.println("myanoclass called...");
//        }
// m2.show();

    }

}


class myThread extends Thread {
    public void run() {
        System.out.println("t1 running....");
    }
}

class  Myanoclass {

    public void show(){
        System.out.println("myanoclass called...");
    }

}