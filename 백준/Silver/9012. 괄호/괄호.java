import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();

        for(int i=0; i<n; i++){
            String line = br.readLine();
            Stack<Character> s = new Stack<>();
            boolean isValid = true;
            for(char c : line.toCharArray()){
                if(c=='('){
                    s.push(c);
                }else{
                    if(!s.isEmpty()){
                        s.pop();
                    }else{
                        isValid = false;
                        break;
                    }
                }
            }
            if (!s.isEmpty()) isValid = false;
            sb.append(isValid ? "YES" : "NO").append('\n');
        }
        System.out.print(sb);
    }
}