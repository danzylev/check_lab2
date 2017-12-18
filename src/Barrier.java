
public class Barrier {
    int num;

    public Barrier(int num) {
        this.num = num;
    }

    public void await() throws InterruptedException {
//        int firstnum = num;
        synchronized (this){
            while (num > 1)  {
                num--;
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
            this.notifyAll();
        }
    }
}
