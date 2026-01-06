import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        int n = str.length();

        Stack<Character> stack = new Stack<>();
        int temp = 1;
        int result = 0; // 최종 결과값
        for(int i=0; i<n; i++){
            char c = str.charAt(i);
            if(c=='('){
                temp *= 2;
                stack.push(c);
            }else if(c=='['){
                temp *= 3;
                stack.push(c);
            }else if(c==')'){
                // 올바르지 않은 괄호
                if(stack.isEmpty() || stack.peek() != '('){
                    result = 0;
                    break;
                }

                // 이전의 괄호와 한 쌍일 경우
                if(str.charAt(i-1) == '('){
                    result += temp;
                }

                stack.pop();
                temp /= 2;
            }else{
                // 올바르지 않은 괄호
                if(stack.isEmpty() || stack.peek() != '['){
                    result = 0;
                    break;
                }

                // 이전의 괄호와 한 쌍일 경우
                if(str.charAt(i-1) == '['){
                    result += temp;
                }

                stack.pop();
                temp /= 3;
            }
        }
        if (!stack.isEmpty()) {
            System.out.println(0);
        } else {
            System.out.println(result);
        }
    }
}