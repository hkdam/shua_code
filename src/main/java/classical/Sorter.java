package classical;

import java.util.ArrayList;
import java.util.List;

public class Sorter {

    public Sorter(){}

    /**
     * 选择排序， 不稳定， n^2
     * [2,3,2,1]
     */
    public <T extends Comparable> void selectSort(T[] nums){

        int len = nums.length;
        for(int i=0; i<len-1; i++){
            int minIndex = i;
            for(int j=i+1; j<len; j++){
                if(nums[j].compareTo(nums[minIndex]) < 0)
                    minIndex = j;
            }

            if(minIndex != i){
                T tmp = nums[minIndex];
                nums[minIndex] = nums[i];
                nums[i] = tmp;
            }
        }
    }


    /**
     * 插入排序, 稳定，n^2
     */
    public <T extends Comparable> void insertSort(T[] nums){

        if(nums == null)
            return;

        for(int i=1; i<nums.length; i++){
            T curNum = nums[i];
            int j=i-1;
            // 找到前面第一个小于等于的值，然后放到它的后面
            for(; j>=0; j--){
                if(nums[j].compareTo(curNum) > 0){
                    nums[j+1] = nums[j];
                }else
                    break;
            }

            nums[j+1] = curNum;
        }
    }

    /**
     * 插入排序，不稳定 n^(1.3 - 2)
     */
    public <T extends Comparable> void shellSort(T[] nums){

        int gap = nums.length/2;

        while(gap >= 1){
            for(int i=gap; i<nums.length; i++){
                T tmp = nums[i];
                int j = i-gap;
                for(; j>=0; j-=gap){
                    if(nums[j].compareTo(tmp) > 0){
                        nums[j+gap] = nums[j];
                    }else
                        break;
                }

                nums[j+gap] = tmp;
            }

            gap/=2;
        }
    }

    /**
     * 交换，稳定，n^2
     */
    public <T extends Comparable> void bubbleSort(T[] nums){

        // n个元素，需要n-1轮，最后一个元素不需要和比人比较了
        // 每一轮从第一个元素开始，逐个比较，把大的放到后面

        int length = nums.length;
        for(int i=0; i<length-1; i++){
            for(int j=0; j<length-1-i; j++){
                if(nums[j].compareTo(nums[j+1]) > 0){
                    T tmp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = tmp;
                }
            }
        }
    }


    /**
     * 交换类排序，快排， nlogn
     */
    public <T extends Comparable> void quickSort(T[] nums, int left, int right){

        if(left < right){
            int index = partition(nums, left, right);
            quickSort(nums, left, index-1);
            quickSort(nums, index+1, right);
        }
    }


    private <T extends Comparable> int partition(T[] nums, int left, int right){

        T pivot = nums[right];
        while(left < right){
            while(left < right && nums[right].compareTo(pivot) > 0)
                right -= 1;
            nums[left] = nums[right];

            while(left < right && nums[left].compareTo(pivot) <= 0)
                left += 1;
            nums[right] = nums[left];
        }
        nums[left] = pivot;

        return left;
    }


    /**
     * 堆排序， 不稳定
     * 堆完全二叉树
     * https://blog.csdn.net/weixin_51609435/article/details/122982075
     */
    public <T extends Comparable> void heapSort(T[] nums){

        int len = nums.length;
        // 从第一个非叶子节点开始, 建堆
        for(int i=(len-2)/2; i>=0; i--){
            downAdjust(nums, i, len-1);
        }
        for(int i=len-1; i>0; i--){
            T tmp = nums[i];
            nums[i] = nums[0];
            nums[0] = tmp;
            downAdjust(nums, 0, i-1);
        }
    }


    private <T extends Comparable> void downAdjust(T[] nums, int root, int end){

        int childIndex = root*2 + 1;
        while(childIndex <= end){
            if(childIndex + 1 <= end && nums[childIndex+1].compareTo(nums[childIndex]) > 0)
                childIndex += 1;
            if(nums[childIndex].compareTo(nums[root]) > 0){
                T tmp = nums[root];
                nums[root] = nums[childIndex];
                nums[childIndex] = tmp;

                root = childIndex;
                childIndex = root*2 + 1;
            }
            else
                break;
        }
    }


    /**
     * 归并排序， 归并，需要时间 nlogn, 空间n
     */
    public void mergeSort(int[] nums, int left, int right){

        if(left < right){
            int mid = (right+left)/2; // !!!!
            mergeSort(nums, left, mid);
            mergeSort(nums, mid+1, right);
            mergeArray(nums, left, mid, mid+1, right);
        }
    }


    private void mergeArray(int[] nums, int left1, int right1, int left2, int right2){

//        List<T> list = new ArrayList<>(right2-left1+1);
        int[] tmpNums = new int[right2-left1+1];
        int index1=left1, index2=left2, index3=0;
        while(index1 <= right1 && index2 <= right2){
            if(nums[index1] <= nums[index2])
                tmpNums[index3++] = nums[index1++];
            else
                tmpNums[index3++] = nums[index2++];
        }

        while(index1 <= right1){
            tmpNums[index3++] = nums[index1++];
        }

        while(index2 <= right2){
            tmpNums[index3++] = nums[index2++];
        }

        index3 = 0;
        for(int i=left1; i<=right2; i++){
            nums[i] = tmpNums[index3++];
        }
    }


    /**
     * https://blog.csdn.net/qq_53139716/article/details/124024376
     * https://blog.csdn.net/weixin_45876036/article/details/124625025
     * @param nums
     */
    public static void sleepSort1(int[] nums){

        for(int i=0; i<nums.length; i++){
            int num = nums[i];
            new Thread(() -> {
                try {
                    Thread.sleep(num*20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    System.out.println("error: " + num);
                }

                System.out.println(num);
            }).start();
        }
    }

}
