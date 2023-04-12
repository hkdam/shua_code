package leet;

import junit.framework.TestCase;
import org.junit.Test;

public class Solution10Test extends TestCase {

    Solution10 solution10 = new Solution10();

    @Test
    public void test1(){

        System.out.println(solution10.isMatch("ab", ".*"));
    }

}