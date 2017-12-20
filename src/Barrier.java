public class Barrier {
    int num;
    final int firstNum;

    public Barrier(int num) {
        this.num = num;
        this.firstNum = num;
    }

    public void await() throws InterruptedException {
        synchronized (this) {
            if (!Thread.interrupted()) {
                if (num > 1) {
                    num--;
                    this.wait();
                } else {
                    this.notifyAll();
                    num = firstNum;
                }
            }
        }
    }
}
