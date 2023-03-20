package jian_zhi;

import junit.framework.TestCase;
import org.junit.Test;

public class Solution4Test extends TestCase {

    Solution4 solution = new Solution4();

    @Test
    public void test1(){

        int[] test = {1,3,2,3,4};
        System.out.println(solution.maxInWindows(test, 3));
    }

}