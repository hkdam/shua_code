package classical;

public class SleepSort2 implements Runnable {

    private int num;

    public SleepSort2(int num){
        this.num = num;
    }

    @Override
    public void run() {

        try {
//            Thread.sleep(num*10);
            // Tread的静态方法都是当前线程执行
            Thread.sleep(num*10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(this.num);
    }
}
