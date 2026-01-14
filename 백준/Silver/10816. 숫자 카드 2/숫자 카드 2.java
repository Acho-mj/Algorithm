import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 가지고 있는 숫자 카드
        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        HashMap<Integer, Integer> my = new HashMap<>();
        for(int i=0; i<n; i++){
            int digit = Integer.parseInt(st.nextToken());
            my.put(digit, my.getOrDefault(digit, 0)+1);
        }

        // 각 숫자별로 몇 개 가지고 있는지
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<m; i++){
            int num = Integer.parseInt(st.nextToken());
            if(my.containsKey(num)){
                sb.append(my.get(num));
            }else{
                sb.append(0);
            }
            sb.append(" ");
        }
        System.out.print(sb);
    }
}