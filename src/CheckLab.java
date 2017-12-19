
public class CheckLab {
    public static void main(String[] args) throws InterruptedException {
        Barrier b = new Barrier(5);

        for (int i = 0; i < 20; i++) {
            new Thread(new FirstThread(b)).start();
            Thread.sleep(500);
        }
    }

        public static class FirstThread implements Runnable{
        private final Barrier b;

            public FirstThread(Barrier b) {
                this.b = b;
            }

            @Override
            public void run(){
                try {
                    System.out.println("Thread " + Thread.currentThread().getName() + " has arrived");

                    b.await();

                    System.out.println("Thread " + Thread.currentThread().getName() + " has released");

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
    }

}
