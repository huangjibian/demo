package huangjibian;

/**
 * Created by Administrator on 2018/9/25.
 */
public class test {
    public static void main(String[] args) throws InterruptedException {
        Thread t =new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    Thread.sleep(0);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("2");
            }
        });
        t.start();

            t.join();


        System.out.println("1");
    }
}
