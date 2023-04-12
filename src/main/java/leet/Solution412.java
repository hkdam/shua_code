package leet;

import java.util.ArrayList;
import java.util.List;

public class Solution412 {

    public List<String> fizzBuzz(int n) {
        List<String> resList = new ArrayList<>();

        for(int i=1; i<=n; i++){
            if(i%15 == 0) // !!!!
                resList.add("FizzBuzz");
            else if(i%5 == 0)
                resList.add("Buzz");
            else if(i%3 == 0)
                resList.add("Fizz");
            else
                resList.add(Integer.toString(i));
        }


        return resList;
    }
}
