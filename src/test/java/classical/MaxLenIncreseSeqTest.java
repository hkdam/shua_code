package classical;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.HashMap;

public class MaxLenIncreseSeqTest extends TestCase {

    MaxLenIncreseSeq maxLenIncreseSeq = new MaxLenIncreseSeq();

    @Test
    public void test1(){

        int[] a = {1, 2, 3, -9, 3, 9, 0, 11};

//        maxLenIncreseSeq.getSeq(a);

        HashMap<Character, Integer> mp = new HashMap<>();
        System.out.println(mp.size());
        System.out.println(mp.get('a'));
        System.out.println(mp.size());

        String b = "1234";
        String c = b.substring(4,4);

        System.out.println(c.length());


    }


}