import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        while(true){
            String line = br.readLine();
            if (line.length() == 1 && line.charAt(0) == '.') break;
            Stack<Character> s = new Stack<>();
            boolean isValid = true;

            for(char c : line.toCharArray()){
                if(c=='('){
                    s.push(c);
                }else if(c=='['){
                    s.push(c);
                }else if(c==')'){
                    if(s.isEmpty() || s.peek() != '('){
                        isValid=false;
                        break;
                    }else{
                        s.pop();
                    }
                }else if(c==']'){
                    if(s.isEmpty() || s.peek() != '['){
                        isValid=false;
                        break;
                    }else{
                        s.pop();
                    }
                }
            }
            if(!s.isEmpty()) isValid=false;
            sb.append(isValid ? "yes" : "no").append('\n');
        }
        System.out.print(sb);
    }
}