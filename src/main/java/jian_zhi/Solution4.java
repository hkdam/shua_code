package jian_zhi;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class Solution4 {

    public ArrayList<Integer> maxInWindows(int[] num, int size) {

        ArrayList<Integer> ans = new ArrayList<>();
        if(num == null || num.length == 0 || size <= 0 || size > num.length)
            return ans;

        Deque<Integer> deque = new ArrayDeque<>();
        for(int i=0; i<size; i++){
            // num[i] >= 也可以
            while(!deque.isEmpty() && num[i] > num[deque.peekLast()])
                deque.pollLast();

            deque.offerLast(i);
        }

        ans.add(num[deque.peekFirst()]);

        for(int i=size; i<num.length; i++){
            while(!deque.isEmpty() && deque.peekFirst() <= i-size)
                deque.pollFirst();

            while(!deque.isEmpty() && num[i] > num[deque.peekLast()])
                deque.pollLast();

            deque.offerLast(i);
            ans.add(num[deque.peekFirst()]);
        }

        return ans;
    }
}
