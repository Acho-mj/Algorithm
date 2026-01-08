import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        Stack<Integer> s = new Stack<>();
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int op = Integer.parseInt(st.nextToken());
            switch (op){
                case 1:
                    s.push(Integer.parseInt(st.nextToken()));
                    break;

                case 2:
                    if(!s.isEmpty()){
                        sb.append(s.peek());
                        s.pop();
                    }else{
                        sb.append(-1);
                    }
                    sb.append('\n');
                    break;

                case 3:
                    sb.append(s.size()).append('\n');
                    break;

                case 4:
                    if(!s.isEmpty()){
                        sb.append(0);
                    }else{
                        sb.append(1);
                    }
                    sb.append('\n');
                    break;

                case 5:
                    if(!s.isEmpty()){
                        sb.append(s.peek());
                    }else{
                        sb.append(-1);
                    }
                    sb.append('\n');
                    break;
            }
        }
        System.out.print(sb.toString());
    }
}