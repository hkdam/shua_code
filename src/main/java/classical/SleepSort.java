package classical;

public class SleepSort {

    public static void main(String[] args) {
        int[] num=new int[]{1,45,28,63,77,62};
//        sleepSort(num);
        SleepSort sleepSort = new SleepSort();
        sleepSort.sleepSort1(num);
    }

    public static void sleepSort(int[] nums) {
        for(int i=0; i<nums.length; i++){
            int num = nums[i];
            new Thread(() -> {
                try {
                    Thread.sleep(num*100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    System.out.println("error: " + num);
                }

                System.out.println(num);
            }).start();
        }
    }


    public void sleepSort1(int[] nums){

        for(int i=0; i<nums.length; i++){
            int num = nums[i];
            new Thread(() -> {
                try {
//                    Thread.sleep(num*10);
                    Thread.currentThread().sleep(num*100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    System.out.println("error: " + num);
                }

                System.out.println(num);
            }).start();
        }
    }
}
