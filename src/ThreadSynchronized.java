public class ThreadSynchronized implements Runnable {

    int count = 200000;

    public int getCount() {
        return count;
    }

    @Override
//    public synchronized void  run()  {
//         synchronized (this) {
             public void run() {
                 int delta = Thread.currentThread().getName().equals("issue") ? -100000 :
                             Thread.currentThread().getName().equals("receive") ? 100000 : 0;
                 synchronized (this) {
                     count += delta;
                 }
//             }if (Thread.currentThread().getName().equals("issue")) {
//                 for (int i = 0; i < 100000; i++) {
//                     count--;
//                 }
//             } else if (Thread.currentThread().getName().equals("receive")) {
//                 for (int i = 0; i < 100000; i++) {
//                     count++;
//                 }
//             }
//         }
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadSynchronized m = new ThreadSynchronized();
         Thread t1 = new Thread(m, "issue");
         Thread t2 = new Thread(m, "receive");
         t1.start();
         t2.start();
         Thread.sleep(5000);
        System.out.println(m.getCount());
    }
}