package classical;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class SorterTest extends TestCase {

    Sorter sorter = new Sorter();

    private PriorityQueue<Integer> tmp = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return 0;
        }
    });

    public static void main(String[] args) {
        int[] c = {1,45,28,63,77,62};

        Sorter.sleepSort1(c);
    }

        @Test
    public void test1(){

//        int a1 = 1;
//        int b1 = 3;
//        Integer aa = Integer.valueOf(a1);
//        Integer bb = Integer.valueOf(b1);
//        System.out.println(aa.compareTo(bb));

        // 调用范性方法时，如果是数组，这基本类型无法自动装箱
        Integer[] a = {2,3,1,2,5,4,7,0,9,3,8};
        int[] b = {2,3,1,2,5,4,7,9,3,8};
        int[] c = {1,45,28,63,77,62};

//        sorter.selectSort(a);
//        sorter.insertSort(a);
//        sorter.bubbleSort(a);
//        sorter.shellSort(a);
//        sorter.quickSort(a, 0, a.length-1);
//        sorter.heapSort(a);
//        sorter.mergeSort(b, 0, b.length-1);
//        System.out.println(Arrays.toString(b));

        Sorter.sleepSort1(c);

//        int tmp = 3;
//        testPrint(tmp);

    }


    public <T> void testPrint(T a){
        System.out.println(a);
    }

}