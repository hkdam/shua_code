package leet;

public class Solution227 {

    public int calculate(String s){

        int len = s.length();
        int ans = 0;
        int curAns = 0;
        char preOperator = '+';
        int num = 0;
        for(int i=0; i<s.length(); i++){

            char ch = s.charAt(i);
            if(ch >= '0' && ch <= '9'){
                num = num*10 + (ch - '0');
            }

            // 如果找到了符号，则前面的开始结算
            if(ch == '+' || ch == '-' || ch == '*' || ch == '/' || i == len-1){

                switch (preOperator){
                    case '+':
                        curAns += num;
                        break;
                    case '-':
                        curAns -= num;
                        break;
                    case '*':
                        curAns *= num;
                        break;
                    case '/':
                        curAns /= num;
                }

                num = 0;
                preOperator = ch;

                if(ch == '+' || ch == '-' || i == len-1){
                    ans += curAns;
                    curAns = 0;
                }
            }
        }

        return ans;
    }
}
