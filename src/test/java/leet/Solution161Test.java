package leet;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution161Test extends TestCase {

    @Test
    public void test1(){

        Solution161 solution = new Solution161();

//        System.out.println(solution.isOneEditDistance("ab", "acb"));
//        System.out.println(solution.isOneEditDistance("cab", "ad"));
//        System.out.println(solution.isOneEditDistance("1203", "1213"));

        List<String> tmp = new ArrayList<>();
        String a = String.join("/", tmp);
        System.out.println(String.format("a: %s , length: %d", a, a.length()));

    }

}